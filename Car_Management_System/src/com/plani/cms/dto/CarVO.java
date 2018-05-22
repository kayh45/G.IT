package com.plani.cms.dto;

public class CarVO {
	private String car_reg_no;
	private String car_divi;
	private String car_model;
	private String ct_date;
	private String ep_date;
	private String co_name;
	private String co_tel;
	private String co_tel1;
	private String co_tel2;
	private String co_tel3;
	private String co_fax;
	private String co_fax1;
	private String co_fax2;
	private String co_fax3;
	private String bo_name;
	private String bo_divi;
	private int bo_age;
	private String bo_s_date;
	private String bo_e_date;
	private int total_dist;
	// 배차에서 쓰려고 만듬 .. 없어질수도 있음
	private int isUsing;
	private int canUse;
	// 배차에서 쓰려고 만듬 .. 없어질수도 있음
	public String getCar_reg_no() {
		return car_reg_no;
	}
	public void setCar_reg_no(String car_reg_no) {
		this.car_reg_no = car_reg_no;
	}
	public String getCar_divi() {
		return car_divi;
	}
	public void setCar_divi(String car_divi) {
		this.car_divi = car_divi;
	}
	public String getCar_model() {
		return car_model;
	}
	public void setCar_model(String car_model) {
		this.car_model = car_model;
	}
	public String getCt_date() {
		return ct_date;
	}
	public void setCt_date(String ct_date) {
		this.ct_date = ct_date;
	}
	public String getEp_date() {
		return ep_date;
	}
	public void setEp_date(String ep_date) {
		this.ep_date = ep_date;
	}
	public String getCo_name() {
		return co_name;
	}
	public void setCo_name(String co_name) {
		this.co_name = co_name;
	}
	public String getCo_tel() {
		co_tel = getCo_tel1() + getCo_tel2() + getCo_tel3();
		return co_tel;
	}
	public void setCo_tel(String co_tel) {
		this.co_tel = co_tel;
	}
	public String getCo_tel1() {
		return co_tel1;
	}
	public void setCo_tel1(String co_tel1) {
		this.co_tel1 = co_tel1;
	}
	public String getCo_tel2() {
		return co_tel2;
	}
	public void setCo_tel2(String co_tel2) {
		this.co_tel2 = co_tel2;
	}
	public String getCo_tel3() {
		return co_tel3;
	}
	public void setCo_tel3(String co_tel3) {
		this.co_tel3 = co_tel3;
	}
	public String getCo_fax() {
		this.co_fax = getCo_fax1() + "-" + getCo_fax2() + "-" + getCo_fax3();
		return co_fax;
	}
	public void setCo_fax(String co_fax) {
		this.co_fax = co_fax;
	}
	public String getCo_fax1() {
		return co_fax1;
	}
	public void setCo_fax1(String co_fax1) {
		this.co_fax1 = co_fax1;
	}
	public String getCo_fax2() {
		return co_fax2;
	}
	public void setCo_fax2(String co_fax2) {
		this.co_fax2 = co_fax2;
	}
	public String getCo_fax3() {
		return co_fax3;
	}
	public void setCo_fax3(String co_fax3) {
		this.co_fax3 = co_fax3;
	}
	public String getBo_name() {
		return bo_name;
	}
	public void setBo_name(String bo_name) {
		this.bo_name = bo_name;
	}
	public String getBo_divi() {
		return bo_divi;
	}
	public void setBo_divi(String bo_divi) {
		this.bo_divi = bo_divi;
	}
	public int getBo_age() {
		return bo_age;
	}
	public void setBo_age(int bo_age) {
		this.bo_age = bo_age;
	}
	public String getBo_s_date() {
		return bo_s_date;
	}
	public void setBo_s_date(String bo_s_date) {
		this.bo_s_date = bo_s_date;
	}
	public String getBo_e_date() {
		return bo_e_date;
	}
	public void setBo_e_date(String bo_e_date) {
		this.bo_e_date = bo_e_date;
	}
	public int getTotal_dist() {
		return total_dist;
	}
	public void setTotal_dist(int total_dist) {
		this.total_dist = total_dist;
	}
	public int getCanUse() {
		return canUse;
	}
	public void setCanUse(int canUse) {
		this.canUse = canUse;
	}
	public int getIsUsing() {
		return isUsing;
	}
	public void setIsUsing(int isUsing) {
		this.isUsing = isUsing;
	}
}
	
