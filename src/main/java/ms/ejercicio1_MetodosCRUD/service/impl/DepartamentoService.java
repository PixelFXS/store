package ms.ejercicio1_MetodosCRUD.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.ejercicio1_MetodosCRUD.entity.Departamento;
import ms.ejercicio1_MetodosCRUD.repository.DepartamentoRepository;
import ms.ejercicio1_MetodosCRUD.service.IDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class DepartamentoService implements IDepartamentoService { //para utilizar los metodos
    //inyeccion de repositorios
    @Autowired //inyectamos la dependecia en la clase;
            DepartamentoRepository departamentoRepository;

    @Override
    public Optional<Departamento> readById(Long idDepartamento) {
        return departamentoRepository.findById(idDepartamento); //ahora buscamos por id los datos
    }

    @Override
    public List<Departamento> readAll() {
        return departamentoRepository.findAll();
                //.stream().filter(s -> s.getIsActive()).toList(); // busca todos
    }


    @Override
    public Departamento create(Departamento departamento) { //guardar datos
        return departamentoRepository.save(departamento);
    }

    @Override
    public Departamento update(Departamento departamento) {
        return departamentoRepository.save(departamento); //actualizar datos
    }

    @Override
    public String delete(Departamento departamento) {
        Optional<Departamento> optionalDepartamento = departamentoRepository.findById(departamento.getIdDepartamento());
        if (optionalDepartamento.isPresent()) {
            Departamento existingDepartamento = optionalDepartamento.get();
            existingDepartamento.setActive(false);
            try {
                departamentoRepository.delete(existingDepartamento);
                return "departamento " + departamento.getIdDepartamento() + " Borrado";
            } catch (Exception e) {
                log.info("error "+e.getMessage()+" Rastreo "+e.getStackTrace());
                return "No se pudo eliminar";
            }
        }else {
            log.info("No encontrado");
            return "No se encontro el departamento";
        }
    }
}




