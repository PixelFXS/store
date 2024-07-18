package ms.ejercicio1_MetodosCRUD.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.websocket.server.PathParam;
import ms.ejercicio1_MetodosCRUD.dto.PersonaDTO;
import ms.ejercicio1_MetodosCRUD.dto.PersonaDTOResponse;
import ms.ejercicio1_MetodosCRUD.entity.Persona;
import ms.ejercicio1_MetodosCRUD.service.impl.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Persona Controller", description = "Mapping for managgement")
public class PersonaController {
    @Autowired
    PersonaService personaService;

    @Operation(summary = "Obtener empleado por id", description = "Solicitud HTPP para obtener a un empleado mediante el Id" +
            " proporcionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Éxito"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/persona/{idEmpleado}")
    public Optional<Persona> readById(@PathVariable Long idEmpleado){
        return personaService.readById(idEmpleado);
    }


    @GetMapping("/persona/all")
    public List<Persona> readAll(){
        return personaService.readAll();
    }

    @PostMapping("/persona/create")
    public ResponseEntity<Persona> createPersona(@RequestBody Persona persona) {
        Persona savedPersona = personaService.create(persona);
        return new ResponseEntity<>(savedPersona, HttpStatus.CREATED);
    }

    @PutMapping("/persona/update")
    public Persona update(@RequestBody Persona persona){
        return personaService.update(persona);
    }

    @DeleteMapping("persona/delete")
    public void delete(@RequestBody Persona persona){
        personaService.delete(persona);
    }

    @GetMapping("/persona/nombre")
    public List<Persona> findByName(@PathParam("nombre") String nombre){
        return personaService.findName(nombre);
    }

    @GetMapping("persona/edad")
    public List<Persona> findByEdad(@PathParam("edad") Byte edad){
        return personaService.findEdad(edad);
    }

    @GetMapping("persona/direccion")
    public List<Persona> findByDireccion(@PathParam("direccion") String direccion){
        return personaService.findDireccion(direccion);
    }

    @GetMapping("/persona/departamento/{idDepartamento}")
    public ResponseEntity<List<PersonaDTO>> findByDepartamento(@PathVariable Long idDepartamento) {
        List<PersonaDTO> persona = personaService.findByDepartamento(idDepartamento);
        if (persona != null && !persona.isEmpty()) {
            return new ResponseEntity<>(persona, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/personaResponseQuery")
    public ResponseEntity<PersonaDTOResponse> responseQuery(@PathParam("nombre") String nombre) {
        List<PersonaDTO> personaResponseList = personaService.responseQuery(nombre);
        PersonaDTOResponse response;

        if (personaResponseList.isEmpty()) {
            response = PersonaDTOResponse.builder()
                    .message("Not found, verify your parameters")
                    .code("1005")
                    .personaResponseList(personaResponseList)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            response = PersonaDTOResponse.builder()
                    .message("Success")
                    .code("0")
                    .personaResponseList(personaResponseList)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }


}