package ms.ejercicio1_MetodosCRUD.service;

import ms.ejercicio1_MetodosCRUD.entity.Persona;

import java.util.List;
import java.util.Optional;

public interface IPersonaService {
    public Optional<Persona> readById(Long idPersona);
    public List<Persona> readAll();
    public Persona create(Persona persona);
    public Persona update(Persona persona);
    public void delete(Long idPersona);
}
