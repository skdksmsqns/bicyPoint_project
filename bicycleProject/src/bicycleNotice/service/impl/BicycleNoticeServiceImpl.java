package bicycleNotice.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bicycleNotice.service.BicycleNoticeService;
import bicycleNotice.service.BicycleNoticeVO;

public class BicycleNoticeServiceImpl extends BaseDAO implements BicycleNoticeService {
	
	public static final String BICYCLENT_SELECT_ALL_SQL = " select nt_num,nt_sj,nt_cn,admin_id from nt_tb order by nt_num asc";
	private static final String BICYCLENT_INSERT_SQL = "insert into nt_tb VALUES(nextval('bicyclent_seq'),?,?,?)";
	private static final String BICYCLENT_SELECT_BY_NO_SQL = "select * from nt_tb where nt_num=?";
	private static final String BICYCLENT_UPDATE_SQL = "update nt_tb set nt_sj=?,nt_cn=? where nt_num =?";
	private static final String BICYCLENT_DELETE_SQL = "delete from nt_tb comments where nt_num=?";


	public List<BicycleNoticeVO> selectAll() {
		List<BicycleNoticeVO> BicycleNoticeVOList = new ArrayList<BicycleNoticeVO>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(BICYCLENT_SELECT_ALL_SQL);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				BicycleNoticeVO bicyclent = new BicycleNoticeVO();
				bicyclent.setNt_num(resultSet.getInt("nt_num"));
				bicyclent.setNt_sj(resultSet.getString("nt_sj"));
				bicyclent.setNt_cn(resultSet.getString("nt_cn"));
				bicyclent.setAdmin_id(resultSet.getString("admin_id"));
				BicycleNoticeVOList.add(bicyclent);
			}

			for (BicycleNoticeVO bicyclent : BicycleNoticeVOList) {
				System.out.println(bicyclent);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			closeDBObject(resultSet, preparedStatement, connection);
		}
		return BicycleNoticeVOList;
	}
	
	public BicycleNoticeVO selectByNo(int nt_num) {

		BicycleNoticeVO bicyclent = new BicycleNoticeVO();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(BICYCLENT_SELECT_BY_NO_SQL);
			preparedStatement.setInt(1, nt_num);
			resultSet=preparedStatement.executeQuery();

			if(resultSet.next()) {

				bicyclent.setNt_num(resultSet.getInt("nt_num"));
				bicyclent.setNt_sj(resultSet.getString("nt_sj"));
				bicyclent.setNt_cn(resultSet.getString("nt_cn"));
				bicyclent.setAdmin_id(resultSet.getString("admin_id"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			closeDBObject(resultSet, preparedStatement, connection);
		}
		return bicyclent;
	}
	
	public void bicyclentinsert(BicycleNoticeVO bicyclent) {
		
		System.out.println("hello");

		//boolean result = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = getConnection();
			
			preparedStatement = connection.prepareStatement(BICYCLENT_INSERT_SQL);
			preparedStatement.setString(1, bicyclent.getNt_sj());
			preparedStatement.setString(2, bicyclent.getNt_cn());
			preparedStatement.setString(3, bicyclent.getAdmin_id());
			

			
			preparedStatement.executeUpdate();


		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			closeDBObject(null, preparedStatement, connection);
		}
		//return result;
	}
	
	@Override
	public boolean bicyclentupdate(BicycleNoticeVO bicyclent) {

		boolean result = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(BICYCLENT_UPDATE_SQL);
			preparedStatement.setString(1, bicyclent.getNt_sj());
			preparedStatement.setString(2, bicyclent.getNt_cn());
			preparedStatement.setInt(3, bicyclent.getNt_num());

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
	
	public boolean bicyclentdelete(int nt_num) {

		boolean result = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(BICYCLENT_DELETE_SQL);
			preparedStatement.setInt(1, nt_num);

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

}
