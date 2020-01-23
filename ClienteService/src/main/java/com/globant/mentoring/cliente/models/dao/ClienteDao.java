package com.globant.mentoring.cliente.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.globant.mentoring.cliente.models.entity.Cliente;

public interface ClienteDao extends CrudRepository<Cliente, Long>{

}
