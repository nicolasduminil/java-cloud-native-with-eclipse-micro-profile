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
@XmlRootElement(name="contact")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContactDetailsDto implements Serializable
{
  private Long contactDetailsId;
  @NonNull
  @NotNull
  @NotEmpty
  @Size(min = 1, max = 40, message="{LAST_NAME_INVALID_SIZE}")
  private String lastName;
  @NonNull
  @NotNull
  @NotEmpty
  @Size(min = 1, max = 40, message="{FIRST_NAME_INVALID_SIZE}")
  private String firstName;
  @NonNull
  @Valid
  private OrganizationDto organization;
  @NonNull
  @NotNull
  @NotEmpty
  @Size(min = 1, max = 12, message="{PHONE_NUMBER_INVALID_SIZE}")
  private String phoneNumber;
  @NonNull
  @NotNull
  @NotEmpty
  @Size(min = 1, max = 60, message="{EMAIL_ADDRESS_INVALID_SIZE}")
  private String emailAddress;
}
