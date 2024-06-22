package ms.ejercicio1_MetodosCRUD.repository;

import ms.ejercicio1_MetodosCRUD.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    //manipulacion del crud
}
