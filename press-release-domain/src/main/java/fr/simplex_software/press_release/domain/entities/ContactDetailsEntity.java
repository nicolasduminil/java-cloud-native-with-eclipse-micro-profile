package fr.simplex_software.press_release.domain.entities;

import fr.simplex_software.press_release.domain.dtos.*;
import jakarta.persistence.*;
import lombok.*;

import java.io.*;

@Entity
@Table(name = "CONTACT_DETAILS")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ContactDetailsEntity implements Serializable
{
  @Id
  @SequenceGenerator(name = "CONTACT_DETAILS_ID_GENERATOR", sequenceName = "CONTACT_DETAILS_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTACT_DETAILS_ID_GENERATOR")
  @Column(name = "CONTACT_DETAILS_ID", unique = true, nullable = false, length = 5)
  private Long contactDetailsId;
  @Column(name = "LAST_NAME", nullable = false, length = 40)
  private String lastName;
  @Column(name = "FIRST_NAME", nullable = false, length = 40)
  private String firstName;
  @OneToOne(mappedBy = "contactDetailsEntity")
  private OrganizationEntity organizationDto;
  @Column(name = "PHONE_NUMBER", nullable = false, length = 12)
  private String phoneNumber;
  @Column(name = "EMAIL_ADDRESS", nullable = false, length = 60)
  private String emailAddress;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "PRESS_RELEASE_ID", referencedColumnName = "PRESS_RELEASE_ID")
  private PressReleaseEntity pressReleaseEntity;
}
