package ms.ejercicio1_MetodosCRUD.controller;

import ms.ejercicio1_MetodosCRUD.entity.Departamento;
import ms.ejercicio1_MetodosCRUD.service.impl.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class DepartamentoController {
    //inyeccion de dependencia
    @Autowired
    DepartamentoService departamentoService;
    @GetMapping("/departamento/{id_Departamento}")//ruta de donde escucha nuestro micro servicio
    public Optional<Departamento> readById(@PathVariable Long id_Departamento) {//leer por una url
        return departamentoService.readById(id_Departamento);
    }

    @GetMapping("/departamento/todos")
    public List<Departamento> readAll(){
        return departamentoService.readAll();
    }

    @PostMapping ("/departamento")
    public Departamento create(@RequestBody Departamento departamento){//mandar a llamar el metodo
        return departamentoService.create(departamento);
    }

    @PutMapping("/departamento/update")
    public Departamento update(@RequestBody Departamento departamento){
        return departamentoService.update(departamento);
    }

    @DeleteMapping("/departamento/delete")
    public void delete(@RequestBody Departamento departamento){
        departamentoService.delete(departamento);
    }

}






