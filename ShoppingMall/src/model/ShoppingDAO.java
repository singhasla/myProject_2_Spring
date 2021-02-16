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

	//게시물 총 갯수
	public int getCount() {
		String sql = "SELECT COUNT(*) FROM board";
		
		return template.queryForInt(sql);
	}

	//게시물 가져오기
	public List<BoardBean> getAllContent(int startRow, int endRow) {

		String sql = "SELECT * FROM (SELECT (@Rownum := @Rownum+1) Rnum, A.* "
									+ "FROM (SELECT * FROM board "
											+ "ORDER BY ref DESC, re_level ASC)A, (SELECT @ROWNUM := 0)R)B "
					+ "WHERE Rnum > ? AND Rnum <= ?;";
		
		RowMapper<BoardBean> rm = new BeanPropertyRowMapper<BoardBean>(BoardBean.class);
		
		return template.query(sql, rm, startRow-1, endRow);
	}
	
	//게시글 작성
	public void boardInsert(BoardBean bean) {
		
		int ref = 1; //글그룹
		int re_step=1;//부모글인지 자식글인지
		int re_level=1;//글이 보여질 순서를 저장하는 변수
		int readcount=0;
		
		//글그룹이 현제 얼마인지 알아야 소스를 작성
		String refmax ="SELECT MAX(ref) FROM board";
		int refdata = template.queryForInt(refmax);
		if(refdata >= 1 ){
			ref = refdata+1;
		}

		bean.setRef(ref);
		bean.setRe_step(re_step);
		bean.setRe_level(re_level);
		bean.setReadcount(readcount);
		
		String sql="INSERT INTO board VALUES((select max(num)+1 from board a),:writer,:email,"
				+ ":subject,:passwd,now(),:readcount,:ref,:re_step,:re_level,:content)";
		SqlParameterSource sqlsource = new BeanPropertySqlParameterSource(bean);

		template.update(sql, sqlsource);
	}
	
	//하나의 게시글을 리턴
	public BoardBean getOneContent(int num) {
		
		//조회수 증가
		String countsql ="UPDATE board SET readcount=readcount+1 WHERE num=?";
		template.update(countsql, num);
		
		//게시글리턴
		String sql ="SELECT * FROM board WHERE num=?";
		RowMapper<BoardBean> rm = new BeanPropertyRowMapper<BoardBean>(BoardBean.class);
		return template.queryForObject(sql, rm, num);
	}

	//답글쓰기
	public void reWriteboard(BoardBean bean) {
		//답변글로 인하여 기존에 답변글들의 레벨을 1씩 증가하는 쿼리
		String levelsql="UPDATE board SET re_level=re_level+1 WHERE ref=? AND re_level >?";
		template.update(levelsql, bean.getRef(), bean.getRe_level());
		
		//실제 답변글을 저장하는 메소드
		bean.setRe_step(bean.getRe_step()+1);
		bean.setRe_level(bean.getRe_level()+1);
		
		String sql="INSERT INTO board VALUES((select max(num)+1 from board a),:writer,:email,"
				+ ":subject,:passwd,now(),:readcount,:ref,:re_step,:re_level,:content)";
		SqlParameterSource sqlsource = new BeanPropertySqlParameterSource(bean);
		template.update(sql, sqlsource);
	}

	//게시글 수정 
	public void boardUpdate(BoardBean bean) {
		String sql="UPDATE board SET content=? WHERE num=? AND passwd=?";
		template.update(sql, bean.getContent(), bean.getNum(), bean.getPasswd());
	}

	//게시글 삭제
	public void boardDelete(BoardBean bean) {
		String sql="DELETE FROM board WHERE num=? AND passwd=?";
		template.update(sql, bean.getNum(), bean.getPasswd());
		
	}
	
}