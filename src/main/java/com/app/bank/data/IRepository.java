package com.app.bank.data;

import java.util.List;

public interface IRepository<T> {
    int create(T obj);
    T update(T obj);
    void delete(T obj);
    T findById(int id);
    List<T> findAll();
}
