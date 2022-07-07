package fr.simplex_software.press_release.domain.tests;

import fr.simplex_software.press_release.domain.dtos.*;
import fr.simplex_software.press_release.domain.entities.*;
import fr.simplex_software.press_release.domain.mappers.*;
import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestEntities extends JpaTest
{
  private static Long id;

  @Test
  @Order(10)
  public void testPersistShouldSucceed()
  {
    PressReleaseDto pressReleaseDto = unmarshalXmlFileToPressReleaseDto(
      new File("src/test/resources/pr.xml"));
    assertThat(pressReleaseDto).isNotNull();
    PressReleaseEntity pressReleaseEntity =
      PressReleaseMapper.INSTANCE.toEntity(pressReleaseDto);
    getEm().getTransaction().begin();
    getEm().persist(
      pressReleaseEntity);
    assertDoesNotThrow(() -> getEm().getTransaction().commit());
    id = pressReleaseEntity.getPressReleaseId();
  }

  @Test
  @Order(20)
  public void testFindAllShouldSucceed()
  {
    TypedQuery<PressReleaseEntity> q =
      getEm().createQuery("from PressReleaseEntity",
        PressReleaseEntity.class);
    List<PressReleaseEntity> pressReleaseEntities = q.getResultList();
    assertThat(pressReleaseEntities).isNotNull();
    assertThat(pressReleaseEntities.size()).isNotNull();
    assertThat(pressReleaseEntities.size()).isNotZero();
    PressReleaseEntity pressReleaseEntity = pressReleaseEntities.get(0);
    assertThat(pressReleaseEntity).isNotNull();
    assertThat(pressReleaseEntity.getPressReleaseName()).isNotNull();
    assertThat(pressReleaseEntity.getPressReleaseName()).isEqualTo(
      "pressReleaseName1");
  }

  @Test
  @Order(30)
  public void testFindByIdShouldSucceed()
  {
    TypedQuery<PressReleaseEntity> q = getEm().createQuery(
      "select c from PressReleaseEntity c where pressReleaseId = :id",
      PressReleaseEntity.class).setParameter("id", id);
    PressReleaseEntity pressReleaseEntity =
      (PressReleaseEntity) q.getSingleResult();
    assertThat(pressReleaseEntity).isNotNull();
    assertThat(pressReleaseEntity.getPressReleaseName()).isNotNull();
    assertThat(pressReleaseEntity.getPressReleaseName()).isEqualTo(
      "pressReleaseName1");
  }

  @Test
  @Order(40)
  public void testMergeShouldSucceed()
  {
    TypedQuery<PressReleaseEntity> q = getEm().createQuery(
        "select c from PressReleaseEntity c where " +
          "pressReleaseId = :id", PressReleaseEntity.class)
      .setParameter("id", id);
    PressReleaseEntity pressReleaseEntity =
      (PressReleaseEntity) q.getSingleResult();
    pressReleaseEntity.setPressReleaseName("pressReleaseName22");
    getEm().getTransaction().begin();
    getEm().merge(pressReleaseEntity);
    getEm().getTransaction().commit();
    pressReleaseEntity = q.getSingleResult();
    assertThat(pressReleaseEntity).isNotNull();
    assertThat(pressReleaseEntity.getPressReleaseName()).isNotNull();
    assertThat(pressReleaseEntity.getPressReleaseName()).isEqualTo(
      "pressReleaseName22");
  }

  @Test
  @Order(50)
  public void testRemoveShouldSucceed()
  {
    TypedQuery<PressReleaseEntity> q = getEm().createQuery(
        "select c from PressReleaseEntity c where " +
          "pressReleaseId = :id", PressReleaseEntity.class)
      .setParameter("id", id);
    PressReleaseEntity pressReleaseEntity =
      (PressReleaseEntity) q.getSingleResult();
    getEm().getTransaction().begin();
    assertDoesNotThrow(() -> getEm().remove(pressReleaseEntity));
  }
}

