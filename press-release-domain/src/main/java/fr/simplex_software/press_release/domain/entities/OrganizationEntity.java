package fr.simplex_software.press_release.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.*;

@Entity
@Table(name = "ORGANIZATIONS")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class OrganizationEntity implements Serializable
{
  @Id
  @SequenceGenerator(name = "ORGANIZATION_ID_GENERATOR", sequenceName = "ORGANIZATION_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORGANIZATION_ID_GENERATOR")
  @Column(name = "ORGANIZATION_ID", unique = true, nullable = false, length = 5)
  private Long organizationId;
  @Column(name = "ORGANIZATION_NAME", nullable = false, length = 40)
  private String oraganizationName;
  @Column(name = "REGISTRATION_NUMBER", nullable = false, length = 40)
  private String organizationRegistrationNumber;
  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "ADDRESS_ID", referencedColumnName =
  "ADDRESS_ID")
  private AddressEntity address;
}
