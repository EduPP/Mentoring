package com.globant.app.oauth.service;

import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.globant.app.oauth.client.ClienteFeignClient;
import com.globant.app.oauth.model.Cliente;

@Service
public class UsuarioService implements IUsuarioService, UserDetailsService {

	private Logger log = LoggerFactory.getLogger(UsuarioService.class);

	@Autowired
	private ClienteFeignClient feignClient;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
		
		log.info("iniciando load User by Username");
		try {
			Cliente usuario = feignClient.findClienteByUserName(userName).getBody();

			List<GrantedAuthority> authorities = usuario.getRoles().stream()
					.map(role -> new SimpleGrantedAuthority(role.getNombre()))
					.peek(authority -> log.info("Role: " + authority.getAuthority())).collect(Collectors.toList());

			log.info("Usuario autenticado: " + userName);
			return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true,
					authorities);
			
		} catch (Exception e) {
			log.info("Exception en loadUserByUsername() method ");
			log.info(e.getMessage());
			String error = "Error en el login, no existe el usuario '" + userName + "' en el sistema";
			log.error(error);
			throw new UsernameNotFoundException(error);
		}	
	}

	@Override
	public Cliente findByUsername(String userName) {
		try {
			return feignClient.findClienteByUserName(userName).getBody();
		} catch (Exception e) {
			return new Cliente();
		}
		
	}

}
