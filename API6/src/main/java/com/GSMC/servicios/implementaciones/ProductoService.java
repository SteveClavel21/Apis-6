package com.GSMC.servicios.implementaciones;

import com.GSMC.dtos.productos.ProductoGuardar;
import com.GSMC.dtos.productos.ProductoModificar;
import com.GSMC.dtos.productos.ProductoSalida;
import com.GSMC.modelos.ProductGSMC;
import com.GSMC.repositorios.IProductoRepository;
import com.GSMC.servicios.interfaces.IProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository productoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductoSalida> obtenerTodos() {
        List<ProductGSMC> productos = productoRepository.findAll();

        return productos.stream()
                .map(producto -> modelMapper.map(producto, ProductoSalida.class))
                .collect(Collectors.toList());
}

@Override
public Page<ProductoSalida> obtenerTodosPaginados(Pageable pageable) {
    Page<ProductGSMC> page = productoRepository.findAll(pageable);

    List<ProductoSalida> productosDto = page.stream()
            .map(producto -> modelMapper.map(producto, ProductoSalida.class))
            .collect(Collectors.toList());

    return new PageImpl<>(productosDto, page.getPageable(), page.getTotalElements());
}

@Override
public ProductoSalida obtenerPorId(Integer id) {
    return modelMapper.map(productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado")), ProductoSalida.class);
}

@Override
public ProductoSalida crear(ProductoGuardar productoGuardar) {
    ProductGSMC producto = productoRepository.save(modelMapper.map(productoGuardar, ProductGSMC.class));
    return modelMapper.map(producto, ProductoSalida.class);
}

@Override
public ProductoSalida editar(ProductoModificar productoModificar) {
    ProductGSMC producto = productoRepository.save(modelMapper.map(productoModificar, ProductGSMC.class));
    return modelMapper.map(producto, ProductoSalida.class);
}

@Override
public void eliminarPorId(Integer id) {
    productoRepository.deleteById(id);
}
 }
