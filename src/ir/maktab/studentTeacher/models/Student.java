package ir.maktab.studentTeacher.models;

public class Student
{
    private int id;
    private int superviserId;
    private String name;
    private String dept;

    public int getId()
    {
        return id;
    }

    public int getSuperviserId()
    {
        return superviserId;
    }

    public String getName()
    {
        return name;
    }

    public String getDept()
    {
        return dept;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setSuperviserId(int superviserId)
    {
        this.superviserId = superviserId;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDept(String dept)
    {
        this.dept = dept;
    }
}
