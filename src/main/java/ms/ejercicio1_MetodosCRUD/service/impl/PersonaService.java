package ms.ejercicio1_MetodosCRUD.service.impl;


import ms.ejercicio1_MetodosCRUD.entity.Persona;
import ms.ejercicio1_MetodosCRUD.repository.PersonaRepository;
import ms.ejercicio1_MetodosCRUD.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public Optional<Persona> readById(Long idPersona) {
        return personaRepository.findById(idPersona);
    }

    @Override
    public List<Persona> readAll() {
        return List.of();
    }

    @Override
    public Persona create(Persona persona) {
        return null;
    }

    @Override
    public Persona update(Persona persona) {
        return null;
    }

    @Override
    public void delete(Long idPersona) {

    }
}
