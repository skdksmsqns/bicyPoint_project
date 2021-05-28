package point.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bicyPoint.service.BicyclePointService;
import bicyPoint.service.BicyclePointVO;
import bicyPoint.sql.BicyclePointSql;
import bicycle.service.BicycleService;
import bicycle.service.BicycleVO;
import bicycle.sql.BicycleSql;
import point.service.PointService;
import point.service.PointVO;
import point.sql.PointSql;

public class PointServiceImpl extends BaseDAO implements PointService {

	public List<PointVO> selectAllPointList() {

		List<PointVO> PointList = new ArrayList<PointVO>();
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(PointSql.POINT_SELECT_ALL_SQL);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				PointVO pointVO = new PointVO();
				pointVO.setId(resultSet.getInt("id"));
				pointVO.setGeom(resultSet.getString("geom"));
				pointVO.setX_geom(resultSet.getString("x_geom"));
				pointVO.setY_geom(resultSet.getString("y_geom"));
				pointVO.setCtv_nam(resultSet.getString("ctv_nam"));
				PointList.add(pointVO);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			closeDBObject(resultSet, preparedStatement, connection);
		}

		return PointList;

	}

	@Override
	public PointVO selectByPointId(int id) {

		PointVO pointVO = new PointVO();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(PointSql.POINT_SELECT_BY_BICYCLE_ID_SQL);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				pointVO.setId(resultSet.getInt("id"));
				pointVO.setX_geom(resultSet.getString("x_geom"));
				pointVO.setY_geom(resultSet.getString("y_geom"));
				pointVO.setCtv_nam(resultSet.getString("ctv_nam"));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			closeDBObject(resultSet, preparedStatement, connection);
		}
		return pointVO;
	}

	@Override
	public boolean deletePoint(int id) {

		boolean result = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(PointSql.POINT_DELETE_SQL);
			preparedStatement.setInt(1, id);

			int rowCount = preparedStatement.executeUpdate();

			if (rowCount > 0) {

				result = true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			closeDBObject(null, preparedStatement, connection);
		}
		return result;
	}

	@Override
	public List<PointVO> selectAllPage(int rowStartNumber, int rowEndNumber) {
		List<PointVO> PointList = new ArrayList<PointVO>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(PointSql.POINT_SELECT_ALL_PAGE_SQL);

			preparedStatement.setInt(1, rowStartNumber);
			preparedStatement.setInt(2, rowEndNumber);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				PointVO pointVO = new PointVO();

				pointVO.setId(resultSet.getInt("id"));
				pointVO.setGeom(resultSet.getString("geom"));
				pointVO.setCtv_nam(resultSet.getString("ctv_nam"));

				PointList.add(pointVO);

			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			closeDBObject(resultSet, preparedStatement, connection);
		}

		return PointList;

	}

}
