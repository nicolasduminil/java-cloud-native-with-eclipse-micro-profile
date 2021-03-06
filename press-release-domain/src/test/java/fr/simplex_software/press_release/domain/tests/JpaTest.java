package fr.simplex_software.press_release.domain.tests;

import fr.simplex_software.press_release.domain.commons.*;
import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.io.*;
import java.sql.*;

public class JpaTest extends TestCommons
{
  private static EntityManagerFactory emf;
  private static EntityManager em;

  @BeforeAll
  public static void init() throws FileNotFoundException, SQLException
  {
    emf = Persistence.createEntityManagerFactory("pr-test");
    em = emf.createEntityManager();
  }

  @AfterAll
  public static void tearDown()
  {
    if (em != null)
    {
      em.clear();
      em.close();
    }
    if (emf != null)
      emf.close();
  }

  public static EntityManagerFactory getEmf()
  {
    return emf;
  }

  public static EntityManager getEm()
  {
    return em;
  }
}
