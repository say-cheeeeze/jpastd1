package com.cheeeeze.shop.domain;

import javax.persistence.*;

@Entity
@Table( name = "LOCKER_INFO" )
public class LockerInfo {

	@Id @GeneratedValue
	private Long id;
	
	private String name;
	
	public Long getId() {
		return id;
	}
	
	public void setId( Long id ) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName( String name ) {
		this.name = name;
	}
}
