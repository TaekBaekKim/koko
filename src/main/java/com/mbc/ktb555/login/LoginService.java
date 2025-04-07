package com.mbc.ktb555.login;

import java.util.ArrayList;

public interface LoginService {

	int idcount(String id);

	

	



	ArrayList<LoginDTO> allout();







	void loginsave(String id, String pw, String name, int age);

}
