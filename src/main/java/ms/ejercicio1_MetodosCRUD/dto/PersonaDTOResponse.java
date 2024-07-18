package ms.ejercicio1_MetodosCRUD.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PersonaDTOResponse {
    private String message;
    private String code;
    private List<PersonaDTO> personaResponseList;
}

