package bicyPoint.web;

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

import bicyPoint.service.BicyclePointService;
import bicyPoint.service.BicyclePointVO;
import bicyPoint.service.impl.BicyclePointServiceImpl;
import bicycle.service.BicycleService;
import bicycle.service.BicycleVO;
import bicycle.service.impl.BicycleServiceImpl;
import page.PageManager;
import page.PageSQL;

@WebServlet(name = "bicyclePointController", urlPatterns = 
	{ "/bicycle_point_list.do","/bicycle_point_detail.do","/bicycle_point_delete.do","/bicycle_point_req_list.do","/mapMainView.do" })
public class BicyclePointController extends HttpServlet {

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

		if (action.equals("bicycle_point_list.do")) {// 리스트

			List<BicyclePointVO> bicyclePointList = new ArrayList<BicyclePointVO>();
			BicyclePointService bicyclePointService = new BicyclePointServiceImpl();

			req.setCharacterEncoding("utf-8");
			bicyclePointList = bicyclePointService.selectAllBicyclePointList();

			req.setAttribute("bicyclePoints", bicyclePointList);

			 //RequestDispatcher rd = req.getRequestDispatcher("/jsp/bicyclePoint/bicyclePointList.jsp");
			RequestDispatcher rd = req.getRequestDispatcher("/bicycle_point_req_list.do?reqPage=1");
			rd.forward(req, resp);

		} else if (action.equals("bicycle_point_detail.do")) {// 아이디 선택 상세보기

			int id = Integer.parseInt(req.getParameter("id"));

			BicyclePointService bicyclePointService = new BicyclePointServiceImpl();
			BicyclePointVO bicyclePointVO = bicyclePointService.selectByBicyclePointId(id);

			req.setAttribute("bicyclePointInfo", bicyclePointVO);

			RequestDispatcher rd = req.getRequestDispatcher("/jsp/bicyclePoint/bicyclePointDetail.jsp");
			rd.forward(req, resp);

		} else if (action.equals("bicycle_point_delete.do")) { // 포인트 정보 삭제

			BicyclePointService bicyclePointService = new BicyclePointServiceImpl();
			BicyclePointVO bicyclePointVO = new BicyclePointVO();

			bicyclePointVO.setId(Integer.parseInt(req.getParameter("id")));

			bicyclePointService.deleteBicyclePoint(bicyclePointVO.getId());

			 RequestDispatcher rd =req.getRequestDispatcher("/bicycle_point_req_list.do?reqPage=1");
			//RequestDispatcher rd = req.getRequestDispatcher("bicycle_list");
			rd.forward(req, resp);

		} else if (action.equals("bicycle_point_req_list.do")) {
			int requestPage = Integer.parseInt(req.getParameter("reqPage"));

			PageManager pm = new PageManager(requestPage);

			 BicyclePointService bicyclePointService = new BicyclePointServiceImpl();
			List<BicyclePointVO> bicyclePointList = bicyclePointService.selectAllPage(pm.getPageRowResult().getRowStartNumber(),
					pm.getPageRowResult().getRowEndNumber());

			HttpSession session = req.getSession();
			session.setAttribute("bicyclePoints", bicyclePointList);
			req.setAttribute("pageGroupResult", pm.getpageGroupResult(PageSQL.BICYCLE_POINT_SELETE_ALL_COUNT));

			RequestDispatcher rd = req.getRequestDispatcher("/jsp/bicyclePoint/bicyclePointList.jsp");
			rd.forward(req, resp);
			
		}else if(action.equals("mapMainView.do")) {// 대여소 지도 이동

			RequestDispatcher rd = req.getRequestDispatcher("/jsp/bicyclePoint/test02.jsp");
			rd.forward(req, resp);
			
		} 

	}
}
