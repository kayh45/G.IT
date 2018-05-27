package com.plani.cms.dto;

public class PlaceVO {


int place_no;
String place_name;
int place_p_no;
String place_addr;
String place_addr_dtl;


public String getPlace_addr_dtl() {
return place_addr_dtl;
}
public void setPlace_addr_dtl(String place_addr_dtl) {
this.place_addr_dtl = place_addr_dtl;
}
public int getPlace_no() {
return place_no;
}
public void setPlace_no(int place_no) {
this.place_no = place_no;
}
public String getPlace_name() {
return place_name;
}
public void setPlace_name(String place_name) {
this.place_name = place_name;
}
public int getPlace_p_no() {
return place_p_no;
}
public void setPlace_p_no(int place_p_no) {
this.place_p_no = place_p_no;
}
public String getPlace_addr() {
return place_addr;
}
public void setPlace_addr(String place_addr) {
this.place_addr = place_addr;
}
}