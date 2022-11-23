package com.hydraulic.applyforme.model.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="salary_range")
public class SalaryRange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="salary_range", nullable = false)
    private String salaryRange;


    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on", updatable = false, nullable = false)
    private Date createdOn;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_on", nullable = false)
    private Date updatedOn;

}
