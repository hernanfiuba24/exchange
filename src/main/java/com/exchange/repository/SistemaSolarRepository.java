package com.exchange.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exchange.model.sistemaSolar.SistemaSolar;

@Repository
public interface SistemaSolarRepository extends CrudRepository<SistemaSolar, Integer> {

}
