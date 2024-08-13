package com.cheeeeze.shop.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * 주문 정보
 */
@Entity
@Table( name = "ORDER_INFO" )
public class OrderInfo {
	
	@Id @GeneratedValue( strategy = GenerationType.AUTO )
	@Column( name = "ORDER_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn( name = "MEMBER_ID")
	private MemberInfo memberInfo;
	
	// 주문 1 에 관련된 상품 N 목록
	@OneToMany( mappedBy = "orderInfo" )
	private List<OrderItemInfo> orderItemList = new ArrayList<>();
	
	private LocalDateTime orderDate;
	
	@Enumerated( value = EnumType.STRING )
	private OrderStatus status;
	
	public Long getId() {
		return id;
	}
	
	public void setId( Long id ) {
		this.id = id;
	}
	
	public MemberInfo getMemberInfo() {
		return memberInfo;
	}
	
	public void setMemberInfo( MemberInfo member ) {
		this.memberInfo = member;
	}
	
	public List<OrderItemInfo> getOrderItemList() {
		return orderItemList;
	}
	
	public void setOrderItemList( List<OrderItemInfo> orderItemList ) {
		this.orderItemList = orderItemList;
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
