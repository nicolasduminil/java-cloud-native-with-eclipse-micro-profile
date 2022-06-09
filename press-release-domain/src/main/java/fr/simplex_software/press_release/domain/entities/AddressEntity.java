package fr.simplex_software.press_release.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.*;

@Entity
@Table(name = "ADDRESSES")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AddressEntity implements Serializable
{
  @Id
  @SequenceGenerator(name = "ADDRESS_ID_GENERATOR", sequenceName = "ADDRESS_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRESS_ID_GENERATOR")
  @Column(name = "ADDRESS_ID", unique = true, nullable = false, length = 5)
  private Long addressId;
  @Column(name = "STREET_ADDRESS", nullable = false, length = 40)
  private String streetAddress;
  @Column(name = "CITY", nullable = false, length = 20)
  private String city;
  @Column(name = "STATE", nullable = true, length = 20)
  private String state;
  @Column(name = "ZIP_CODE", nullable = false, length = 5)
  private String zipCode;
  @Column(name = "COUNTRY", nullable = false, length = 20)
  private String country;
  @OneToOne(mappedBy = "addressEntity")
  private OrganizationEntity organizationEntity;
}
