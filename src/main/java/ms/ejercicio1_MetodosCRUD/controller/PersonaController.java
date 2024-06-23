package ms.ejercicio1_MetodosCRUD.controller;

import ms.ejercicio1_MetodosCRUD.entity.Persona;
import ms.ejercicio1_MetodosCRUD.service.impl.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PersonaController {
    @Autowired
    PersonaService personaService;
    @GetMapping("/persona/{idEmpleado}")
    public Optional<Persona> readById(@PathVariable Long idEmpleado){
        return personaService.readById(idEmpleado);
    }

    @GetMapping("/persona/all")
    public List<Persona> readAll(){
        return personaService.readAll();
    }

    @PostMapping("/persona/create")
    public ResponseEntity<Persona> createPersona(@RequestBody Persona persona) {
        Persona savedPersona = personaService.create(persona);
        return new ResponseEntity<>(savedPersona, HttpStatus.CREATED);
    }

    @PutMapping("/persona/update")
    public Persona update(@RequestBody Persona persona){
        return personaService.update(persona);
    }

    @DeleteMapping("persona/delete")
    public void delete(@RequestBody Persona persona){
        personaService.delete(persona);
    }
}