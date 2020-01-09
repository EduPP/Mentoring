package com.globant.mentoring.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.globant.mentoring.models.entity.Cliente;

public interface ClienteDao extends CrudRepository<Cliente, Long>{

}
