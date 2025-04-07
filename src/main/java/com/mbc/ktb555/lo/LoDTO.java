package com.mbc.ktb555.lo;

public class LoDTO {
String id,pw;

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getPw() {
	return pw;
}

public void setPw(String pw) {
	this.pw = pw;
}

public LoDTO(String id, String pw) {
	super();
	this.id = id;
	this.pw = pw;
}

public LoDTO() {
	super();
	// TODO Auto-generated constructor stub
}
}
