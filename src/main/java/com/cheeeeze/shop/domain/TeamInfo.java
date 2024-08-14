package com.cheeeeze.shop.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table( name = "TEAM_INFO")
public class TeamInfo {
	
	@Id @GeneratedValue( strategy = GenerationType.AUTO )
	private Long id;
	private String name;
	
	@OneToMany
	@JoinColumn( name = "TEAM_ID")
	private List<MemberInfo> members = new ArrayList<>();
	
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
	
	public List<MemberInfo> getMembers() {
		return members;
	}
	
	public void setMembers( List<MemberInfo> members ) {
		this.members = members;
	}
}
