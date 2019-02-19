package app.repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import app.model.Alumno;

@RepositoryRestResource()
public interface AlumnoRepository extends PagingAndSortingRepository<Alumno, Integer> {

	Page<Alumno> findAll(Pageable p);
	//List<Alumno> findByApellidos(String apellidos);
	//@RestResource(path = "nameStartsWith", rel = "nameStartsWith")
	//Page<Alumno> findByNameStartsWith(@Param("name") String name, Pageable p);
}