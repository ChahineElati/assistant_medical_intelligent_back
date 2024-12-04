package tn.enicarthage.projetihm.Entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.*;
import org.springframework.stereotype.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

@Entity
public class Historique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "personne_id", nullable = false)
    private Personne personne;

    @ManyToOne
    @JoinColumn(name = "medicament_id", nullable = false)
    private Medicament medicament;

    private LocalDateTime datePrise;

    private boolean pris; // true = pris, false = raté

    // Getters, Setters, Constructeurs
    public Historique() {}

    public Historique(Personne personne, Medicament medicament, LocalDateTime datePrise, boolean pris) {
        this.personne = personne;
        this.medicament = medicament;
        this.datePrise = datePrise;
        this.pris = pris;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public Medicament getMedicament() {
		return medicament;
	}

	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}

	public LocalDateTime getDatePrise() {
		return datePrise;
	}

	public void setDatePrise(LocalDateTime datePrise) {
		this.datePrise = datePrise;
	}

	public boolean isPris() {
		return pris;
	}

	public void setPris(boolean pris) {
		this.pris = pris;
	}

    // Getters et setters...
    
}
