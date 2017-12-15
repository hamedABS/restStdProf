package ir.maktab.studentTeacher.dao;

import java.sql.*;

/**
 * Created by Hamed-Abbaszadeh on 12/2/2017.
 */
public class Dao
{
    Connection connection=null;
    Statement statement=null;
    ResultSet resultSet=null;
    private String url = "jdbc:mysql://localhost/uni";
    Dao()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
             connection = DriverManager.getConnection(url, "root", "");
             statement = connection.createStatement();
        } catch (InstantiationException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

    }


    public  void executeUpdate(String sql)
    {
        try
        {
            statement.executeUpdate(sql);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public  ResultSet executeQuery(String sql)
    {
        ResultSet rs=null;
        try
        {
            resultSet = statement.executeQuery(sql);
            rs=resultSet;
            return rs;

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            return rs;
        }
    }

    public void close()
    {
        try
        {
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (NullPointerException e)
        {
            System.out.println("oops");
        }

    }
}
