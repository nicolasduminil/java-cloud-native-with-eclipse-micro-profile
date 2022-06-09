package fr.simplex_software.press_release.domain.dtos;

import fr.simplex_software.press_release.domain.converters.*;
import jakarta.validation.*;
import jakarta.validation.constraints.*;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.*;
import lombok.*;

import java.io.*;
import java.time.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@XmlRootElement(name="pressRelease")
@XmlAccessorType(XmlAccessType.FIELD)
public class PressReleaseDto implements Serializable
{
  private Long pressReleaseId;
  @NonNull
  @NotNull
  @NotEmpty
  @Size(min = 1, max = 40, message="{PRESS_RELEASE_NAME_INVALID_SIZE}")
  private String pressReleaseName;
  @NonNull
  @Valid
  @XmlJavaTypeAdapter(value = LocalDateXmlAdapter.class)
  private LocalDate releaseDate;
  @NonNull
  @Valid
  private ContactDetailsDto contact;
  @NotNull
  @NotEmpty
  @Size(min = 1, max = 120, message="{PATH_TO_LOGO_INVALID_SIZE}")
  private String pathToLogo;
  @NotNull
  @NotEmpty
  @Size(min = 1, max = 120, message="{PATH_TO_HEADER_INVALID_SIZE}")
  private String pathToHeader;
  @NotNull
  @NotEmpty
  @Size(min = 1, max = 120, message="{PATH_TO_CONTENT_INVALID_SIZE}")
  private String pathToContent;
  @NotNull
  @NotEmpty
  @Size(min = 1, max = 120, message="{PATH_TO_FINAL_NOTE_INVALID_SIZE}")
  private String pathToFinalNote;
}
