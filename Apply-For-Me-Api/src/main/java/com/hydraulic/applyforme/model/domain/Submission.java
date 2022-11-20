package com.hydraulic.applyforme.model.domain;

import com.hydraulic.applyforme.model.enums.JobLocationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


/**
 * This entity records job submission that was made by the applier
 * on behalf of the developer and which developer.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="job_submission")
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "professional_id")
    private Professional professional;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "applier_id")
    private Applier applier;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @Column(name = "job_link")
    private String jobLink;

    @Column(name = "job_location")
    private String jobLocation;

    @Column(name = "job_company")
    private String jobCompany;

    @Column(name ="job_location_type")
    @Enumerated(EnumType.STRING)
    private JobLocationType jobLocationType ;

    /**
     * Summary or description or details of the job the applier or reverse recruiter submitted on behalf of the developer.
     */
    @Column(name ="summary")
    private String summary;

    @Column(name = "other_comment", nullable = true)
    private String otherComment;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date createdOn;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_on", nullable = false)
    private Date updatedOn;

}
