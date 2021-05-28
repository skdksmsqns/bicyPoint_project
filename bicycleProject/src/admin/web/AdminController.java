package admin.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.service.AdminService;
import admin.service.AdminVO;
import admin.service.impl.AdminServiceImpl;

@WebServlet(name = "adminController", urlPatterns = { "/adminLlogin_from.do", "/adminLogin.do","/logout.do" })
public class AdminController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		process(req, resp);

	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uri = req.getRequestURI();

		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);

		req.setCharacterEncoding("utf-8");

		if (action.equals("adminLlogin_from.do")) {

			RequestDispatcher rd = req.getRequestDispatcher("/jsp/admin/adminLogin.jsp");
			rd.forward(req, resp);

		} else if (action.equals("adminLogin.do")) {

			AdminVO adminVO = null;
			String adminID = req.getParameter("adminID");
			String adminPassword = req.getParameter("adminPassword");

			AdminService adminService = new AdminServiceImpl();
			adminVO = adminService.selectByAdminID(adminID);

			if (adminVO != null) {

				if (adminID.equals(adminVO.getAdminID()) && adminPassword.equals(adminVO.getAdminPassword())) {

					HttpSession session = req.getSession(); // 브라우저 닫을때가지 생존
					session.setAttribute("admin", adminVO);
					req.setAttribute("message", "로그인중");

					RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
					rd.forward(req, resp);

				} else {

					req.setAttribute("message", "아이디 또는 비밀번호를 다시 확인 해주세요 ");

					RequestDispatcher rd = req.getRequestDispatcher("/jsp/admin/adminLogin.jsp");
					rd.forward(req, resp);
				}
			}
		}

		else if (action.equals("logout.do")) {

			HttpSession session = req.getSession(); // 브라우저 닫을때가지 생

			session.removeAttribute("admin");

			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.forward(req, resp);
		}

	}
}
