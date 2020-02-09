package com.locadora.proj.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.TypeAlias;

import com.sun.istack.NotNull;

@Entity
@Table(name = "INF_MOTO")

public class Moto implements Serializable {

	private static final long SerialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long codigo;

	@NotNull
	@Column(name = "COD_MOTO")

	private String cor;
	private String modelo;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public static long getSerialversionuid() {
		return SerialVersionUID;
	}

}
