package br.com.cursojsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name="PessoaBean")
public class PessoaBean {
	
	private String nome;
	private String sobrenome;
	private String nomeCompleto;
	
	private List<String> nomeCompletos = new ArrayList<>();
	
	
	public List<String> getNomeCompletos() {
		return nomeCompletos;
	}

	public void setNomeCompletos(List<String> nomeCompletos) {
		this.nomeCompletos = nomeCompletos;
	}
	public void nomeCompleto() {
		nomeCompleto = nome + " "+ sobrenome;
	}

	public String addNome() {
		nomeCompleto();
		nomeCompletos.add(nomeCompleto);
		return "";
	}
	
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	

}
