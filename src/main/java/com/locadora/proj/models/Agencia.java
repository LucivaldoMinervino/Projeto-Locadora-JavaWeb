package com.locadora.proj.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NegativeOrZero;

import org.springframework.data.annotation.TypeAlias;

import com.sun.istack.NotNull;

@Entity
@Table(name = "INF_AGENCIA")
public class Agencia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long codigo;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	@NotNull
	@Column(name = "NUM_CNPJ")
	private String cnpj;

	@NegativeOrZero
	@Column(name = "NOME_FANT_EMPRESA")
	private String nomefantasia;

	@NotNull
	@Column(name = "TEL_CONTATO")
	private String telefone;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomefantasia() {
		return nomefantasia;
	}

	public void setNomefantasia(String nomefantasia) {
		this.nomefantasia = nomefantasia;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
