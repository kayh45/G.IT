package com.plani.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.plani.cms.dto.CourseVO;
import com.plani.cms.dto.PlaceCourVO;
import com.plani.cms.dto.PlaceVO;
import com.plani.cms.util.DBManager;

/**
 * 경로를 등록, 수정, 삭제, 조회 하기 할 수 있는 클래스
 * @author 조성철
 *
 */
public class CourseDAO {
	private static CourseDAO instance = new CourseDAO();

	public static CourseDAO getInstance() {
		return instance;
	}
	

	/**
	 * 경로를 등록 할 수 있는 메소드
	 * @param cVo : course 객체
	 */
	public void insertCourse(CourseVO cVo) {
		String sql = "INSERT INTO cour (s_place, e_place, distance, cour_purpo, cour_divi) "
				   + "VALUES(?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			
			pstmt.setInt(1, cVo.getS_place());
			pstmt.setInt(2, cVo.getE_place());
			pstmt.setInt(3, cVo.getDistance());
			pstmt.setString(4, cVo.getCour_purpo());
			pstmt.setString(5, cVo.getCour_divi());
			

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	/**
	 * 경로를 수정할 수 있는 메소드 
	 * @param cVo : course 객체
	 */
	public void updateCourse(CourseVO cVo) {
		String sql = "UPDATE cour "
				   + "	 SET s_place = ?"
				   + "     , e_place = ?"
				   + "     , distance = ?"
				   + "     , cour_purpo = ?"
				   + "     , cour_divi = ? "
				   + " WHERE cour_no = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, cVo.getS_place());
			pstmt.setInt(2, cVo.getE_place());
			pstmt.setInt(3, cVo.getDistance());
			pstmt.setString(4, cVo.getCour_purpo());
			pstmt.setString(5, cVo.getCour_divi());
			pstmt.setInt(6, cVo.getCour_no());
	
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
	
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	/**
	 * 경로를 삭제할 수 있는 메소드
	 * @param course_no
	 */
	public void DeleteCourse(int course_no) {

		String sql = "DELETE FROM cour "
				   + " WHERE cour_no = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, course_no);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt);

		}
	}
	
	/**
	 * 출발지 기준으로 하는 경로 데이터 조회
	 * @param name : 출발지 이름
	 * @return 	   : 경로 리스트 
	 */
	public List<PlaceCourVO> courSplaceSearchByNameLike(String name) {
		String sql ="SELECT c.cour_no"
				  + "	  , c.s_place as 's_place' "
				  + "     , (SELECT place_name "
				  + "		   FROM place "
				  + "		  WHERE place_no = s_place ) as 's_place_name' "
				  + "	  , (SELECT place_addr "
			      + "		   FROM place "
			      + "		  WHERE place_no = s_place) as 's_place_addr' "
			      + "     , (SELECT place_divi "
			      + "	 	   FROM place "
			      + "        WHERE place_no = s_place) as 's_place_divi' "
			      + "	  , c.e_place "
			      + "     , (SELECT place_name "
			      + "		   FROM place "
			      + "        WHERE place_no = e_place) as 'e_place_name' "
			      + "	  , (SELECT place_addr "
			      + "		   FROM place "
			      + "        WHERE place_no = e_place) as 'e_place_addr' "
			      + "     , (SELECT place_divi "
			      + "         FROM place "
			      + "        WHERE place_no = e_place) as 'e_place_divi' "
			      + "     , c.cour_purpo "
			      + "     , c.distance "
			      + "     , c.cour_divi "
			      + "  FROM cour c, place p "
			      + " WHERE p.place_no = c.s_place "
			      + "   AND p.place_name like '%" + name + "%' "
			      + " ORDER BY c.s_place";
		

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<PlaceCourVO> list = new ArrayList<PlaceCourVO>();
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				PlaceCourVO pcVo = new PlaceCourVO();
				
				pcVo.setCour_no(rs.getInt("cour_no"));
				pcVo.setS_place_no(rs.getInt("s_place"));
				pcVo.setS_place_name(rs.getString("s_place_name"));
				pcVo.setS_place_addr(rs.getString("s_place_addr"));
				pcVo.setS_place_divi(rs.getString("s_place_divi"));
				pcVo.setE_place_no(rs.getInt("e_place"));
				pcVo.setE_place_name(rs.getString("e_place_name"));
				pcVo.setE_place_addr(rs.getString("e_place_addr"));
				pcVo.setE_place_divi(rs.getString("e_place_divi"));
				pcVo.setCour_purpo(rs.getString("cour_purpo"));
				pcVo.setDistance(rs.getInt("distance"));
				pcVo.setCour_divi(rs.getString("cour_divi"));
				
				list.add(pcVo);

			}
		
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			DBManager.close(conn, stmt, rs);
		
		}
		return list;
	}
	
	
	/**
	 * 도착지 기준으로 경로를 조회할 수 있는 메소드
	 * @param name : 도착지
	 * @return	   : 경로 리스트
	 */
	public List<PlaceCourVO> courEplaceSearchByNameLike(String name) {
		String sql = "SELECT c.cour_no"
				   + "	   , c.s_place as 's_place'"
				   + "	   , (SELECT place_name "
				   + "		    FROM place "
				   + "     	   WHERE place_no = s_place) as 's_place_name' "
				   + "	   , (SELECT place_addr "
				   + "		    FROM place "
				   + "		   WHERE place_no = s_place) as 's_place_addr' "
				   + "	   , (SELECT place_divi "
				   + "		    FROM place "
				   + "  	   WHERE place_no = s_place) as 's_place_divi'"
				   + "	   , c.e_place "
				   + "     , (SELECT place_name "
				   + "		    FROM place "
				   + "		   WHERE place_no = e_place) as 'e_place_name' "
				   + "	   , (SELECT place_addr "
				   + "		    FROM place "
				   + "         WHERE place_no = e_place) as 'e_place_addr' "
				   + " 	   , (SELECT place_divi "
				   + "		    FROM place "
				   + "		   WHERE place_no = e_place) as 'e_place_divi'"
				   + "	   , c.cour_purpo"
				   + "     , c.distance"
				   + "     , c.cour_divi "
				   + "  FROM cour c, place p "
				   + " WHERE p.place_no = c.e_place "
				   + "	 AND p.place_name like '%" + name + "%' "
				   + " ORDER BY c.e_place";
		
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<PlaceCourVO> list = new ArrayList<PlaceCourVO>();
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				PlaceCourVO pcVo = new PlaceCourVO();
				
				pcVo.setCour_no(rs.getInt("cour_no"));
				pcVo.setS_place_no(rs.getInt("s_place"));
				pcVo.setS_place_name(rs.getString("s_place_name"));
				pcVo.setS_place_addr(rs.getString("s_place_addr"));
				pcVo.setS_place_divi(rs.getString("s_place_divi"));
				pcVo.setE_place_no(rs.getInt("e_place"));
				pcVo.setE_place_name(rs.getString("e_place_name"));
				pcVo.setE_place_addr(rs.getString("e_place_addr"));
				pcVo.setE_place_divi(rs.getString("e_place_divi"));
				pcVo.setCour_purpo(rs.getString("cour_purpo"));
				pcVo.setDistance(rs.getInt("distance"));
				pcVo.setCour_divi(rs.getString("cour_divi"));
				
				list.add(pcVo);
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
	
		} finally {
			DBManager.close(conn, stmt, rs);
		
		}
		return list;
	}
	
	/**
	 * 경로 전체 데이터 조회
	 * @param name	: 경로명
	 * @return		: 경로 리스트
	 */
	public List<PlaceCourVO> courAllplaceSearchByNameLike(String name) {
		String sql = "SELECT c.cour_no"
				   + "	   , c.s_place as 's_place'"
				   + "     , (SELECT place_name "
				   + "		    FROM place "
				   + "         WHERE place_no = s_place) as 's_place_name'"
				   + "     , (SELECT place_addr "
				   + "          FROM place "
				   + "         WHERE place_no = s_place) as 's_place_addr'"
				   + "     , (SELECT place_divi "
				   + "          FROM place "
				   + "         WHERE place_no = s_place) as 's_place_divi'"
				   + " 	   , c.e_place"
				   + "	   , (SELECT place_name "
				   + "          FROM place "
				   + "         WHERE place_no = e_place) as 'e_place_name'"
				   + "	   , (SELECT place_addr "
				   + "          FROM place "
				   + "         WHERE place_no = e_place) as 'e_place_addr'"
				   + "	   , (SELECT place_divi "
				   + "			FROM place "
				   + "		   WHERE place_no = e_place) as 'e_place_divi'"
				   + "	   , c.cour_purpo"
				   + "	   , c.distance"
				   + "     , c.cour_divi "
				   + "  FROM cour c, place p "
				   + " WHERE p.place_no = c.e_place "
				   + " ORDER BY c.s_place";
		
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<PlaceCourVO> list = new ArrayList<PlaceCourVO>();
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				PlaceCourVO pcVo = new PlaceCourVO();
				
				pcVo.setCour_no(rs.getInt("cour_no"));
				pcVo.setS_place_no(rs.getInt("s_place"));
				pcVo.setS_place_name(rs.getString("s_place_name"));
				pcVo.setS_place_addr(rs.getString("s_place_addr"));
				pcVo.setS_place_divi(rs.getString("s_place_divi"));
				pcVo.setE_place_no(rs.getInt("e_place"));
				pcVo.setE_place_name(rs.getString("e_place_name"));
				pcVo.setE_place_addr(rs.getString("e_place_addr"));
				pcVo.setE_place_divi(rs.getString("e_place_divi"));
				pcVo.setCour_purpo(rs.getString("cour_purpo"));
				pcVo.setDistance(rs.getInt("distance"));
				pcVo.setCour_divi(rs.getString("cour_divi"));

				list.add(pcVo);
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, stmt, rs);
		
		}
		return list;
	}

	public List<PlaceVO> placeSearchByNameLike(String name) {
		/**
		 * 사원 이름에 대한 부분일치 검색
		 * @MemberSearchAction 에서 사용
		 */
		String sql = "SELECT p.* "
				   + "	FROM place p "
				   + " WHERE p.place_name LIKE '%" + name + "%'";
			

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<PlaceVO> list = new ArrayList<PlaceVO>();

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				PlaceVO pVo = new PlaceVO();

				pVo.setPlace_no(rs.getInt("place_no"));
				pVo.setPlace_name(rs.getString("place_name"));
				pVo.setPlace_p_no(rs.getInt("place_p_no"));
				pVo.setPlace_addr(rs.getString("place_addr"));
				pVo.setPlace_addr_dtl(rs.getString("place_addr_dtl"));
				
				

				list.add(pVo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	/*public List<CourseVO> selectAllCourse() {
		
		String sql = "select * from course";
			

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<CourseVO> list = new ArrayList<CourseVO>();

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				CourseVO cVo = new CourseVO();

				cVo.setCour_no(rs.getInt("cour_no"));
				cVo.setCour_purpo(rs.getString("cour_purpo"));
				cVo.setDistance(rs.getInt("distance"));
				cVo.setCour_divi(rs.getString("cour_divi"));
				
				list.add(cVo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
*/




}

