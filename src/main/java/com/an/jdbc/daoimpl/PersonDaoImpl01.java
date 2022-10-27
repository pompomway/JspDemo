package com.an.jdbc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.an.jdbc.utils.Person;
@Component
public class PersonDaoImpl01 extends PersonDaoImpl{
	
	RowMapper<Person> rowMap=new BeanPropertyRowMapper<>(Person.class);
	List<Person>list=new ArrayList<>();
	
	@Override
	public List<Person> getById(JdbcTemplate jt, String... id) {
		for(String idd:id) {
			String sql="select * from login where id=?;";
			List<Person> getList=jt.query(sql,rowMap,idd);
			getList.forEach(x->list.add(x));
		}
		return list;
	}

	@Override
	public List<Person> getByPass(JdbcTemplate jt, String... pass) {
		for(String pas:pass) {
			String sql="select id,pass from login where pass=?;";
			List<Person> getList=jt.query(sql,rowMap,pas);
			getList.forEach(x->list.add(x));
		}
		return list;
	}

}
