package ms.ejercicio1_MetodosCRUD.repository;

import ms.ejercicio1_MetodosCRUD.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

}
