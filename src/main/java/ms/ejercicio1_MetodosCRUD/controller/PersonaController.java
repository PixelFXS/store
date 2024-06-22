package ms.ejercicio1_MetodosCRUD.controller;

import ms.ejercicio1_MetodosCRUD.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PersonaController {
    @Autowired
    ms.ejercicio1_MetodosCRUD.service.impl.PersonaService personaService;
    @GetMapping("/persona/{idEmpleado}")
    public Optional<Persona> readById(@PathVariable Long idEmpleado){
        return personaService.readById(idEmpleado);
    }
}