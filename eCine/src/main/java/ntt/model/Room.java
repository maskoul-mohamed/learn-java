package ntt.model;

import javax.persistence.Column;

public class Room extends AbstractModel<Long>{

	/**
	 *
	 */
	private static final long serialVersionUID = 7904385736355383824L;
	
	
	@Column(nullable =false , length= 40)
	private int number;

	private int capacite;
}
