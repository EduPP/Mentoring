package com.globant.mentoring.cliente.models.entity.service;

import java.util.List;

import com.globant.mentoring.cliente.models.dto.ClienteDTO;

public interface ClienteService {

	public ClienteDTO findClienteById(long id);
	
	public List<ClienteDTO> findAll();
	
	public ClienteDTO save(ClienteDTO cliente) throws Exception;
	
	public void deleteById(long id);
}
