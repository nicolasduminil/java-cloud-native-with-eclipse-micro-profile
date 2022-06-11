package fr.simplex_software.press_release.domain.tests;

import fr.simplex_software.press_release.domain.commons.*;
import fr.simplex_software.press_release.domain.dtos.*;
import fr.simplex_software.press_release.domain.entities.*;
import fr.simplex_software.press_release.domain.mappers.*;
import org.junit.jupiter.api.*;

import java.io.*;

import static org.assertj.core.api.Assertions.*;

public class TestPressReleaseMapper extends TestCommons
{
  @Test
  public void testPressReleaseMapper()
  {
    PressReleaseDto pressReleaseDto =
      this.unmarshalXmlFileToPressReleaseDto(
        new File("src/test/resources/pr" + ".xml"));
    assertThat(pressReleaseDto).isNotNull();
    PressReleaseEntity pressReleaseEntity =
      PressReleaseMapper.INSTANCE.toEntity(pressReleaseDto);
    assertThat(pressReleaseEntity).isNotNull();
    assertThat(pressReleaseEntity.getPressReleaseName()).isEqualTo(
      "pressReleaseName1");
    pressReleaseDto =
      PressReleaseMapper.INSTANCE.fromEntity(pressReleaseEntity);
    assertThat(pressReleaseDto).isNotNull();
    assertThat(pressReleaseDto.getPressReleaseName()).isEqualTo(
      "pressReleaseName1");
  }
}
