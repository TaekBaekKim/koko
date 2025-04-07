package com.mbc.ktb555;

import java.awt.print.Book;
import java.sql.Date;
import java.util.ArrayList;

public interface Service {



	void insertb(String bname, String name, java.util.Date bdate, int bprice, String bimage);

	ArrayList<BookDTO> selectb();

	void countup(int num);

	ArrayList<BookDTO> cnt(int num);

	BookDTO update(int num);

	void updatego(String bname, String name, Date bdate, int bprice, String bimage, String bcnt, int num);

	int total();//전체레코드수구하기
	   public ArrayList<BookDTO> page(PageDTO dto);//페이지정보





}
