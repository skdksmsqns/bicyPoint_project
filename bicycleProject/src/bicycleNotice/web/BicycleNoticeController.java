package bicycleNotice.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bicycleNotice.service.BicycleNoticeService;
import bicycleNotice.service.BicycleNoticeVO;
import bicycleNotice.service.impl.BicycleNoticeServiceImpl;

@WebServlet(name = "BicycleNoticeController", urlPatterns = {"/bicyclent_list","/bicyclent_input","/bicyclent_save", "/bicyclent_detail", "/bicyclent_update", "/bicyclent_delete"})


public class BicycleNoticeController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		System.out.println("doGet() 호출됨");

		Process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		System.out.println("doPost() 호출됨");

		Process(req, resp);

	}
	
	private void Process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");

		String uri = req.getRequestURI();

		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		
		if (action.equals("bicyclent_list")) {
			
			System.out.println("hello");

			BicycleNoticeService service = new BicycleNoticeServiceImpl();
			List<BicycleNoticeVO> BicycleNoticeVOList = service.selectAll();

			req.setAttribute("bicyclents", BicycleNoticeVOList);

			RequestDispatcher rd = req.getRequestDispatcher("/jsp/BicycleNT/BicycleNoticeVOList.jsp");
			rd.forward(req, resp);

		}
		
		if (action.equals("bicyclent_input")) {

			RequestDispatcher rd = req.getRequestDispatcher("/jsp/BicycleNT/BicycleNoticeInput.jsp");
			rd.forward(req, resp);
		}
		
		if (action.equals("bicyclent_save")) {
			
			BicycleNoticeVO bicyclent = new BicycleNoticeVO();
			BicycleNoticeService dao = new BicycleNoticeServiceImpl();

			bicyclent.setNt_sj(req.getParameter("nt_sj"));
			bicyclent.setNt_cn(req.getParameter("nt_cn"));
			bicyclent.setAdmin_id("admin");
			dao.bicyclentinsert(bicyclent);

			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.forward(req, resp);
			
		}
		
		
		if (action.equals("bicyclent_detail")) {
			
			int nt_num = Integer.parseInt(req.getParameter("nt_num"));
			
			BicycleNoticeService dao = new BicycleNoticeServiceImpl();
			BicycleNoticeVO bicyclent = dao.selectByNo(nt_num);
			
			req.setAttribute("bicyclent", bicyclent);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/BicycleNT/BicycleNoticeDetail.jsp");
			
			rd.forward(req, resp);
		}			
		
		if (action.equals("bicyclent_update")) {
			
			BicycleNoticeVO bicyclent = new BicycleNoticeVO();
			
			bicyclent.setNt_num(Integer.parseInt(req.getParameter("nt_num")));
			bicyclent.setNt_sj(req.getParameter("nt_sj"));
			bicyclent.setNt_cn(req.getParameter("nt_cn"));

			BicycleNoticeService dao = new BicycleNoticeServiceImpl();
			boolean result = dao.bicyclentupdate(bicyclent);
			
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.forward(req, resp);
		}
		
		if (action.equals("bicyclent_delete")) {

			BicycleNoticeService dao = new BicycleNoticeServiceImpl();
			BicycleNoticeVO bicyclent = new BicycleNoticeVO();
			
			bicyclent.setNt_num(Integer.parseInt(req.getParameter("nt_num")));

			boolean result = dao.bicyclentdelete(bicyclent.getNt_num());

			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.forward(req, resp);

		}

	}	

}
