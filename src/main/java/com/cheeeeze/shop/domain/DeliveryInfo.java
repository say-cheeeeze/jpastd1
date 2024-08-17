package com.cheeeeze.shop.domain;

import javax.persistence.*;

@Entity
@Table( name = "TBL_DELIVERY" )
public class DeliveryInfo {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@Column( name = "DELIVERY_ID")
	private Long id;
	private String street;
	private String city;
	private String zipCode;
	
	// 주문과 배송은 1:1
	// mappedBy 는 주문정보에 의해 연관관계 매핑됨
	@OneToOne( mappedBy = "deliveryInfo")
	private OrderInfo orderInfo;
	
	private DeliveryStatus deliveryStatus;
	
	public Long getId() {
		return id;
	}
	
	public void setId( Long id ) {
		this.id = id;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet( String street ) {
		this.street = street;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity( String city ) {
		this.city = city;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode( String zipCode ) {
		this.zipCode = zipCode;
	}
	
	public OrderInfo getOrderInfo() {
		return orderInfo;
	}
	
	public void setOrderInfo( OrderInfo orderInfo ) {
		this.orderInfo = orderInfo;
	}
	
	public DeliveryStatus getDeliveryStatus() {
		return deliveryStatus;
	}
	
	public void setDeliveryStatus( DeliveryStatus deliveryStatus ) {
		this.deliveryStatus = deliveryStatus;
	}
}
