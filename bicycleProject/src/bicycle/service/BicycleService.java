package bicycle.service;

import java.util.List;

public interface BicycleService {

	List<BicycleVO> selectAllBicycleList();

	BicycleVO selectByBicycleNum(String bicycleNum);

	boolean insertBicycle(BicycleVO bicycleVO);

	boolean updateBicycle(BicycleVO bicycleVO);

	boolean deleteBicycle(String bicycleNum);
	
	List<BicycleVO> selectAllPage(int rowStartNumber, int rowEndNumber);
}
