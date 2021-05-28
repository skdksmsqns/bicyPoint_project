package bicycle.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bicyPoint.sql.BicyclePointSql;
import bicycle.service.BicycleService;
import bicycle.service.BicycleVO;
import bicycle.sql.BicycleSql;

public class BicycleServiceImpl extends BaseDAO implements BicycleService {

	public List<BicycleVO> selectAllBicycleList() {

		List<BicycleVO> bicycleList = new ArrayList<BicycleVO>();
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(BicycleSql.BICYCLE_SELECT_ALL_SQL);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				BicycleVO bicycleVO = new BicycleVO();
				bicycleVO.setBicycleNum(resultSet.getString("bicycle_num"));
				bicycleVO.setBicycleAddr(resultSet.getString("bicycle_addr"));
				bicycleVO.setBicycleTel(resultSet.getString("bicycle_tel"));

				bicycleList.add(bicycleVO);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			closeDBObject(resultSet, preparedStatement, connection);
		}

		return bicycleList;

	}

	@Override
	public BicycleVO selectByBicycleNum(String bicycleNum) {

		BicycleVO bicycleVO = new BicycleVO();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(BicycleSql.BICYCLE_SELECT_BY_BICYCLE_NUM_SQL);
			preparedStatement.setString(1, bicycleNum);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				bicycleVO.setBicycleNum(resultSet.getString("bicycle_num"));
				bicycleVO.setBicycleAddr(resultSet.getString("bicycle_addr"));
				bicycleVO.setBicycleTel(resultSet.getString("bicycle_tel"));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			closeDBObject(resultSet, preparedStatement, connection);
		}
		return bicycleVO;
	}

	@Override
	public boolean insertBicycle(BicycleVO bicycleVO) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(BicycleSql.BICYCLE_INSERT_SQL);

			preparedStatement.setString(1, bicycleVO.getBicycleAddr());
			preparedStatement.setString(2, bicycleVO.getBicycleTel());

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
	public boolean updateBicycle(BicycleVO bicycleVO) {

		boolean result = false;

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(BicycleSql.BICYCLE_UPDATE_SQL);

			preparedStatement.setString(1, bicycleVO.getBicycleAddr());
			preparedStatement.setString(2, bicycleVO.getBicycleTel());
			preparedStatement.setString(3, bicycleVO.getBicycleNum());

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
	public boolean deleteBicycle(String bicycleNum) {

		boolean result = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(BicycleSql.BICYCLE_DELETE_SQL);
			preparedStatement.setString(1, bicycleNum);

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
	public List<BicycleVO> selectAllPage(int rowStartNumber, int rowEndNumber) {

		List<BicycleVO> bicyclelist = new ArrayList<BicycleVO>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(BicycleSql.BICYCLE_SELECT_ALL_PAGE_SQL);

			preparedStatement.setInt(1, rowStartNumber);
			preparedStatement.setInt(2, rowEndNumber);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				BicycleVO bicycleVO = new BicycleVO();

				bicycleVO.setBicycleNum(resultSet.getString("bicycle_num"));
				bicycleVO.setBicycleAddr(resultSet.getString("bicycle_addr"));
				bicycleVO.setBicycleTel(resultSet.getString("bicycle_tel"));
				
				bicyclelist.add(bicycleVO);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			closeDBObject(resultSet, preparedStatement, connection);
		}

		return bicyclelist;

	}

}
