package com.mundogamer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mundogamer.model.Juego;

@Repository
public interface JuegoRepository extends JpaRepository<Juego, Integer> {

	List<Juego> findAllByOrderByDescripcionAsc();
	List<Juego> findAllByOrderByIdJuegosDesc();
	
	@Query("""
            select j
            from Juego as j
            where 
                (j.categoria.idCategoria = :idCategoria or :idCategoria is null or :idCategoria = '')
                and
                (j.descripcion like concat('%', :nombre, '%') or :nombre is null or :nombre = '')
            order by j.descripcion asc
            """)
    List<Juego> findAllByFilters(
        @Param("idCategoria") String idCategoria,
        @Param("nombre") String nombre
    );
	
}
