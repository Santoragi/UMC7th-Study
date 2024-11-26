package umc7.spring.repository.RegionRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc7.spring.domain.QRegion;
import umc7.spring.domain.Region;

@Repository
@RequiredArgsConstructor
public class RegionRepositoryImpl implements RegionRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;
    private final QRegion region = QRegion.region;

    @Override
    public Region findRegionById(Long regionId){
        return jpaQueryFactory
                .select(region)
                .from(region)
                .where(region.id.eq(regionId))
                .fetchOne();
    }
}
