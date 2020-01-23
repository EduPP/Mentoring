package com.globant.mentoring.consultacliente.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.globant.mentoring.consultacliente.models.ClienteDTO;


@FeignClient(name = "cliente-servicio")
public interface ClienteClientRest {
	
	@GetMapping("/clientes")
	public ResponseEntity<List<ClienteDTO>> listarClientes();
	
	/*
	@GetMapping("/clientes/{id}")
	public ResponseEntity<?> obtenerCliente(@PathVariable long id);
	
	@PostMapping("/clientes")
	public ResponseEntity<ClienteDTO> crear(@RequestBody ClienteDTO clienteDto) throws Exception;
	
	@PutMapping("/clientes/{id}")
	public ResponseEntity<?> editar(@RequestBody ClienteDTO clienteDto,  @PathVariable long id) throws Exception;
*/
}
