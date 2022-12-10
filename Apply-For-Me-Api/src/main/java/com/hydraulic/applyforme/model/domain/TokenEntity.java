package com.hydraulic.applyforme.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "otp_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenEntity implements Serializable{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(updatable = false, nullable = false)
    private String id;

    private String otp;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "member_id")
    private Member member;

    public TokenEntity(Member saveMember) {

    }

    @Override
    public String toString() {
        return "PasswordResetTokenEntity{" +
                "id='" + id + '\'' +
                ", otp='" + otp + '\'' +
                ", member=" + member +
                '}';
    }
}
