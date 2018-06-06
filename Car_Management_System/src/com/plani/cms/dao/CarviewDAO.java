package com.plani.cms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.plani.cms.dto.CarviewVO;
import com.plani.cms.dto.RepaVO;
import com.plani.cms.util.DBManager;

public class CarviewDAO {
	private static CarviewDAO instance = new CarviewDAO();

	public static CarviewDAO getInstance() {
		return instance;
	}
	
	public List<CarviewVO> selectDateCar(String repa_s_date, String repa_e_date,String car_reg_no){
		String sql = "select left(dd.driv_s_date,16) as 'driv_s_date',  d.dept_name, m.mem_posi, m.mem_name, dd.driv_purpo,"
+"(select place_name from place where place_no = s_place) as 's_place_name',"
+"(select place_name from place where place_no = e_place) as 'e_place_name', (dd.oil_fee+dd.trans_fee+dd.etc_fee) as 'fee',"
+"dd.befo_dist,c.distance,(dd.befo_dist+c.distance) as 'total_dist', dd.etc_text from driv dd, dept d, mem m, cour c, car cc " 
+"where dd.car_reg_no = cc.car_reg_no AND dd.mem_id = m.mem_id AND d.dept_no = m.dept_no AND dd.cour_no=c.cour_no and dd.car_reg_no='" + car_reg_no + "'and dd.driv_s_date between '" + repa_s_date + "' and '" + repa_e_date + "' order by dd.driv_s_date asc;";

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

				cVo.setDriv_s_date(rs.getString("driv_s_date"));
				cVo.setDept_name(rs.getString("dept_name"));
				cVo.setMem_posi(rs.getString("mem_posi"));
				cVo.setMem_name(rs.getString("mem_name"));
				cVo.setDriv_purpo(rs.getString("driv_purpo"));
				cVo.setS_place_name(rs.getString("s_place_name"));
				cVo.setE_place_name(rs.getString("e_place_name"));
				cVo.setTotal_fee(rs.getInt("fee"));
				cVo.setBefo_dist(rs.getInt("befo_dist"));
				cVo.setDistance(rs.getInt("distance"));
				cVo.setAfter_dist(rs.getInt("total_dist"));
				cVo.setEtc_text(rs.getString("etc_text"));
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
