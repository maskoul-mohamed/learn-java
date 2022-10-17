package com.hendisantika.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie extends AbstractModel<Long>{


	/**
	 *
	 */
	private static final long serialVersionUID = 8434800877766942973L;

	@Column(nullable=false , length=50)
	private String title;
	
	@Column(nullable= false)
	private int duration;
	
	@Column(nullable = false)
	private int year;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="GENER_ID")
	private Genre genre;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="DIRECTOR_ID")
	private Person director;
	
	
    @ManyToMany
    @JoinTable(
      name="FILM_ACTEUR",
      joinColumns=@JoinColumn(name="ACTOR_ID", referencedColumnName="ID"),
      inverseJoinColumns=@JoinColumn(name="FILM_ID", referencedColumnName="ID"))
    private List<Person> actors;
   
    
    private List<Session> sessions;
    
    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Date created_at;
}