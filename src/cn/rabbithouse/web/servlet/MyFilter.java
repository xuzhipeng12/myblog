package cn.rabbithouse.web.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
//@WebFilter("/index.jsp")
public class MyFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest   req = (HttpServletRequest) request;
		Cookie[] cks = req.getCookies();
		String userName = "";
		String passwd = "";
		if(cks != null){
			for(Cookie ck : cks){
				if(ck.getName().equals("user")){
					userName = ck.getValue().split("&")[0];
					passwd = ck.getValue().split("&")[1];
					request.getRequestDispatcher("/servlet/loginservlet?checkcode=1&userName="+userName+"&password="+passwd).forward(request, response);
				}
			}
		}
		chain.doFilter(request, response);	
	}


}
