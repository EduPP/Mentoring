package com.globant.mentoring.consultacliente.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.globant.mentoring.consultacliente.client.ClienteClientRest;
import com.globant.mentoring.consultacliente.models.ClienteDTO;

@Service
public class ConsultasClienteServiceImpl implements ConsultasClienteService {

	@Autowired
	private ClienteClientRest clienteRest;
	
	@Override
	public List<ClienteDTO> findClientesAntiguos(Date desde) {
	
		List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
		
		clientes = (List<ClienteDTO>)clienteRest.listarClientes().getBody();
		
		Iterator<ClienteDTO> iteracionClientes = clientes.iterator();
		while (iteracionClientes.hasNext()) {
			ClienteDTO cliente = iteracionClientes.next(); // must be called before you can call i.remove()

			if(cliente.getFrom().compareTo(desde) < 0) {
				iteracionClientes.remove();
			}
		}
		
		return clientes;
	}

}
