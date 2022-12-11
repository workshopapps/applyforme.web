package com.hydraulic.applyforme.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "otp")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GenericGenerator(name = "uuid", strategy = "uuid2")
//    @Column(updatable = false, nullable = false)
    private Long id;

    private String otp;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


    @Override
    public String toString() {
        return "PasswordResetTokenEntity{" +
                "id='" + id + '\'' +
                ", otp='" + otp + '\'' +
                ", member=" + member +
                '}';
    }
}
