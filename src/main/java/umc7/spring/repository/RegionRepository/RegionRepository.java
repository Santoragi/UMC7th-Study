package umc7.spring.repository.RegionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc7.spring.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Long>, RegionRepositoryCustom {

}
