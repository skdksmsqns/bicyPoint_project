package bicyPoint.sql;

public class BicyclePointSql {
	
		// 포인트 리스트 
		public static final String BICYCLE_POINT_SELECT_ALL_SQL
			= "SELECT id,ST_AsText(geom) geom,new_nam FROM byst_point ORDER BY id ASC";
		
		// 포인트 아이디 선택 상세보기
		public static final String BICYCLE_POINT_SELECT_BY_BICYCLE_ID_SQL 
			= "SELECT id,ST_AsText(geom) geom,new_nam FROM byst_point WHERE id = ?";
		
		// 포인트  정보 삭제
		public static final String  BICYCLE_POINT_DELETE_SQL 
			= "DELETE FROM byst_point WHERE id = ?";
		
		// 포인트 페이지네이션
		public static final String BICYCLE_POINT_SELECT_ALL_PAGE_SQL
			=" SELECT id,ST_AsText(geom) geom,new_nam FROM (SELECT ROW_NUMBER() OVER (ORDER BY id) AS RN, * FROM byst_point ) T WHERE rn BETWEEN ? and ?" ; 
				
}
