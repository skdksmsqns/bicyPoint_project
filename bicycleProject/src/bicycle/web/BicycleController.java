package bicycle.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bicycle.service.BicycleService;
import bicycle.service.BicycleVO;
import bicycle.service.impl.BicycleServiceImpl;
import page.PageManager;
import page.PageSQL;

@WebServlet(name = "bicycleController", urlPatterns =
	{"/bicycle_list.do","/bicycle_detail.do","/bicycle_insert_form.do","/bicycle_insert.do","/bicycle_update.do","/bicycle_delete.do","/bicycle_req_list.do" })
public class BicycleController  extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet() 호출됨");
		req.setCharacterEncoding("utf-8");

		Process(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost() 호출됨");

		req.setCharacterEncoding("utf-8");
		Process(req, resp); 

	}
	private void Process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		
		String uri = req.getRequestURI();

		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);

	if(action.equals("bicycle_list.do")) {// 대여소 리스트 
			
			List<BicycleVO> bicycleList = new ArrayList<BicycleVO>();
			BicycleService bicycleService = new BicycleServiceImpl();
		

			
			req.setCharacterEncoding("utf-8");
			bicycleList = bicycleService.selectAllBicycleList();
			
			req.setAttribute("bicycles", bicycleList);
			
			//RequestDispatcher rd = req.getRequestDispatcher("/jsp/bicycle/bicycleList.jsp");
			RequestDispatcher rd = req.getRequestDispatcher("bicycle_req_list.do?reqPage=1");
			rd.forward(req, resp);
			
		}else if (action.equals("bicycle_detail.do")) {// 대여소 넘버 선택 상세보기
			
			String bicycleNum = req.getParameter("bicycleNum");
			
			BicycleService bicycleService = new BicycleServiceImpl();
			BicycleVO bicycleVO= bicycleService.selectByBicycleNum(bicycleNum);
			
			req.setAttribute("bicycleinfo", bicycleVO);
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/bicycle/bicycleDetail.jsp");
			rd.forward(req, resp);
		
		}else if(action.equals("bicycle_insert_form.do")) {// 대여소 정보 저장 페이지 이동

			RequestDispatcher rd = req.getRequestDispatcher("/jsp/bicycle/bicycleInsertForm.jsp");
			rd.forward(req, resp);
			
		}else if (action.equals("bicycle_insert.do")) {// 대여소 정보 저장

			BicycleService bicycleService = new BicycleServiceImpl();
			BicycleVO bicycleVO = new BicycleVO();

			bicycleVO.setBicycleAddr(req.getParameter("bicycleAddr"));
			bicycleVO.setBicycleTel(req.getParameter("bicycleTel"));
		
			bicycleService.insertBicycle(bicycleVO); 
			
			RequestDispatcher rd = req.getRequestDispatcher("bicycle_list");
			rd.forward(req, resp);
			
		}else if (action.equals("bicycle_update.do")) { // 대여소 정보 수정

			BicycleVO bicycleVO = new BicycleVO();
			BicycleService bicycleService = new BicycleServiceImpl();
			
			bicycleVO.setBicycleAddr(req.getParameter("bicycleAddr"));
			bicycleVO.setBicycleTel(req.getParameter("bicycleTel"));
			bicycleVO.setBicycleNum(req.getParameter("bicycleNum"));
			
			bicycleService.updateBicycle(bicycleVO);

			
			//RequestDispatcher rd = req.getRequestDispatcher("notice_req_list?reqPage=1");
			 
			RequestDispatcher rd = req.getRequestDispatcher("bicycle_list");
			rd.forward(req, resp);

		}else if (action.equals("bicycle_delete.do")) { // 대여소 정보 삭제

			BicycleVO bicycleVO = new BicycleVO();
			BicycleService bicycleService = new BicycleServiceImpl();

			bicycleVO.setBicycleNum(req.getParameter("bicycleNum"));

			bicycleService.deleteBicycle(bicycleVO.getBicycleNum());

			//RequestDispatcher rd = req.getRequestDispatcher("notice_req_list?reqPage=1");
			RequestDispatcher rd = req.getRequestDispatcher("bicycle_list");
			rd.forward(req, resp);

		} else if (action.equals("bicycle_req_list.do")) {
			int requestPage = Integer.parseInt(req.getParameter("reqPage"));
			
			PageManager pm = new PageManager(requestPage);

			BicycleService bicycleService = new BicycleServiceImpl();

			List<BicycleVO> bicycleList = bicycleService.selectAllPage(pm.getPageRowResult().getRowStartNumber(),pm.getPageRowResult().getRowEndNumber());

			HttpSession session = req.getSession();
			session.setAttribute("bicycles", bicycleList);
			req.setAttribute("pageGroupResult", pm.getpageGroupResult(PageSQL.BICYCLE_SELETE_ALL_COUNT));

			RequestDispatcher rd = req.getRequestDispatcher("/jsp/bicycle/bicycleList.jsp");
			rd.forward(req, resp);
			  }
			 
			
	}
}
