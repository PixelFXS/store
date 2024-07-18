package ms.ejercicio1_MetodosCRUD.service.impl;

import ms.ejercicio1_MetodosCRUD.client.VehicleClient;
import ms.ejercicio1_MetodosCRUD.model.Vehicle;
import ms.ejercicio1_MetodosCRUD.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService implements IVehicleService {
    @Autowired
    VehicleClient vehicleClient;

    @Override
    public List<Vehicle> readAll() {
        return vehicleClient.readVehicles();
    }

    @Override
    public Vehicle readById(Long id) {
        return vehicleClient.readId(id);
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        return vehicleClient.createVehicle(vehicle);
    }
}
