package ms.ejercicio1_MetodosCRUD.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="departamento")
public class Departamento {
    @Id //para decir que la columna id es la id primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //para mencionar que es autoincrementable
    @Column(name="id_departamento") //para especificar que columna va con el atributo
    private Long idDepartamento;

    @Column(name="m2")
    private Double m2;

    @Column(name="precio")
    private Double precio;

    @Column(name = "isActive")
    private Boolean isActive=true;

    public Departamento setActive(boolean b) {
        return null;
    }
}
