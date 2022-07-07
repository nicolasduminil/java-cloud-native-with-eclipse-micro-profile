package fr.simplex_software.press_release.service.tests;

import de.hilling.junit.cdi.annotations.*;
import de.hilling.junit.cdi.jee.*;
import de.hilling.junit.cdi.scope.*;
import jakarta.enterprise.context.*;
import jakarta.enterprise.inject.*;
import jakarta.inject.*;
import jakarta.persistence.*;

@TestSuiteScoped
public class EntityManagerProducer
{
  @Inject
  private EntityManagerResourcesProvider entityManagerResourcesProvider;

  @Produces
  @GlobalTestImplementation
  @ApplicationScoped
  public EntityManager getEntityManager()
  {
    return entityManagerResourcesProvider.resolveEntityManager("pr-test");
  }
}
