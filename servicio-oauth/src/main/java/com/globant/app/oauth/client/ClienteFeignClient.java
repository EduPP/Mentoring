package com.globant.app.oauth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.globant.app.oauth.model.Cliente;

@FeignClient(name="cliente-servicio")
@RequestMapping("/clientes")
public interface ClienteFeignClient {

	@GetMapping("/oauth")
	public ResponseEntity<Cliente> findClienteByUserName(@RequestParam("userName") String userName) throws Exception;
	
}
