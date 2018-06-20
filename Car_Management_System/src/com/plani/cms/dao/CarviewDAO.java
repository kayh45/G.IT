package com.plani.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.plani.cms.dto.CarviewVO;
import com.plani.cms.util.DBManager;

public class CarviewDAO {
	private static CarviewDAO instance = new CarviewDAO();

	public static CarviewDAO getInstance() {
		return instance;
	}
	
	public List<CarviewVO> selectDateCar0(String repa_s_date, String repa_e_date, String mem_id, int page){
		 //1번 페이지 1~10
	    //2번 페이지 11~20
	    int startNum =(page-1)*10;
	    int endNum = page*10;
	    System.out.println(startNum+"//"+endNum);
		String sql = "select left(dd.driv_s_date,4) as 'driv_year', substr(dd.driv_s_date,6,2) as 'driv_month', substr(dd.driv_s_date,9,2) as 'driv_day', d.dept_name, m.mem_name, dd.driv_divi,"
+"(select place_divi from place where place_no = s_place) as 's_place_divi', (select place_name from place where place_no = s_place) as 's_place_name', (select place_addr from place where place_no = s_place) as 's_place_addr',"
+"(select place_divi from place where place_no = e_place) as 'e_place_divi', (select place_name from place where place_no = e_place) as 'e_place_name', (select place_addr from place where place_no = e_place) as 'e_place_addr',"
+"dd.driv_dist, dd.driv_purpo, (dd.oil_fee + dd.trans_fee + etc_fee) as 'total_fee', dd.card_divi, dd.oil_fee, dd.trans_fee, dd.etc_fee, dd.etc_text from driv dd, dept d, mem m, cour c, car cc " 
+"where dd.car_reg_no = cc.car_reg_no AND dd.mem_id = m.mem_id AND d.dept_no = m.dept_no AND dd.cour_no=c.cour_no and dd.driv_s_date between '" + repa_s_date + "' and '" + repa_e_date + "' and m.mem_id='" + mem_id + "' order by dd.driv_s_date asc LIMIT " + startNum + ", 10 ;";

		List<CarviewVO> list = new ArrayList<CarviewVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				CarviewVO cVo = new CarviewVO();

				cVo.setDriv_year(rs.getString("driv_year"));
				cVo.setDriv_month(rs.getString("driv_month"));
				cVo.setDriv_day(rs.getString("driv_day"));
				cVo.setDept_name(rs.getString("dept_name"));
				cVo.setMem_name(rs.getString("mem_name"));
				cVo.setDriv_divi(rs.getString("driv_divi"));
				cVo.setPlace_s_divi(rs.getString("driv_divi"));
				cVo.setPlace_s_divi(rs.getString("s_place_divi"));
				cVo.setS_place_name(rs.getString("s_place_name"));
				cVo.setS_place_addr(rs.getString("s_place_addr"));
				cVo.setPlace_e_divi(rs.getString("e_place_divi"));
				cVo.setE_place_name(rs.getString("e_place_name"));
				cVo.setE_place_addr(rs.getString("e_place_addr"));
				cVo.setDistance(rs.getInt("driv_dist"));
				cVo.setDistance(rs.getInt("driv_dist"));
				cVo.setDriv_purpo(rs.getString("driv_purpo"));
				cVo.setTotal_fee(rs.getInt("total_fee"));
				cVo.setCard_divi(rs.getString("card_divi"));
				cVo.setOil_fee(rs.getInt("oil_fee"));
				cVo.setTrans_fee(rs.getInt("trans_fee"));
				cVo.setEtc_fee(rs.getInt("etc_fee"));
				cVo.setEtc_text(rs.getString("etc_text")); 
				//cVo.setTotal_fee(cVo.getOil_fee() + cVo.getTrans_fee() + cVo.getEtc_fee());
				list.add(cVo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			 DBManager.close(conn, stmt, rs);
		}
		 return list;	
	}
	public int selectDateCar0(String repa_s_date, String repa_e_date, String mem_id){
	    //1번 페이지 1~10
	    //2번 페이지 11~20
	 
	    int count =0;
	    
		String sql = "select count(dd.driv_no) as 'count' from driv dd, dept d, mem m, cour c, car cc " 
	+"where dd.car_reg_no = cc.car_reg_no AND dd.mem_id = m.mem_id AND d.dept_no = m.dept_no AND dd.cour_no=c.cour_no and dd.driv_s_date between '" + repa_s_date + "' and '" + repa_e_date + "' and m.mem_id='" + mem_id + "' order by dd.driv_s_date asc;";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			 DBManager.close(conn, stmt, rs);
		}
		 return count;	
	}
	public List<CarviewVO> selectDateEx(String repa_s_date, String repa_e_date){
		String sql = "select left(dd.driv_s_date,4) as 'driv_year', substr(dd.driv_s_date,6,2) as 'driv_month', substr(dd.driv_s_date,9,2) as 'driv_day', d.dept_name, m.mem_name, dd.driv_divi,"
+"(select place_divi from place where place_no = s_place) as 's_place_divi', (select place_name from place where place_no = s_place) as 's_place_name', (select place_addr from place where place_no = s_place) as 's_place_addr',"
+"(select place_divi from place where place_no = e_place) as 'e_place_divi', (select place_name from place where place_no = e_place) as 'e_place_name', (select place_addr from place where place_no = e_place) as 'e_place_addr',"
+"dd.driv_dist, dd.driv_purpo, (dd.oil_fee + dd.trans_fee + etc_fee) as 'total_fee', dd.card_divi, dd.oil_fee, dd.trans_fee, dd.etc_fee, dd.etc_text from driv dd, dept d, mem m, cour c, car cc " 
+"where dd.car_reg_no = cc.car_reg_no AND dd.mem_id = m.mem_id AND d.dept_no = m.dept_no AND dd.cour_no=c.cour_no and dd.driv_s_date between '" + repa_s_date + "' and '" + repa_e_date + "' order by dd.driv_s_date asc;";

		List<CarviewVO> list = new ArrayList<CarviewVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				CarviewVO cVo = new CarviewVO();

				cVo.setDriv_year(rs.getString("driv_year"));
				cVo.setDriv_month(rs.getString("driv_month"));
				cVo.setDriv_day(rs.getString("driv_day"));
				cVo.setDept_name(rs.getString("dept_name"));
				cVo.setMem_name(rs.getString("mem_name"));
				cVo.setDriv_divi(rs.getString("driv_divi"));
				//cVo.setPlace_s_divi(rs.getString("driv_divi"));
				cVo.setPlace_s_divi(rs.getString("s_place_divi"));
				cVo.setS_place_name(rs.getString("s_place_name"));
				cVo.setS_place_addr(rs.getString("s_place_addr"));
				cVo.setPlace_e_divi(rs.getString("e_place_divi"));
				cVo.setE_place_name(rs.getString("e_place_name"));
				cVo.setE_place_addr(rs.getString("e_place_addr"));
				//cVo.setDistance(rs.getInt("driv_dist"));
				cVo.setDistance(rs.getInt("driv_dist"));
				cVo.setDriv_purpo(rs.getString("driv_purpo"));
				cVo.setTotal_fee(rs.getInt("total_fee"));
				cVo.setCard_divi(rs.getString("card_divi"));
				cVo.setOil_fee(rs.getInt("oil_fee"));
				cVo.setTrans_fee(rs.getInt("trans_fee"));
				cVo.setEtc_fee(rs.getInt("etc_fee"));
				cVo.setEtc_text(rs.getString("etc_text")); 
				//cVo.setTotal_fee(cVo.getOil_fee() + cVo.getTrans_fee() + cVo.getEtc_fee());
				list.add(cVo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			 DBManager.close(conn, stmt, rs);
		}
		 return list;	
	}
	
	public int selectPageDateCount(String repa_s_date, String repa_e_date){
	    //1번 페이지 1~10
        //2번 페이지 11~20
     
        int count =0;
        
		String sql = "select count(dd.driv_no) as 'count' from driv dd, dept d, mem m, cour c, car cc " 
+"where dd.car_reg_no = cc.car_reg_no AND dd.mem_id = m.mem_id AND d.dept_no = m.dept_no AND dd.cour_no=c.cour_no and dd.driv_s_date between '" + repa_s_date + "' and '" + repa_e_date + "' order by dd.driv_s_date asc;";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			 DBManager.close(conn, stmt, rs);
		}
		 return count;	
	}
	
	
	public List<CarviewVO> selectPageDate(String repa_s_date, String repa_e_date, int page){
	    //1번 페이지 1~10
        //2번 페이지 11~20
        int startNum =(page-1)*10;
        int endNum = page*10;
        System.out.println(startNum+"//"+endNum);
        
		String sql = "select left(dd.driv_s_date,4) as 'driv_year', substr(dd.driv_s_date,6,2) as 'driv_month', substr(dd.driv_s_date,9,2) as 'driv_day', d.dept_name, m.mem_name, dd.driv_divi,"
+"(select place_divi from place where place_no = s_place) as 's_place_divi', (select place_name from place where place_no = s_place) as 's_place_name', (select place_addr from place where place_no = s_place) as 's_place_addr',"
+"(select place_divi from place where place_no = e_place) as 'e_place_divi', (select place_name from place where place_no = e_place) as 'e_place_name', (select place_addr from place where place_no = e_place) as 'e_place_addr',"
+"dd.driv_dist, dd.driv_purpo, (dd.oil_fee + dd.trans_fee + etc_fee) as 'total_fee', dd.card_divi, dd.oil_fee, dd.trans_fee, dd.etc_fee, dd.etc_text from driv dd, dept d, mem m, cour c, car cc " 
+"where dd.car_reg_no = cc.car_reg_no AND dd.mem_id = m.mem_id AND d.dept_no = m.dept_no AND dd.cour_no=c.cour_no and dd.driv_s_date between '" + repa_s_date + "' and '" + repa_e_date + "' order by dd.driv_s_date asc LIMIT " + startNum + ", 10 ;";
		List<CarviewVO> list = new ArrayList<CarviewVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				CarviewVO cVo = new CarviewVO();

				cVo.setDriv_year(rs.getString("driv_year"));
				cVo.setDriv_month(rs.getString("driv_month"));
				cVo.setDriv_day(rs.getString("driv_day"));
				cVo.setDept_name(rs.getString("dept_name"));
				cVo.setMem_name(rs.getString("mem_name"));
				cVo.setDriv_divi(rs.getString("driv_divi"));
				cVo.setPlace_s_divi(rs.getString("driv_divi"));
				cVo.setPlace_s_divi(rs.getString("s_place_divi"));
				cVo.setS_place_name(rs.getString("s_place_name"));
				cVo.setS_place_addr(rs.getString("s_place_addr"));
				cVo.setPlace_e_divi(rs.getString("e_place_divi"));
				cVo.setE_place_name(rs.getString("e_place_name"));
				cVo.setE_place_addr(rs.getString("e_place_addr"));
				cVo.setDistance(rs.getInt("driv_dist"));
				cVo.setDistance(rs.getInt("driv_dist"));
				cVo.setDriv_purpo(rs.getString("driv_purpo"));
				cVo.setTotal_fee(rs.getInt("total_fee"));
				cVo.setCard_divi(rs.getString("card_divi"));
				cVo.setOil_fee(rs.getInt("oil_fee"));
				cVo.setTrans_fee(rs.getInt("trans_fee"));
				cVo.setEtc_fee(rs.getInt("etc_fee"));
				cVo.setEtc_text(rs.getString("etc_text")); 
				//cVo.setTotal_fee(cVo.getOil_fee() + cVo.getTrans_fee() + cVo.getEtc_fee());
				list.add(cVo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			 DBManager.close(conn, stmt, rs);
		}
		 return list;	
	}
	public List<CarviewVO> selectDateCar(String repa_s_date, String repa_e_date,String car_reg_no, int page){
		  //1번 페이지 1~10
        //2번 페이지 11~20
        int startNum =(page-1)*10;
        int endNum = page*10;
        System.out.println(startNum+"//"+endNum);
		String sql = "select left(dd.driv_s_date,4) as 'driv_year', substr(dd.driv_s_date,6,2) as 'driv_month', substr(dd.driv_s_date,9,2) as 'driv_day', d.dept_name, m.mem_name, dd.driv_divi,"
+"(select place_divi from place where place_no = s_place) as 's_place_divi', (select place_name from place where place_no = s_place) as 's_place_name', (select place_addr from place where place_no = s_place) as 's_place_addr',"
+"(select place_divi from place where place_no = e_place) as 'e_place_divi', (select place_name from place where place_no = e_place) as 'e_place_name', (select place_addr from place where place_no = e_place) as 'e_place_addr',"
+"dd.driv_dist, dd.driv_purpo, (dd.oil_fee + dd.trans_fee + etc_fee) as 'total_fee', dd.card_divi, dd.oil_fee, dd.trans_fee, dd.etc_fee, dd.etc_text from driv dd, dept d, mem m, cour c, car cc " 
+"where dd.car_reg_no = cc.car_reg_no AND dd.mem_id = m.mem_id AND d.dept_no = m.dept_no AND dd.cour_no=c.cour_no and dd.car_reg_no='" + car_reg_no + "'and dd.driv_s_date between '" + repa_s_date + "' and '" + repa_e_date + "' order by dd.driv_s_date asc LIMIT " + startNum + ", 10 ;";

		List<CarviewVO> list = new ArrayList<CarviewVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				CarviewVO cVo = new CarviewVO();

				cVo.setDriv_year(rs.getString("driv_year"));
				cVo.setDriv_month(rs.getString("driv_month"));
				cVo.setDriv_day(rs.getString("driv_day"));
				cVo.setDept_name(rs.getString("dept_name"));
				cVo.setMem_name(rs.getString("mem_name"));
				cVo.setDriv_divi(rs.getString("driv_divi"));
				cVo.setPlace_s_divi(rs.getString("driv_divi"));
				cVo.setPlace_s_divi(rs.getString("s_place_divi"));
				cVo.setS_place_name(rs.getString("s_place_name"));
				cVo.setS_place_addr(rs.getString("s_place_addr"));
				cVo.setPlace_e_divi(rs.getString("e_place_divi"));
				cVo.setE_place_name(rs.getString("e_place_name"));
				cVo.setE_place_addr(rs.getString("e_place_addr"));
				cVo.setDistance(rs.getInt("driv_dist"));
				cVo.setDistance(rs.getInt("driv_dist"));
				cVo.setDriv_purpo(rs.getString("driv_purpo"));
				cVo.setTotal_fee(rs.getInt("total_fee"));
				cVo.setCard_divi(rs.getString("card_divi"));
				cVo.setOil_fee(rs.getInt("oil_fee"));
				cVo.setTrans_fee(rs.getInt("trans_fee"));
				cVo.setEtc_fee(rs.getInt("etc_fee"));
				cVo.setEtc_text(rs.getString("etc_text")); 
				//cVo.setTotal_fee(cVo.getOil_fee() + cVo.getTrans_fee() + cVo.getEtc_fee());
				list.add(cVo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			 DBManager.close(conn, stmt, rs);
		}
		 return list;	
	}
	public List<CarviewVO> selectDateCarEx(String repa_s_date, String repa_e_date,String car_reg_no){
		String sql = "select left(dd.driv_s_date,4) as 'driv_year', substr(dd.driv_s_date,6,2) as 'driv_month', substr(dd.driv_s_date,9,2) as 'driv_day', d.dept_name, m.mem_name, dd.driv_divi,"
+"(select place_divi from place where place_no = s_place) as 's_place_divi', (select place_name from place where place_no = s_place) as 's_place_name', (select place_addr from place where place_no = s_place) as 's_place_addr',"
+"(select place_divi from place where place_no = e_place) as 'e_place_divi', (select place_name from place where place_no = e_place) as 'e_place_name', (select place_addr from place where place_no = e_place) as 'e_place_addr',"
+"dd.driv_dist, dd.driv_purpo, (dd.oil_fee + dd.trans_fee + etc_fee) as 'total_fee', dd.card_divi, dd.oil_fee, dd.trans_fee, dd.etc_fee, dd.etc_text from driv dd, dept d, mem m, cour c, car cc " 
+"where dd.car_reg_no = cc.car_reg_no AND dd.mem_id = m.mem_id AND d.dept_no = m.dept_no AND dd.cour_no=c.cour_no and dd.car_reg_no='" + car_reg_no + "'and dd.driv_s_date between '" + repa_s_date + "' and '" + repa_e_date + "' order by dd.driv_s_date asc";

		List<CarviewVO> list = new ArrayList<CarviewVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				CarviewVO cVo = new CarviewVO();

				cVo.setDriv_year(rs.getString("driv_year"));
				cVo.setDriv_month(rs.getString("driv_month"));
				cVo.setDriv_day(rs.getString("driv_day"));
				cVo.setDept_name(rs.getString("dept_name"));
				cVo.setMem_name(rs.getString("mem_name"));
				cVo.setDriv_divi(rs.getString("driv_divi"));
				cVo.setPlace_s_divi(rs.getString("driv_divi"));
				cVo.setPlace_s_divi(rs.getString("s_place_divi"));
				cVo.setS_place_name(rs.getString("s_place_name"));
				cVo.setS_place_addr(rs.getString("s_place_addr"));
				cVo.setPlace_e_divi(rs.getString("e_place_divi"));
				cVo.setE_place_name(rs.getString("e_place_name"));
				cVo.setE_place_addr(rs.getString("e_place_addr"));
				cVo.setDistance(rs.getInt("driv_dist"));
				cVo.setDistance(rs.getInt("driv_dist"));
				cVo.setDriv_purpo(rs.getString("driv_purpo"));
				cVo.setTotal_fee(rs.getInt("total_fee"));
				cVo.setCard_divi(rs.getString("card_divi"));
				cVo.setOil_fee(rs.getInt("oil_fee"));
				cVo.setTrans_fee(rs.getInt("trans_fee"));
				cVo.setEtc_fee(rs.getInt("etc_fee"));
				cVo.setEtc_text(rs.getString("etc_text")); 
				//cVo.setTotal_fee(cVo.getOil_fee() + cVo.getTrans_fee() + cVo.getEtc_fee());
				list.add(cVo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			 DBManager.close(conn, stmt, rs);
		}
		 return list;	
	}
	public int selectDateCar(String repa_s_date, String repa_e_date, String car_reg_no){
	    //1번 페이지 1~10
        //2번 페이지 11~20
     
        int count =0;
        
		String sql = "select count(dd.driv_no) as 'count' from driv dd, dept d, mem m, cour c, car cc " 
+"where dd.car_reg_no = cc.car_reg_no AND dd.mem_id = m.mem_id AND d.dept_no = m.dept_no AND dd.cour_no=c.cour_no and dd.car_reg_no='" + car_reg_no + "'and dd.driv_s_date between '" + repa_s_date + "' and '" + repa_e_date + "' order by dd.driv_s_date asc;";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			 DBManager.close(conn, stmt, rs);
		}
		 return count;	
	}
	public List<CarviewVO> selectDateMem(String repa_s_date, String repa_e_date, String mem_id, int page){
		  //1번 페이지 1~10
        //2번 페이지 11~20
        int startNum =(page-1)*10;
        int endNum = page*10;
        System.out.println(startNum+"//"+endNum);
		String sql = "select left(dd.driv_s_date,4) as 'driv_year', substr(dd.driv_s_date,6,2) as 'driv_month', substr(dd.driv_s_date,9,2) as 'driv_day', d.dept_name, m.mem_name, dd.driv_divi,"
	+"(select place_divi from place where place_no = s_place) as 's_place_divi', (select place_name from place where place_no = s_place) as 's_place_name', (select place_addr from place where place_no = s_place) as 's_place_addr',"
	+"(select place_divi from place where place_no = e_place) as 'e_place_divi', (select place_name from place where place_no = e_place) as 'e_place_name', (select place_addr from place where place_no = e_place) as 'e_place_addr',"
	+"dd.driv_dist, dd.driv_purpo, (dd.oil_fee + dd.trans_fee + etc_fee) as 'total_fee', dd.card_divi, dd.oil_fee, dd.trans_fee, dd.etc_fee, dd.etc_text from driv dd, dept d, mem m, cour c, car cc " 
	+"where dd.car_reg_no = cc.car_reg_no AND dd.mem_id = m.mem_id AND d.dept_no = m.dept_no AND dd.cour_no=c.cour_no and dd.driv_s_date between '" + repa_s_date + "' and '" + repa_e_date + "' and dd.mem_id='" + mem_id + "' order by dd.driv_s_date asc LIMIT " + startNum + ", 10 ;";

		List<CarviewVO> list = new ArrayList<CarviewVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				CarviewVO cVo = new CarviewVO();

				cVo.setDriv_year(rs.getString("driv_year"));
				cVo.setDriv_month(rs.getString("driv_month"));
				cVo.setDriv_day(rs.getString("driv_day"));
				cVo.setDept_name(rs.getString("dept_name"));
				cVo.setMem_name(rs.getString("mem_name"));
				cVo.setDriv_divi(rs.getString("driv_divi"));
				cVo.setPlace_s_divi(rs.getString("driv_divi"));
				cVo.setPlace_s_divi(rs.getString("s_place_divi"));
				cVo.setS_place_name(rs.getString("s_place_name"));
				cVo.setS_place_addr(rs.getString("s_place_addr"));
				cVo.setPlace_e_divi(rs.getString("e_place_divi"));
				cVo.setE_place_name(rs.getString("e_place_name"));
				cVo.setE_place_addr(rs.getString("e_place_addr"));
				cVo.setDistance(rs.getInt("driv_dist"));
				cVo.setDistance(rs.getInt("driv_dist"));
				cVo.setDriv_purpo(rs.getString("driv_purpo"));
				cVo.setTotal_fee(rs.getInt("total_fee"));
				cVo.setCard_divi(rs.getString("card_divi"));
				cVo.setOil_fee(rs.getInt("oil_fee"));
				cVo.setTrans_fee(rs.getInt("trans_fee"));
				cVo.setEtc_fee(rs.getInt("etc_fee"));
				cVo.setEtc_text(rs.getString("etc_text")); 
				//cVo.setTotal_fee(cVo.getOil_fee() + cVo.getTrans_fee() + cVo.getEtc_fee());
				list.add(cVo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			 DBManager.close(conn, stmt, rs);
		}
		 return list;	
	}
	public List<CarviewVO> selectDateMemEx(String repa_s_date, String repa_e_date, String mem_id){
		String sql = "select left(dd.driv_s_date,4) as 'driv_year', substr(dd.driv_s_date,6,2) as 'driv_month', substr(dd.driv_s_date,9,2) as 'driv_day', d.dept_name, m.mem_name, dd.driv_divi,"
	+"(select place_divi from place where place_no = s_place) as 's_place_divi', (select place_name from place where place_no = s_place) as 's_place_name', (select place_addr from place where place_no = s_place) as 's_place_addr',"
	+"(select place_divi from place where place_no = e_place) as 'e_place_divi', (select place_name from place where place_no = e_place) as 'e_place_name', (select place_addr from place where place_no = e_place) as 'e_place_addr',"
	+"dd.driv_dist, dd.driv_purpo, (dd.oil_fee + dd.trans_fee + etc_fee) as 'total_fee', dd.card_divi, dd.oil_fee, dd.trans_fee, dd.etc_fee, dd.etc_text from driv dd, dept d, mem m, cour c, car cc " 
	+"where dd.car_reg_no = cc.car_reg_no AND dd.mem_id = m.mem_id AND d.dept_no = m.dept_no AND dd.cour_no=c.cour_no and dd.driv_s_date between '" + repa_s_date + "' and '" + repa_e_date + "' and dd.mem_id='" + mem_id + "' order by dd.driv_s_date asc";

		List<CarviewVO> list = new ArrayList<CarviewVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				CarviewVO cVo = new CarviewVO();

				cVo.setDriv_year(rs.getString("driv_year"));
				cVo.setDriv_month(rs.getString("driv_month"));
				cVo.setDriv_day(rs.getString("driv_day"));
				cVo.setDept_name(rs.getString("dept_name"));
				cVo.setMem_name(rs.getString("mem_name"));
				cVo.setDriv_divi(rs.getString("driv_divi"));
				cVo.setPlace_s_divi(rs.getString("driv_divi"));
				cVo.setPlace_s_divi(rs.getString("s_place_divi"));
				cVo.setS_place_name(rs.getString("s_place_name"));
				cVo.setS_place_addr(rs.getString("s_place_addr"));
				cVo.setPlace_e_divi(rs.getString("e_place_divi"));
				cVo.setE_place_name(rs.getString("e_place_name"));
				cVo.setE_place_addr(rs.getString("e_place_addr"));
				cVo.setDistance(rs.getInt("driv_dist"));
				cVo.setDistance(rs.getInt("driv_dist"));
				cVo.setDriv_purpo(rs.getString("driv_purpo"));
				cVo.setTotal_fee(rs.getInt("total_fee"));
				cVo.setCard_divi(rs.getString("card_divi"));
				cVo.setOil_fee(rs.getInt("oil_fee"));
				cVo.setTrans_fee(rs.getInt("trans_fee"));
				cVo.setEtc_fee(rs.getInt("etc_fee"));
				cVo.setEtc_text(rs.getString("etc_text")); 
				//cVo.setTotal_fee(cVo.getOil_fee() + cVo.getTrans_fee() + cVo.getEtc_fee());
				list.add(cVo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			 DBManager.close(conn, stmt, rs);
		}
		 return list;	
	}
	public int selectDateMem(String repa_s_date, String repa_e_date, String mem_id){
	    //1번 페이지 1~10
        //2번 페이지 11~20
     
        int count =0;
        
		String sql = "select count(dd.driv_no) as 'count' from driv dd, dept d, mem m, cour c, car cc " 
+"where dd.car_reg_no = cc.car_reg_no AND dd.mem_id = m.mem_id AND d.dept_no = m.dept_no AND dd.cour_no=c.cour_no and dd.driv_s_date between '" + repa_s_date + "' and '" + repa_e_date + "' and dd.mem_id='" + mem_id + "' order by dd.driv_s_date asc;";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			 DBManager.close(conn, stmt, rs);
		}
		 return count;	
	} 							
