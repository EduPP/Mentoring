package com.globant.mentoring.models.entity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.globant.mentoring.models.dao.ClienteDao;
import com.globant.mentoring.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly = true)
	public Cliente findClienteById(long id) {		
		return clienteDao.findById(id).get();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {		
		return (List<Cliente>)clienteDao.findAll();
	}

}
