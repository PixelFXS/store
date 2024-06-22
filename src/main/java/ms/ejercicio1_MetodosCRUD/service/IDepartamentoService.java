package ms.ejercicio1_MetodosCRUD.service;


import ms.ejercicio1_MetodosCRUD.entity.Departamento;
import java.util.List;
import java.util.Optional;

public interface IDepartamentoService {
    public Optional<Departamento> readById(Long id_Departamento); //leer solo uno
    public List<Departamento> readAll();
    public Departamento create(Departamento departamento); //crear
    public Departamento update(Departamento departamento); //actualizar
    public void delete(Departamento departamento); //eliminar
}
