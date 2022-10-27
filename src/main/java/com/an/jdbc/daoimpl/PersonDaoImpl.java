package com.an.jdbc.daoimpl;



import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.an.jdbc.dao.PersonDao;
import com.an.jdbc.utils.Person;

public abstract class PersonDaoImpl implements PersonDao{

	@Override
	public int save(JdbcTemplate jt, Person person) {
		String sql="insert into login (id,pass)value(?,?);";
		return jt.update(sql,person.getId(),person.getPass());
	}

	@Override
	public int update(JdbcTemplate jt, Person person) {
		String sql="update login set pass=? where pk=?;";
		return jt.update(sql,person.getPass(),person.getPk());
	}

	@Override
	public int delete(JdbcTemplate jt, int pk) {
		String sql="delete from login where pk=?;";
		return jt.update(sql,pk);
	}

	@Override
	public Person getByPk(JdbcTemplate jt, int pk) {
		String sql="select id,pass from login where pk=?;";
		Person pn=new Person();
		RowMapper<Person> rowMap=new BeanPropertyRowMapper<>(Person.class);
		try {
			pn=jt.queryForObject(sql,rowMap,pk);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pn;
	}

	

}
