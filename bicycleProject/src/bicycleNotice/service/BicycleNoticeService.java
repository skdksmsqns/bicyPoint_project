package bicycleNotice.service;

import java.util.List;



public interface BicycleNoticeService {
	
	List<BicycleNoticeVO> selectAll();
	BicycleNoticeVO selectByNo(int nt_num);
	
	void bicyclentinsert(BicycleNoticeVO bicyclent);
	boolean bicyclentupdate(BicycleNoticeVO bicyclent);
	boolean bicyclentdelete(int nt_num);
	
	//void bookinsert(BicycleNoticeVO bicyclent);


}
