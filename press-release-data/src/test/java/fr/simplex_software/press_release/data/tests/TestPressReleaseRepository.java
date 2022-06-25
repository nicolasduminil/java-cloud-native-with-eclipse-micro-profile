package fr.simplex_software.press_release.data.tests;

import de.hilling.junit.cdi.*;
import fr.simplex_software.press_release.data.*;
import fr.simplex_software.press_release.domain.commons.*;
import fr.simplex_software.press_release.domain.dtos.*;
import fr.simplex_software.press_release.domain.entities.*;
import fr.simplex_software.press_release.domain.mappers.*;
import jakarta.persistence.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;

import java.io.*;
import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(CdiTestJunitExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestPressReleaseRepository extends TestCommons
{
  //@Inject
  private static PressReleaseRepositoryImpl pressReleaseRepository;

  @BeforeAll
  public static void postConstruct()
  {
    pressReleaseRepository = new PressReleaseRepositoryImpl(
      Persistence.createEntityManagerFactory("pr-test")
        .createEntityManager(),
      PressReleaseEntity.class);
  }

  @Test
  @Order(10)
  public void testPressreleaseRepositorySholdBeNonNull()
  {
    assertThat(pressReleaseRepository).isNotNull();
    assertThat(pressReleaseRepository.getEntityManager()).isNotNull();
  }

  @Test
  @Order(20)
  public void testSaveShouldSucceed()
  {
    PressReleaseDto pressReleaseDto = unmarshalXmlFileToPressReleaseDto(
      new File("src/test/resources/pr.xml"));
    assertThat(pressReleaseDto).isNotNull();
    PressReleaseEntity pressReleaseEntity =
      PressReleaseMapper.INSTANCE.toEntity(pressReleaseDto);
    assertDoesNotThrow(() -> pressReleaseRepository.save(pressReleaseEntity));
  }

  @Test
  @Order(30)
  public void testFindAllShouldSucceed()
  {
    List<PressReleaseEntity> pressReleaseEntityList =
      pressReleaseRepository.findAll();
    asserts(pressReleaseEntityList);
  }

  @Test
  @Order(40)
  public void testFindAnyShouldSucceed()
  {
    List<PressReleaseEntity> pressReleaseEntityList =
      pressReleaseRepository.findByProperty("pressReleaseName",
        new String("pressReleaseName1"));
    asserts(pressReleaseEntityList);
  }

  @Test
  @Order(50)
  public void testUpdateShouldSucceed()
  {
    List<PressReleaseEntity> pressReleaseEntityList =
      pressReleaseRepository.findAll();
    asserts(pressReleaseEntityList);
    PressReleaseEntity pressReleaseEntity = pressReleaseEntityList.get(0);
    pressReleaseRepository.getEntityManager().detach(pressReleaseEntity);
    pressReleaseEntity.setPressReleaseName("pressReleaseName2");
    pressReleaseEntity = pressReleaseRepository.update(pressReleaseEntity);
    pressReleaseRepository.initCriteria();
    pressReleaseEntityList = pressReleaseRepository.findAll();
    assertThat(pressReleaseEntityList.size()).isNotZero();
    assertThat(pressReleaseEntityList.get(0).getPressReleaseName()).isEqualTo(
      "pressReleaseName2");
  }

  @Test
  @Order(60)
  public void testDeleteShouldSucceed()
  {
    List<PressReleaseEntity> pressReleaseEntityList =
      pressReleaseRepository.findAll();
    asserts(pressReleaseEntityList);
    PressReleaseEntity pressReleaseEntity = pressReleaseEntityList.get(0);
    assertDoesNotThrow(() -> pressReleaseRepository.delete(pressReleaseEntity));
    pressReleaseEntityList = pressReleaseRepository.findAll();
    assertThat(pressReleaseEntityList.size()).isEqualTo(0);
  }

  private void asserts(List<PressReleaseEntity> pressReleaseEntityList)
  {
    assertThat(pressReleaseEntityList).isNotNull();
    assertThat(pressReleaseEntityList.size()).isNotZero();
    PressReleaseEntity pressReleaseEntity = pressReleaseEntityList.get(0);
    assertThat(pressReleaseEntity).isNotNull();
    assertThat(pressReleaseEntity.getPressReleaseName()).startsWith("pressReleaseName");
  }
}
