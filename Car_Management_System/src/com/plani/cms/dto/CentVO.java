package com.plani.cms.dto;

public class CentVO {
	private int cent_no;
	private String cent_name;
	private int cent_p_no;
	private String cent_addr;
	private String cent_addr1;
	private String cent_addr2;
	private String cent_tell;
	private String cent_tell1;
	private String cent_tell2;
	private String cent_tell3;
	private String cent_fax;
	private String cent_fax1;
	private String cent_fax2;
	private String cent_fax3;
	private String ceo_name;
	public int getCent_no() {
		return cent_no;
	}
	public void setCent_no(int cent_no) {
		this.cent_no = cent_no;
	}
	public String getCent_name() {
		return cent_name;
	}
	public void setCent_name(String cent_name) {
		this.cent_name = cent_name;
	}
	public int getCent_p_no() {
		return cent_p_no;
	}
	public void setCent_p_no(int cent_p_no) {
		this.cent_p_no = cent_p_no;
	}
	public String getCent_addr() {
		 cent_addr = getCent_addr1() + " " + getCent_addr2();
		 return cent_addr;
	}
	public void setCent_addr(String cent_addr) {
		this.cent_addr = cent_addr;
	}
	public String getCent_addr1() {
		return cent_addr1;
	}
	public void setCent_addr1(String cent_addr1) {
		this.cent_addr1 = cent_addr1;
	}
	public String getCent_addr2() {
		return cent_addr2;
	}
	public void setCent_addr2(String cent_addr2) {
		this.cent_addr2 = cent_addr2;
	}
	public String getCent_tell() {
		 cent_tell = getCent_tell1() + "-" + getCent_tell2() + "-" + getCent_tell3();
			return cent_tell;
	}
	public void setCent_tell(String cent_tell) {
		this.cent_tell = cent_tell;
	}
	public String getCent_tell1() {
		return cent_tell1;
	}
	public void setCent_tell1(String cent_tell1) {
		this.cent_tell1 = cent_tell1;
	}
	public String getCent_tell2() {
		return cent_tell2;
	}
	public void setCent_tell2(String cent_tell2) {
		this.cent_tell2 = cent_tell2;
	}
	public String getCent_tell3() {
		return cent_tell3;
	}
	public void setCent_tell3(String cent_tell3) {
		this.cent_tell3 = cent_tell3;
	}
	public String getCent_fax() {
		 cent_fax = getCent_fax1() + "-" + getCent_fax2() + "-" + getCent_fax3();
		 return cent_fax;
	}
	public void setCent_fax(String cent_fax) {
		this.cent_fax = cent_fax;
	}
	public String getCent_fax1() {
		return cent_fax1;
	}
	public void setCent_fax1(String cent_fax1) {
		this.cent_fax1 = cent_fax1;
	}
	public String getCent_fax2() {
		return cent_fax2;
	}
	public void setCent_fax2(String cent_fax2) {
		this.cent_fax2 = cent_fax2;
	}
	public String getCent_fax3() {
		return cent_fax3;
	}
	public void setCent_fax3(String cent_fax3) {
		this.cent_fax3 = cent_fax3;
	}
	public String getCeo_name() {
		return ceo_name;
	}
	public void setCeo_name(String ceo_name) {
		this.ceo_name = ceo_name;
	}
	
	
}
