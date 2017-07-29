package cn.rabbithouse.dologin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.dsna.util.images.ValidateCode;
@WebServlet("/servlet/checkcode")
public class CheckCode extends HttpServlet {

	public CheckCode() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control","no-cache");
		response.setHeader("expires", "0");
		ValidateCode vc = new ValidateCode(110, 25, 4, 10);
		vc.write(response.getOutputStream());
		HttpSession session = request.getSession();
		session.setAttribute("checkcode", vc.getCode());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
