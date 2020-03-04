package com.globant.mentoring.cliente.dao;

import org.springframework.data.repository.CrudRepository;

import com.globant.mentoring.cliente.entity.Cliente;

public interface ClienteDao extends CrudRepository<Cliente, Long>{

}
