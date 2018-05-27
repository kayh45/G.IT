package com.plani.cms.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import com.plani.cms.util.DBManager;
import com.plani.cms.dto.CarVO;

public class CarDAO {
	private static CarDAO instance = new CarDAO();

	public static CarDAO getInstance() {
		return instance;
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

	
	
	
	public List<CarVO> carSearchByNameLike(String car_reg_no) {
		String sql = "select * from car"
				+ " where car_reg_no like '%" + car_reg_no + "%'";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<CarVO> list = new ArrayList<CarVO>();

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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	public int insertCar_payCar(CarVO cVo) {
		int result = -1;
		String sql = "insert into car(car_reg_no, car_divi, car_model,"
				+ "bo_name,bo_divi,bo_age,bo_s_date,bo_e_date,total_dist) values(?,?,?,?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, cVo.getCar_reg_no());
			pstmt.setString(2, cVo.getCar_divi());
			pstmt.setString(3, cVo.getCar_model());
			pstmt.setString(4, cVo.getBo_name());
			pstmt.setString(5, cVo.getBo_divi());
			pstmt.setInt(6, cVo.getBo_age());
			pstmt.setString(7, cVo.getBo_s_date());
			pstmt.setString(8, cVo.getBo_e_date());
			pstmt.setInt(9, cVo.getTotal_dist());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	public void insertCar_rentalCar(CarVO cVo) {
		String sql = "insert into car(car_reg_no, car_divi, car_model, ct_date, ep_date,"
				+ "co_name,co_tel,co_fax,bo_name,bo_divi,bo_age,bo_s_date,bo_e_date,total_dist) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, cVo.getCar_reg_no());
			pstmt.setString(2, cVo.getCar_divi());
			pstmt.setString(3, cVo.getCar_model());
			pstmt.setString(4, cVo.getCt_date());
			pstmt.setString(5, cVo.getEp_date());
			pstmt.setString(6, cVo.getCo_name());
			pstmt.setString(7, cVo.getCo_tel());
			pstmt.setString(8, cVo.getCo_fax());
			pstmt.setString(9, cVo.getBo_name());
			pstmt.setString(10, cVo.getBo_divi());
			pstmt.setInt(11, cVo.getBo_age());
			pstmt.setString(12, cVo.getBo_s_date());
			pstmt.setString(13, cVo.getBo_e_date());
			pstmt.setInt(14, cVo.getTotal_dist());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void updateCar(CarVO cVo) {
		String sql = "update car set car_divi=?, car_model=?,"
				+ "ct_date=?,ep_date=?,co_name=?,co_tel=?,co_fax=?,"
				+ "bo_name=?, bo_divi=?, bo_age=?,bo_s_date=?,bo_e_date=?,total_dist=? "
				+ "where car_reg_no=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, cVo.getCar_divi());
			pstmt.setString(2, cVo.getCar_model());
			pstmt.setString(3, cVo.getCt_date());
			pstmt.setString(4, cVo.getEp_date());
			pstmt.setString(5, cVo.getCo_name());
			pstmt.setString(6, cVo.getCo_tel());
			pstmt.setString(7, cVo.getCo_fax());
			pstmt.setString(8, cVo.getBo_name());
			pstmt.setString(9, cVo.getBo_divi());
			pstmt.setInt(10, cVo.getBo_age());
			pstmt.setString(11, cVo.getBo_s_date());
			pstmt.setString(12, cVo.getBo_e_date());
			pstmt.setInt(13, cVo.getTotal_dist());
			pstmt.setString(14, cVo.getCar_reg_no());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void DeleteCar(String car_reg_no) {

		String sql = "DELETE FROM car WHERE car_reg_no = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, car_reg_no);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt);

		}
	}
	public int confirmCarNo(String car_reg_no) {
		
		int result = -1;
		String sql = "select car_reg_no from car where car_reg_no=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, car_reg_no);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				result = 1; // 데이터 존재.
			} else if(car_reg_no==" ") {
				result = 0;
			
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
}


	