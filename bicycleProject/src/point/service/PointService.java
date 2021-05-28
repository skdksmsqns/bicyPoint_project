package point.service;

import java.util.List;

public interface PointService {

	List<PointVO> selectAllPointList();

	PointVO selectByPointId(int id);

	boolean deletePoint(int id);
	
	List<PointVO> selectAllPage(int rowStartNumber, int rowEndNumber);
}
