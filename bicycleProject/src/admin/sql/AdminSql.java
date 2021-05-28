package admin.sql;

public class AdminSql {
	public static final String ADMIN_LOGIN_SQL =
			"SELECT adminsn,adminid,adminpassword,adminname,admingender FROM admin_tb WHERE adminID = ?"; 
}
