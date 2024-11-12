package umc7.spring.repository.MemberRepository;

import umc7.spring.domain.Member;

public interface MemberRepositoryCustom {
    Member findMemberById(Long memberId);
}
