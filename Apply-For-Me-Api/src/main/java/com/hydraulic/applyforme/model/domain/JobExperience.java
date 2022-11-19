package com.hydraulic.applyforme.model.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="job_experience")
public class JobExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="title")
    private String title;

    @Column(name ="company_name")
    private String companyName;

    @Temporal(TemporalType.DATE)
    @Column(name ="start_date")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name ="end_date")
    private Date endDate;
}
