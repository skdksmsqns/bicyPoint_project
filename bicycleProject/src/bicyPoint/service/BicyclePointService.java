package bicyPoint.service;

import java.util.List;

public interface BicyclePointService {

	List<BicyclePointVO> selectAllBicyclePointList();

	BicyclePointVO selectByBicyclePointId(int id);

	//boolean insertBicyclePoint(BicyclePointVO bicyclePointVO);

	//boolean updateBicyclePoint(BicyclePointVO bicyclePointVO);

	boolean deleteBicyclePoint(int id);
	
	List<BicyclePointVO> selectAllPage(int rowStartNumber, int rowEndNumber);
}
