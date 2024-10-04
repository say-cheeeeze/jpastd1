package com.cheeeeze.shop.domain;

import javax.persistence.*;

@Entity
@Table( name = "TBL_BOOK" )
public class BookInfo {
	
	@Id @GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "BOOK_ID")
	private Long id;
	private String title;
	
	public void setId( Long id ) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setTitle( String title ) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
}
