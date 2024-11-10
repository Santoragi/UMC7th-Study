package umc7.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -694893339L;

    public static final QMember member = new QMember("member1");

    public final umc7.spring.domain.base.QBaseEntity _super = new umc7.spring.domain.base.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final StringPath birthDate = createString("birthDate");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final EnumPath<umc7.spring.domain.enums.Gender> gender = createEnum("gender", umc7.spring.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> inactiveDate = createDate("inactiveDate", java.time.LocalDate.class);

    public final ListPath<Inquiry, QInquiry> inquiryList = this.<Inquiry, QInquiry>createList("inquiryList", Inquiry.class, QInquiry.class, PathInits.DIRECT2);

    public final ListPath<umc7.spring.domain.mapping.MemberAgree, umc7.spring.domain.mapping.QMemberAgree> memberAgreeList = this.<umc7.spring.domain.mapping.MemberAgree, umc7.spring.domain.mapping.QMemberAgree>createList("memberAgreeList", umc7.spring.domain.mapping.MemberAgree.class, umc7.spring.domain.mapping.QMemberAgree.class, PathInits.DIRECT2);

    public final ListPath<umc7.spring.domain.mapping.MemberMission, umc7.spring.domain.mapping.QMemberMission> memberMissionList = this.<umc7.spring.domain.mapping.MemberMission, umc7.spring.domain.mapping.QMemberMission>createList("memberMissionList", umc7.spring.domain.mapping.MemberMission.class, umc7.spring.domain.mapping.QMemberMission.class, PathInits.DIRECT2);

    public final ListPath<umc7.spring.domain.mapping.MemberPrefer, umc7.spring.domain.mapping.QMemberPrefer> memberPreferList = this.<umc7.spring.domain.mapping.MemberPrefer, umc7.spring.domain.mapping.QMemberPrefer>createList("memberPreferList", umc7.spring.domain.mapping.MemberPrefer.class, umc7.spring.domain.mapping.QMemberPrefer.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final StringPath phoneNum = createString("phoneNum");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<Review, QReview> reviewList = this.<Review, QReview>createList("reviewList", Review.class, QReview.class, PathInits.DIRECT2);

    public final EnumPath<umc7.spring.domain.enums.MemberStatus> status = createEnum("status", umc7.spring.domain.enums.MemberStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}
