package com.cheeeeze.shop.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * 상품 정보
 */
@Entity
@Table( name = "TBL_ORDER_ITEM" )
public class OrderItemInfo {
	
	@Id @GeneratedValue( strategy = GenerationType.AUTO )
	@Column( name = "ORDER_ITEM_ID" )
	private Long id;
	
	@ManyToOne
	@JoinColumn( name = "ORDER_ID" )
	private OrderInfo orderInfo;
	
	private int orderPrice;
	private int count;
	
	public Long getId() {
		return id;
	}
	
	public void setId( Long id ) {
		this.id = id;
	}
	
	public OrderInfo getOrderInfo() {
		return orderInfo;
	}
	
	public void setOrderInfo( OrderInfo orderInfo ) {
		this.orderInfo = orderInfo;
	}
	
	
	public int getOrderPrice() {
		return orderPrice;
	}
	
	public void setOrderPrice( int orderPrice ) {
		this.orderPrice = orderPrice;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount( int count ) {
		this.count = count;
	}
}
