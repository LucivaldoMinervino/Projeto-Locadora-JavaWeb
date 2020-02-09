package com.locadora.proj.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import javassist.SerialVersionUID;

@Entity
@Table(name = "INF_CARRO")

public class Carro implements Serializable {

	private static final long SerialVersionUID = 1L;

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
	@Column(name = "MODELO_CARRO")
	private String modelo;

	@NotNull
	@Column(name = "ANO_FABRICACAO")
	private String anofab;

	@NotNull
	@Column(name = " MARCA_CARRO")
	private String marca;

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAnofab() {
		return anofab;
	}

	public void setAnofab(String anofab) {
		this.anofab = anofab;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public static long getSerialversionuid() {
		return SerialVersionUID;
	}

}
