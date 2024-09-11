package com.GSMC.dtos.productos;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter

public class ProductoModificar implements Serializable{
    private Integer id;
    private String nombreGSMC;
    private String descripcionGSMC;
    private BigDecimal precio;

}
