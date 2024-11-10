package umc7.spring.repository.MissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc7.spring.domain.Mission;
import umc7.spring.domain.QMember;
import umc7.spring.domain.QMission;
import umc7.spring.domain.enums.MissionStatus;
import umc7.spring.domain.mapping.QMemberMission;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMember member = QMember.member;
    private final QMission mission = QMission.mission;
    private final QMemberMission memberMission = QMemberMission.memberMission;

    @Override
    public List<Mission> findAllMissionByStatusAndMemberId(Long memberId, MissionStatus missionStatus) {
        BooleanBuilder predicate = new BooleanBuilder();
        predicate.and(memberMission.member.id.eq(memberId));
        predicate.and(memberMission.status.eq(missionStatus));

        List<Mission> missions = jpaQueryFactory
                .selectFrom(mission)
                .join(memberMission).on(mission.id.eq(memberMission.mission.id))
                .where(predicate)
                .orderBy(memberMission.createdAt.desc())
                .fetch();

        return missions;
    }

}
