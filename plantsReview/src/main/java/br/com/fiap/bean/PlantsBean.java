package br.com.fiap.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.fiap.dao.PlantsDao;
import br.com.fiap.model.Plants;

@Named
@RequestScoped
public class PlantsBean {
	
	private Plants plants = new Plants();

	public void save() {
		new PlantsDao().save(this.plants);
		System.out.println("Salvando..." + this.plants);
		FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage("Planta cadastrada com sucesso"));
	}
	
	public List<Plants> getPlants(){
		return new PlantsDao().getAll();
	}

	public Plants getPlants1() {
		return plants;
	}

	public void setPlants(Plants plants) {
		this.plants = plants;
	}


}
