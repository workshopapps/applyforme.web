package com.hydraulic.applyforme.model.domain;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@Builder
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name ="apply_for_me")
public class ApplyForMe {

    public ApplyForMe() {
        createdOn = new Date();
        updatedOn = new Date();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title = "Apply For Me";

    @Column
    private String version = "1.0";

    @Column
    private String description = "You work at a remote company and you earn $1k a month. You are very happy. But you sometimes think - what if there are better jobs out there for me? But it&apos;s too much work to apply. In comes: ApplyForMe. A service where you tell us your skills and what you are looking for, and people apply for you for 100s of jobs. All you need to do is attend interviews.";

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on", updatable = false, nullable = false)
    private Date createdOn;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_on", nullable = false)
    private Date updatedOn;
}
