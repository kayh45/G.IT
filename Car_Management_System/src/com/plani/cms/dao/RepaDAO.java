package com.plani.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.plani.cms.dto.CarVO;
import com.plani.cms.dto.RepaVO;
import com.plani.cms.util.DBManager;

public class RepaDAO {
	private static RepaDAO instance = new RepaDAO();

	public static RepaDAO getInstance() {
		return instance;
	}
	
	
	public List<RepaVO> selectOnlyDate(String repa_s_date,String repa_e_date){
		String sql = "select * from repa where repa_s_date >='" + repa_s_date + "'and repa_e_date<='" + repa_e_date + "' ";

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
				rVo.setRepa_divi(rs.getString("repa_divi"));
				list.add(rVo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;	
	}
	public List<RepaVO> selectDateCent(String repa_s_date,String repa_e_date,String cent_no){
		String sql = "select * from repa where repa_s_date >='" + repa_s_date + "'and repa_e_date<='" + repa_e_date + "'and cent_no='" + cent_no + "' ";

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
				rVo.setRepa_divi(rs.getString("repa_divi"));
				list.add(rVo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;	
	}
	
	public List<RepaVO> selectDateCentReg(String repa_s_date,String repa_e_date,String cent_no,String car_reg_no){
		String sql = "select * from repa where repa_s_date >='" + repa_s_date + "'and repa_e_date<='" + repa_e_date + "'and cent_no='" + cent_no + "'and car_reg_no='" + car_reg_no + "' ";

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
				rVo.setRepa_divi(rs.getString("repa_divi"));
				list.add(rVo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;	
	}
	
	
	public List<RepaVO> selectDateReg(String repa_s_date,String repa_e_date,String car_reg_no){
		String sql = "select * from repa where repa_s_date >='" + repa_s_date + "'and repa_e_date<='" + repa_e_date + "'and car_reg_no='" + car_reg_no + "' ";

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
				rVo.setRepa_divi(rs.getString("repa_divi"));
				list.add(rVo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;	
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
		String sql = "insert into repa(cent_no, car_reg_no,mechanic_name,repa_s_date,repa_e_date,repa_cont,repa_fee,repa_divi) values(?,?,?,?,?,?,?,?)";

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
			pstmt.setString(8, rVo.getRepa_divi());
		

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	public void updateRepa(RepaVO rVo) {
		String sql = "update repa set cent_no=?, car_reg_no=?,"
				+ "mechanic_name=?,repa_s_date=?,repa_e_date=?,repa_cont=?,repa_fee=?,repa_divi=? where repa_no=?";

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
			pstmt.setString(8, rVo.getRepa_divi());
			pstmt.setInt(9, rVo.getRepa_no());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void DeleteRepa(int repa_no) {

		String sql = "DELETE FROM repa WHERE repa_no = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, repa_no);

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

	public List<CarVO> selectAllCar() {

		String sql = "select * from car order by car_reg_no desc";

		List<CarVO> list = new ArrayList<CarVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				CarVO cVo = new CarVO();

				cVo.setCar_reg_no(rs.getString("car_reg_no"));
				cVo.setCar_divi(rs.getString("car_divi"));
				cVo.setCar_model(rs.getString("car_model"));
				cVo.setCt_date(rs.getString("ct_date"));
				cVo.setEp_date(rs.getString("ep_date"));
				cVo.setCo_name(rs.getString("co_name"));
				cVo.setCo_tel(rs.getString("co_tel"));
				cVo.setCo_fax(rs.getString("co_fax"));
				cVo.setBo_name(rs.getString("bo_name"));
				cVo.setBo_divi(rs.getString("bo_divi"));
				cVo.setBo_age(rs.getInt("bo_age"));
				cVo.setBo_s_date(rs.getString("bo_s_date"));
				cVo.setBo_e_date(rs.getString("bo_e_date"));
				cVo.setTotal_dist(rs.getInt("total_dist"));
				

				list.add(cVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	
	
}