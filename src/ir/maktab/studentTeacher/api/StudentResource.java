package ir.maktab.studentTeacher.api;

import ir.maktab.studentTeacher.dao.StudentDao;
import ir.maktab.studentTeacher.dao.StudentDaoImplementation;
import ir.maktab.studentTeacher.models.Student;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * Created by Hamed-Abbaszadeh on 12/15/2017.
 */
@Path("student")
public class StudentResource
{
    StudentDao studentDao = new StudentDaoImplementation();

    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    public void add(Student student)
    {
        studentDao.add(student);
    }

    @POST
    @Path("deleteAll")
    public void deleteAll()
    {
        studentDao.deleteAll();
    }

    @POST
    @Path("deleteById")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteById(Student student)
    {
        studentDao.delete(student.getId());
    }

    @PUT
    @Path("retrive/{formerId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void retrive(@PathParam("formerId") int id ,Student student )
    {
        studentDao.edit(id, student.getId(),student.getName(),student.getDept(),student.getSuperviserId());
    }

    @GET
    @Path("load/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student load(@PathParam("id") int id)
    {
        return studentDao.load(id);
    }

    @GET
    @Path("loadAll")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Student> loadAll()
    {
        return studentDao.getAll();
    }
}
