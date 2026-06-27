package com.mundogamer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mundogamer.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String>{

	Cliente findByCorreoAndPassword(String correo, String password);
	
	/*Admin*/
	List<Cliente> findAllByOrderByEstadoAsc();
	List<Cliente> findAllByOrderByIdClienteAsc();
	
	@Query("SELECT c FROM Cliente c WHERE c.correo = :email AND c.password = :password AND c.estado = '1'")
    Cliente autenticar(@Param("email") String email, @Param("password") String password);

	
	@Query("""
	        select c
	        from Cliente as c
	        where 
	            (:idCliente is null or :idCliente = '' or c.idCliente = :idCliente)
	            and
	            (:estado is null or :estado = '' or c.estado = :estado)
	        """)
	List<Cliente> findAllByFilters(
	    @Param("idCliente") String idCliente,
	    @Param("estado") String estado
	);
	
}