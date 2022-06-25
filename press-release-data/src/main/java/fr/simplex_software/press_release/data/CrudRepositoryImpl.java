package fr.simplex_software.press_release.data;

import jakarta.enterprise.context.*;
import jakarta.enterprise.inject.*;
import jakarta.inject.*;
import jakarta.persistence.*;
import jakarta.persistence.criteria.*;
import jakarta.transaction.*;

import java.util.*;

public class CrudRepositoryImpl<T> implements CrudRepository<T>
{
  @Inject
  private EntityManager entityManager;
  private Class<T> entityClass;
  private Root<T> root;
  private CriteriaQuery<T> criteriaQuery;
  private CriteriaBuilder criteriaBuilder;

  public CrudRepositoryImpl()
  {
  }

  @SuppressWarnings("unchecked")
  public CrudRepositoryImpl(EntityManager entityManager, Class<T> entityClass)
  {
    this.entityManager = entityManager;
    this.entityClass = entityClass;
    initCriteria();
  }

  @Override
  public void initCriteria()
  {
    criteriaBuilder = entityManager.getCriteriaBuilder();
    criteriaQuery = criteriaBuilder.createQuery(entityClass);
    root = criteriaQuery.from(entityClass);
  }

  @Override
  public Optional<T> findById(Long id)
  {
    return Optional.ofNullable(entityManager.find(entityClass, id));
  }

  @Override
  public List<T> findAll()
  {
    return entityManager.createQuery(criteriaQuery.select(root))
      .getResultList();
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<T> findByProperty(String propertyName, Object type)
  {
    return entityManager.createQuery(criteriaQuery.select(root)
        .where(criteriaBuilder.equal(root.get(propertyName), type)))
      .getResultList();
  }

  @Override
  public T save(T t)
  {
    entityManager.getTransaction().begin();
    entityManager.persist(t);
    entityManager.getTransaction().commit();
    return t;
  }

  @Override
  public T update(T t)
  {
    entityManager.getTransaction().begin();
    t = entityManager.merge(t);
    entityManager.getTransaction().commit();
    return t;
  }

  @Override
  public void delete(T t)
  {
    entityManager.getTransaction().begin();
    entityManager.remove(entityManager.merge(t));
    entityManager.getTransaction().commit();
  }

  @Produces
  public EntityManager getEntityManager()
  {
    return entityManager;
  }

  public void setEntityManager(EntityManager entityManager)
  {
    this.entityManager = entityManager;
  }

  public Class<T> getEntityClass()
  {
    return entityClass;
  }

  public void setEntityClass(Class<T> entityClass)
  {
    this.entityClass = entityClass;
  }
}
