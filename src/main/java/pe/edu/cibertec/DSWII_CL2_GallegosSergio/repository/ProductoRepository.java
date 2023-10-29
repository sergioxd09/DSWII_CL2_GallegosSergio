package pe.edu.cibertec.DSWII_CL2_GallegosSergio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DSWII_CL2_GallegosSergio.model.bd.Producto;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    Optional<Producto> findByProductoname(String nombre);

    List<Producto> findByProductonameContainingIgnoreCase(String filtro);

    @Query("SELECT p FROM Producto p WHERE p.nombre LIKE %:filtro%")
    List<Producto> filtrarProductoPorNombre(@Param("filtro") String filtro);

    @Query(value = "SELECT * FROM producto WHERE nombre LIKE %:filtro%",
            nativeQuery = true)
    List<Producto> filtrarProductoPorNombreSQL(@Param("filtro") String filtro);

}
