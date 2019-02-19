package app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "amount", catalog = "example_db")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property = "@id")
public class Amount implements java.io.Serializable{
	
	private Integer id;
	private String trans_name;
	private Date trans_date;
	private Double amount;
	
	public Amount() {
		
	}
	
	public Amount(Integer id,String trans_name,Date trans_date,Double amount) {
		this.id = id;
		this.trans_name = trans_name;
		this.trans_date = trans_date;
		this.amount = amount;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "trans_name", length = 100)
	public String getTrans_name() {
		return this.trans_name;
	}
	
	public void setTrans_name(String trans_name) {
		this.trans_name = trans_name;
	}
	
	@Column(name = "trans_date")
	public Date getTrans_date() {
		return this.trans_date;
	}
	
	public void setTrans_date(Date trans_date) {
		this.trans_date = trans_date;
	}
	
	@Column(name = "amount")
	public Double getAmount() {
		return this.amount;
	}
	
	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
