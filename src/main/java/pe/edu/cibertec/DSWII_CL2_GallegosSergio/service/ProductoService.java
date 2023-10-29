package pe.edu.cibertec.DSWII_CL2_GallegosSergio.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_CL2_GallegosSergio.model.bd.Producto;
import pe.edu.cibertec.DSWII_CL2_GallegosSergio.repository.ProductoRepository;
import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class ProductoService {

    private ProductoRepository productoRepository;

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    public Optional<Producto> obtenerProductoPorId(Integer id) {
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isEmpty()) {
            return Optional.empty();
        } else
            return producto;
    }


    public void eliminarProducto(Integer id) {
        productoRepository.deleteById(id);
    }

    public List<Producto> buscarProductosPorNombre(String nombre) {
        return productoRepository.findByNombre(nombre);
    }

    public List<Producto> buscarProductosEntre10Y100() {
        return productoRepository.findProductosEntre10y100();
    }

    public List<Producto> buscarProductosPorAnio2024(Integer anio) {
        return productoRepository.findProductosByYear2024(anio);
    }
}


