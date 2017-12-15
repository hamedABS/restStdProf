package ir.maktab.studentTeacher.dao;

import ir.maktab.studentTeacher.models.Student;
import java.util.ArrayList;

public interface StudentDao
{
    void add(Student student);
    boolean delete(int id);
    Student load(int id) ;
    ArrayList getAll();
    boolean edit(int formerId,int id ,String editedName , String dept , int spId);
    void deleteAll();
}
