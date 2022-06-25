package fr.simplex_software.press_release.data;

import fr.simplex_software.press_release.domain.entities.*;

import jakarta.enterprise.context.*;
import jakarta.persistence.*;

//@ApplicationScoped
public class PressReleaseRepositoryImpl
  extends CrudRepositoryImpl<PressReleaseEntity>
  implements PressReleaseRepository
{
  public PressReleaseRepositoryImpl()
  {
  }

  public PressReleaseRepositoryImpl(EntityManager entityManager, Class<PressReleaseEntity> entityClass)
  {
    super(entityManager, entityClass);
  }
}
