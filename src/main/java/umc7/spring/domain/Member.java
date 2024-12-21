package umc7.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc7.spring.domain.base.BaseEntity;
import umc7.spring.domain.enums.Gender;
import umc7.spring.domain.enums.MemberStatus;
import umc7.spring.domain.enums.Role;
import umc7.spring.domain.mapping.MemberAgree;
import umc7.spring.domain.mapping.MemberMission;
import umc7.spring.domain.mapping.MemberPrefer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@DynamicUpdate
@DynamicInsert
@Builder
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 20, columnDefinition = "VARCHAR(20) DEFAULT '2000-01-01'")
    private String birthDate;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'OTHER'")
    private Gender gender;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = false, length = 30)
    private String address;

    @Column(length = 30)
    private String specAddress;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status;

    private LocalDate inactiveDate;

//    @Column(nullable = false, length = 20)
    private String nickname;

//    @Column(nullable = false, length = 20)
    private String phoneNum;

    @ColumnDefault("0")
    private Integer point;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Inquiry> inquiryList = new ArrayList<>();

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birth='" + birthDate + '\'' +
                ", gender=" + gender + '\'' +
                ", address=" + address + '\'' +
                ", nickname=" + nickname + '\'' +
                ", phoneNum=" + phoneNum + '\'' +
                ", point=" + point + '\'' +
                '}';
    }

    public void encodePassword(String password) {
        this.password = password;
    }

}
