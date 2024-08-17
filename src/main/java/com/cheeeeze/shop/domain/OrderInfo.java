package com.cheeeeze.shop.domain;

import java.util.Date;
import javax.persistence.*;

/**
 * 주문 정보
 */
@Entity
@Table( name = "TBL_ORDER" )
public class OrderInfo {
	
	@Id @GeneratedValue( strategy = GenerationType.AUTO )
	@Column( name = "ORDER_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn( name = "MEMBER_ID")
	private MemberInfo memberInfo;
	
	// 주문 정보와 배송정보는 1:1
	@OneToOne
	@JoinColumn( name = "DELIVERY_ID") // 연관관계의 주인은 배송정보로 정함
	private DeliveryInfo deliveryInfo;
	
	private Date orderDate;
	
	private OrderStatus orderStatus;
	
	public Long getId() {
		return id;
	}
	
	public void setId( Long id ) {
		this.id = id;
	}
	
	public MemberInfo getMemberInfo() {
		return memberInfo;
	}
	
	public void setMemberInfo( MemberInfo memberInfo ) {
		this.memberInfo = memberInfo;
	}
	
	public DeliveryInfo getDeliveryInfo() {
		return deliveryInfo;
	}
	
	public void setDeliveryInfo( DeliveryInfo deliveryInfo ) {
		this.deliveryInfo = deliveryInfo;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}
	
	public void setOrderDate( Date orderDate ) {
		this.orderDate = orderDate;
	}
	
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	
	public void setOrderStatus( OrderStatus orderStatus ) {
		this.orderStatus = orderStatus;
	}
}
