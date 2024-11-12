package umc7.spring.service.MissionService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc7.spring.domain.Mission;
import umc7.spring.domain.enums.MissionStatus;

import java.util.Optional;
import java.util.List;

public interface MissionQueryService {
    Optional<Mission> findMission(Long id);

    List<Mission> findAllMissionByStatusAndMemberId(Long memberId, MissionStatus missionStatus);

    Page<Mission> findMissionByMemberIDAndRegionId(Long memberId, Long regionId, Pageable pageable); //도전 가능한 미션

    List<Long> countMissionComplete(Long memberId, Long regionId);

}
