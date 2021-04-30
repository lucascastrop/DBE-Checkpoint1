package br.com.fiap.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.fiap.dao.RegisterDao;
import br.com.fiap.model.Register;


@Named
@RequestScoped
public class RegisterBean {
	
	private Register register = new Register();

	public void save() {
		new RegisterDao().save(this.register);
		System.out.println("Salvando..." + this.register);
		FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage("Usuário cadastrado com sucesso"));
	}
	
	public List<Register> getRegister1(){
		return new RegisterDao().getAll();
	}

	public Register getRegister() {
		return register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}


}