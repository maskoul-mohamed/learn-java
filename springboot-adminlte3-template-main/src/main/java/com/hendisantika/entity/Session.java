package com.hendisantika.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Session extends AbstractModel<Long> {

	/**
	 *
	 */
	private static final long serialVersionUID = -1276375044939213374L;

	
	@Column(name = "date_projection")
	private Date dateProjection;
	
	@Column(name = "beginning_hour")
	private java.sql.Time beginningHour;
	
	@Column(name = "end_time")
	private java.sql.Time endTime;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Film_ID")
    private Movie film;
	
//	@ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="salle_ID")
//    private Salle salle;
}
