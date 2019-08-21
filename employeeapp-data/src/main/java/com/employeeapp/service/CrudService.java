package com.employeeapp.service;

import java.util.List;
import java.util.Set;

public interface CrudService<T,ID> {
    List<T> findAll();
    T save(T object);
    T findById(ID id);
    void delete(T object);
    void deleteById(ID id);
}
