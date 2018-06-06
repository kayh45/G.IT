package com.plani.cms.dto;

public class RepaVO {
/*	CREATE TABLE if not exists `cms`.`repa` (
			  `repa_no` INT NOT NULL AUTO_INCREMENT,
			  `cent_no` INT NOT NULL,
			  `car_reg_no` VARCHAR(30) NOT NULL,
			  `mechanic_name` VARCHAR(30) NULL,
			  `repa_s_date` DATE NOT NULL,
			  `repa_e_date` DATE NOT NULL,
			  `repa_cont` VARCHAR(500) NULL,
			  `repa_fee` INT NULL,
			  PRIMARY KEY (`repa_no`),
			CONSTRAINT FK_cms_cent FOREIGN KEY(cent_no) REFERENCES cent(cent_no),
			CONSTRAINT FK_cms_car FOREIGN KEY(car_reg_no) REFERENCES car(car_reg_no));
			#차량 정비내역 테이블 생성*/
	private int repa_no;
	private int cent_no;
	private String cent_name;
	private String car_reg_no;
	private String mechanic_name;
	private String repa_s_date;
	private String repa_e_date;
	private String repa_cont;
	private int repa_fee;
	private String repa_divi;
	
	
	public String getCent_name() {
		return cent_name;
	}
	public void setCent_name(String cent_name) {
		this.cent_name = cent_name;
	}
	public int getRepa_no() {
		return repa_no;
	}
	public String getRepa_divi() {
		return repa_divi;
	}
	public void setRepa_divi(String repa_divi) {
		this.repa_divi = repa_divi;
	}
	public void setRepa_no(int repa_no) {
		this.repa_no = repa_no;
	}
	public int getCent_no() {
		return cent_no;
	}
	public void setCent_no(int cent_no) {
		this.cent_no = cent_no;
	}
	public String getCar_reg_no() {
		return car_reg_no;
	}
	public void setCar_reg_no(String car_reg_no) {
		this.car_reg_no = car_reg_no;
	}
	public String getMechanic_name() {
		return mechanic_name;
	}
	public void setMechanic_name(String mechanic_name) {
		this.mechanic_name = mechanic_name;
	}
	public String getRepa_s_date() {
		return repa_s_date;
	}
	public void setRepa_s_date(String repa_s_date) {
		this.repa_s_date = repa_s_date;
	}
	public String getRepa_e_date() {
		return repa_e_date;
	}
	public void setRepa_e_date(String repa_e_date) {
		this.repa_e_date = repa_e_date;
	}
	public String getRepa_cont() {
		return repa_cont;
	}
	public void setRepa_cont(String repa_cont) {
		this.repa_cont = repa_cont;
	}
	public int getRepa_fee() {
		return repa_fee;
	}
	public void setRepa_fee(int repa_fee) {
		this.repa_fee = repa_fee;
	}
	
}
