package com.hydraulic.applyforme.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="member_secret_code")
public class MemberSecretCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="sign_up_verification_code")
    private String signUpVerificationCode;

    @OneToOne
    @JoinColumn(name = "member_email_fk", referencedColumnName ="email_address")
    private Member member;
}
