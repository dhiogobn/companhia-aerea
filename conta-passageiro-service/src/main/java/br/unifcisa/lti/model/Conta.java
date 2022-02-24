package br.unifcisa.lti.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idConta;
	private String login;
	private String senha;
	private String nomeDeUsuario;
	private Date dataCriacaoConta;
	
	public Conta() {
		super();
	}
	public Conta(String login, String senha, String nomeDeUsuario, Date dataCriacaoConta) {
		super();
		this.login = login;
		this.senha = senha;
		this.nomeDeUsuario = nomeDeUsuario;
		this.dataCriacaoConta = dataCriacaoConta;
	}
	public long getIdConta() {
		return idConta;
	}
	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNomeDeUsuario() {
		return nomeDeUsuario;
	}
	public void setNomeDeUsuario(String nomeDeUsuario) {
		this.nomeDeUsuario = nomeDeUsuario;
	}
	public Date getDataCriacaoConta() {
		return dataCriacaoConta;
	}
	public void setDataCriacaoConta(Date dataCriacaoConta) {
		this.dataCriacaoConta = dataCriacaoConta;
	}
	
	
	
	

}
