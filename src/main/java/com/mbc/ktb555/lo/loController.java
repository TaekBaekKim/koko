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
    PasswordEncoder passwordEncoder; // BCryptPasswordEncoder를 주입받음

    @RequestMapping(value = "/login")
    public String login() {
        return "login"; // 로그인 페이지를 반환
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // BCryptPasswordEncoder는 비밀번호 암호화에 자주 사용됩니다.
    }

    @RequestMapping(value = "/home")
    public String log(LoDTO dto, HttpServletResponse response, HttpServletRequest request) throws IOException {
        String id = dto.getId();
        String pw = dto.getPw();
        LoService ls = sqlSession.getMapper(LoService.class);
        String spw = ls.pwsearch(id); // 데이터베이스에서 비밀번호 조회
      
        // 비밀번호 비교
        boolean flag = passwordEncoder.matches(pw, spw); // 주입받은 PasswordEncoder를 사용
        if (flag) {
            // 비밀번호 일치 -> 로그인 성공
            HttpSession hs = request.getSession();
            hs.setAttribute("loginstate", true);
            hs.setAttribute("id", id);
            hs.setMaxInactiveInterval(180); // 180초 동안 안 움직이면 자동 로그아웃
            return "redirect:/main"; // 홈 페이지로 리디렉션
        } else {
            // 비밀번호 불일치 -> 로그인 실패
            response.setContentType("text/html;charset=utf-8");
            PrintWriter pwr = response.getWriter();
            pwr.print("<script>alert('아이디 또는 비밀번호 오류')</script>");
            pwr.print("<script>location.href='login'</script>");
            pwr.close();
            return "redirect:/login"; // 로그인 페이지로 리디렉션
        }
    }
    @RequestMapping(value = "/logout")
    public String loout(HttpServletRequest request) {
       HttpSession hs=request.getSession();
       hs.removeAttribute("loginstate");
       hs.removeAttribute("id");
    	return "redirect:/main"; // 로그인 페이지를 반환
    }
}
