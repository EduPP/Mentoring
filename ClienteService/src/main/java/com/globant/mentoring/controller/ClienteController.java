package com.globant.mentoring.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
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
import com.globant.mentoring.models.dto.ClienteDTO;
import com.globant.mentoring.models.entity.Cliente;
import com.globant.mentoring.models.entity.service.ClienteService;

@RefreshScope
@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Value("${configuracion.texto}")
	private String texto;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> obtenerCliente(@PathVariable long id) {
		Cliente cliente = clienteService.findClienteById(id);
		ClienteDTO clienteDto = modelMapper.map(cliente, ClienteDTO.class);
		return new ResponseEntity<ClienteDTO>(clienteDto,HttpStatus.OK);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> listarClientes() {
		List<Cliente> clientes = clienteService.findAll();
		List<ClienteDTO> clientesDto = Arrays.asList(modelMapper.map(clientes, ClienteDTO[].class));
		return new ResponseEntity<List<ClienteDTO>>(clientesDto,HttpStatus.OK);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ClienteDTO> crear(@RequestBody ClienteDTO clienteDto){
		Cliente cliente = modelMapper.map(clienteDto, Cliente.class);
		Cliente newclient  = clienteService.save(cliente);
		ClienteDTO clienteDtoResponse = modelMapper.map(newclient, ClienteDTO.class);
		return new ResponseEntity<ClienteDTO>(clienteDtoResponse,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> editar(@RequestBody ClienteDTO clienteDto,  @PathVariable long id){
		Cliente cliente = modelMapper.map(clienteDto, Cliente.class);
		Cliente clienteEncontrado = clienteService.findClienteById(id);

		clienteEncontrado.setEstado(cliente.getEstado());
		clienteEncontrado.setName(cliente.getName());
		clienteEncontrado.setFrom(cliente.getFrom());
		clienteEncontrado.setThrough(cliente.getThrough());
		
		Cliente updatedClient = clienteService.save(clienteEncontrado);
		ClienteDTO clientResponse = modelMapper.map(updatedClient, ClienteDTO.class);
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
