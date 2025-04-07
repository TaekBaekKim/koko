package com.mbc.ktb555.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
@Autowired
SqlSession sqlSession;

@RequestMapping(value = "/logininput")
public String logininput() {
	

	
	return "logininput";
}
@ResponseBody
@RequestMapping(value = "/idgo")
public String idgo(String id) {
	LoginService ls=sqlSession.getMapper(LoginService.class);
int count=ls.idcount(id);
if(count==0) 
	return "ok";
else return "no";
		
}
@RequestMapping(value = "/loginsave")
public String loginsave(LoginDTO dto) {
	String id=dto.getId();
	String pw=dto.getPw();
	String name=dto.getName();
	int age=dto.getAge();
			//�н����� ��ȣȭ����
	PasswordEncoder pe= new BCryptPasswordEncoder();
	pw=pe.encode(pw);
	LoginService ls=sqlSession.getMapper(LoginService.class);
	ls.loginsave(id,pw,name,age);

	
	return "redirect:/";
}
@RequestMapping(value = "/loginout")
public String loginout(Model model, HttpServletRequest request,HttpServletResponse response) throws IOException {
    HttpSession hs = request.getSession();
    
    // ���ǿ��� loginstate ���� ������ �� null üũ �߰�
    Boolean flag = (Boolean) hs.getAttribute("loginstate");
    
    // flag�� null�̸� �α��� ���°� �ƴϹǷ� �� ���ڿ� ��ȯ
    if (flag != null && flag) {
        LoginService ls = sqlSession.getMapper(LoginService.class);
        ArrayList<LoginDTO> list = ls.allout();
        model.addAttribute("list", list);
        return "loginout";
    } else {
    	   response.setContentType("text/html;charset=utf-8");
           PrintWriter pwr = response.getWriter();
           pwr.print("<script>alert('���̵� �Ǵ� ��й�ȣ ����')</script>");
           pwr.print("<script>location.href='login'</script>");
           pwr.close();
           return "redirect:/login"; // �α��� �������� ���𷺼�
       
    }
}


}