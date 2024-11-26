package umc7.spring.repository.RegionRepository;

import umc7.spring.domain.Region;

public interface RegionRepositoryCustom {
    Region findRegionById(Long RegionId);
}
