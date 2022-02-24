package br.unifcisa.lti.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Passagem {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String login;
	private String cpf;
	private Date dataDeCompra;
	private Date dataDoEmbarque;
	private double valor;
	
	public Passagem() {
		super();
	}
	public Passagem(String login, String cpf, Date dataDeCompra, Date dataDoEmbarque, double valor) {
		super();
		this.login = login;
		this.cpf = cpf;
		this.dataDeCompra = dataDeCompra;
		this.dataDoEmbarque = dataDoEmbarque;
		this.valor = valor;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataDeCompra() {
		return dataDeCompra;
	}

	public void setDataDeCompra(Date dataDeCompra) {
		this.dataDeCompra = dataDeCompra;
	}

	public Date getDataDoEmbarque() {
		return dataDoEmbarque;
	}

	public void setDataDoEmbarque(Date dataDoEmbarque) {
		this.dataDoEmbarque = dataDoEmbarque;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public long getId() {
		return id;
	}

	

}
