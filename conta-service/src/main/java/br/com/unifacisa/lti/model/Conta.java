package br.com.unifacisa.lti.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long conta;
	private String titular;
	private long agencia;
	private double saldo;
	
	public Conta() {
		super();
	}
	public Conta(long conta, String titular, long agencia, double saldo) {
		super();
		this.conta = conta;
		this.titular = titular;
		this.agencia = agencia;
		this.saldo = saldo;
	}
	public long getId() {
		return id;
	}

	public long getConta() {
		return conta;
	}
	public void setConta(long conta) {
		this.conta = conta;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public long getAgencia() {
		return agencia;
	}
	public void setAgencia(long agencia) {
		this.agencia = agencia;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	

	

}
