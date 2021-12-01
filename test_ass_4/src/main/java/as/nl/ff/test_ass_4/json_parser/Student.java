package as.nl.ff.test_ass_4.json_parser;


import java.util.Objects;

public class Student {
    private int id;
    private String name = "";
    private float avgGrade;
    private boolean activeStudent;
    private char classCode;

    public Student() {
    }

    public Student(int id, String name, float avgGrade, boolean activeStudent, char classCode) {
        this.id = id;
        this.name = name;
        this.avgGrade = avgGrade;
        this.activeStudent = activeStudent;
        this.classCode = classCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(float avgGrade) {
        this.avgGrade = avgGrade;
    }

    public boolean isActiveStudent() {
        return activeStudent;
    }

    public void setActiveStudent(boolean activeStudent) {
        this.activeStudent = activeStudent;
    }

    public char getClassCode() {
        return classCode;
    }

    public void setClassCode(char classCode) {
        this.classCode = classCode;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", avgGrade=" + avgGrade +
                ", activeStudent=" + activeStudent +
                ", classCode=" + classCode +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Float.compare(student.avgGrade, avgGrade) == 0 && activeStudent == student.activeStudent && classCode == student.classCode && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, avgGrade, activeStudent, classCode);
    }
}
