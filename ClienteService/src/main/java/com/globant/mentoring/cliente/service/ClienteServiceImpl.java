package com.globant.mentoring.cliente.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globant.mentoring.cliente.dao.ClienteDao;
import com.globant.mentoring.cliente.dto.ClienteDTO;
import com.globant.mentoring.cliente.entity.Cliente;
import com.globant.mentoring.cliente.exception.BadRequestException;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteDao clienteDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Value("${exceptions.bad.request.message}")
	private String badRequestMessage;
	
	@Override
	@Transactional(readOnly = true)
	public ClienteDTO findClienteById(long id) throws Exception{	
		Cliente cliente = clienteDao.findById(id).get();
		return modelMapper.map(cliente,ClienteDTO.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ClienteDTO> findAll() throws Exception{	
		List<Cliente> clientes = (List<Cliente>)clienteDao.findAll();
		return Arrays.asList(modelMapper.map(clientes,ClienteDTO[].class));
	}

	@Override
	public ClienteDTO save(ClienteDTO clienteDto) throws Exception {
		validarFechas(clienteDto.getFrom(),clienteDto.getThrough());
		Cliente clienteRequest = modelMapper.map(clienteDto,Cliente.class);
		Cliente clienteNuevo = clienteDao.save(clienteRequest);
		return modelMapper.map(clienteNuevo,ClienteDTO.class);
	}

	@Override
	public void deleteById(long id) throws Exception{
		clienteDao.deleteById(id);		
	}
	
	public void validarFechas(Date fechaMenor, Date fechaMayor) throws Exception {
		if(fechaMenor.compareTo(fechaMayor) >= 0) {
			throw new BadRequestException(badRequestMessage);
		}
	}
	

}
