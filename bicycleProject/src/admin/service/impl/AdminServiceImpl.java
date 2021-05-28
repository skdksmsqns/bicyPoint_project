package admin.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import admin.service.AdminService;
import admin.service.AdminVO;
import admin.sql.AdminSql;
import bicycle.service.impl.BaseDAO;

public class AdminServiceImpl extends BaseDAO implements AdminService {

	//로그인 기능
	@Override
	public AdminVO selectByAdminID(String adminID) {
	
		AdminVO adminVO = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(AdminSql.ADMIN_LOGIN_SQL);
			preparedStatement.setString(1, adminID);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				adminVO = new AdminVO();
				adminVO.setAdminSN(resultSet.getString("adminSN"));
				adminVO.setAdminID(resultSet.getString("adminID"));
				adminVO.setAdminPassword(resultSet.getString("adminPassword"));
				adminVO.setAdminName(resultSet.getString("adminName"));
				adminVO.setAdminGender(resultSet.getString("adminGender"));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			closeDBObject(resultSet, preparedStatement, connection);
		}

		return adminVO;
	}

}
