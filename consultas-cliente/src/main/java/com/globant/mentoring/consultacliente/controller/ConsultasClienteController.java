package com.globant.mentoring.consultacliente.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globant.mentoring.consultacliente.models.ClienteDTO;
import com.globant.mentoring.consultacliente.service.ConsultasClienteService;

@RestController
@RequestMapping("/consultas")
public class ConsultasClienteController {

	@Autowired
	private ConsultasClienteService consultasClienteService;
	
	@GetMapping("/antiguedad")
	public ResponseEntity<?> obtenerClientesDesde(@RequestParam String desde){
		Date desdeFecha = new Date();
		try {
			desdeFecha = new SimpleDateFormat("dd-MM-yyyy").parse(desde);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<ClienteDTO> clientes = consultasClienteService.findClientesAntiguos(desdeFecha);	
		return new ResponseEntity<List<ClienteDTO>>(clientes,HttpStatus.OK);
	}
}
