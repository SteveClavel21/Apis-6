package com.GSMC.servicios.interfaces;

import com.GSMC.dtos.productos.ProductoGuardar;
import com.GSMC.dtos.productos.ProductoModificar;
import com.GSMC.dtos.productos.ProductoSalida;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductoService {
    List<ProductoSalida> obtenerTodos();

    Page<ProductoSalida> obtenerTodosPaginados(Pageable pageable);

    ProductoSalida obtenerPorId(Integer id);

    ProductoSalida crear(ProductoGuardar productoGuardar);

    ProductoSalida editar(ProductoModificar productoModificar);

    void eliminarPorId(Integer id);

}
