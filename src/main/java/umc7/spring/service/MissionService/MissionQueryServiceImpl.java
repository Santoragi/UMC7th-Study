package umc7.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc7.spring.domain.Mission;
import umc7.spring.domain.enums.MissionStatus;
import umc7.spring.repository.MissionRepository.MissionRepository;

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
        filteredMissions.forEach(mission -> System.out.println("Mission: " + mission));

        return filteredMissions;
    }

    @Override
    public Page<Mission> findMissionByMemberIDAndRegionId(Long memberId, Long regionId, Pageable pageable){
        Page<Mission> filteredMissions = missionRepository.findMissionByMemberIDAndRegionId(memberId, regionId, pageable);
        filteredMissions.forEach(mission -> System.out.println("Mission: " + mission));

        return filteredMissions;
    }

    @Override
    public List<Long> countMissionComplete(Long memberId, Long regionId){
        List<Long> count = missionRepository.countMissionComplete(memberId, regionId);
        System.out.println("Total: " + count.get(0));
        System.out.println("Complete: " + count.get(1));

        return count;
    }

}
