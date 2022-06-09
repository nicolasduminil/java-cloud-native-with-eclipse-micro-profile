package fr.simplex_software.press_release.domain.dtos;

import jakarta.validation.constraints.*;
import jakarta.xml.bind.annotation.*;
import lombok.*;

import java.io.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@XmlRootElement(name="address")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddressDto implements Serializable
{
  private Long addressId;
  @NonNull
  @NotNull
  @NotEmpty
  @Size(min = 1, max = 40, message="{STREET_ADDRESS_INVALID_SIZE}")
  private String streetAddress;
  @NonNull
  @NotNull
  @NotEmpty
  @Size(min = 1, max = 20, message="{CITY_NAME_INVALID_SIZE}")
  private String city;
  @NotNull
  @NotEmpty
  @Size(min = 1, max = 20, message="{STATE_NAME_INVALID_SIZE}")
  private String state;
  @NonNull
  @NotNull
  @NotEmpty
  @Size(min = 1, max = 5, message="{ZIP_CODE_INVALID_SIZE}")
  private String zipCode;
  @NonNull
  @NotNull
  @NotEmpty
  @Size(min = 1, max = 20, message="{COUNTRY_NAME_INVALID_SIZE}")
  private String country;
}
