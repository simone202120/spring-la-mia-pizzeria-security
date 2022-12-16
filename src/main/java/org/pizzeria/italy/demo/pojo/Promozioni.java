package org.pizzeria.italy.demo.pojo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class Promozioni {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	@NotNull(message = "la data non puo essere vuota")
	private LocalDate dataInizio; 
	
	@Column
	@NotNull(message = "la data non può essere vuota")
	private LocalDate dataFine; 
	
	@Column(unique = true)
	@NotNull(message = "il titolo deveessere valido")
	private String titolo;
	
	@OneToMany(mappedBy = "Promozioni", cascade = CascadeType.REMOVE)
	private List<Pizza> pizzas;
	
	public Promozioni() { }
	public Promozioni(LocalDate dataInizio, LocalDate dataFine, String titolo) {
		setDataInizio(dataInizio);
		setDataFine(dataFine);
		setTitlolo(titolo);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDate getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}

	public String getTitlolo() {
		return titolo;
	}

	public void setTitlolo(String title) {
		this.titolo = title;
	}
	public List<Pizza> getPizzas() {
		return pizzas;
	}
	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	
	@Override
	public String toString() {
		return  + getId()  + " " + getTitlolo() + "  " + getDataInizio() + " " + getDataFine();
	}
	
	
	
	
}

