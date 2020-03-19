package com.globant.mentoring.cliente.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.UniqueConstraint;
import javax.persistence.ManyToMany;
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
	private Long id;
	private String name;
	
	@Column(unique = true , length = 20)
	private String username;
	private String password;
	@Column(name = "fecha_inicio")
	@Temporal(TemporalType.DATE)
	private Date from;
	
	@Column(name = "fecha_fin")
	@Temporal(TemporalType.DATE)
	private Date through;	
	private String estado;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "clientes_roles", joinColumns = @JoinColumn(name = "cliente_id"), inverseJoinColumns = @JoinColumn(name = "role_id"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "cliente_id", "role_id" }) })
	private List<Role> roles;
	
	private static final long serialVersionUID = 792594780988936534L;
	
}
