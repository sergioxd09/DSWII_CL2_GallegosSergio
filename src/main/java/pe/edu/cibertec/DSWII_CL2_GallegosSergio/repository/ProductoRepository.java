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
    public List<Producto>  findByNombre(String nombre);

    public List<Producto> findProductosEntre10y100();

    @Query(value = "SELECT * FROM Producto p WHERE YEAR(:fecha) = 2024", nativeQuery = true)
    public List<Producto> findProductosByYear2024(@Param("fecha")Integer anio);


}
