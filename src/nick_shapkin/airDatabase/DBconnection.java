package nick_shapkin.airDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBconnection {

        public static void main(String[] args)
        {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


            Connection connection = null;
            ResultSet resultSet = null;
            Statement statement = null;

            try
            {
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection("jdbc:sqlite:D:\\DataBase\\airplane2\\airplane2.db");
                statement = connection.createStatement();
                resultSet = statement
                        .executeQuery("SELECT * FROM Departure");
                while (resultSet.next())
                {
                    System.out.println("Departure:"
                            + resultSet.getString("route_id"));
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                try
                {
                    resultSet.close();
                    statement.close();
                    connection.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
