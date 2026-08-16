package com.sassi.bank.services;

import java.util.List;

/**
 * @author Hatem SASSI
 */
public interface AbstractService<T> {

  Integer save(T dto);

  List<T> findAll();

  T findById(Integer id);

  void delete(Integer id);

}
