package com.hydraulic.applyforme.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Member was chosen for table name because all other user types in the system
 * can identify as member or participants of the system and design to create this entity
 * was due to the fact all users of the system have a shared or common characteristics for example
 * their first name, last name, email address, phone number and others. If all the shared elements is placed
 * into individual user tables or entities, there would be little to no minimization of redundancy.
 * Only attributes or properties that is peculiar to each individual is added within their own schema.
 * A Member can be termed or interchanged with a User or Participant or Actor in this context.
 */

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="member",
        indexes = {
            @Index(
                    columnList = "email_address",
                    name = "email_address_idx",
                    unique = true
            ),
        },
        uniqueConstraints = {
            @UniqueConstraint(
                    columnNames = {"email_address", "phone_number"},
                    name = "email_address_phone_number_uq"
            )
        }
)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    /**
     * This column stores a reference to the country of the citizenship of an actor
     * in the system
     */
    @ManyToOne(fetch = FetchType.EAGER, optional = false,cascade = CascadeType.ALL)
    @JoinColumn(name = "nationality_id")
    private Country nationality;

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationality=" + nationality +
                ", countryOfResidence=" + countryOfResidence +
                ", dateOfBirth=" + dateOfBirth +
                ", currentJobTitle='" + currentJobTitle + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", username='" + username + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", active=" + active +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                ", roles=" + roles +
                '}';
    }

    /**
     * This column stores a reference to the country where the actor presently resides.
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "country_of_residence_id")
    private Country countryOfResidence;

    @Temporal(TemporalType.DATE)
    @Column(name ="date_of_birth")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dateOfBirth = new Date();

    /**
     * This identifies the current professional or working job title of the member of the system irrespective of the role
     * they would identify with or be assigned to in the system.
     */
    @Column(name ="current_job_title")
    private String currentJobTitle;

    @Column(name = "email_address", nullable = false)
    private String emailAddress;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name ="phone_number")
    private String phoneNumber;

    @Column(name ="city")
    private String city;

    @Column(name ="state")
    private String state;

    @Column(name ="password", nullable = false)
    private String password;

    /**
     * This column or property stores a reference to the display picture of a member or user of the system.
     */
    @Column(name ="avatar")
    private String avatar;

    /**
     * This column stores and indicate the current state of the profile of a member in the system.
     * This is also to indicate if the user will have access to some features or part of the system.
     */
    @Column(name ="active", nullable = false)
    private Boolean active = true;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on", updatable = false, nullable = false)
    private Date createdOn;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_on", nullable = false)
    private Date updatedOn;

    /**
     * This declaration creates what is called a Junction table or Join table. This is so
     * because a user in the system can have and play multiple roles. For example a user can be
     * an administrator, super administrator, product manager or even a payroll manager.
     * <br/>
     * <br/>
     * Therefore, a new table is necessary to interlink the member and roles table or any other table
     * that is going to be used to guide the assignment of privileges or authorities in the system.
     * <br/>
     * <br/>
     * OneToMany relationship is not a suitable option because if used, then only a single user
     * can have the title of an admin and no one else. However, in a real world company or organization;
     * there are usually more than one administrator in the system.
     * <br/>
     * <br/>
     * For Reference on a Junction table
     * @see <a href="https://learn.microsoft.com/en-us/sql/ssms/visual-db-tools/map-many-to-many-relationships-visual-database-tools?view=sql-server-ver16">Map Many-to-Many Relationships</a>
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "member_roles",
            joinColumns = @JoinColumn(
                    name = "member_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles = new HashSet<>();

    public void addRole(Role role) {
        this.getRoles().add(role);
    }

    public void clearRoles() {
        this.roles = new HashSet<>();
    }
}
