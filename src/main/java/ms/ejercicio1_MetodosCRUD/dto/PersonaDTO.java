package ms.ejercicio1_MetodosCRUD.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {
    private String nombre;
    private String direccion;
    private Double m2;
}
