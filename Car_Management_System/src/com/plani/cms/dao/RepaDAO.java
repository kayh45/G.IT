package com.plani.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.plani.cms.dto.CentVO;
import com.plani.cms.dto.RepaVO;
import com.plani.cms.util.DBManager;

public class RepaDAO {
	private static RepaDAO instance = new RepaDAO();

	public static RepaDAO getInstance() {
		return instance;
	}

	public List<RepaVO> selectAllCus() {

		String sql = "select * from repa order by repa_no desc";

		List<RepaVO> list = new ArrayList<RepaVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				RepaVO rVo = new RepaVO();

				rVo.setRepa_no(rs.getInt("repa_no"));
				rVo.setCent_no(rs.getInt("cent_no"));
				rVo.setCar_reg_no(rs.getString("car_reg_no"));
				rVo.setMechanic_name(rs.getString("mechanic_name"));
				rVo.setRepa_s_date(rs.getString("repa_s_date"));
				rVo.setRepa_e_date(rs.getString("repa_e_date"));
				rVo.setRepa_cont(rs.getString("repa_cont"));
				rVo.setRepa_fee(rs.getInt("repa_fee"));
				list.add(rVo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}

	public void insertRepa(RepaVO rVo) {
		String sql = "insert into repa(cent_no, car_reg_no,mechanic_name,repa_s_date,repa_e_date,repa_cont,repa_fee) values(?,?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, rVo.getCent_no());
			pstmt.setString(2, rVo.getCar_reg_no());
			pstmt.setString(3, rVo.getMechanic_name());
			pstmt.setString(4, rVo.getRepa_s_date());
			pstmt.setString(5, rVo.getRepa_e_date());
			pstmt.setString(6, rVo.getRepa_cont());
			pstmt.setInt(7, rVo.getRepa_fee());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	/*
	 * public void updateCent(CentVO cVo) { String sql =
	 * "update cent set cent_name=?, ceo_name=?," +
	 * "cent_tell=?,cent_fax=?,cent_p_no=?,cent_addr=? where cent_no=?";
	 * 
	 * Connection conn = null; PreparedStatement pstmt = null;
	 * 
	 * try { conn = DBManager.getConnection(); pstmt =
	 * conn.prepareStatement(sql);
	 * 
	 * pstmt.setString(1, cVo.getCent_name()); pstmt.setString(2,
	 * cVo.getCeo_name()); pstmt.setString(3, cVo.getCent_tell());
	 * pstmt.setString(4, cVo.getCent_fax()); pstmt.setInt(5,
	 * cVo.getCent_p_no()); pstmt.setString(6, cVo.getCent_addr());
	 * pstmt.setInt(7, cVo.getCent_no());
	 * 
	 * pstmt.executeUpdate(); } catch (SQLException e) { e.printStackTrace(); }
	 * finally { DBManager.close(conn, pstmt); } }
	 * 
	 * public void DeleteCent(int cent_no) {
	 * 
	 * String sql = "DELETE FROM cent WHERE cent_no = ?";
	 * 
	 * Connection conn = null; PreparedStatement pstmt = null;
	 * 
	 * try { conn = DBManager.getConnection(); pstmt =
	 * conn.prepareStatement(sql);
	 * 
	 * pstmt.setInt(1, cent_no);
	 * 
	 * pstmt.executeUpdate();
	 * 
	 * } catch (SQLException e) { e.printStackTrace();
	 * 
	 * } finally { DBManager.close(conn, pstmt);
	 * 
	 * } }
	 */
	public RepaVO repaSearchByCarRegNo(String car_reg_no) {

		String sql = "select * from repa where car_reg_no = '" + car_reg_no + "'";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		RepaVO rVo = new RepaVO();

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			/*
			 * private int repa_no; private int cent_no; private String
			 * car_reg_no; private String mechanic_name; private String
			 * repa_s_date; private String repa_e_date; private String
			 * repa_cont; private int repa_fee;
			 */

			while (rs.next()) {
				rVo.setRepa_no(rs.getInt("repa_no"));
				rVo.setCent_no(rs.getInt("cent_no"));
				rVo.setCar_reg_no(rs.getString("car_reg_no"));
				rVo.setMechanic_name(rs.getString("mechanic_name"));
				rVo.setRepa_s_date(rs.getString("repa_s_date"));
				rVo.setRepa_e_date(rs.getString("repa_e_date"));
				rVo.setRepa_cont(rs.getString("repa_cont"));
				rVo.setRepa_fee(rs.getInt("repa_fee"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return rVo;
	}

	public List<RepaVO> repaSearchByCarRegNoLike(String car_reg_no) {

		String sql = "select * from repa where car_reg_no like '%" + car_reg_no + "%'";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<RepaVO> list = new ArrayList<RepaVO>();

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				RepaVO rVo = new RepaVO();

				rVo.setRepa_no(rs.getInt("repa_no"));
				rVo.setCent_no(rs.getInt("cent_no"));
				rVo.setCar_reg_no(rs.getString("car_reg_no"));
				rVo.setMechanic_name(rs.getString("mechanic_name"));
				rVo.setRepa_s_date(rs.getString("repa_s_date"));
				rVo.setRepa_e_date(rs.getString("repa_e_date"));
				rVo.setRepa_cont(rs.getString("repa_cont"));
				rVo.setRepa_fee(rs.getInt("repa_fee"));

				list.add(rVo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}

}