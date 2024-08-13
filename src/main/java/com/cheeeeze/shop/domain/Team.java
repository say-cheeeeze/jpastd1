package com.cheeeeze.shop.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Team {
	
	@Id @GeneratedValue( strategy = GenerationType.AUTO )
	private Long id;
	private String name;
	
	@OneToMany( mappedBy = "team" )
	private List<Member> members = new ArrayList<>();
	
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
	
	public List<Member> getMembers() {
		return members;
	}
	
	public void setMembers( List<Member> members ) {
		this.members = members;
	}
}
