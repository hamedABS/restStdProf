package ir.maktab.studentTeacher.dao;

import ir.maktab.studentTeacher.models.Teacher;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public interface TeacherDao
{
     void add(Teacher teacher);
     void delete(int id);
     void deleteAll();
     Teacher load(int id);
     ArrayList getAll();
     boolean edit(int formerId,int id ,String editedName , String address);
}
