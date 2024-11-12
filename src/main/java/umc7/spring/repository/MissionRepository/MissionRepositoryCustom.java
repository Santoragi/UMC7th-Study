package umc7.spring.repository.MissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import umc7.spring.domain.Mission;
import umc7.spring.domain.enums.MissionStatus;

import java.util.List;

public interface MissionRepositoryCustom {
    List<Mission> findAllMissionByStatusAndMemberId(Long memberId, MissionStatus missionStatus); //미션목록

    Page<Mission> findMissionByMemberIDAndRegionId(Long memberId, Long regionId, Pageable pageable); //도전 가능한 미션

    List<Long> countMissionComplete(Long memberId, Long regionId);  //지역에서 성공한 미션 개수/지역 총 미션 개수
}
