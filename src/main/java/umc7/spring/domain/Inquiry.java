package umc7.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc7.spring.domain.base.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@AllArgsConstructor
public class Inquiry extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = false, length = 100)
    private String body;

    //문의 사진 생략

    @Column(nullable = false, length = 50)
    private String reply;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

}