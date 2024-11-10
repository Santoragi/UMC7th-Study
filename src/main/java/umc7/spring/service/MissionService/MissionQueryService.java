package umc7.spring.service.MissionService;

import umc7.spring.domain.Mission;
import umc7.spring.domain.enums.MissionStatus;

import java.util.Optional;
import java.util.List;

public interface MissionQueryService {
    Optional<Mission> findMission(Long id);

    List<Mission> findAllMissionByStatusAndMemberId(Long memberId, MissionStatus missionStatus);

}
