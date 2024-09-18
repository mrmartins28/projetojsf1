package br.com.cursojsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dao.DAOGeneric;
import br.com.entidades.Pessoa;

@ViewScoped
@ManagedBean(name="pessoaBean")
public class PessoaBean {
	
	private Pessoa pessoa = new Pessoa();
	private DAOGeneric<Pessoa> daoGeneric = new DAOGeneric<Pessoa>();
	
	public String salvar() {
		pessoa = daoGeneric.merge(pessoa);
		return "pessoa";
	}
	
	public String novo() {
		pessoa = new Pessoa();
		return "";
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public DAOGeneric<Pessoa> getDaoGeneric() {
		return daoGeneric;
	}

	public void setDaoGeneric(DAOGeneric<Pessoa> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}

}
