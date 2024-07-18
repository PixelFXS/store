package ms.ejercicio1_MetodosCRUD.controller;

import ms.ejercicio1_MetodosCRUD.model.Vehicle;
import ms.ejercicio1_MetodosCRUD.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class VehicleController {
    @Autowired
    private IVehicleService vehicleService;

    @GetMapping("/vehicle")
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> vehicles = vehicleService.readAll();
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/vehicle/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        Vehicle vehicle = vehicleService.readById(id);
        if (vehicle != null) {
            return new ResponseEntity<>(vehicle, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/vehicle/create")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        Vehicle createdVehicle = vehicleService.create(vehicle);
        return new ResponseEntity<>(createdVehicle, HttpStatus.CREATED);
    }
}
