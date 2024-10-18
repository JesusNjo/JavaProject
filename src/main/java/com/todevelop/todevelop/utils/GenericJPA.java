package com.todevelop.todevelop.utils;

import java.util.List;
import java.util.Optional;

public interface GenericJPA<E, K> {
    Optional<E> findById(K var1);

    E save(E var1);

    List<E> saveAll(List<E> var1);

    void delete(E var1);
}