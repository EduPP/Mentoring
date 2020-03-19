package com.globant.mentoring.cliente.service;

import java.util.List;

import com.globant.mentoring.cliente.dto.ClienteDTO;
import com.globant.mentoring.cliente.entity.Cliente;

public interface ClienteService {

	public ClienteDTO findClienteById(Long id) throws Exception;
	
	public Cliente findClienteByUserName(String userName) throws Exception;
	
	public List<ClienteDTO> findAll() throws Exception;
	
	public ClienteDTO save(ClienteDTO cliente) throws Exception;
	
	public void deleteById(Long id) throws Exception;
}
