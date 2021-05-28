package bicyPoint.service.impl;

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

public class BicyclePointServiceImpl extends BaseDAO implements BicyclePointService {

	public List<BicyclePointVO> selectAllBicyclePointList() {

		List<BicyclePointVO> bicyclePointList = new ArrayList<BicyclePointVO>();
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(BicyclePointSql.BICYCLE_POINT_SELECT_ALL_SQL);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				BicyclePointVO bicyclePointVO = new BicyclePointVO();
				bicyclePointVO.setId(resultSet.getInt("id"));
				bicyclePointVO.setGeom(resultSet.getString("geom"));
				bicyclePointVO.setNew_nam(resultSet.getString("new_nam"));
				bicyclePointList.add(bicyclePointVO);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			closeDBObject(resultSet, preparedStatement, connection);
		}

		return bicyclePointList;

	}

	@Override
	public BicyclePointVO selectByBicyclePointId(int id) {

		BicyclePointVO bicyclePointVO = new BicyclePointVO();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(BicyclePointSql.BICYCLE_POINT_SELECT_BY_BICYCLE_ID_SQL);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				bicyclePointVO.setId(resultSet.getInt("id"));
				bicyclePointVO.setGeom(resultSet.getString("geom"));
				bicyclePointVO.setNew_nam(resultSet.getString("new_nam"));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			closeDBObject(resultSet, preparedStatement, connection);
		}
		return bicyclePointVO;
	}

	@Override
	public boolean deleteBicyclePoint(int id) {

		boolean result = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(BicyclePointSql.BICYCLE_POINT_DELETE_SQL);
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
	public List<BicyclePointVO> selectAllPage(int rowStartNumber, int rowEndNumber) {

		List<BicyclePointVO> bicyclePointlist = new ArrayList<BicyclePointVO>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(BicyclePointSql.BICYCLE_POINT_SELECT_ALL_PAGE_SQL);

			preparedStatement.setInt(1, rowStartNumber);
			preparedStatement.setInt(2, rowEndNumber);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				BicyclePointVO bicyclePointVO = new BicyclePointVO();

				bicyclePointVO.setId(resultSet.getInt("id"));
				bicyclePointVO.setGeom(resultSet.getString("geom"));
				bicyclePointVO.setNew_nam(resultSet.getString("new_nam"));

				bicyclePointlist.add(bicyclePointVO);

			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			closeDBObject(resultSet, preparedStatement, connection);
		}

		return bicyclePointlist;

	}

}
