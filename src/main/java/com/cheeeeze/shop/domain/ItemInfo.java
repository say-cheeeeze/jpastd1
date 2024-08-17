package com.cheeeeze.shop.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table( name = "TBL_ITEM" )
public class ItemInfo {
	
	@Id @GeneratedValue( strategy = GenerationType.AUTO )
	@Column( name = "ITEM_ID" )
	private Long id;
	private String name;
	
	@OneToMany
	@JoinColumn( name = "ITEM_ID" )
	private List<OrderItemInfo> orderItemList = new ArrayList<>();
	
	@ManyToMany( mappedBy = "itemList" ) // 이 연관관계는 카테고리쪽에서 매핑을 다 했다. 주인이 카테고리쪽임.
	private List<CategoryInfo> categoryList = new ArrayList<>();
	
	private int price;
	private int stockQuantity;
	
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
	
	public List<OrderItemInfo> getOrderItemList() {
		return orderItemList;
	}
	
	public void setOrderItemList( List<OrderItemInfo> orderItemList ) {
		this.orderItemList = orderItemList;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice( int price ) {
		this.price = price;
	}
	
	public int getStockQuantity() {
		return stockQuantity;
	}
	
	public void setStockQuantity( int stockQuantity ) {
		this.stockQuantity = stockQuantity;
	}
}
