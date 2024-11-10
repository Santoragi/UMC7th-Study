package umc7.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc7.spring.domain.Mission;
import umc7.spring.domain.Store;
import umc7.spring.domain.enums.MissionStatus;
import umc7.spring.repository.MissionRepository.MissionRepository;
import umc7.spring.repository.StoreRepository.StoreRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService{

    private final MissionRepository missionRepository;

    @Override
    public Optional<Mission> findMission(Long id) {
        return missionRepository.findById(id);
    }

    @Override
    public List<Mission> findAllMissionByStatusAndMemberId(Long memberId, MissionStatus missionStatus) {
        List<Mission> filteredMissions = missionRepository.findAllMissionByStatusAndMemberId(memberId, missionStatus);
        filteredMissions.forEach(store -> System.out.println("Store: " + store));

        return filteredMissions;
    }
}
