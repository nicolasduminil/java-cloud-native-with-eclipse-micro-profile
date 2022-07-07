package fr.simplex_software.press_release.service;

import fr.simplex_software.press_release.domain.entities.*;
import jakarta.ejb.*;
import jakarta.persistence.*;
import lombok.extern.slf4j.*;

import java.text.*;
import java.time.*;
import java.util.*;

@Stateless
@Slf4j
public class PressReleaseService
{
  private static ResourceBundle myBundle =
    ResourceBundle.getBundle("messages");

  @PersistenceContext
  private EntityManager entityManager;

  public Long save(PressReleaseEntity pressReleaseEntity)
  {
    entityManager.persist(pressReleaseEntity);
    return pressReleaseEntity.getPressReleaseId();
  }

  public List<PressReleaseEntity> findAll()
  {
    List<PressReleaseEntity> pressReleaseEntities =
      entityManager.createNamedQuery(myBundle.getString("PARAMS_ALL"), PressReleaseEntity.class)
        .getResultList();
    if (pressReleaseEntities.size() == 0)
      throw (new EntityNotFoundException(myBundle.getString("FIND_ALL_EXCEPTION")));
    return pressReleaseEntities;
  }

  public List<PressReleaseEntity> findByName(String name)
  {
    List<PressReleaseEntity> pressReleaseEntities =
      entityManager.createNamedQuery(myBundle.getString("PARAMS_BY_NAME"), PressReleaseEntity.class)
        .setParameter("name", name)
        .getResultList();
    if (pressReleaseEntities.size() == 0)
      throw (new EntityNotFoundException(MessageFormat.format(myBundle.getString("FIND_BY_NAME_EXCEPTION"), name)));
    return pressReleaseEntities;
  }

  public List<PressReleaseEntity> findByDate(LocalDate date)
  {
    List<PressReleaseEntity> pressReleaseEntities =
      entityManager.createNamedQuery(myBundle.getString("PARAMS_BY_DATE"), PressReleaseEntity.class)
        .setParameter("date", date)
        .getResultList();
    if (pressReleaseEntities.size() == 0)
      throw (new EntityNotFoundException(MessageFormat.format(myBundle.getString("FIND_BY_DATE_EXCEPTION"), date)));
    return pressReleaseEntities;
  }

  public PressReleaseEntity findById(Long id)
  {
    PressReleaseEntity pressReleaseEntity =
      entityManager.find(PressReleaseEntity.class, id);
    if (pressReleaseEntity == null)
      throw (new EntityNotFoundException(String.format(myBundle.getString("FIND_BY_ID_EXCEPTION"), id)));
    return pressReleaseEntity;
  }

  public PressReleaseEntity update(PressReleaseEntity pressReleaseEntity)
  {
    return entityManager.merge(pressReleaseEntity);
  }

  public void delete(PressReleaseEntity pressReleaseEntity)
  {
    entityManager.remove(pressReleaseEntity);
  }
}
