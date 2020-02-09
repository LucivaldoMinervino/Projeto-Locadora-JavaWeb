package com.locadora.proj.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.LastModifiedDate;

import com.sun.istack.NotNull;

import javassist.SerialVersionUID;

@Entity
@Table(name = "TAB_CLIENTE")
public class Cliente implements Serializable {

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
	@Column(name = "NOME DO LOCATARIO")
	private String nome;

	@NotNull
	@Column(name = "NOME_RG")
	private String rg;

	@Column(name = "ENDERECO")
	private String datanascimento;
	private String endrua;

	public Long getId() {
		return codigo;
	}

	public void setId(Long id) {
		this.codigo = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(String datanascimento) {
		this.datanascimento = datanascimento;
	}

	public String getEndrua() {
		return endrua;
	}

	public void setEndrua(String endrua) {
		this.endrua = endrua;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
