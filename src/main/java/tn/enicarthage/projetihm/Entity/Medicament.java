package tn.enicarthage.projetihm.Entity;
import jakarta.persistence.*;
import org.springframework.stereotype.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Medicament {

   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String posologie; // Exemple : "2 comprimés par jour"
    private LocalDateTime heurePrise; // Heure prévue de la prise

    // Many-to-One relation with Personne
    @ManyToOne
    @JoinColumn(name = "personne_id")
    private Personne personne;

    // Constructeurs, getters, setters, etc.
    public Medicament() {}

    public Medicament(String nom, String posologie, LocalDateTime heurePrise, Personne personne) {
        this.nom = nom;
        this.posologie = posologie;
        this.heurePrise = heurePrise;
        this.personne = personne;
    }

    public void setPersonne(Personne personne) {
    	this.personne = personne;
    }

    public String getNom() {
        return  this.nom;
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPosologie() {
		return posologie;
	}

	public void setPosologie(String posologie) {
		this.posologie = posologie;
	}

	public LocalDateTime getHeurePrise() {
		return heurePrise;
	}

	public void setHeurePrise(LocalDateTime heurePrise) {
		this.heurePrise = heurePrise;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}



}

