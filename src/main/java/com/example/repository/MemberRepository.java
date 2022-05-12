package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.Member;

@Repository
public class MemberRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;

	
	private RowMapper<Member> ROW_MAPPER_MEMBER=(rs,i)->{
		Member member=new Member();
		member.setId(rs.getInt("id"));
		member.setName(rs.getString("name"));
		member.setAge(rs.getInt("age"));
		member.setDepId(rs.getInt("dep_id"));
		return member;
	};
	
	public List<Member> findName(String name){
		String sql="SELECT name FROM members WHERE name LIKE :name";
		
		return template.query(sql, ROW_MAPPER_MEMBER);
	}
}