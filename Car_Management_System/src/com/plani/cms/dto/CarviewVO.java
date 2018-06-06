package com.plani.cms.dto;

public class CarviewVO {
	private String driv_s_date;//일자         12개
	private String dept_name;//부서
	private String mem_posi;//직책
	private String mem_name;//이름
	private String driv_purpo;//운행목적
	private String s_place_name;//출발지
	private String e_place_name;//도착지
	private int total_fee;//법인카드 사용금액
	private int befo_dist;//주행전누적거리
	private int distance;//주행거리
	private int after_dist;//주행후누적거리
	private String etc_text; //비고 
	public String getDriv_s_date() {
		return driv_s_date;
	}
	public void setDriv_s_date(String driv_s_date) {
		this.driv_s_date = driv_s_date;
	}
	public String getMem_posi() {
		return mem_posi;
	}
	public void setMem_posi(String mem_posi) {
		this.mem_posi = mem_posi;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	
	
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getDriv_purpo() {
		return driv_purpo;
	}
	public void setDriv_purpo(String driv_purpo) {
		this.driv_purpo = driv_purpo;
	}
	public String getS_place_name() {
		return s_place_name;
	}
	public void setS_place_name(String s_place_name) {
		this.s_place_name = s_place_name;
	}
	public String getE_place_name() {
		return e_place_name;
	}
	public void setE_place_name(String e_place_name) {
		this.e_place_name = e_place_name;
	}
	public int getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}
	public int getBefo_dist() {
		return befo_dist;
	}
	public void setBefo_dist(int befo_dist) {
		this.befo_dist = befo_dist;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getAfter_dist() {
		return after_dist;
	}
	public void setAfter_dist(int after_dist) {
		this.after_dist = after_dist;
	}
	public String getEtc_text() {
		return etc_text;
	}
	public void setEtc_text(String etc_text) {
		this.etc_text = etc_text;
	}
	

	

	
	
	
}
