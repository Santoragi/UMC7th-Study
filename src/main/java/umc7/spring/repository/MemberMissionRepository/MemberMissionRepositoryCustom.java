package umc7.spring.repository.MemberMissionRepository;

import umc7.spring.domain.mapping.MemberMission;

public interface MemberMissionRepositoryCustom {
    MemberMission findMemberMissionByMemberIdAndMissionId(Long memberId, Long missionId);
    MemberMission findByMemberMissionId(Long memberMissionId);
}
