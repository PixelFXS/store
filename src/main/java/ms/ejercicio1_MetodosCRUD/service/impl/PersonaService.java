package ms.ejercicio1_MetodosCRUD.service.impl;


import lombok.extern.slf4j.Slf4j;
import ms.ejercicio1_MetodosCRUD.dto.PersonaDTO;
import ms.ejercicio1_MetodosCRUD.entity.Departamento;
import ms.ejercicio1_MetodosCRUD.entity.Persona;
import ms.ejercicio1_MetodosCRUD.repository.DepartamentoRepository;
import ms.ejercicio1_MetodosCRUD.repository.PersonaRepository;
import ms.ejercicio1_MetodosCRUD.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PersonaService implements IPersonaService {
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


    @Override
    public List<Persona> findEdad(Byte edad){
        return personaRepository.findByEdad(edad);
    }

    @Override
    public List<Persona> findName(String nombre){
        return personaRepository.findByNombre(nombre);
    }

    @Override
    public List<Persona> findDireccion(String direccion) {
        return personaRepository.findByDireccion(direccion);
    }

    @Override
    public List<PersonaDTO> findByDepartamento(Long idDepartamento) {
        List<Persona> persona = personaRepository.findByFkIdDepartamento_IdDepartamento(idDepartamento);
        return persona.stream()
                .map(people -> new PersonaDTO(
                        people.getNombre(),
                        people.getDireccion(),
                        people.getFkIdDepartamento().getM2()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonaDTO> responseQuery(String nombre) {
        List<Object[]> objectList=personaRepository.personaResponse(nombre);
        List<PersonaDTO> personaResponseList=objectList.stream().map(s->{
            PersonaDTO personaResponse=new PersonaDTO();
            personaResponse.setNombre(s[0].toString());
            personaResponse.setDireccion(s[1].toString());
            personaResponse.setM2(Double.valueOf(s[2].toString()));
            return personaResponse;
        }).toList();
        return personaResponseList;
    }

}
