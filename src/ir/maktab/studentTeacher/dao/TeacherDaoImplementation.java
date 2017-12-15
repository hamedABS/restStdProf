package ir.maktab.studentTeacher.dao;

import ir.maktab.studentTeacher.models.Teacher;
import org.junit.Test;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class TeacherDaoImplementation extends Dao implements TeacherDao
{
    Dao dao = new Dao();

    public void add(Teacher teacher)
    {
        String sql = "insert into prof(name,address) values('" + teacher.getName() + "', '" + teacher.getAddress() + "')";
        executeUpdate(sql);
        close();
    }

    public void delete(int id)
    {
        String sql = "DELETE FROM prof WHERE id='" + id + "'";
        executeUpdate(sql);
        close();
    }

    public Teacher load(int id)
    {
        String sql = "select * from prof where id='" + id + "'";
        Teacher teacher = new Teacher();

        try
        {
            ResultSet rs = executeQuery(sql);
            while (rs.next())
            {
                teacher.setId(rs.getInt("id"));
                teacher.setName(rs.getString("name"));
                teacher.setAddress(rs.getString("address"));
            }
            rs.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            close();
            return teacher;
        }
    }

    public ArrayList<Teacher> getAll()
    {
        String sql = "SELECT * FROM prof";
        ArrayList<Teacher> teachers = new ArrayList<>();

        try
        {
            ResultSet resultSet = executeQuery(sql);
            while (resultSet.next())
            {
                Teacher teacher = new Teacher();
                teacher.setId(resultSet.getInt("id"));
                teacher.setName(resultSet.getString("name"));
                teacher.setAddress(resultSet.getString("address"));
                teachers.add(teacher);
            }
            resultSet.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return teachers;
    }
    @Test
    public void test()
    {
        ArrayList<Teacher>teachers= getAll();
        for (Teacher te : teachers)
        {
            System.out.println(te.getId());
        }

    }

    public boolean edit(int formerId, int id, String name, String address)
    {
        boolean flag = false;
        try
        {
            if (executeQuery("select * from prof where id='" + formerId + "' ").next() == false)
            {
                return false;
            } else
            {
                String sql = "update prof set id='" + id + "' ,  name='" + name + "' , address='" + address + "'" +
                        " where id='" + formerId + "'";

                dao.executeUpdate(sql);
                flag = true;
            }

        } finally
        {
            return flag;
        }
    }

    public void deleteAll()
    {
        String sql = "DELETE FROM prof ";
        dao.executeUpdate(sql);
        dao.close();
    }

}
