package ms.ejercicio1_MetodosCRUD.client;

import ms.ejercicio1_MetodosCRUD.model.Vehicle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "vehicles", url = "https://66849cdc56e7503d1ae0ad3d.mockapi.io/vehicles")
public interface VehicleClient {

    @GetMapping("/vehicle")
    public List<Vehicle> readVehicles();

    @GetMapping("/vehicle/{id}")
    public Vehicle readId(@PathVariable("id") Long id);

    @PostMapping("/vehicle")
    public Vehicle createVehicle(@RequestBody Vehicle vehicle);
}

