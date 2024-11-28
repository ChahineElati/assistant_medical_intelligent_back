package tn.enicarthage.projetihm.Contrôleurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.enicarthage.projetihm.Services.*;
import tn.enicarthage.projetihm.dto.PersonneLogin;
import tn.enicarthage.projetihm.Entity.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/personnes")
public class PersonneController {
	
    @Autowired
    private PersonneService personneService;

    // API pour login
    @PostMapping("/login")
    public ResponseEntity<Personne> login(@RequestBody PersonneLogin personneLogin) {
    	Personne personne = personneService.getPersonneByEmail(personneLogin.getEmail());
    	if(personne!=null && personne.getPassword().equals(personneLogin.getPassword())) {
    		return new ResponseEntity<>(personne, HttpStatus.ACCEPTED);
    	} else {
    		return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    	}
    }
    
    // API pour créer une personne
    @PostMapping("/create")
    public ResponseEntity<Personne> createPersonne(@RequestBody Personne personne) {
        Personne createdPersonne = personneService.createPersonne(personne);
        return new ResponseEntity<>(createdPersonne, HttpStatus.CREATED);
    }

    // API pour récupérer une personne par son ID
    @GetMapping("/{personneId}")
    public ResponseEntity<Personne> getPersonne(@PathVariable Long personneId) {
        Personne personne = personneService.getPersonneById(personneId);
        return new ResponseEntity<>(personne, HttpStatus.OK);
    }

    // API pour ajouter un médicament à une personne
    @PostMapping("/{personneId}/medicaments")
    public ResponseEntity<Medicament> addMedicamentToPersonne(
            @PathVariable Long personneId, @RequestBody Medicament medicament) {
        Medicament addedMedicament = personneService.addMedicamentToPersonne(personneId, medicament);
        return new ResponseEntity<>(addedMedicament, HttpStatus.CREATED);
    }



    // API pour ajouter un rendez-vous à une personne
    @PostMapping("/{personneId}/rendezvous")
    public ResponseEntity<RendezVous> addRendezVousToPersonne(
            @PathVariable Long personneId, @RequestBody RendezVous rendezVous) {
        RendezVous addedRendezVous = personneService.addRendezVousToPersonne(personneId, rendezVous);
        return new ResponseEntity<>(addedRendezVous, HttpStatus.CREATED);
    }


}
