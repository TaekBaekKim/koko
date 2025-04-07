package com.mbc.ktb555.login;

public class LoginDTO {
String id,pw,name;
int age;
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
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public LoginDTO(String id, String pw, String name, int age) {
	super();
	this.id = id;
	this.pw = pw;
	this.name = name;
	this.age = age;
}
public LoginDTO() {
	super();
	// TODO Auto-generated constructor stub
}
}
