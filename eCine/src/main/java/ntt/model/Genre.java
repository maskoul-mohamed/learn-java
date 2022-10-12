package ntt.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Genre extends AbstractModel<Long>{

	/**
	 *
	 */
	private static final long serialVersionUID = 4302912942805839887L;
	
	@Column(nullable=false, length= 50)
	private String libelle;
	
	@OneToMany(mappedBy = "gener")
	@JsonIgnore
	private List<Movie> movie;

}
