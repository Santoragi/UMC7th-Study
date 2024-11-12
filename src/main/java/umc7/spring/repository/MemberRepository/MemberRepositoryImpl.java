package umc7.spring.repository.MemberRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc7.spring.domain.Member;
import umc7.spring.domain.QMember;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMember member = QMember.member;
    @Override
    public Member findMemberById(Long memberId){
        return jpaQueryFactory
                .select(member)
                .from(member)
                .where(member.id.eq(memberId))
                .fetchOne();
    }
}
