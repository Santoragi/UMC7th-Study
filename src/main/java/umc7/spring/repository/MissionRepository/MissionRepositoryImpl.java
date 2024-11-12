package umc7.spring.repository.MissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import umc7.spring.domain.Mission;
import umc7.spring.domain.QMission;
import umc7.spring.domain.enums.MissionStatus;
import umc7.spring.domain.mapping.QMemberMission;

import java.util.ArrayList;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMission mission = QMission.mission;
    private final QMemberMission memberMission = QMemberMission.memberMission;

    @Override
    public List<Mission> findAllMissionByStatusAndMemberId(Long memberId, MissionStatus missionStatus) {
        BooleanBuilder predicate = new BooleanBuilder();
        predicate.and(memberMission.member.id.eq(memberId));
        predicate.and(memberMission.status.eq(missionStatus));

        return jpaQueryFactory
                .selectFrom(mission)
                .join(memberMission).on(mission.id.eq(memberMission.mission.id))
                .where(predicate)
                .orderBy(memberMission.createdAt.desc())
                .fetch();
    }

    @Override
    public Page<Mission> findMissionByMemberIDAndRegionId(Long memberId, Long regionId, Pageable pageable){
        List<Mission> missions = jpaQueryFactory
                .selectFrom(mission)
                .where(
                        mission.id.notIn(
                                JPAExpressions
                                        .select(memberMission.mission.id)
                                        .from(memberMission)
                                        .where(memberMission.member.id.eq(memberId))
                        ),
                        mission.region.id.eq(regionId)
                )
                .orderBy(mission.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        // 총 개수를 조회하는 쿼리
        long total = jpaQueryFactory
                .select(mission.count())
                .from(mission)
                .where(
                        mission.id.notIn(
                                JPAExpressions
                                        .select(memberMission.mission.id)
                                        .from(memberMission)
                                        .where(memberMission.member.id.eq(memberId))
                        ),
                        mission.region.id.eq(regionId)
                )
                .fetchOne();

        return new PageImpl<>(missions, pageable, total);
    }

    @Override
    public List<Long> countMissionComplete(Long memberId, Long regionId){
        BooleanBuilder predicate = new BooleanBuilder();
        predicate.and(memberMission.member.id.eq(memberId));
        predicate.and(memberMission.status.eq(MissionStatus.COMPLETE));
        predicate.and(memberMission.region.id.eq(regionId));

        long count, total;
        List<Long> result = new ArrayList<>();
        count = jpaQueryFactory
                .select(mission.count())
                .from(mission)
                .where(mission.region.id.eq(regionId))
                .fetchCount();

        total= jpaQueryFactory
                .select(memberMission.count())
                .from(memberMission)
                .where(predicate)
                .fetchCount();

        result.add(count);
        result.add(total);

        return result;
    }

}
