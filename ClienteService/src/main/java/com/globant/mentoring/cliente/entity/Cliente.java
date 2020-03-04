package com.globant.mentoring.cliente.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@Setter
@Getter
@NoArgsConstructor
public class Cliente implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;

	@Column(name = "fecha_inicio")
	@Temporal(TemporalType.DATE)
	private Date from;
	
	@Column(name = "fecha_fin")
	@Temporal(TemporalType.DATE)
	private Date through;
	
	private String estado;

	
	private static final long serialVersionUID = 792594780988936534L;
	
}
