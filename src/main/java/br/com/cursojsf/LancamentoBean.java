package br.com.cursojsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.dao.DAOGeneric;
import br.com.entidades.Lancamento;
import br.com.entidades.Pessoa;
import br.com.repository.IDaoLancamento;
import br.com.repository.IDaoLancamentosImpl;

@ViewScoped
@ManagedBean(name = "lancamentoBean")
public class LancamentoBean {
	
	private PessoaBean pessoaBean = new PessoaBean();
	private Lancamento lancamento = new Lancamento();
	private DAOGeneric<Lancamento> daoGeneric = new DAOGeneric<Lancamento>();
	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	private IDaoLancamento iDaoLancamento = new IDaoLancamentosImpl();
	
	public String salvar() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext  externalContext = context.getExternalContext();
		Pessoa pessoaUser = (Pessoa) externalContext.getSessionMap().get("usuarioLogado");
		
		lancamento.setUsuario(pessoaUser);
		lancamento = daoGeneric.merge(lancamento);
		
		carregarLancamentos();
		
		return "";
	}
	
	@PostConstruct
	public void carregarLancamentos(){
		
		Pessoa pessoaUser = pessoaBean.userLogado();
		
		lancamentos = iDaoLancamento.consultar(pessoaUser.getId());
	}
	
	public String novo() {
		lancamento = new Lancamento();
		
		return "";
	}
	
	public String deletar() {
		
		daoGeneric.deletarPorId(lancamento);
		lancamento = new Lancamento();
		carregarLancamentos();
		return "";
	}
	public String limparForm() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		List<String> clientIds = new ArrayList<String>();
		clientIds.add("formLancamento");
		UIViewRoot view = ctx.getViewRoot();
		view.resetValues(ctx, clientIds); // reseta os componentes da lista
		return "";
	}
	
	public Lancamento getLancamento() {
		return lancamento;
	}
	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}
	public DAOGeneric<Lancamento> getDaoGeneric() {
		return daoGeneric;
	}
	public void setDaoGeneric(DAOGeneric<Lancamento> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}
	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}
	
	
	

}
