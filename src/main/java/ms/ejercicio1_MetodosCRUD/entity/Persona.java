package ms.ejercicio1_MetodosCRUD.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "persona")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Persona")
    private Long idPersona;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "edad")
    private byte edad;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Departamento", nullable = false)
    private Departamento fkIdDepartamento;

}
