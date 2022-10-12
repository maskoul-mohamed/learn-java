package ntt.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.Columns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Nationality extends AbstractModel<Long> {

	/**
	 *
	 */
	private static final long serialVersionUID = -7392412712927672061L;

	@Column(nullable = false, length= 50)
	private String libelle;
	
	
	@OneToMany(mappedBy = "nationalite")
	@JsonIgnore
	private List<Person> persons;
	
	
	public String toString() {
		return this.libelle;
	}
	
	public String getLibelle() {
		return this.libelle;
	}
}
