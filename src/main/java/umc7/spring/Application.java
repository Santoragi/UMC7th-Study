package umc7.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import umc7.spring.domain.enums.MissionStatus;
import umc7.spring.service.MissionService.MissionQueryService;
import umc7.spring.service.StoreService.StoreQueryService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context) {

		//워크북 내용
//		return args -> {
//			StoreQueryService storeService = context.getBean(StoreQueryService.class);
//
//			// 파라미터 값 설정
//			String name = "요아정";
//			Float score = 4.0f;
//
//			// 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
//			System.out.println("Executing findStoresByNameAndScore with parameters:");
//			System.out.println("Name: " + name);
//			System.out.println("Score: " + score);
//
//			storeService.findStoresByNameAndScore(name, score)
//					.forEach(System.out::println);
//		};

		//미션1. 내가 완료한 미션 확인하기
//		return args -> {
//			MissionQueryService missionService = context.getBean(MissionQueryService.class);
//
//			Long id = 1L;
//			MissionStatus missionStatus = MissionStatus.valueOf("COMPLETE");
//
//			System.out.println("MemberID: " + id);
//			System.out.println("missionStatus: "+missionStatus);
//
//			missionService.findAllMissionByStatusAndMemberId(id,missionStatus)
//					.forEach(System.out::println);
//		};

		//미션3. 홈 화면 쿼리 -> 선택한 지역에서 도전 가능한 미션
		Pageable pageable = PageRequest.of(0,3);
		return args -> {
			MissionQueryService missionService = context.getBean(MissionQueryService.class);

			Long memberId = 1L;
			Long regionId = 1L;

			System.out.println("MemberID: " + memberId);
			System.out.println("RegionID: " + regionId);

			missionService.findMissionByMemberIDAndRegionId(memberId, regionId, pageable)
					.forEach(System.out::println);
			missionService.countMissionComplete(memberId, regionId)
					.forEach(System.out::println);
		};
	}
}
