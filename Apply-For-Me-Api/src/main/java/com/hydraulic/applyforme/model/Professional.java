package com.hydraulic.applyforme.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * This is a user who is seeking for greener pastures or new job opportunities aside
 * his or her current role or position at work.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "professional")
public class Professional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(mappedBy = "professional")
    private Applier applier;

    @Column(name = "available_for_interview" , nullable = false)
    private boolean availableForInterview = false;

    @Column(name ="linkedin_link")
    private String linkedinLink;

    @Column(name = "hobbies")
    private String hobbies;

    @Column(name ="other_link_1")
    private String otherLink1;

    @Column(name ="other_link_2")
    private String otherLink2;

    @Column(name ="other_link_3")
    private String otherLink3;

    @OneToMany(mappedBy = "professional")
    private Set<ProfessionalProfile> professionalProfile = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "professional")
    private Set<Submission> submissions = new HashSet<>();
}
