package com.globant.app.oauth.service;

import com.globant.app.oauth.model.Cliente;

public interface IUsuarioService {
	
	public Cliente findByUsername(String username);

}
