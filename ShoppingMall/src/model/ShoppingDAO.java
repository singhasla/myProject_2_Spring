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
		
		//rm = DB의 테이블 컬럼명을 매칭한 객체
		RowMapper<SuBean> rm = new BeanPropertyRowMapper<SuBean>(SuBean.class);
		
		return template.query(sql, rm);
	}
	
	//왼쪽 카테고리 메뉴 중 선택된 카테고리의 수작업 공구들을 리턴해주는 메소드
	public List<SuBean> getSelectSutool(String num){
		
		String sql =  "SELECT * FROM sutool WHERE sucate=?";
		
		RowMapper<SuBean> rm = new BeanPropertyRowMapper<SuBean>(SuBean.class);
		
		return template.query(sql, rm, num);
	}

	//수작업 공구번호 하나를 전달받아 공구정보를 리턴
	public SuBean getOneSutool(int suno) {
		
		String sql = "SELECT * FROM sutool WHERE suno=?";
		
		//rm = DB의 테이블 컬럼명을 매칭한 객체
		RowMapper<SuBean> rm = new BeanPropertyRowMapper<SuBean>(SuBean.class);
		
		return template.queryForObject(sql, rm, suno);
	}
	
}
