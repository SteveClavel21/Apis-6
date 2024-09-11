package com.GSMC.dtos.productos;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter

public class ProductoGuardar implements Serializable{

    private String nombreGSMC;
    private String descripcionGSMC;
    private BigDecimal precio;
}
