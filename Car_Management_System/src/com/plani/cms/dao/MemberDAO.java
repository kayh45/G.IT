package com.plani.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.plani.cms.dto.DeptVO;
import com.plani.cms.dto.MemberVO;
import com.plani.cms.util.DBManager;

public class MemberDAO {

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	} // Singleton 패턴		
	
	
	public void passwordUpdate(MemberVO mVo) {
		/**
		 * 사원 수정
		 **/
		String sql = "UPDATE mem SET mem_pw = ? where mem_id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mVo.getMem_pw());
			pstmt.setString(2, mVo.getMem_id());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt);

		}
	}
	
	public void memberInsert(MemberVO mVo) {
		/**
		 * 사원 등록
		 * 사원정보를 받아와서 입력시킴
		 * @MemberWriteAction 에서 사용
		 **/
		String sql = "insert into mem(mem_id, mem_pw, mem_name, mem_jumin, mem_p_no, mem_addr, mem_addr_dtl, mem_hp"
				+ ", mem_posi, mem_auth, dept_no)"
				+ " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mVo.getMem_id());
			pstmt.setString(2, mVo.getMem_pw());
			pstmt.setString(3, mVo.getMem_name());
			pstmt.setString(4, mVo.getMem_jumin());
			pstmt.setString(5, mVo.getMem_p_no());
			pstmt.setString(6, mVo.getMem_addr());
			pstmt.setString(7, mVo.getMem_addr_dtl());
			pstmt.setString(8, mVo.getMem_hp());
			pstmt.setString(9, mVo.getMem_posi());
			pstmt.setString(10, mVo.getMem_auth());
			pstmt.setInt(11, mVo.getDept_no());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt);

		}
	}
	
	public void memberUpdate(MemberVO mVo) {
		/**
		 * 사원 수정
		 **/
		String sql = "UPDATE mem SET mem_name = ?, mem_jumin = ?, mem_p_no = ?, mem_addr = ?"
				+ ", mem_addr_dtl = ?, mem_hp = ?, mem_posi = ?, mem_auth = ?, dept_no =?  where mem_id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mVo.getMem_name());
			pstmt.setString(2, mVo.getMem_jumin());
			pstmt.setString(3, mVo.getMem_p_no());
			pstmt.setString(4, mVo.getMem_addr());
			pstmt.setString(5, mVo.getMem_addr_dtl());
			pstmt.setString(6, mVo.getMem_hp());
			pstmt.setString(7, mVo.getMem_posi());
			pstmt.setString(8, mVo.getMem_auth());
			pstmt.setInt(9, mVo.getDept_no());
			pstmt.setString(10, mVo.getMem_id());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt);

		}
	}
	
	public void memberDelete(String mem_id) {
		/**
		 * 부서 수정 -> TODO 사원 삭제로 바꿔야됨 TODO
		 * 부서 번호와 부서명을 받아와서 수정
		 * @DeptModifyAction 에서 사용
		 **/
		String sql = "DELETE FROM mem WHERE mem_id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mem_id);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt);

		}
	}
	
	public int loginCheck(MemberVO mVo) {
		/**
		 * 로그인 검사를 위한 메소드
		 * @LoginAction 에서 사용
		 **/
		String sql = "SELECT mem_pw FROM mem WHERE mem_id = '" + mVo.getMem_id() + "'";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
				
			if (rs.next()) {
				
				if (rs.getString("mem_pw") != null && rs.getString("mem_pw").equals(mVo.getMem_pw())) {
					return 1; //로그인 성공
				}else {
					return 0; //로그인 실패
				}
			}else {
				return -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}	
		return -1;
	}
	
	public MemberVO getMemberInfoAll(MemberVO tempVo) {
		/**
		 * 로그인 세션 정보를 받아오기 위한 메소드
		 * 비밀번호는 받지 않는다(보안을 위해)
		 * @LoginAction 에서 사용
		 **/
		String sql = "SELECT * FROM mem WHERE mem_id = '" + tempVo.getMem_id() + "'";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		MemberVO mVo = new MemberVO();

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				mVo.setMem_id(rs.getString("mem_id"));
				mVo.setMem_name(rs.getString("mem_name"));
				mVo.setMem_jumin(rs.getString("mem_jumin"));
				mVo.setMem_p_no(rs.getString("mem_p_no"));
				mVo.setMem_addr(rs.getString("mem_addr"));
				mVo.setMem_addr_dtl(rs.getString("mem_addr_dtl"));
				mVo.setMem_hp(rs.getString("mem_hp"));
				mVo.setMem_posi(rs.getString("mem_posi"));
				mVo.setMem_auth(rs.getString("mem_auth"));
				mVo.setDept_no(rs.getInt("dept_no"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return mVo;
	}
	
	public int idDupCheck(String id) {
		/**
		 * 로그인 검사를 위한 메소드
		 * @LoginAction 에서 사용
		 **/
		String sql = "SELECT * FROM mem WHERE mem_id = '" + id + "'";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				return 1; // 이미 값이 있다.
			}else {
				return 0; // 값이 없다.
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}	
		return -1; // 비정상적 리턴
	}
	
	public List<MemberVO> memberSearchByName(String name) {
		/**
		 * 사원 이름에 대한 부분일치 검색
		 * @MemberSearchAction 에서 사용
		 **/
		String sql = "select * from mem m inner join dept d on m.dept_no = d.dept_no"
				+ " where mem_name like '%" + name + "%'";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<MemberVO> list = new ArrayList<MemberVO>();

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				MemberVO mVo = new MemberVO();

				mVo.setMem_id(rs.getString("mem_id"));
				mVo.setMem_name(rs.getString("mem_name"));
				mVo.setMem_jumin(rs.getString("mem_jumin"));
				mVo.setMem_p_no(rs.getString("mem_p_no"));
				mVo.setMem_addr(rs.getString("mem_addr"));
				mVo.setMem_addr_dtl(rs.getString("mem_addr_dtl"));
				mVo.setMem_hp(rs.getString("mem_hp"));
				mVo.setMem_posi(rs.getString("mem_posi"));
				mVo.setMem_auth(rs.getString("mem_auth"));
				mVo.setDept_no(rs.getInt("d.dept_no"));
				mVo.setDept_name(rs.getString("d.dept_name"));

				list.add(mVo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}

}
