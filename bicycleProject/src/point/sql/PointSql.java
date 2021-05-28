package point.sql;

public class PointSql {
	
		// 포인트 리스트 
		public static final String POINT_SELECT_ALL_SQL
			= "SELECT id,ST_AsText(geom) geom,st_x(geom) x_geom,st_y(geom) y_geom,ctv_nam FROM chwi_point ORDER BY id asc";
		
		// 포인트 아이디 선택 상세보기
		public static final String POINT_SELECT_BY_BICYCLE_ID_SQL 
			= "SELECT id,st_x(geom) x_geom,st_y(geom) y_geom,ctv_nam FROM chwi_point WHERE id = ?";
		
		// 포인트  정보 삭제
		public static final String  POINT_DELETE_SQL 
			= "DELETE FROM chwi_point WHERE id = ?";
		
		// 포인트 페이지네이션
		public static final String POINT_SELECT_ALL_PAGE_SQL
			=" SELECT id,ST_AsText(geom) geom,ctv_nam FROM (SELECT ROW_NUMBER() OVER (ORDER BY id) AS RN, * FROM chwi_point ) T WHERE rn BETWEEN ? and ?" ; 
				
}
