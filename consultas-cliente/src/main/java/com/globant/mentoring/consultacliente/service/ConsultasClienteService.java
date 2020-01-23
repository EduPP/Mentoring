package com.globant.mentoring.consultacliente.service;

import java.util.Date;
import java.util.List;
import com.globant.mentoring.consultacliente.models.ClienteDTO;

public interface ConsultasClienteService {

	public List<ClienteDTO> findClientesAntiguos(Date desde);
}
