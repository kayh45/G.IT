package com.plani.cms.dto;

public class MemberVO extends DeptVO{

//	  `mem_id` VARCHAR(50) NOT NULL,
//	  `mem_pw` VARCHAR(50) NOT NULL,
//	  `mem_name` VARCHAR(30) NOT NULL,
//	  `mem_jumin` INT NOT NULL,
//	  `mem_p_no` VARCHAR(5) NULL,
//	  `mem_addr` VARCHAR(255) NULL,
//	  `mem_hp` VARCHAR(11) NOT NULL,
//	  `mem_posi` VARCHAR(30) NULL,
//	  `mem_auth` CHAR(1) NOT NULL default 0,
//	  `dept_no` INT NOT NULL,
//	  PRIMARY KEY (`mem_id`),
//	CONSTRAINT FK_cms_dept FOREIGN KEY(dept_no) REFERENCES dept(dept_no));
	
	String mem_id;
	String mem_pw;
	String mem_name;
	int mem_jumin;
	String mem_p_no;
	String mem_addr;
	String mem_hp;
	String mem_posi;
	int mem_auth;
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public int getMem_jumin() {
		return mem_jumin;
	}
	public void setMem_jumin(int mem_jumin) {
		this.mem_jumin = mem_jumin;
	}
	public String getMem_p_no() {
		return mem_p_no;
	}
	public void setMem_p_no(String mem_p_no) {
		this.mem_p_no = mem_p_no;
	}
	public String getMem_addr() {
		return mem_addr;
	}
	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}
	public String getMem_hp() {
		return mem_hp;
	}
	public void setMem_hp(String mem_hp) {
		this.mem_hp = mem_hp;
	}
	public String getMem_posi() {
		return mem_posi;
	}
	public void setMem_posi(String mem_posi) {
		this.mem_posi = mem_posi;
	}
	public int getMem_auth() {
		return mem_auth;
	}
	public void setMem_auth(int mem_auth) {
		this.mem_auth = mem_auth;
	}
	
}
