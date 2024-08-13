package com.cheeeeze.shop.domain;

import java.time.LocalDateTime;
import javax.persistence.*;

//@Entity
//@Table( name = "ORDERS" )
public class Order {
	
	@Id @GeneratedValue( strategy = GenerationType.AUTO )
	@Column( name = "ORDER_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn( name = "MEMBER_ID")
	private Member member;
	
	private LocalDateTime orderDate;
	
	@Enumerated( value = EnumType.STRING )
	private OrderStatus status;
	
	public Long getId() {
		return id;
	}
	
	public void setId( Long id ) {
		this.id = id;
	}
	
	public Member getMember() {
		return member;
	}
	
	public void setMember( Member member ) {
		this.member = member;
	}
	
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	
	public void setOrderDate( LocalDateTime orderDate ) {
		this.orderDate = orderDate;
	}
	
	public OrderStatus getStatus() {
		return status;
	}
	
	public void setStatus( OrderStatus status ) {
		this.status = status;
	}
}
