package ir.maktab.studentTeacher.cli;

import ir.maktab.studentTeacher.dao.StudentDao;
import ir.maktab.studentTeacher.dao.StudentDaoImplementation;
import ir.maktab.studentTeacher.dao.TeacherDao;
import ir.maktab.studentTeacher.dao.TeacherDaoImplementation;
import ir.maktab.studentTeacher.models.Student;
import ir.maktab.studentTeacher.models.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CLI
{
     StudentDao studentDao = new StudentDaoImplementation();
    TeacherDao teacherDao = new TeacherDaoImplementation();
    Scanner scanner = new Scanner(System.in);

}
