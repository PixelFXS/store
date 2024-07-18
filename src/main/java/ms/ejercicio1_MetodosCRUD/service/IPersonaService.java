package ms.ejercicio1_MetodosCRUD.service;

import ms.ejercicio1_MetodosCRUD.dto.PersonaDTO;
import ms.ejercicio1_MetodosCRUD.dto.PersonaDTOResponse;
import ms.ejercicio1_MetodosCRUD.entity.Persona;

import java.util.List;
import java.util.Optional;

public interface IPersonaService {
    public Optional<Persona> readById(Long idPersona);
    public List<Persona> readAll();
    public Persona create(Persona persona);
    public Persona update(Persona persona);
    public String delete(Persona persona);

    public List<Persona> findEdad(Byte edad);
    public List<Persona> findName(String nombre);
    public List<Persona> findDireccion(String direccion);
     List<PersonaDTO> findByDepartamento(Long idDepartamento);
     List<PersonaDTO> responseQuery(String nombre);
}
