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
			/*servlet��3������
			*		1����ȡ������
			*		2������ҵ���߼�
			*		3���ַ�ת��
			**/
			//��ȡ������
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			//��ȡsession
			HttpSession session = request.getSession();
			String userName = request.getParameter("userName"); 
			String password = request.getParameter("password");
			String remeber = request.getParameter("remeber");
			String autologin = request.getParameter("autologin");
			String realCheckCode = request.getParameter("checkedCode");
			String inputCheckCode = (String)session.getAttribute("checkcode");
			String checkcode = request.getParameter("checkcode");
			//����ҵ���߼�
			//�ַ�ת��
			
			if(checkcode!= null){
				//�ж��û��������ǹ�ƥ��
				if(userName.equals("admin")&&password.equals("12345")){
					Cookie ck = new Cookie("userName", userName);
					Cookie ck1 = new Cookie("user",userName+"&"+"12345");
					//����cookie·��Ϊ��ǰӦ��
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
					response.getWriter().println("��½�ɹ�!");
					response.setHeader("refresh", "2;url="+request.getContextPath()+"/index.jsp");
				}
				else{
					request.setAttribute("msg", "�û��������벻��ȷ��");
					//response.setHeader("refresh", ";url="+request.getContextPath()+"/pages/login.jsp");
					request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
				}
			}
			//�ж���֤���Ƿ���ȷ
			if(realCheckCode.toLowerCase().equals(inputCheckCode.toLowerCase()))
			{
				//�ж��û��������ǹ�ƥ��
				if(userName.equals("admin")&&password.equals("12345")){
					Cookie ck = new Cookie("userName", userName);
					Cookie ck1 = new Cookie("user",userName+"&"+"12345");
					//����cookie·��Ϊ��ǰӦ��
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
					response.getWriter().println("��½�ɹ�!");
					response.setHeader("refresh", "2;url="+request.getContextPath()+"/index.jsp");
				}
				else{
					request.setAttribute("msg", "�û��������벻��ȷ��");
					//response.setHeader("refresh", ";url="+request.getContextPath()+"/pages/login.jsp");
					request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
				}
			}
			else{
				request.setAttribute("msg", "��֤�벻��ȷ��");
				request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
			}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
