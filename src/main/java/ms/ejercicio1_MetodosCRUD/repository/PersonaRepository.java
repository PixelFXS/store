package ms.ejercicio1_MetodosCRUD.repository;

import ms.ejercicio1_MetodosCRUD.entity.Departamento;
import ms.ejercicio1_MetodosCRUD.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    //manipulacion del crud
    List<Persona> findByNombre(String nombre);
    List<Persona> findByEdad(Byte edad);
    List<Persona> findByDireccion(String direccion);
    List<Persona> findByFkIdDepartamento_IdDepartamento(Long idDepartamento);

    @Query(value = "select p.nombre, p.direccion, d.m2  from persona p\n" +
            "inner join departamento d  on p.id_Departamento =d.id_Departamento where p.nombre like %:nombre% ", nativeQuery = true)
    List<Object[]> personaResponse(String nombre);


}
