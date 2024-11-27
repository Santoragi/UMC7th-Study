package umc7.spring.service.MemberMissionService;

import umc7.spring.domain.mapping.MemberMission;

public interface MemberMissionService {
    public MemberMission createMemberMission(Long memberId, Long missionId);
}
