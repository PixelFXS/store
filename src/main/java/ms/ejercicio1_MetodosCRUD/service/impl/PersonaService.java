package ms.ejercicio1_MetodosCRUD.service.impl;


import ms.ejercicio1_MetodosCRUD.entity.Departamento;
import ms.ejercicio1_MetodosCRUD.entity.Persona;
import ms.ejercicio1_MetodosCRUD.repository.DepartamentoRepository;
import ms.ejercicio1_MetodosCRUD.repository.PersonaRepository;
import ms.ejercicio1_MetodosCRUD.service.IPersonaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements IPersonaService {

    private static final Logger log = LoggerFactory.getLogger(PersonaService.class);
    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    DepartamentoRepository departamentoRepository;

    @Override
    public Optional<Persona> readById(Long idPersona) {
        return personaRepository.findById(idPersona);
    }

    @Override
    public List<Persona> readAll() {
        return personaRepository.findAll();
    }

    @Override
    public Persona create(Persona persona) {
        Departamento departamento = persona.getFkIdDepartamento();
        if (departamento.getIdDepartamento() == null) {
            departamento = departamentoRepository.save(departamento);
        } else {
            Optional<Departamento> existingDepartamento = departamentoRepository.findById(departamento.getIdDepartamento());
            if (existingDepartamento.isPresent()) {
                departamento = existingDepartamento.get();
            } else {
                departamento = departamentoRepository.save(departamento);
            }
        }
        persona.setFkIdDepartamento(departamento);
        return personaRepository.save(persona);
    }

    @Override
    public Persona update(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public String delete(Persona persona) {
        Optional <Persona>optionalPersona=personaRepository.findById(persona.getIdPersona());
        if(optionalPersona.isPresent()){
            try {
                personaRepository.delete(persona);
                log.info("Persona con id: "+persona.getIdPersona()+" Eliminado***");
                return "Eliminado";
            }catch (Exception e){
                log.info("Error: "+e.getMessage()+" Rastreo: "+e.getStackTrace());
                return "No eliminado";
            }
        }else {
            return "No encontrado";
        }
    }
}
