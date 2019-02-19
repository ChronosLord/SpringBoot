package app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "aula", catalog = "example_db")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,property="@id")
public class Aula implements java.io.Serializable{
	
	private Integer aulaId;
	private String codAula;
	private Character status;
	private Set<AulaAlumno> aulaAlumnos = new HashSet<AulaAlumno>(0);
	
	public Aula() {
		
	}
	
	public Aula(String codAula, Character status, Set<AulaAlumno> aulaAlumnos) {
		this.codAula = codAula;
		this.status = status;
		this.aulaAlumnos = aulaAlumnos;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	
	@Column(name = "aula_id",unique = true, nullable = false)
	public Integer getAulaId() {
		return this.aulaId;
	}
	
	public void setAulaId(Integer aulaId) {
		this.aulaId = aulaId;
	}
	
	@Column(name = "cod_aula",length = 5)
	public String getCodAula() {
		return this.codAula;
	}
	
	public void setCodAula(String codAula) {
		this.codAula = codAula;
	}
	
	@Column(name = "status", length = 1)
	public Character getStatus() {
		return this.status;
	}
	
	public void setStatus(Character status) {
		this.status = status;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "aula")
	public Set<AulaAlumno> getAulaAlumnos() {
		return this.aulaAlumnos;
	}
	
	public void setAulaAlumnos(Set<AulaAlumno> aulaAlumnos) {
		this.aulaAlumnos = aulaAlumnos;
	}
}
