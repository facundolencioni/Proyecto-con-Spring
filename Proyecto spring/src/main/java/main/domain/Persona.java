package main.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.Data;

@Entity
@Data
@Table(name="persona")
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpersona;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String apellido;
    
    private String telefono;
    @NotEmpty
    @Email
    private String email;
    @NotNull
    private Double saldo;
}
