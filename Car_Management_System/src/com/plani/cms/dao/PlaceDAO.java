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

public class PlaceDAO {

	private static PlaceDAO instance = new PlaceDAO();

	public static PlaceDAO getInstance() {
		return instance;
	} // Singleton 패턴

	
	public void placeInsert(PlaceVO pVo) {
		
		
		String sql = "insert into place(place_name, place_p_no, place_addr, place_addr_dtl)"
				+ " values(?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			
			pstmt.setString(1, pVo.getPlace_name());
			pstmt.setInt(2, pVo.getPlace_p_no());
			pstmt.setString(3, pVo.getPlace_addr());
			pstmt.setString(4, pVo.getPlace_addr_dtl());
			
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt);

		}
	}
	
	public void placeUpdate(PlaceVO pVo) {
		
		
		String sql = "UPDATE place SET place_name = ?, place_p_no = ?, place_addr = ?, place_addr_dtl=? " 
		+ "where place_no = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, pVo.getPlace_name());
			pstmt.setInt(2, pVo.getPlace_p_no());
			pstmt.setString(3, pVo.getPlace_addr());
			pstmt.setString(4, pVo.getPlace_addr_dtl());
			pstmt.setInt(5, pVo.getPlace_no());
			

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt);

		}
	}
	
	public void placeDelete(int place_no) {
		/**
		 * 부서 수정 -> TODO 사원 삭제로 바꿔야됨 TODO
		 * 부서 번호와 부서명을 받아와서 수정
		 * @DeptModifyAction 에서 사용
		 **/
		String sql = "DELETE FROM place WHERE place_no = ?";

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
	
	public PlaceVO placeSearchByName(String name) {

		String sql = "select * from place where place_name = '" + name + "'";

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
	
	public List<PlaceVO> placeSearchByNameLike(String name) {
		/**
		 * 사원 이름에 대한 부분일치 검색
		 * @MemberSearchAction 에서 사용
		 ***/
		String sql = "select * from place where place_name like '%" + name + "%'";
			

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
	
public int confirmPlaceName(String place_name) {
		
		int result = -1;
		String sql = "select place_name from place where place_name=?";
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
			} else if(rs.next()) {
				result = 1; // 데이터 존재.
			System.out.println(result +":통과");
			} else {
				result = -1;
			}
		}// 데이터 없음.
		catch (Exception e) {
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

public List<PlaceVO> selectAllPlace() {

	String sql = "select * from place order by place_no desc";

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

