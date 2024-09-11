package com.GSMC.modelos;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "productos")
public class ProductGSMC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_gsmc", nullable = false)
    private String nombreGSMC;

    @Column(name = "descripcion_gsmc")
    private String descripcionGSMC;

    @Column(name = "precio", nullable = false)
    private BigDecimal precio;
}
