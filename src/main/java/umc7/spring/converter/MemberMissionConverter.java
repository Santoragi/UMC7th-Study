package umc7.spring.converter;

import umc7.spring.domain.mapping.MemberMission;
import umc7.spring.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MemberMissionConverter {

    public static MissionResponseDTO.ChallengeResultDTO toChallengeResultDTO(MemberMission memberMission){
        return MissionResponseDTO.ChallengeResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberMission toMemberMission(){
        return MemberMission.builder()
                .build();
    }
}
