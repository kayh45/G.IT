package com.plani.cms.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.plani.cms.dto.CarlogVO;
import com.plani.cms.util.DBManager;

public class CarlogDAO {

	private static CarlogDAO instance = new CarlogDAO();

	public static CarlogDAO getInstance() {
		return instance;
	}
	
/*	private int driv_no;
	private String mem_id;
	private String car_reg_no;
	private int cour_no;
	private String driv_s_date;
	private String driv_e_date;
	private String driv_purpo;
	private String card_divi;
	private int oil_fee;
	private int trans_fee;
	private String etc_text;
	private int etc_fee;
	private int befo_dist;*/
	
	public void updateCarlog(CarlogVO cVo) {
		String sql = "update driv set cour_no=?, driv_purpo=?, card_divi=?, oil_fee=?, trans_fee=?, etc_text=?, etc_fee=?, befo_dist=? "
				+ "where driv_no=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, cVo.getCour_no());
			pstmt.setString(2, cVo.getDriv_purpo());
			pstmt.setString(3, cVo.getCard_divi());
			pstmt.setInt(4, cVo.getOil_fee());
			pstmt.setInt(5, cVo.getTrans_fee());
			pstmt.setString(6, cVo.getEtc_text());
			pstmt.setInt(7, cVo.getEtc_fee());
			pstmt.setInt(8, cVo.getBefo_dist());
			pstmt.setInt(9, cVo.getDriv_no());
	
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void DeleteCarlog(int driv_no) {

		String sql = "DELETE FROM driv WHERE driv_no = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, driv_no);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt);

		}
	}
public List<CarlogVO> drivSearchByNameComplete(String mem_id) {
	String sql ="select d.driv_no, d.car_reg_no, cc.car_model, m.mem_id, m.mem_name, d.driv_s_date, d.driv_e_date, d.cour_no, d.driv_purpo, "
			+ "(select place_name from place where place_no = s_place) as 's_place_name', "
			+ "(select place_name from place where place_no = e_place) as 'e_place_name', "
			+ "c.distance, d.card_divi, d.oil_fee, d.trans_fee, d.etc_text, d.etc_fee from driv d, mem m, cour c, car cc "
			+ "where (d.mem_id=m.mem_id) AND (c.cour_no = d.cour_no) AND (d.car_reg_no = cc.car_reg_no) AND m.mem_id= '" + mem_id + "'"
					+ "order by d.driv_no";
	
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	List<CarlogVO> list = new ArrayList<CarlogVO>();
	
	try {
		conn = DBManager.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			
			CarlogVO cVo = new CarlogVO();
			
			cVo.setDriv_no(rs.getInt("driv_no"));
			cVo.setCar_reg_no(rs.getString("car_reg_no"));
			cVo.setCar_model(rs.getString("car_model"));
			cVo.setMem_id(rs.getString("mem_id"));
			cVo.setMem_name(rs.getString("mem_name"));
			cVo.setDriv_s_date(rs.getString("driv_s_date"));
			cVo.setDriv_e_date(rs.getString("driv_e_date"));
			cVo.setCour_no(rs.getInt("cour_no"));
			cVo.setDriv_purpo(rs.getString("driv_purpo"));
			cVo.setS_place_name(rs.getString("s_place_name"));
			cVo.setE_place_name(rs.getString("e_place_name"));
			cVo.setDistance(rs.getInt("distance"));
			cVo.setCard_divi(rs.getString("card_divi"));
			cVo.setOil_fee(rs.getInt("oil_fee"));
			cVo.setTrans_fee(rs.getInt("trans_fee"));
			cVo.setEtc_text(rs.getString("etc_text"));
			cVo.setEtc_fee(rs.getInt("etc_fee"));
			list.add(cVo);
			
			
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		DBManager.close(conn, stmt, rs);
	}
	return list;
}


public List<CarlogVO> drivSearchByNameNoncomplete(String mem_id) {
	String sql ="select d.driv_no, d.car_reg_no, c.car_model, m.mem_name, d.driv_s_date, d.driv_e_date from driv d, mem m, car c "
			+ "where d.mem_id=m.mem_id AND d.car_reg_no=c.car_reg_no AND d.cour_no is null AND m.mem_id= '" + mem_id + "' "
					+ "order by d.driv_no";
	
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	List<CarlogVO> list = new ArrayList<CarlogVO>();
	
	try {
		conn = DBManager.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			
			CarlogVO cVo = new CarlogVO();
			
			cVo.setDriv_no(rs.getInt("driv_no"));
			cVo.setCar_reg_no(rs.getString("car_reg_no"));
			cVo.setCar_model(rs.getString("car_model"));
			cVo.setMem_name(rs.getString("mem_name"));
			cVo.setDriv_s_date(rs.getString("driv_s_date"));
			cVo.setDriv_e_date(rs.getString("driv_e_date"));
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


/*public List<CarlogVO> drivSearchAllByName(String mem_id) {
	String sql ="select d.driv_no, d.car_reg_no, d.driv_s_date, d.driv_e_date, d.cour_no from driv d, mem m "
			+ "where d.mem_id=m.mem_id AND and m.mem_id= '" + mem_id + "'";
	
	
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	List<CarlogVO> list = new ArrayList<CarlogVO>();
	
	try {
		conn = DBManager.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			
			CarlogVO cVo = new CarlogVO();
			
			cVo.setDriv_no(rs.getInt("driv_no"));
			cVo.setCar_reg_no(rs.getString("car_reg_no"));
			cVo.setDriv_s_date(rs.getString("driv_s_date"));
			cVo.setDriv_e_date(rs.getString("driv_e_date"));
			cVo.setCour_no(rs.getInt("cour_no"));
			list.add(cVo);
			
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		DBManager.close(conn, stmt, rs);
	}
	return list;
}*/