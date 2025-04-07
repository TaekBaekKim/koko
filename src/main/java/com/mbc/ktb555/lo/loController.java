package com.mbc.ktb555.lo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loController {

    @Autowired
    SqlSession sqlSession;

    @Autowired
    PasswordEncoder passwordEncoder; // BCryptPasswordEncoder�� ���Թ���

    @RequestMapping(value = "/login")
    public String login() {
        return "login"; // �α��� �������� ��ȯ
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // BCryptPasswordEncoder�� ��й�ȣ ��ȣȭ�� ���� ���˴ϴ�.
    }

    @RequestMapping(value = "/home")
    public String log(LoDTO dto, HttpServletResponse response, HttpServletRequest request) throws IOException {
        String id = dto.getId();
        String pw = dto.getPw();
        LoService ls = sqlSession.getMapper(LoService.class);
        String spw = ls.pwsearch(id); // �����ͺ��̽����� ��й�ȣ ��ȸ
      
        // ��й�ȣ ��
        boolean flag = passwordEncoder.matches(pw, spw); // ���Թ��� PasswordEncoder�� ���
        if (flag) {
            // ��й�ȣ ��ġ -> �α��� ����
            HttpSession hs = request.getSession();
            hs.setAttribute("loginstate", true);
            hs.setAttribute("id", id);
            hs.setMaxInactiveInterval(180); // 180�� ���� �� �����̸� �ڵ� �α׾ƿ�
            return "redirect:/main"; // Ȩ �������� ���𷺼�
        } else {
            // ��й�ȣ ����ġ -> �α��� ����
            response.setContentType("text/html;charset=utf-8");
            PrintWriter pwr = response.getWriter();
            pwr.print("<script>alert('���̵� �Ǵ� ��й�ȣ ����')</script>");
            pwr.print("<script>location.href='login'</script>");
            pwr.close();
            return "redirect:/login"; // �α��� �������� ���𷺼�
        }
    }
    @RequestMapping(value = "/logout")
    public String loout(HttpServletRequest request) {
       HttpSession hs=request.getSession();
       hs.removeAttribute("loginstate");
       hs.removeAttribute("id");
    	return "redirect:/main"; // �α��� �������� ��ȯ
    }
}
