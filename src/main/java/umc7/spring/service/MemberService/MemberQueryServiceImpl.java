package umc7.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc7.spring.domain.Member;
import umc7.spring.repository.MemberRepository.MemberRepository;
import umc7.spring.repository.MemberRepository.MemberRepositoryCustom;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {
    private final MemberRepository memberRepository;

    @Override
    public Member findMemberById(Long memberId){
        Member filteredMember = memberRepository.findMemberById(memberId);
        System.out.println(filteredMember.toString());

        return filteredMember;
    }
}
