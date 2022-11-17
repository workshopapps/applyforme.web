package com.hydraulic.applyforme.model.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="salary_range")
public class SalaryRange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="sal_range", nullable = false)
    private String salaryRange;
}
