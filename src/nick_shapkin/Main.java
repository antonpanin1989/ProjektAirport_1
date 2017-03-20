package nick_shapkin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet res = null;

        try {
            Driver driver = (Driver) Class.forName("org.sqlite.JDBC").newInstance();
            String url = "jdbc:sqlight:d:\\DataBase\\airplane2\\airplane2.db";
            con = DriverManager.getConnection(url);

            String sql1 = "SELECT * from Departure dp";
            stmt = con.createStatement();
            res = stmt.executeQuery(sql1);

            while (res.next()) {
                System.out.println(res.getString("time_Dept" + res.getObject("rout_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (res != null) res.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}



