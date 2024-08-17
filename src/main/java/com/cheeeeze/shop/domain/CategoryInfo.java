package com.cheeeeze.shop.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * 카테고리 객체
 */
@Entity
@Table( name = "TBL_CATEGORY" )
public class CategoryInfo {
	
	@Id @GeneratedValue( strategy = GenerationType.AUTO )
	@Column( name = "CATEGORY_ID" )
	private Long id;
	private String name;
	
	@ManyToMany
	@JoinTable( name = "TBL_CATEGORY_ITEM",// 연결 테이블 이름(N:N)
				joinColumns = @JoinColumn( name = "CATEGORY_ID" ), // 내가 조인하는 필드
				inverseJoinColumns = @JoinColumn( name = "ITEM_ID" ) // 반대쪽에 조인하는 필드
				)
	private List<ItemInfo> itemList = new ArrayList<>();
	
	// 자기자신과의 셀프 매핑. 부모 1 카테고리
	@ManyToOne
	@JoinColumn( name = "PARENT_ID" )
	private CategoryInfo parent;
	
	// 자기자신과의 셀프 매핑. 자식 N 카테고리
	@OneToMany( mappedBy = "parent")
	private List<CategoryInfo> childList = new ArrayList<>();
	
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
	
	public List<ItemInfo> getItemList() {
		return itemList;
	}
	
	public void setItemList( List<ItemInfo> itemList ) {
		this.itemList = itemList;
	}
	
	public CategoryInfo getParent() {
		return parent;
	}
	
	public void setParent( CategoryInfo parent ) {
		this.parent = parent;
	}
	
	public List<CategoryInfo> getChildList() {
		return childList;
	}
	
	public void setChildList( List<CategoryInfo> childList ) {
		this.childList = childList;
	}
}
