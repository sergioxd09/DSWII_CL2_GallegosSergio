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

    public List<Producto> listarProductos(){
        return productoRepository.findAll();
    }
    public Producto guardar(Producto producto){
        return productoRepository.save(producto);
    }
    public Optional<Producto> obtenerProductoPorId(Integer id){
        Optional<Producto> producto = productoRepository.findById(id);
        if(producto.isEmpty()){
            return Optional.empty();
        }else
            return producto;
    }

    public Optional<Producto> obtenerProductoPorNombre(String nombre){
        Optional<Producto> producto = productoRepository.findByProductoname(nombre);
        if(producto.isEmpty())
            return  Optional.empty();
        else
            return producto;
    }

    public List<Producto> obtenerProductosPorFiltro(String filtro){
        return productoRepository.filtrarProductoPorNombreSQL(filtro);
    }


}
