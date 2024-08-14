package com.cheeeeze.shop.domain;

import javax.persistence.*;

@Entity
@Table( name = "MEMBER_INFO" )
public class MemberInfo {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@Column( name = "MEMBER_ID")
	private Long id;
	private String name;
	private String street;
	private String zipCode;
	
	@OneToOne
	@JoinColumn( name = "LOCKER_ID")
	private LockerInfo lockerInfo;
	
	
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
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet( String street ) {
		this.street = street;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode( String zipCode ) {
		this.zipCode = zipCode;
	}
	
	public LockerInfo getLockerInfo() {
		return lockerInfo;
	}
	
	public void setLockerInfo( LockerInfo lockerInfo ) {
		this.lockerInfo = lockerInfo;
	}
}
