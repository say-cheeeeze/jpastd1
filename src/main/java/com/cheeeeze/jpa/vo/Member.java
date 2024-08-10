package com.cheeeeze.jpa.vo;

import java.util.Date;
import javax.persistence.*;

// 이 애노테이션이 있어야 jpa 가 entity 로 관리한다.
@Entity
@Table
@SequenceGenerator(
			name = "MEMBER_SEQ_GEN",
			sequenceName = "MEMBER_SEQ", //매핑할 시퀀스 이름
			initialValue = 1,
			allocationSize = 50
)
public class Member {
	
	@Id // primary key 애노테이션
	@GeneratedValue( strategy = GenerationType.SEQUENCE,
					 generator = "MEMBER_SEQ_GEN")
	private Long id;
	
	@Column( name = "name", nullable = false )
	private String name;
	/*
	@Enumerated( EnumType.STRING)
	private RoleType roleType;
	
	@Temporal( TemporalType.TIMESTAMP )
	private Date createdDate;
	
	@Temporal( TemporalType.TIMESTAMP )
	private Date lastModifiedDate;
	
	@Lob
	private String description;*/
	
	public Member() {
	}
	
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
}
