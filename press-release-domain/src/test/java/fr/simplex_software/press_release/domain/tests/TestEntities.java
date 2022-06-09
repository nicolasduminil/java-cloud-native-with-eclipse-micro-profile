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

public class TestEntities extends JpaTest
{
  @Test
  public void testPressReleaseDtos()
  {
    System.out.println ("### testPressReleaseDtos(): Start");
    PressReleaseDto pressReleaseDto = unmarshalXmlFileToPressReleaseDto(
      new File("src/test/resources/pr.xml"));
    assertThat(pressReleaseDto).isNotNull();
    getEm().getTransaction().begin();
    getEm().persist(
      PressReleaseMapper.INSTANCE.toEntity(pressReleaseDto));
    System.out.println ("### testPressReleaseDtos(): Done 1");
    getEm().getTransaction().commit();
    TypedQuery<PressReleaseEntity> q = getEm().createQuery("from PressReleaseEntity", PressReleaseEntity.class);
    List<PressReleaseEntity> pressReleaseEntities = q.getResultList();
    assertThat(pressReleaseEntities).isNotNull();
    assertThat(pressReleaseEntities.size()).isNotNull();
    assertThat(pressReleaseEntities.size()).isNotZero();
    System.out.println ("### testPressReleaseDtos(): Done 2");
    PressReleaseEntity pressReleaseEntity = pressReleaseEntities.get(0);
    assertThat(pressReleaseEntity).isNotNull();
    assertThat(pressReleaseEntity.getPressReleaseName()).isNotNull();
    assertThat(pressReleaseEntity.getPressReleaseName()).isEqualTo(
      "pressReleaseName1");
    q = getEm().createQuery(
                 "select c from PressReleaseEntity c where " +
                 "pressReleaseId = :id", PressReleaseEntity.class)
               .setParameter("id",
                             pressReleaseEntity.getPressReleaseId());
    pressReleaseEntity = (PressReleaseEntity) q.getSingleResult();
    assertThat(pressReleaseEntity).isNotNull();
    assertThat(pressReleaseEntity.getPressReleaseName()).isNotNull();
    assertThat(pressReleaseEntity.getPressReleaseName()).isEqualTo(
      "pressReleaseName1");
    pressReleaseEntity.setPressReleaseName("pressReleaseName22");
    getEm().getTransaction().begin();
    getEm().merge(pressReleaseEntity);
    getEm().getTransaction().commit();
    pressReleaseEntity = q.getSingleResult();
    assertThat(pressReleaseEntity).isNotNull();
    assertThat(pressReleaseEntity.getPressReleaseName()).isNotNull();
    assertThat(pressReleaseEntity.getPressReleaseName()).isEqualTo(
      "pressReleaseName22");
    getEm().getTransaction().begin();
    getEm().remove(pressReleaseEntity);
    Query finalQ = q;
    assertThrows(NoResultException.class, finalQ::getSingleResult);
  }
}

