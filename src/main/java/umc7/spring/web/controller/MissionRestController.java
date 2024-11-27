package umc7.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc7.spring.apiPayload.ApiResponse;
import umc7.spring.converter.MemberMissionConverter;
import umc7.spring.domain.mapping.MemberMission;
import umc7.spring.service.MemberMissionService.MemberMissionService;
import umc7.spring.validation.annotation.CheckMissions;
import umc7.spring.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MemberMissionService memberMissionService;

    @PostMapping("/{missionId}/challenge")
    public ApiResponse<MissionResponseDTO.ChallengeResultDTO> addChallenge(@CheckMissions @PathVariable("missionId") Long missionId){

        Long memberId = 1L;
        MemberMission memberMission = memberMissionService.createMemberMission(memberId,missionId);
        return ApiResponse.onSuccess(MemberMissionConverter.toChallengeResultDTO(memberMission));
    }

}
