package umc7.spring.repository.MemberMissionRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc7.spring.domain.QMember;
import umc7.spring.domain.QMission;
import umc7.spring.domain.mapping.MemberMission;
import umc7.spring.domain.mapping.QMemberMission;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;
    private final QMember member = QMember.member;
    private final QMission mission = QMission.mission;
    private final QMemberMission memberMission = QMemberMission.memberMission;
    @Override
    public MemberMission findMemberMissionByMemberIdAndMissionId(Long memberId, Long missionId) {

        return jpaQueryFactory
                .select(memberMission)
                .from(memberMission)
                .where(memberMission.member.id.eq(memberId).and(memberMission.mission.id.eq(missionId)))
                .fetchOne();
    }

    @Override
    public MemberMission findByMemberMissionId(Long memberMissionId) {
        return jpaQueryFactory
                .select(memberMission)
                .from(memberMission)
                .where(memberMission.id.eq(memberMissionId))
                .fetchOne();
    }

}
