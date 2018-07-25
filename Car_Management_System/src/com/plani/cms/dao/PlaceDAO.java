package com.plani.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.plani.cms.dto.CarVO;
import com.plani.cms.dto.CentVO;
import com.plani.cms.dto.DeptVO;
import com.plani.cms.dto.MemberVO;
import com.plani.cms.dto.PlaceVO;
import com.plani.cms.util.DBManager;

/**
 * 장소를 등록, 수정, 삭제, 조회할 수 있는 클래스
 * @author 조성철
 *
 */
public class PlaceDAO {

	private static PlaceDAO instance = new PlaceDAO();

	public static PlaceDAO getInstance() {
		return instance;
	} // Singleton 패턴

	/**
	 * 장소를 등록할 수 있는 메소드
	 * @param pVo : place 객체
	 */
	public void placeInsert(PlaceVO pVo) {
		
		
		String sql = "INSERT INTO place(place_name"
				   + "				  , place_p_no"
				   + "				  , place_addr"
				   + "				  , place_addr_dtl"
				   + "				  , place_divi) "
				   + "VALUES(?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			
			pstmt.setString(1, pVo.getPlace_name());
			pstmt.setInt(2, pVo.getPlace_p_no());
			pstmt.setString(3, pVo.getPlace_addr());
			pstmt.setString(4, pVo.getPlace_addr_dtl());
			pstmt.setString(5, pVo.getPlace_divi());
			
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt);

		}
	}
	
	/**
	 * 장소를 수정할 수 있는 메소드
	 * @param pVo : place 객체
	 */
	public void placeUpdate(PlaceVO pVo) {
		
		String sql = "UPDATE place "
				   + "SET place_name = ?"
				   + "  , place_p_no = ?"
				   + "  , place_addr = ?"
				   + "  , place_addr_dtl = ?"
				   + "  , place_divi=? " 
				   + "WHERE place_no = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, pVo.getPlace_name());
			pstmt.setInt(2, pVo.getPlace_p_no());
			pstmt.setString(3, pVo.getPlace_addr());
			pstmt.setString(4, pVo.getPlace_addr_dtl());
			pstmt.setString(5, pVo.getPlace_divi());
			pstmt.setInt(6, pVo.getPlace_no());
			

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt);

		}
	}
	
	/**
	 * 장소를 삭제할 수 있는 메소드
	 * @param place_no : 장소 번호
	 */
	public void placeDelete(int place_no) {
		
		String sql = "DELETE FROM place "
				   + " WHERE place_no = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, place_no);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt);

		}
	}
	
	/**
	 * 장소 이름으로 장소를 조회할 수 있는 메소드
	 * @param name : 장소명
	 * @return	   : 장소 리스트
	 */
	public PlaceVO placeSearchByName(String name) {

		String sql = "SELECT p.* "
				   + "  FROM place p"
				   + " WHERE p.place_name = '" + name + "'";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		PlaceVO pVo = new PlaceVO();

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				pVo.setPlace_no(rs.getInt("place_no"));
				pVo.setPlace_name(rs.getString("place_name"));
				pVo.setPlace_p_no(rs.getInt("place_p_no"));
				pVo.setPlace_addr(rs.getString("place_addr"));
				pVo.setPlace_addr_dtl(rs.getString("place_addr_dtl"));

			}
	
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			DBManager.close(conn, stmt, rs);
		
		}
		
		return pVo;
	}
	
	/**
	 * 사원 이름에 대한 부분일치 조회할 수 있는 메소드
	 * @param name : 장소 이름
	 * @return	   : 장소 리스트
	 */
	public List<PlaceVO> placeSearchByNameLike(String name) {
		
		String sql = "SELECT * "
				   + "  FROM place "
				   + " WHERE place_name LIKE '%" + name + "%'";
			

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
				pVo.setPlace_divi(rs.getString("place_divi"));
				
				list.add(pVo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	/**
	 * 장소 데이터 있는지 없는지 확인하는 메소드
	 * @param place_name : 장소명
	 * @return			 : 존재 : 1 : null : 0 : 존재X : -1
	 */
	public int confirmPlaceName(String place_name) {
		
		int result = -1;
		String sql = "SELECT place_name "
				   + "  FROM place "
				   + " WHERE place_name=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, place_name);

			rs = pstmt.executeQuery();

			if (place_name.equals("")) {
				result = 0;
				
			} else if (rs.next()) {
				result = 1; // 데이터 존재.
				System.out.println(result +":통과");
			
			} else {
				result = -1;
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			try {
				if (rs != null)
					rs.close();

				if (pstmt != null)
					pstmt.close();
				
				if (conn != null)
					conn.close();
			
			} catch (Exception e) {
				e.printStackTrace();
			
			}
		}
		return result;
	}
	
	/**
	 * 장소를 전체 조회할 수 있는 메소드
	 * @return : 장소 리스트
	 */
	public List<PlaceVO> selectAllPlace() {

		String sql = "SELECT * "
				   + "  FROM place "
				   + " ORDER BY place_no DESC";
	
		List<PlaceVO> list = new ArrayList<PlaceVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
	
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
				pVo.setPlace_divi(rs.getString("place_divi"));
	
	
				list.add(pVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}

}

