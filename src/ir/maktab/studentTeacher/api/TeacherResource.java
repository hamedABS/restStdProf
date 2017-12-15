package ir.maktab.studentTeacher.api;
import ir.maktab.studentTeacher.dao.TeacherDao;
import ir.maktab.studentTeacher.dao.TeacherDaoImplementation;
import ir.maktab.studentTeacher.models.Student;
import ir.maktab.studentTeacher.models.Teacher;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("prof")
public class TeacherResource
{
    TeacherDao teacherDao=new TeacherDaoImplementation();
    @Path("add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void add(Teacher teacher)
    {
        teacherDao.add(teacher);
    }

    @Path("deleteAll")
    @POST
    public void deleteAll()
    {
        teacherDao.deleteAll();
    }

    @Path("deleteById")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(Student user)
    {
        teacherDao.delete(user.getId());
    }

    @Path("load/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Teacher load(@PathParam("id") int id)
    {
            return teacherDao.load(id);
    }

    @Path("loadAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Teacher> loadAll()
    {
        return teacherDao.getAll();
    }

}
