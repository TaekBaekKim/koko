package com.mbc.ktb555;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


@Controller
public class HomeController {
@Autowired
	SqlSession sqlSession;
String path="C:\\MBC12AI\\spring\\day4_book\\src\\main\\webapp\\image";
	
	
	@RequestMapping(value = "/input")
	public String kk1() {
		
		return "binput";
	}
	@RequestMapping(value = "save",method = RequestMethod.POST)
	public String kk2(MultipartHttpServletRequest mul) throws IllegalStateException, IOException {
		String bname=mul.getParameter("bname");
		String name=mul.getParameter("name");
		java.sql.Date bdate=java.sql.Date.valueOf(mul.getParameter("bdate"));
		int bprice=Integer.parseInt(mul.getParameter("bprice"));
		MultipartFile mf=mul.getFile("bimage");
		String bimage=mf.getOriginalFilename();
		
		UUID uu =UUID.randomUUID();
		bimage=uu.toString()+"_"+bimage;
		mf.transferTo(new File(path+"\\"+bimage));
		Service ss=sqlSession.getMapper(Service.class);
		ss.insertb(bname,name,bdate,bprice,bimage);
		
		mf.transferTo(new File(path+"\\"+bimage));
		return "redirect:/";
	}
//	@RequestMapping(value = "/out")
//	public String kk3(Model model ) {
//		Service ss=sqlSession.getMapper(Service.class);
//		ArrayList<BookDTO>list=ss.selectb();
//		model.addAttribute("list", list);
//		return "bout";
//	}
	// --  2222 -->
	   @RequestMapping(value="/out")
	      public String ko16(HttpServletRequest request, PageDTO dto,Model mo) {
	         String nowPage=request.getParameter("nowPage");
	         String cntPerPage=request.getParameter("cntPerPage");
	         Service sc = sqlSession.getMapper(Service.class);
	         //전체레코드수구하기
	         int total=sc.total();
	         if(nowPage==null && cntPerPage == null) {
	            nowPage="1";
	            cntPerPage="5";
	         }
	         else if(nowPage==null) {
	            nowPage="1";
	         }
	         else if(cntPerPage==null) {
	            cntPerPage="5";
	         }      
	         dto=new PageDTO(total,Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
	         mo.addAttribute("paging",dto);
	         mo.addAttribute("list",sc.page(dto));
	         return "bout";
	    //2222222222
	   }//

	@RequestMapping(value = "/contup")
	public String kk4(Model model, HttpServletRequest request){
		int num=Integer.parseInt(request.getParameter("num"));
		Service ss=sqlSession.getMapper(Service.class);
		ss.countup(num);
		ArrayList<BookDTO>list=ss.cnt(num);
		model.addAttribute("list2", list);
		return "countview";
	}
	@RequestMapping(value = "/update")
	public String kk5(Model model,HttpServletRequest request){
		int num=Integer.parseInt(request.getParameter("num"));
		Service ss=sqlSession.getMapper(Service.class);
		
		BookDTO dto=ss.update(num);
		model.addAttribute("dto", dto);
		return "update2";
	}	

@RequestMapping(value = "/updatego",method = RequestMethod.POST)
public String kk6(MultipartHttpServletRequest mul,Model model) throws IllegalStateException, IOException {
	int num=Integer.parseInt(mul.getParameter("num"));
	String bname=mul.getParameter("bname");
	String name=mul.getParameter("name");
	java.sql.Date bdate=java.sql.Date.valueOf(mul.getParameter("bdate"));
	int bprice=Integer.parseInt(mul.getParameter("bprice"));
	MultipartFile mf=mul.getFile("bimage");
	String bcnt=mul.getParameter("bcnt");
	String image=mul.getParameter("image");
	String bimage=mf.getOriginalFilename();
	UUID uu =UUID.randomUUID();
	bimage=uu.toString()+"_"+bimage;
	mf.transferTo(new File(path+"\\"+bimage));
	
	
	File ff=new File(path+"\\"+bimage);
	ff.delete();
	Service ss=sqlSession.getMapper(Service.class);
	ss.updatego(bname,name,bdate,bprice,bimage,bcnt,num);
	return "main";
}
@RequestMapping(value = "/map")
public String kk7(){
	return "map";
}
}
