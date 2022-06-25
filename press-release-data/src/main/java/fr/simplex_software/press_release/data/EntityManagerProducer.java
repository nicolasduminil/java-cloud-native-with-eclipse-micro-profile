package fr.simplex_software.press_release.data;

import jakarta.enterprise.context.*;
import jakarta.enterprise.inject.*;
import jakarta.persistence.*;

@ApplicationScoped
public class EntityManagerProducer
{
  @Produces
  public EntityManager getEntityManager()
  {
    return Persistence
      .createEntityManagerFactory("pr-test")
      .createEntityManager();
  }

  public void closeEntityManager(@Disposes @Default EntityManager entityManager)
  {
    if (entityManager.isOpen())
      entityManager.close();
  }
}
