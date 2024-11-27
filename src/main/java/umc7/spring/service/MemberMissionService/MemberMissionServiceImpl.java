package umc7.spring.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc7.spring.converter.MemberMissionConverter;
import umc7.spring.domain.Member;
import umc7.spring.domain.Mission;
import umc7.spring.domain.mapping.MemberMission;
import umc7.spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc7.spring.repository.MemberRepository.MemberRepository;
import umc7.spring.repository.MissionRepository.MissionRepository;

@Service
@RequiredArgsConstructor
public class MemberMissionServiceImpl implements MemberMissionService{

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    @Override
    public MemberMission createMemberMission(Long memberId, Long missionId) {
        MemberMission newMemberMission = MemberMissionConverter.toMemberMission();
        Member member = memberRepository.findMemberById(memberId);
        Mission mission = missionRepository.findMissionById(missionId);

        newMemberMission.setMember(member);
        newMemberMission.setMission(mission);

        return memberMissionRepository.save(newMemberMission);
    }
}
