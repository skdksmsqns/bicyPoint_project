package bicycle.sql;

public class BicycleSql {
	
		// 대여소 리스트 
		public static final String BICYCLE_SELECT_ALL_SQL
			= "select bicycle_num,bicycle_addr,bicycle_tel from bicycle_tb order by bicycle_num asc";
		
		// 대여소 넘버 선택 상세보기
		public static final String BICYCLE_SELECT_BY_BICYCLE_NUM_SQL 
			= "select bicycle_num,bicycle_addr,bicycle_tel from bicycle_tb where bicycle_num like ?";
		
		// 대여소 정보 저장
		public static final String BICYCLE_INSERT_SQL 
			= "insert into bicycle_tb (bicycle_num, bicycle_addr, bicycle_tel)\r\n VALUES(to_char(NOW(),'YYYYMMDD')  || lpad(cast(nextval('bicycle_seq') as varchar(12)) , 12, '0'),?, ?)";
		
		// 대여소 정보 수정
		public static final String BICYCLE_UPDATE_SQL 
			= "UPDATE bicycle_tb SET bicycle_addr=?,bicycle_tel=? where bicycle_num like ?";
		
		// 대여소 정보 삭제
		public static final String  BICYCLE_DELETE_SQL 
			= "DELETE FROM bicycle_tb WHERE bicycle_num like ?";
		
		public static final String BICYCLE_SELECT_ALL_PAGE_SQL
			=" SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY bicycle_num) AS RN, * FROM bicycle_tb ) T WHERE rn BETWEEN ? and ?" ; 
				
}
