package com.globant.mentoring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.globant.mentoring.models.entity.Cliente;
import com.globant.mentoring.models.entity.service.ClienteService;

@RefreshScope
@RestController
public class ClienteController {
	
	@Value("${configuracion.texto}")
	private String texto;
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/cliente/{id}")
	public Cliente obtenerCliente(@PathVariable long id) {
		Cliente cliente = clienteService.findClienteById(id);
		System.out.println(cliente);
		return cliente;
	}
	
	@GetMapping("/clientes")
	public List<Cliente> listarClientes() {
		List<Cliente> clientes = clienteService.findAll();
		return clientes;
	}
	
	@GetMapping("/obtener-config")
	public ResponseEntity<?> obtenerConfiguracion() {
		
		Map<String,String> json = new HashMap<String, String>();
		json.put("texto", texto);
		return new ResponseEntity<Map<String,String>>(json, HttpStatus.OK); 
	}

}
