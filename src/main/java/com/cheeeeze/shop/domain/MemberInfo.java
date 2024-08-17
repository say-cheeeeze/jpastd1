package com.cheeeeze.shop.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table( name = "TBL_MEMBER" )
public class MemberInfo {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@Column( name = "MEMBER_ID")
	private Long id;
	private String name;
	private String street;
	private String city;
	private String zipCode;
	
	@OneToMany
	@JoinColumn( name = "ORDER_ID")
	private List<OrderInfo> orderList = new ArrayList<>();
	
	public String getCity() {
		return city;
	}
	
	public void setCity( String city ) {
		this.city = city;
	}
	
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
	
	public List<OrderInfo> getOrderList() {
		return orderList;
	}
	
	public void setOrderList( List<OrderInfo> orderList ) {
		this.orderList = orderList;
	}
}
