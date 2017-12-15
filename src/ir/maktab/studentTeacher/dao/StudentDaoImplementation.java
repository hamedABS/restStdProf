package ir.maktab.studentTeacher.dao;

import com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import ir.maktab.studentTeacher.models.Student;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class StudentDaoImplementation extends Dao implements StudentDao
{

    @Override
    public void add(Student student)
    {
        String sql = "INSERT into student (name,dept,superviser_id) VALUES" +
                "('" + student.getName() + "','" + student.getDept() + "','" + student.getSuperviserId() + "' )";
        executeUpdate(sql);
        close();
    }

    public boolean delete(int id)
    {
        boolean flag = false;
        try
        {
            if (executeQuery("select * from student where id='" + id + "'").next() == false)
            {
                return false;
            } else
            {
                String sql = "DELETE FROM student WHERE id='" + id + "'";
                // String sql2 =String.format( "DELETE FROM student WHERE name='%s'",name) ;
                executeUpdate(sql);
                flag = true;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            close();
            return flag;
        }

    }

    public Student load(int id)
    {
        String sql = "select * from student where id='" + id + "'";
        Student student = new Student();
        try
        {
            ResultSet rs = executeQuery(sql);
            while (rs.next())
            {
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setDept(rs.getString("dept"));
                student.setSuperviserId(rs.getInt("superviser_id"));
            }
            rs.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            close();
            return student;
        }

    }

    public ArrayList<Student> getAll()
    {
        String sql = "SELECT * FROM student";
        ArrayList<Student> students = new ArrayList<>();

        try
        {
            ResultSet resultSet = executeQuery(sql);

                while (resultSet.next())
                {
                    Student student = new Student();
                    student.setId(resultSet.getInt("id"));
                    student.setName(resultSet.getString("name"));
                    student.setDept(resultSet.getString("dept"));
                    student.setSuperviserId(resultSet.getInt("superviser_id"));
                    students.add(student);
                }
            resultSet.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return students;
    }

    public boolean edit(int formerId, int id, String name, String dept, int spId)
    {
        boolean flag = false;
        try
        {
            if (executeQuery("select * from student where id='" + formerId + "' ").next() == false)
            {
                return false;
            } else
            {
                String sql = "update student set id='" + id + "' ,  name='" + name + "' , dept='" + dept + "'" +
                        ", superviser_id='" + spId + "' where id='" + formerId + "'";

                executeUpdate(sql);
                flag = true;
            }

        } finally
        {
            close();
            return flag;
        }
    }

    @Override
    public void deleteAll()
    {
        String sql = "DELETE FROM student";
        executeUpdate(sql);
    }

}
