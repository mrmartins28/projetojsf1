package br.com.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.faces.bean.ViewScoped;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@ViewScoped
@Entity
public class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String sobreNome;
	
	private Integer idade;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento = new Date();
	
	private String sexo;
	
	private String[] frameworks;
	
	private Boolean ativo;
	
	private String login;
	
	private String senha;
	
	private String perfil;
	
	private String escolaridade;
	
	private Integer[] linguagens;
	

	
	public Pessoa() {
		
		
	}
	
	public void setLinguagens(Integer[] linguagens) {
		this.linguagens = linguagens;
	}
	
	public Integer[] getLinguagens() {
		return linguagens;
	}
	
	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}
	
	public String getEscolaridade() {
		return escolaridade;
	}
	
	
	public String getPerfil() {
		return perfil;
	}



	public void setPerfil(String perfil) {
		this.perfil = perfil;
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



	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	
	public Boolean getAtivo() {
		return ativo;
	}

	public String[] getFrameworks() {
		return frameworks;
	}


	public void setFrameworks(String[] frameworks) {
		this.frameworks = frameworks;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getSexo() {
		return sexo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", sobreNome=" + sobreNome + ", idade=" + idade
				+ ", dataNascimento=" + dataNascimento + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
