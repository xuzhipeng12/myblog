package cn.rabbithouse.dologin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/servlet/loginservlet")
public class Dologin extends HttpServlet {

	public Dologin() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			/*servlet的3个功能
			*		1、获取表单数据
			*		2、处理业务逻辑
			*		3、分发转向
			**/
			//获取表单数据
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			//获取session
			HttpSession session = request.getSession();
			String userName = request.getParameter("userName"); 
			String password = request.getParameter("password");
			String remeber = request.getParameter("remeber");
			String autologin = request.getParameter("autologin");
			String realCheckCode = request.getParameter("checkedCode");
			String inputCheckCode = (String)session.getAttribute("checkcode");
			String checkcode = request.getParameter("checkcode");
			//处理业务逻辑
			//分发转向
			
			if(checkcode!= null){
				//判断用户名密码是够匹配
				if(userName.equals("admin")&&password.equals("12345")){
					Cookie ck = new Cookie("userName", userName);
					Cookie ck1 = new Cookie("user",userName+"&"+"12345");
					//设置cookie路径为当前应用
					ck.setPath("/");
					ck1.setPath("/");
					if(remeber!= null){
						ck.setMaxAge(Integer.MAX_VALUE);
					}
					else{
						ck.setMaxAge(0);
					}
					if(autologin != null){
						ck1.setMaxAge(Integer.MAX_VALUE);
					}
					else{
						ck1.setMaxAge(0);
					}
					response.addCookie(ck1);
					response.addCookie(ck);
					session.setAttribute("usrname",userName);
					response.getWriter().println("登陆成功!");
					response.setHeader("refresh", "2;url="+request.getContextPath()+"/index.jsp");
				}
				else{
					request.setAttribute("msg", "用户名或密码不正确！");
					//response.setHeader("refresh", ";url="+request.getContextPath()+"/pages/login.jsp");
					request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
				}
			}
			//判断验证码是否正确
			if(realCheckCode.toLowerCase().equals(inputCheckCode.toLowerCase()))
			{
				//判断用户名密码是够匹配
				if(userName.equals("admin")&&password.equals("12345")){
					Cookie ck = new Cookie("userName", userName);
					Cookie ck1 = new Cookie("user",userName+"&"+"12345");
					//设置cookie路径为当前应用
					ck.setPath("/");
					ck1.setPath("/");
					if(remeber!= null){
						ck.setMaxAge(Integer.MAX_VALUE);
					}
					else{
						ck.setMaxAge(0);
					}
					if(autologin != null){
						ck1.setMaxAge(Integer.MAX_VALUE);
					}
					else{
						ck1.setMaxAge(0);
					}
					response.addCookie(ck1);
					response.addCookie(ck);
					session.setAttribute("usrname",userName);
					response.getWriter().println("登陆成功!");
					response.setHeader("refresh", "2;url="+request.getContextPath()+"/index.jsp");
				}
				else{
					request.setAttribute("msg", "用户名或密码不正确！");
					//response.setHeader("refresh", ";url="+request.getContextPath()+"/pages/login.jsp");
					request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
				}
			}
			else{
				request.setAttribute("msg", "验证码不正确！");
				request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
			}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
