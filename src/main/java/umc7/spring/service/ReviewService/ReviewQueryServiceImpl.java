package umc7.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc7.spring.domain.Member;
import umc7.spring.domain.Review;
import umc7.spring.repository.MemberRepository.MemberRepository;
import umc7.spring.repository.ReviewRepository.ReviewRepository;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    @Override
    public Page<Review> getReviewList(Long memberId, Integer page) {
        Member member = memberRepository.findMemberById(memberId);
        Page<Review> memberPage= reviewRepository.findAllByMember(member, PageRequest.of(page,10));

        return memberPage;
    }
}
