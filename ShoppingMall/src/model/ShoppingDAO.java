package model;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class ShoppingDAO {

	SimpleJdbcTemplate template;
	DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		
		template = new SimpleJdbcTemplate(dataSource);
	}

	public List<SuBean> getAllSutool() {
		
		String sql = "SELECT * FROM sutool";
		
		//rm = DB의 테이블 컬럼명을 매칭한 객체 생성
		RowMapper<SuBean> rm = new BeanPropertyRowMapper<SuBean>(SuBean.class);
		
		return template.query(sql, rm);
	}
	
	public List<SuBean> getSelectSutool(String num){
		
		String sql =  "SELECT * FROM sutool WHERE sucate=?";
		
		RowMapper<SuBean> rm = new BeanPropertyRowMapper<SuBean>(SuBean.class);
		
		return template.query(sql, rm, num);
	}
	
}
