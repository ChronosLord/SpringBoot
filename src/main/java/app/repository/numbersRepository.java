package app.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "/numbers/generateRandomInteger")
public interface numbersRepository {
	
}
