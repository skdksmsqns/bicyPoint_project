package point.web;

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
import point.service.PointService;
import point.service.PointVO;
import point.service.impl.PointServiceImpl;

@WebServlet(name = "pointController", urlPatterns = 
	{ "/point_list.do","/point_detail.do","/point_delete.do","/point_req_list.do","/point_list_map.do" })
public class PointController extends HttpServlet {

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

		if (action.equals("point_list.do")) {// 리스트

			List<PointVO> pointList = new ArrayList<PointVO>();
			PointService pointService = new PointServiceImpl();

			req.setCharacterEncoding("utf-8");
			pointList = pointService.selectAllPointList();

			req.setAttribute("points", pointList);

			 //RequestDispatcher rd = req.getRequestDispatcher("/jsp/bicyclePoint/bicyclePointList.jsp");
			RequestDispatcher rd = req.getRequestDispatcher("/point_req_list.do?reqPage=1");
			rd.forward(req, resp);

		} else if (action.equals("point_detail.do")) {// 아이디 선택 상세보기
			int id = Integer.parseInt(req.getParameter("id"));

			PointService pointService = new PointServiceImpl();
			PointVO pointVO = pointService.selectByPointId(id);

			req.setAttribute("pointInfo", pointVO);

			RequestDispatcher rd = req.getRequestDispatcher("/jsp/point/pointDetailMap.jsp");
			rd.forward(req, resp);
			
			
			/*
			 * int id = Integer.parseInt(req.getParameter("id"));
			 * 
			 * 
			 * PointService pointService = new PointServiceImpl(); PointVO pointVO =
			 * pointService.selectByPointId(id);
			 * 
			 * req.setAttribute("pointInfo", pointVO);
			 * 
			 * RequestDispatcher rd =
			 * req.getRequestDispatcher("/jsp/point/pointDetail.jsp"); rd.forward(req,
			 * resp);
			 */
			
		} else if (action.equals("point_delete.do")) { // 포인트 정보 삭제

			PointService pointService = new PointServiceImpl();
			PointVO pointVO = new PointVO();
			
			pointVO.setId(Integer.parseInt(req.getParameter("id")));

			pointService.deletePoint(pointVO.getId());

			 RequestDispatcher rd =req.getRequestDispatcher("/point_req_list.do?reqPage=1");
			//RequestDispatcher rd = req.getRequestDispatcher("bicycle_list");
			rd.forward(req, resp);

		} else if (action.equals("point_req_list.do")) {
			int requestPage = Integer.parseInt(req.getParameter("reqPage"));

			PageManager pm = new PageManager(requestPage);

			PointService pointService = new PointServiceImpl();
			List<PointVO> pointList = pointService.selectAllPage(pm.getPageRowResult().getRowStartNumber(),
					pm.getPageRowResult().getRowEndNumber());

			HttpSession session = req.getSession();
			session.setAttribute("points", pointList);
			req.setAttribute("pageGroupResult", pm.getpageGroupResult(PageSQL.POINT_SELETE_ALL_COUNT));

			RequestDispatcher rd = req.getRequestDispatcher("/jsp/point/pointList.jsp");
			rd.forward(req, resp);
			
		}else if(action.equals("point_list_map.do")) {// 리스트

			List<PointVO> pointList = new ArrayList<PointVO>();
			PointService pointService = new PointServiceImpl();

			req.setCharacterEncoding("utf-8");
			pointList = pointService.selectAllPointList();

			req.setAttribute("points", pointList);
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/point/pointListlMap.jsp");
			rd.forward(req, resp);

		}

	}
}
