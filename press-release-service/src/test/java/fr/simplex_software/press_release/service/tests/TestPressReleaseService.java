package fr.simplex_software.press_release.service.tests;

import de.hilling.junit.cdi.*;
import fr.simplex_software.press_release.domain.commons.*;
import fr.simplex_software.press_release.domain.dtos.*;
import fr.simplex_software.press_release.domain.entities.*;
import fr.simplex_software.press_release.domain.mappers.*;
import fr.simplex_software.press_release.service.*;
import jakarta.inject.*;
import jakarta.persistence.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;

import java.io.*;
import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(CdiTestJunitExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestPressReleaseService extends TestCommons
{
  @Inject
  private PressReleaseService pressReleaseService;

  @Test
  @Order(10)
  public void testSaveShouldSucceed()
  {
    PressReleaseDto pressReleaseDto = unmarshalXmlFileToPressReleaseDto(
      new File("src/test/resources/pr.xml"));
    assertThat(pressReleaseDto).isNotNull();
    PressReleaseEntity pressReleaseEntity =
      PressReleaseMapper.INSTANCE.toEntity(pressReleaseDto);
    pressReleaseService.save(pressReleaseEntity);
    assertThat(pressReleaseEntity.getPressReleaseId()).isNotNull();
  }

  @Test
  @Order(20)
  public void testFindAllShouldSucceed()
  {
    List<PressReleaseEntity> pressReleaseEntityList =
      pressReleaseService.findAll();
    assertThat(pressReleaseEntityList).isNotNull();
    assertThat(pressReleaseEntityList.size()).isNotZero();
    assertThat(pressReleaseEntityList.get(0).getPressReleaseName()).isEqualTo(
      "pressReleaseName1");
  }

  @Test
  @Order(30)
  public void testFinfByNameShouldSucceed()
  {
    List<PressReleaseEntity> pressReleaseEntityList =
      pressReleaseService.findByName("pressReleaseName1");
    assertThat(pressReleaseEntityList).isNotNull();
    assertThat(pressReleaseEntityList.size()).isNotZero();
    assertThat(pressReleaseEntityList.get(0).getPressReleaseName()).isEqualTo(
      "pressReleaseName1");
  }

  @Test
  @Order(40)
  public void testFinfByIdShouldSucceed()
  {
    List<PressReleaseEntity> pressReleaseEntityList =
      pressReleaseService.findByName("pressReleaseName1");
    PressReleaseEntity pressReleaseEntity = pressReleaseService.findById(
      pressReleaseEntityList.get(0).getPressReleaseId());
    assertThat(pressReleaseEntity).isNotNull();
    assertThat(pressReleaseEntity.getPressReleaseName()).isEqualTo(
      "pressReleaseName1");
  }

  @Test
  @Order(50)
  public void testUpdateShouldSucceed()
  {
    List<PressReleaseEntity> pressReleaseEntityList =
      pressReleaseService.findByName("pressReleaseName1");
    PressReleaseEntity pressReleaseEntity = pressReleaseEntityList.get(0);
    pressReleaseEntity.setPressReleaseName("pressReleaseName2");
    assertDoesNotThrow(() -> pressReleaseService.update(pressReleaseEntity));
  }

  @Test
  @Order(60)
  public void testDeleteShouldSucceed()
  {
    List<PressReleaseEntity> pressReleaseEntityList =
      pressReleaseService.findByName("pressReleaseName2");
    PressReleaseEntity pressReleaseEntity = pressReleaseEntityList.get(0);
    assertDoesNotThrow(() -> pressReleaseService.delete(pressReleaseEntity));
  }

  @Test
  @Order(70)
  public void testFindAllShouldFail()
  {
    assertThrows(EntityNotFoundException.class,
      () -> pressReleaseService.findAll());
  }

  @Test
  @Order(70)
  public void testFindByNameShouldFail()
  {
    assertThrows(EntityNotFoundException.class,
      () -> pressReleaseService.findByName("toto"));
  }

  @Test
  @Order(70)
  public void testFindByIdShouldFail()
  {
    assertThrows(EntityNotFoundException.class,
      () -> pressReleaseService.findById(1000L));
  }
}
