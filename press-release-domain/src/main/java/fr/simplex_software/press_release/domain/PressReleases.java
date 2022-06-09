package fr.simplex_software.press_release.domain;

import fr.simplex_software.press_release.domain.dtos.*;
import jakarta.xml.bind.annotation.*;
import lombok.*;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@XmlRootElement(name="pressRelease")
@XmlAccessorType(XmlAccessType.FIELD)
public class PressReleases
{
  private List<PressReleaseDto> pressReleases;
}
