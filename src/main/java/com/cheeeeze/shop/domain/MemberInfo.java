package com.cheeeeze.shop.domain;

import java.util.ArrayList;
import java.util.List;
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
	
	// 주문 정보에 회원 값이 있기 때문에 굳이 회원에서도 주문 목록을
	// 가지고 있을 필요가 없다.
	// => 주석함이 좋다.
//	@OneToMany( mappedBy = "memberInfo" )
//	private List<OrderInfo> orderList = new ArrayList<>();
	
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
}
