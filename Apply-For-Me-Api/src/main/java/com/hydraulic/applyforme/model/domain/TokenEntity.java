package com.hydraulic.applyforme.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name= "otp")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String otp;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Override
    public String toString() {
        return "PasswordResetTokenEntity{" +
                "id='" + id + '\'' +
                ", otp='" + otp + '\'' +
                ", member=" + member.getEmailAddress() +
                '}';
    }
}
