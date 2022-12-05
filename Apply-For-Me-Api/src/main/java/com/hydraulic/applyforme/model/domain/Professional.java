package com.hydraulic.applyforme.model.domain;

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

    @Column(name = "available_for_interview" , nullable = false)
    private boolean availableForInterview = false;

    @Column(name ="linkedin_link")
    private String linkedinLink;

    @Column(name ="facebook_link")
    private String facebookLink;

    @Column(name ="twitter_link")
    private String twitterLink;

    @Column(name ="instagram_link")
    private String instagramLink;

    @Column(name = "hobbies")
    private String hobbies;

    @Column(name ="other_link_1")
    private String otherLink1;

    @Column(name ="other_link_2")
    private String otherLink2;

    @Column(name ="other_link_3")
    private String otherLink3;

    @OneToMany(mappedBy = "professional", fetch = FetchType.LAZY)
    private Set<ProfessionalProfile> professionalProfiles = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "professional")
    private Set<Submission> submissions = new HashSet<>();
}