public List<CarviewVO> selectAll(String repa_s_date, String repa_e_date,String car_reg_no, String mem_id, int page){
	  //1번 페이지 1~10
    //2번 페이지 11~20
    int startNum =(page-1)*10;
    int endNum = page*10;
    System.out.println(startNum+"//"+endNum);
	String sql = "select left(dd.driv_s_date,4) as 'driv_year', substr(dd.driv_s_date,6,2) as 'driv_month', substr(dd.driv_s_date,9,2) as 'driv_day', d.dept_name, m.mem_name, dd.driv_divi,"
+"(select place_divi from place where place_no = s_place) as 's_place_divi', (select place_name from place where place_no = s_place) as 's_place_name', (select place_addr from place where place_no = s_place) as 's_place_addr',"
+"(select place_divi from place where place_no = e_place) as 'e_place_divi', (select place_name from place where place_no = e_place) as 'e_place_name', (select place_addr from place where place_no = e_place) as 'e_place_addr',"
+"dd.driv_dist, dd.driv_purpo, (dd.oil_fee + dd.trans_fee + etc_fee) as 'total_fee', dd.card_divi, dd.oil_fee, dd.trans_fee, dd.etc_fee, dd.etc_text from driv dd, dept d, mem m, cour c, car cc " 
+"where dd.car_reg_no = cc.car_reg_no AND dd.mem_id = m.mem_id AND d.dept_no = m.dept_no AND dd.cour_no=c.cour_no and dd.car_reg_no='" + car_reg_no + "'and dd.driv_s_date between '" + repa_s_date + "' and '" + repa_e_date + "' and dd.mem_id='" + mem_id + "' order by dd.driv_s_date asc LIMIT " + startNum + ", 10 ;";

	List<CarviewVO> list = new ArrayList<CarviewVO>();
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	try {
		conn = DBManager.getConnection();
		stmt = conn.createStatement();

		rs = stmt.executeQuery(sql);

		while (rs.next()) {

			CarviewVO cVo = new CarviewVO();

			cVo.setDriv_year(rs.getString("driv_year"));
			cVo.setDriv_month(rs.getString("driv_month"));
			cVo.setDriv_day(rs.getString("driv_day"));
			cVo.setDept_name(rs.getString("dept_name"));
			cVo.setMem_name(rs.getString("mem_name"));
			cVo.setDriv_divi(rs.getString("driv_divi"));
			cVo.setPlace_s_divi(rs.getString("driv_divi"));
			cVo.setPlace_s_divi(rs.getString("s_place_divi"));
			cVo.setS_place_name(rs.getString("s_place_name"));
			cVo.setS_place_addr(rs.getString("s_place_addr"));
			cVo.setPlace_e_divi(rs.getString("e_place_divi"));
			cVo.setE_place_name(rs.getString("e_place_name"));
			cVo.setE_place_addr(rs.getString("e_place_addr"));
			cVo.setDistance(rs.getInt("driv_dist"));
			cVo.setDistance(rs.getInt("driv_dist"));
			cVo.setDriv_purpo(rs.getString("driv_purpo"));
			cVo.setTotal_fee(rs.getInt("total_fee"));
			cVo.setCard_divi(rs.getString("card_divi"));
			cVo.setOil_fee(rs.getInt("oil_fee"));
			cVo.setTrans_fee(rs.getInt("trans_fee"));
			cVo.setEtc_fee(rs.getInt("etc_fee"));
			cVo.setEtc_text(rs.getString("etc_text")); 
			//cVo.setTotal_fee(cVo.getOil_fee() + cVo.getTrans_fee() + cVo.getEtc_fee());
			list.add(cVo);

		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		 DBManager.close(conn, stmt, rs);
	}
	 return list;	
}
public List<CarviewVO> selectAllEx(String repa_s_date, String repa_e_date,String car_reg_no, String mem_id){
	String sql = "select left(dd.driv_s_date,4) as 'driv_year', substr(dd.driv_s_date,6,2) as 'driv_month', substr(dd.driv_s_date,9,2) as 'driv_day', d.dept_name, m.mem_name, dd.driv_divi,"
+"(select place_divi from place where place_no = s_place) as 's_place_divi', (select place_name from place where place_no = s_place) as 's_place_name', (select place_addr from place where place_no = s_place) as 's_place_addr',"
+"(select place_divi from place where place_no = e_place) as 'e_place_divi', (select place_name from place where place_no = e_place) as 'e_place_name', (select place_addr from place where place_no = e_place) as 'e_place_addr',"
+"dd.driv_dist, dd.driv_purpo, (dd.oil_fee + dd.trans_fee + etc_fee) as 'total_fee', dd.card_divi, dd.oil_fee, dd.trans_fee, dd.etc_fee, dd.etc_text from driv dd, dept d, mem m, cour c, car cc " 
+"where dd.car_reg_no = cc.car_reg_no AND dd.mem_id = m.mem_id AND d.dept_no = m.dept_no AND dd.cour_no=c.cour_no and dd.car_reg_no='" + car_reg_no + "'and dd.driv_s_date between '" + repa_s_date + "' and '" + repa_e_date + "' and dd.mem_id='" + mem_id + "' order by dd.driv_s_date asc";

	List<CarviewVO> list = new ArrayList<CarviewVO>();
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	try {
		conn = DBManager.getConnection();
		stmt = conn.createStatement();

		rs = stmt.executeQuery(sql);

		while (rs.next()) {

			CarviewVO cVo = new CarviewVO();

			cVo.setDriv_year(rs.getString("driv_year"));
			cVo.setDriv_month(rs.getString("driv_month"));
			cVo.setDriv_day(rs.getString("driv_day"));
			cVo.setDept_name(rs.getString("dept_name"));
			cVo.setMem_name(rs.getString("mem_name"));
			cVo.setDriv_divi(rs.getString("driv_divi"));
			cVo.setPlace_s_divi(rs.getString("driv_divi"));
			cVo.setPlace_s_divi(rs.getString("s_place_divi"));
			cVo.setS_place_name(rs.getString("s_place_name"));
			cVo.setS_place_addr(rs.getString("s_place_addr"));
			cVo.setPlace_e_divi(rs.getString("e_place_divi"));
			cVo.setE_place_name(rs.getString("e_place_name"));
			cVo.setE_place_addr(rs.getString("e_place_addr"));
			cVo.setDistance(rs.getInt("driv_dist"));
			cVo.setDistance(rs.getInt("driv_dist"));
			cVo.setDriv_purpo(rs.getString("driv_purpo"));
			cVo.setTotal_fee(rs.getInt("total_fee"));
			cVo.setCard_divi(rs.getString("card_divi"));
			cVo.setOil_fee(rs.getInt("oil_fee"));
			cVo.setTrans_fee(rs.getInt("trans_fee"));
			cVo.setEtc_fee(rs.getInt("etc_fee"));
			cVo.setEtc_text(rs.getString("etc_text")); 
			//cVo.setTotal_fee(cVo.getOil_fee() + cVo.getTrans_fee() + cVo.getEtc_fee());
			list.add(cVo);

		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		 DBManager.close(conn, stmt, rs);
	}
	 return list;	
}
public int selectAll(String repa_s_date, String repa_e_date,String car_reg_no, String mem_id){
    //1번 페이지 1~10
    //2번 페이지 11~20
 
    int count =0;
    
	String sql = "select count(dd.driv_no) as 'count' from driv dd, dept d, mem m, cour c, car cc " 
+"where dd.car_reg_no = cc.car_reg_no AND dd.mem_id = m.mem_id AND d.dept_no = m.dept_no AND dd.cour_no=c.cour_no and dd.car_reg_no='" + car_reg_no + "'and dd.driv_s_date between '" + repa_s_date + "' and '" + repa_e_date + "' and dd.mem_id='" + mem_id + "' order by dd.driv_s_date asc;";

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	try {
		conn = DBManager.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			count = rs.getInt("count");
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		 DBManager.close(conn, stmt, rs);
	}
	 return count;	
}

public List<CarviewVO> selectAllMember(int page){
    //1번 페이지 1~10
    //2번 페이지 11~20
    int startNum = (page-1)*10+1;
    int endNum = page*10;
    System.out.println(startNum+"//"+endNum);
    String sql="SELECT * FROM ("
            +         "SELECT * FROM ("
            +             "SELECT ROWNUM row_num, MEMBER.* FROM "
            +            "MEMBER ORDER BY NUM DESC"
            +         ")PAGING_MEMBER WHERE row_num>=?"
            + ") WHERE row_num <=?";
    List<CarviewVO> list = new ArrayList<CarviewVO>();
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
    try {
        System.out.println("DB에 접근하였습니다");
        conn = DBManager.getConnection();
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, startNum);
        pstmt.setInt(2, endNum);
        rs = pstmt.executeQuery();

    
    }
    catch (SQLException e) {
		e.printStackTrace();
	} finally {
		 DBManager.close(conn, stmt, rs);
		 try{
			 if(pstmt!=null)pstmt.close();
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	}
    return list;	
}
}
