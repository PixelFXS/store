package ms.ejercicio1_MetodosCRUD.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "persona")
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

    @ManyToOne
    @JoinColumn(name = "id_Departamento", nullable = false)
    private Departamento fkIdDepartamento;

    public Persona(){
        //constructor vacio
    }

    public Persona(Long idPersona, String nombre, String direccion, byte edad, Departamento fkIdDepartamento) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.direccion = direccion;
        this.edad = edad;
        this.fkIdDepartamento = fkIdDepartamento;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public Departamento getFkIdDepartamento() {
        return fkIdDepartamento;
    }

    public void setFkIdDepartamento(Departamento fkIdDepartamento) {
        this.fkIdDepartamento = fkIdDepartamento;
    }
}
