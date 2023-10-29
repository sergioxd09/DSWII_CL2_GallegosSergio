package pe.edu.cibertec.DSWII_CL2_GallegosSergio.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DSWII_CL2_GallegosSergio.exception.ResourceNotFoundException;
import pe.edu.cibertec.DSWII_CL2_GallegosSergio.model.bd.Producto;
import pe.edu.cibertec.DSWII_CL2_GallegosSergio.service.ProductoService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/producto")
public class ProductoController {

    private ProductoService productoService;


    @GetMapping("")
    public ResponseEntity<List<Producto>> listarProductos(){
        List<Producto> productoList = new ArrayList<>();
        productoService.listarProductos()
                .forEach(productoList::add);
        if(productoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductos(
            @PathVariable("id") Integer id){
        Producto producto = productoService
                .obtenerProductoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El producto con el Id Nro. "+
                        id + " no existe."));

        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Producto>> buscarProductosPorNombre(
            @PathVariable("nombre") String nombre
    ){
        List<Producto> productos = productoService.buscarProductosPorNombre(nombre);
        if (productos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<Producto> registrarProducto(
            @RequestBody Producto producto
    ){
        return new ResponseEntity<>(
                productoService.guardar(producto), HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(
            @PathVariable("id") Integer id,
            @RequestBody Producto producto
    ){
        Producto oldProducto = productoService
                .obtenerProductoPorId(id)
                .orElse(null);
        if (oldProducto != null) {
        oldProducto.setNombre(producto.getNombre());
        oldProducto.setDescripcion(producto.getDescripcion());
        oldProducto.setCantidad(producto.getCantidad());
        oldProducto.setFechaVencimiento(producto.getFechaVencimiento());
        Producto productoupdate = productoService.guardar(oldProducto);
            return new ResponseEntity<>(productoupdate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(
            @PathVariable("id") Integer id
    ){
        productoService.eliminarProducto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    @GetMapping("/cantidad")
    public ResponseEntity<List<Producto>> buscarProductosEntre10Y100(){
        List<Producto> productos = productoService.buscarProductosEntre10Y100();
        if (productos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("/vencimiento/2024/{anio}")
    public ResponseEntity<List<Producto>> buscarProductosPorAnio2024(@PathVariable("anio") Integer anio){
        List<Producto> productoList = new ArrayList<>();
        productoService.buscarProductosPorAnio2024(anio)
                .forEach(productoList::add);
        if (productoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productoList, HttpStatus.OK);
    }

}


