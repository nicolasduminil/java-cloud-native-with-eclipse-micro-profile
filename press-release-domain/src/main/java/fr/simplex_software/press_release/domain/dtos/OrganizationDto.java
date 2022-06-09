package fr.simplex_software.press_release.domain.dtos;

import jakarta.validation.*;
import jakarta.validation.constraints.*;
import jakarta.xml.bind.annotation.*;
import lombok.*;

import java.io.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@XmlRootElement(name="organization")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrganizationDto implements Serializable
{
  private Long organizationId;
  @NonNull
  @NotNull
  @NotEmpty
  @Size(min = 1, max = 40, message="{ORGANIZATION_NAME_INVALID_SIZE}")
  private String oraganizationName;
  @NonNull
  @NotNull
  @NotEmpty
  @Size(min = 1, max = 40, message="{ORGANIZATION_NUMBER_INVALID_SIZE}")
  private String organizationRegistrationNumber;
  @NonNull
  @Valid
  private AddressDto organizationAddressDto;
}
