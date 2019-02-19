package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.Amount;

@Repository("amountJPARepository")
public interface AmountJPARepository extends JpaRepository<Amount, Integer>{
	
}
