package com.plani.cms.dto;

import java.util.Date;

public class DrivVO extends MemberVO {

//	driv_no int(11) AI PK 
//	mem_id varchar(50) 
//	car_reg_no varchar(30) 
//	cour_no int(11) 
//	driv_s_date datetime 
//	driv_e_date datetime 
//	driv_purpo varchar(50) 
//	card_divi varchar(50) 
//	oil_fee int(11) 
//	trans_fee int(11) 
//	etc_text varchar(100) 
//	etc_fee int(11) 
//	befo_dist int(11)
	
	private int driv_no;
	private String mem_id;
	private String car_reg_no;
	private int cour_no;
	private String driv_s_date;
	private String driv_e_date;
	private String card_divi;
	private int oil_fee;
	private int trans_fee;
	private String etc_text;
	private int etc_fee;
	private int befo_dist;
	
	private int s_hour;
	private int e_hour;
	private String date;
	
	public int getDriv_no() {
		return driv_no;
	}
	public void setDriv_no(int driv_no) {
		this.driv_no = driv_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getCar_reg_no() {
		return car_reg_no;
	}
	public void setCar_reg_no(String car_reg_no) {
		this.car_reg_no = car_reg_no;
	}
	public int getCour_no() {
		return cour_no;
	}
	public void setCour_no(int cour_no) {
		this.cour_no = cour_no;
	}
	public String getDriv_s_date() {
		return driv_s_date;
	}
	public void setDriv_s_date(String driv_s_date2) {
		this.driv_s_date = driv_s_date2;
	}
	public String getDriv_e_date() {
		return driv_e_date;
	}
	public void setDriv_e_date(String driv_e_date) {
		this.driv_e_date = driv_e_date;
	}
	public String getCard_divi() {
		return card_divi;
	}
	public void setCard_divi(String card_divi) {
		this.card_divi = card_divi;
	}
	public int getOil_fee() {
		return oil_fee;
	}
	public void setOil_fee(int oil_fee) {
		this.oil_fee = oil_fee;
	}
	public int getTrans_fee() {
		return trans_fee;
	}
	public void setTrans_fee(int trans_fee) {
		this.trans_fee = trans_fee;
	}
	public String getEtc_text() {
		return etc_text;
	}
	public void setEtc_text(String etc_text) {
		this.etc_text = etc_text;
	}
	public int getEtc_fee() {
		return etc_fee;
	}
	public void setEtc_fee(int etc_fee) {
		this.etc_fee = etc_fee;
	}
	public int getBefo_dist() {
		return befo_dist;
	}
	public void setBefo_dist(int befo_dist) {
		this.befo_dist = befo_dist;
	}
	public int getS_hour() {
		return s_hour;
	}
	public void setS_hour(int s_hour) {
		this.s_hour = s_hour;
	}
	public int getE_hour() {
		return e_hour;
	}
	public void setE_hour(int e_hour) {
		this.e_hour = e_hour;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "DrivVO [driv_no=" + driv_no + ", mem_id=" + mem_id + ", car_reg_no=" + car_reg_no + ", cour_no="
				+ cour_no + ", driv_s_date=" + driv_s_date + ", driv_e_date=" + driv_e_date + ", card_divi=" + card_divi
				+ ", oil_fee=" + oil_fee + ", trans_fee=" + trans_fee + ", etc_text=" + etc_text + ", etc_fee="
				+ etc_fee + ", befo_dist=" + befo_dist + ", s_hour=" + s_hour + ", e_hour=" + e_hour + "]";
	}
	
	
	
	
	
}
