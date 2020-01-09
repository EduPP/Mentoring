package com.globant.mentoring.models.entity.service;

import java.util.List;
import com.globant.mentoring.models.entity.Cliente;

public interface ClienteService {

	public Cliente findClienteById(long id);
	public List<Cliente> findAll();
}
