package app.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import app.model.Amount;
import app.repository.AmountJPARepository;

@RestController
@Service
public class AmountService {
	
	@Autowired
	AmountJPARepository amountJpaRepo;
	
	private static final Logger log = LoggerFactory.getLogger(AmountService.class);
	
	Amount amount = new Amount();
	
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	
	public AmountService() {
		
	}
	
	@GetMapping( path = "/amount/findAll")
	public ResponseEntity<?> findAllFilters(){
		List<Amount> amount = amountJpaRepo.findAll();
		return ResponseEntity.ok(amount);
	}
	
	@DeleteMapping( path = "/amount/{id}")
	public ResponseEntity<?> delete(@PathVariable(name="id",required=true) Integer id){
		amountJpaRepo.deleteById(id);
		List<Amount> amount = amountJpaRepo.findAll();
		return ResponseEntity.ok(amount);
	}
	
	@PostMapping( path = "/amount")
	public ResponseEntity<?> save(@RequestBody Amount am){
		/*
		 * amount.setTrans_name(am.getTrans_name()); Date date1= am.getTrans_date();
		 * Date date2 = new Date(); if (date1.toString().compareTo("")==0) { date1 =
		 * date2; } amount.setTrans_date(date1); amount.setAmount(am.getAmount());
		 */
		amountJpaRepo.save(am);
		List<Amount> amount = amountJpaRepo.findAll();
		return ResponseEntity.ok(amount);
	}
	
	@PutMapping( path = "/amount/{id}")
	public ResponseEntity<?> update(@PathVariable(name= "id", required= true) Integer id,@RequestBody Amount amou){
		amount.setId(id);
		Optional<Amount> am =amountJpaRepo.findById(id);
		Amount amount2=am.orElse(null);
		if(amount2!=null && amount2.getId() == id) {
			if (amou.getTrans_name().compareTo("")!=0) {
				amount2.setTrans_name(amou.getTrans_name());
			}
			if (amou.getAmount() != -1) {
				amount2.setAmount(amou.getAmount());
			}
			if (amou.getTrans_date().toString().compareTo("")!=0) {
				
				amount2.setTrans_date(amou.getTrans_date());
				//log.info("Date amou: {}",amou.getTrans_date());
				//log.info("Date amount2: {}",amount2.getTrans_date());
			}
			amountJpaRepo.save(amount2);
			List<Amount> amount = amountJpaRepo.findAll();
			return ResponseEntity.ok(amount);
		}
		else {
			return ResponseEntity.badRequest().build();
		}
		
	}
}
