package umc7.spring.repository.MissionRepository;

import umc7.spring.domain.Mission;
import umc7.spring.domain.Store;
import umc7.spring.domain.enums.MissionStatus;

import java.util.List;

public interface MissionRepositoryCustom {
    List<Mission> findAllMissionByStatusAndMemberId(Long memberId, MissionStatus missionStatus);
}
