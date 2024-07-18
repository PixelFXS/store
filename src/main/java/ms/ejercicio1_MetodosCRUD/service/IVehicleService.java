package ms.ejercicio1_MetodosCRUD.service;

import ms.ejercicio1_MetodosCRUD.model.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<Vehicle> readAll();
    Vehicle readById(Long id);
    Vehicle create(Vehicle vehicle);
}
