package fr.simplex_software.press_release.domain.tests;

import fr.simplex_software.press_release.domain.commons.*;
import fr.simplex_software.press_release.domain.dtos.*;
import fr.simplex_software.press_release.domain.entities.*;
import fr.simplex_software.press_release.domain.mappers.*;
import fr.simplex_software.tfp.plan_journey.jaxb.*;
import org.junit.jupiter.api.*;

import java.io.*;

import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestPressReleaseMapper extends TestCommons
{
  private static PressReleaseDto pressReleaseDto;
  private static PressReleaseEntity pressReleaseEntity;
  private static PressReleaseType pressReleaseType;

  @Test
  @Order(10)
  public void testUnmarshalXmlFileShouldSucceed()
  {
    pressReleaseDto =
      this.unmarshalXmlFileToPressReleaseDto(
        new File("src/test/resources/pr" + ".xml"));
    assertThat(pressReleaseDto).isNotNull();
    assertThat(pressReleaseDto.getPressReleaseName()).isEqualTo(
      "pressReleaseName1");
  }

  @Test
  @Order(20)
  public void testToEntityShouldSucceed()
  {
    pressReleaseEntity =
      PressReleaseMapper.INSTANCE.toEntity(pressReleaseDto);
    assertThat(pressReleaseEntity).isNotNull();
    assertThat(pressReleaseEntity.getPressReleaseName()).isEqualTo(
      "pressReleaseName1");
  }

  @Test
  @Order(30)
  public void testFromEntityShouldSucceed()
  {
    pressReleaseDto =
      PressReleaseMapper.INSTANCE.fromEntity(pressReleaseEntity);
    assertThat(pressReleaseDto).isNotNull();
    assertThat(pressReleaseDto.getPressReleaseName()).isEqualTo(
      "pressReleaseName1");
  }

  @Test
  @Order(40)
  public void testToBeanShouldSucceed()
  {
    pressReleaseType = PressReleaseMapper.INSTANCE.toBean(pressReleaseDto);
    assertThat(pressReleaseType).isNotNull();
    assertThat(pressReleaseType.getPressReleaseName()).isEqualTo(
      "pressReleaseName1");
  }

  @Test
  @Order(50)
  public void testToBean2ShouldSucceed()
  {
    pressReleaseType = PressReleaseMapper.INSTANCE.toBean(pressReleaseEntity);
    assertThat(pressReleaseType).isNotNull();
    assertThat(pressReleaseType.getPressReleaseName()).isEqualTo(
      "pressReleaseName1");
  }

  @Test
  @Order(60)
  public void testFromBeanShouldSucceed()
  {
    pressReleaseDto = PressReleaseMapper.INSTANCE.fromBean(pressReleaseType);
    assertThat(pressReleaseDto).isNotNull();
    assertThat(pressReleaseDto.getPressReleaseName()).isEqualTo(
      "pressReleaseName1");
  }

  @Test
  @Order(70)
  public void testToEntity2ShouldSucceed()
  {
    pressReleaseEntity = PressReleaseMapper.INSTANCE.toEntity(pressReleaseType);
    assertThat(pressReleaseEntity).isNotNull();
    assertThat(pressReleaseEntity.getPressReleaseName()).isEqualTo(
      "pressReleaseName1");
  }
}
