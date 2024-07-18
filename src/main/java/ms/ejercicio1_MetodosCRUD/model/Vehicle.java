package ms.ejercicio1_MetodosCRUD.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Vehicle {
    private Long id;
    private String nameVehicle;
    private String modelVehicle;
    private String fuelVehicle;
    private String typeColor;
}
