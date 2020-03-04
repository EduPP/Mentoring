package com.globant.mentoring.cliente.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.globant.mentoring.cliente.dto.ClienteDTO;
import com.globant.mentoring.cliente.service.ClienteService;

@RefreshScope
@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Value("${configuracion.texto}")
	private String texto;
	
	@Autowired
	private ClienteService clienteService;

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> obtenerCliente(@PathVariable long id) throws Exception {
		ClienteDTO cliente = clienteService.findClienteById(id);
		return new ResponseEntity<ClienteDTO>(cliente,HttpStatus.OK);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<ClienteDTO>> listarClientes() throws Exception {
		List<ClienteDTO> clientes = clienteService.findAll();
	    
		return new ResponseEntity<List<ClienteDTO>>(clientes,HttpStatus.OK);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ClienteDTO> crear(@RequestBody ClienteDTO clienteDto) throws Exception{
		ClienteDTO clienteDtoResponse = clienteService.save(clienteDto);
		return new ResponseEntity<ClienteDTO>(clienteDtoResponse,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> editar(@RequestBody ClienteDTO clienteDto,  @PathVariable long id) throws Exception{
		ClienteDTO clienteEncontrado = clienteService.findClienteById(id);
		clienteEncontrado.setEstado(clienteDto.getEstado());
		clienteEncontrado.setName(clienteDto.getName());
		clienteEncontrado.setFrom(clienteDto.getFrom());
		clienteEncontrado.setThrough(clienteDto.getThrough());
		
		ClienteDTO clientResponse = clienteService.save(clienteEncontrado);
		return new ResponseEntity<ClienteDTO>(clientResponse,HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/obtener-config")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> obtenerConfiguracion() {
		
		Map<String,String> json = new HashMap<String, String>();
		json.put("texto", texto);
		return new ResponseEntity<Map<String,String>>(json, HttpStatus.OK); 
	}

}
