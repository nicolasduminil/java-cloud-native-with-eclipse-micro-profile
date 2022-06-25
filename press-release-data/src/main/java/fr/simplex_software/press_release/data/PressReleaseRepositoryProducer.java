package fr.simplex_software.press_release.data;

import jakarta.enterprise.context.*;
import jakarta.enterprise.inject.*;
import jakarta.enterprise.inject.spi.*;
import jakarta.inject.*;
import jakarta.persistence.*;

import java.lang.reflect.*;

@ApplicationScoped
public class PressReleaseRepositoryProducer
{
  @Inject
  private EntityManager entityManager;

  @Produces
  public CrudRepositoryImpl getCrudRepositoryImpl(InjectionPoint injectionPoint)
  {
    ParameterizedType type = (ParameterizedType) injectionPoint.getType();
    Class classT = (Class) type.getActualTypeArguments()[0];
    CrudRepositoryImpl crudRepository = new CrudRepositoryImpl(entityManager, classT);
    crudRepository.setEntityManager(entityManager);
    return crudRepository;
  }
}
