package model;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
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

	//로그인시 아이디 중복체크
	public int getLogin(MemberBean mbean) {
		
		String sql = "SELECT count(*) FROM member WHERE memid=?";
		
		return template.queryForInt(sql, mbean.getMemid());

	}

	//회원가입
	public void insertMember(MemberBean mbean) {

		String sql = "INSERT INTO member VALUES (:memid, :mempasswd1, :mempasswd2, :memname, :memphone, :memdate)";
		
		SqlParameterSource sqlsource = new BeanPropertySqlParameterSource(mbean);
		
		template.update(sql, sqlsource);
	}

	//로그인처리
	public int getLoginProc(MemberBean mbean) {
		
		String sql = "SELECT count(*) FROM member WHERE memid=? AND mempasswd1=?";
		
		return template.queryForInt(sql, mbean.getMemid(), mbean.getMempasswd1());

	}
	
}
