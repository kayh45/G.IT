package com.plani.cms.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.plani.cms.dto.CentVO;
import com.plani.cms.util.DBManager;

/**
 * 정비소를 등록, 수정, 삭제, 조회를 할 수 있는 클래스(싱글톤)
 * 
 * @author 조성철
 *
 */
public class CentDAO {
	private static CentDAO instance = new CentDAO();

	public static CentDAO getInstance() {
		return instance;
	}
	
	/**
	 * 정비소 이름으로 정비소 데이터가 있는지 없는지 판단하는 메소드
	 * 
	 * @param cent_name : 정비소 이름 
	 * @return			: 데이터 null : 0 : 데이터 존재 : 1 : 데이터 없음 : -1
	 */
	public int confirmCentName(String cent_name) {

		int result = -1;
		String sql = "SELECT c.CENT_NO "
				   + "  FROM cent c "
				   + " WHERE c.CENT_NO = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, cent_name);

			rs = pstmt.executeQuery();

			if (cent_name.equals("")) {
				// 데이터 NULL
				result = 0;
			
			} else if (rs.next()) {
				 // 데이터 존재.
				result = 1;
				System.out.println(result + ":통과");
		
			} else {
				 // 데이터 없음.
				result = -1;
			}
		} // 데이터 없음.
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
	
	/**
	 * 정비소 데이터를 전체 조회하는 메소드
	 * 
	 * @return : 정비소 리스트
	 */
	public List<CentVO> selectAllCent() {

		String sql = "SELECT c.* "
				   + "  FROM cent c "
				   + " ORDER BY c.CENT_NO DESC";

		List<CentVO> list = new ArrayList<CentVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				CentVO cVo = new CentVO();

				cVo.setCent_no(rs.getInt("cent_no"));
				cVo.setCent_name(rs.getString("cent_name"));
				cVo.setCeo_name(rs.getString("ceo_name"));
				cVo.setCent_tell(rs.getString("cent_tell"));
				cVo.setCent_fax(rs.getString("cent_fax"));
				cVo.setCent_p_no(rs.getInt("cent_p_no"));
				cVo.setCent_addr(rs.getString("cent_addr"));
				cVo.setCent_addr_dtl(rs.getString("cent_addr_dtl"));

				list.add(cVo);
			}
	
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, stmt, rs);
	
		}
		return list;
	}
	
	/**
	 * 정비소 데이터를 등록하는 메소드
	 * @param cVo : cVo 객체
	 */
	public void insertCent(CentVO cVo) {
		String sql = "INSERT INTO cent (CENT_NAME, CEO_NAME, CENT_TELL, CENT_FAX"
				   + "				  , CENT_P_NO, CENT_ADDR, CENT_ADDR_DTL) "
				   + "VALUES(?, ?, ?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, cVo.getCent_name());
			pstmt.setString(2, cVo.getCeo_name());
			pstmt.setString(3, cVo.getCent_tell());
			pstmt.setString(4, cVo.getCent_fax());
			pstmt.setInt(5, cVo.getCent_p_no());
			pstmt.setString(6, cVo.getCent_addr());
			pstmt.setString(7, cVo.getCent_addr_dtl());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	/**
	 * 정비소 데이터를 수정하는 메소드
	 * 
	 * @param cVo : cVo 객체
	 */
	public void updateCent(CentVO cVo) {
		String sql = "UPDATE cent c "
				   + "   SET c.CENT_NAME = ?"
				   + "	   , c.CEO_NAME = ?"
				   + "     , c.CENT_TELL = ?"
				   + "     , c.CENT_FAX = ?"
				   + "     , c.CENT_P_NO = ?"
				   + "     , c.CENT_ADDR = ?"
				   + "     , c.CENT_ADDR_DTL = ?  "
				   + " WHERE c.CENT_NO = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, cVo.getCent_name());
			pstmt.setString(2, cVo.getCeo_name());
			pstmt.setString(3, cVo.getCent_tell());
			pstmt.setString(4, cVo.getCent_fax());
			pstmt.setInt(5, cVo.getCent_p_no());
			pstmt.setString(6, cVo.getCent_addr());
			pstmt.setString(7, cVo.getCent_addr_dtl());
			pstmt.setInt(8, cVo.getCent_no());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	/**
	 * 정비소 데이터를 삭제하는 메소드
	 * @param cent_no : 정비소 번호
	 */
	public void DeleteCent(int cent_no) {

		String sql = "DELETE "
				   + "  FROM cent c"
				   + " WHERE c.CENT_NO = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, cent_no);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt);

		}
	}
	
	/**
	 * 정비소 이름으로 조회하는 메소드
	 * 
	 * @param name : 정비소 이름
	 * @return : 정비소 리스트
	 */

	public CentVO centSearchByName(String name) {

		String sql = "SELECT c.* "
				   + "  FROM cent c "
				   + " WHERE c.CENT_NAME = '" + name + "'";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		CentVO cVo = new CentVO();

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				cVo.setCent_no(rs.getInt("cent_no"));
				cVo.setCent_name(rs.getString("cent_name"));
				cVo.setCeo_name(rs.getString("ceo_name"));
				cVo.setCent_tell(rs.getString("cent_tell"));
				cVo.setCent_fax(rs.getString("cent_fax"));
				cVo.setCent_p_no(rs.getInt("cent_p_no"));
				cVo.setCent_addr(rs.getString("cent_addr"));
				cVo.setCent_addr_dtl(rs.getString("cent_addr_dtl"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return cVo;
	}

	/**
	 * 정비소 이름의 키워드로 데이터 조회하는 메소드
	 * 
	 * @param name : 정비소 이름 키워드
	 * @return 	   : 정비소 리스트
	 */
	public List<CentVO> centSearchByNameLike(String name) {

		String sql = "SELECT c.* "
				   + "  FROM cent c "
				   + " WHERE c.CENT_NAME LIKE '%" + name + "%'";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<CentVO> list = new ArrayList<CentVO>();

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				CentVO cVo = new CentVO();

				cVo.setCent_no(rs.getInt("cent_no"));
				cVo.setCent_name(rs.getString("cent_name"));
				cVo.setCeo_name(rs.getString("ceo_name"));
				cVo.setCent_tell(rs.getString("cent_tell"));
				cVo.setCent_fax(rs.getString("cent_fax"));
				cVo.setCent_p_no(rs.getInt("cent_p_no"));
				cVo.setCent_addr(rs.getString("cent_addr"));
				cVo.setCent_addr_dtl(rs.getString("cent_addr_dtl"));

				list.add(cVo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
}
