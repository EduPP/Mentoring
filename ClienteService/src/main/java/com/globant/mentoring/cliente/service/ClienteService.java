package com.globant.mentoring.cliente.service;

import java.util.List;

import com.globant.mentoring.cliente.dto.ClienteDTO;

public interface ClienteService {

	public ClienteDTO findClienteById(long id) throws Exception;
	
	public List<ClienteDTO> findAll() throws Exception;
	
	public ClienteDTO save(ClienteDTO cliente) throws Exception;
	
	public void deleteById(long id) throws Exception;
}
