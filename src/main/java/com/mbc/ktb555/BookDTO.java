package com.mbc.ktb555;

import java.sql.Date;

public class BookDTO {
int bnumber;
String bname;
String name;
Date bdate;
int bprice;
String bimage;
int bcnt;
public BookDTO() {
	super();
	// TODO Auto-generated constructor stub
}
public BookDTO(int bnumber, String bname, String name, Date bdate, int bprice, String bimage, int bcnt) {
	super();
	this.bnumber = bnumber;
	this.bname = bname;
	this.name = name;
	this.bdate = bdate;
	this.bprice = bprice;
	this.bimage = bimage;
	this.bcnt = bcnt;
}
public int getBnumber() {
	return bnumber;
}
public void setBnumber(int bnumber) {
	this.bnumber = bnumber;
}
public String getBname() {
	return bname;
}
public void setBname(String bname) {
	this.bname = bname;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Date getBdate() {
	return bdate;
}
public void setBdate(Date bdate) {
	this.bdate = bdate;
}
public int getBprice() {
	return bprice;
}
public void setBprice(int bprice) {
	this.bprice = bprice;
}
public String getBimage() {
	return bimage;
}
public void setBimage(String bimage) {
	this.bimage = bimage;
}
public int getBcnt() {
	return bcnt;
}
public void setBcnt(int bcnt) {
	this.bcnt = bcnt;
}

}

