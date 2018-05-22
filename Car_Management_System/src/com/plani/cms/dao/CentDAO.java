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

public class CentDAO {
	private static CentDAO instance = new CentDAO();

	public static CentDAO getInstance() {
		return instance;
	}

	public List<CentVO> selectAllCus() {

		String sql = "select * from cent order by cent_no desc";

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
				cVo.setCent_addr(rs.getString("cent_addr_dtl"));


				list.add(cVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}

	public void insertCent(CentVO cVo) {
		String sql = "insert into cent(cent_name, ceo_name,"
				+ "cent_tell,cent_fax,cent_p_no,cent_addr,cent_addr_dtl) values(?,?,?,?,?,?,?)";

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
	
	public void updateCent(CentVO cVo) {
		String sql = "update cent set cent_name=?, ceo_name=?,"
				+ "cent_tell=?,cent_fax=?,cent_p_no=?,cent_addr=?,cent_addr_dtl=? where cent_no=?";

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
	
	public void DeleteCent(int cent_no) {

		String sql = "DELETE FROM cent WHERE cent_no = ?";

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
	
	public CentVO centSearchByName(String name) {

		String sql = "select * from cent where cent_name = '" + name + "'";

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

	public List<CentVO> centSearchByNameLike(String name) {

		String sql = "select * from cent where cent_name like '%" + name + "%'";

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

