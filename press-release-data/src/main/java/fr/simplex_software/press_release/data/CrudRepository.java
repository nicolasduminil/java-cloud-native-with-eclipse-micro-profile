package fr.simplex_software.press_release.data;

import java.util.*;

public interface CrudRepository<T>
{
  void initCriteria();
  Optional<T> findById(Long id);
  List<T> findAll();
  List<T> findByProperty(String propertyName, Object type);
  T save(T t);
  T update(T t);
  void delete(T t);
}
