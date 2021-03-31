package record.student;

import portalcredentialscreator.PortalCredentialCreator;
import record.password.Password;
import record.username.UserName;
import subjectandsubjectcode.Subject;
import subjectandsubjectcode.SubjectCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: record.student
 * Project Name: OnlineAssessmentStudentPortal
 * Date: 28-03-2021
 */

public class Student implements Comparable<Student> {
    private String name;
    private int classRollNumber;
    private long universityRollNumber;
    private char section;
    private int currentYear;
    private String course;
    private UserName userName;
    private Password password;
    private Map<SubjectCode, Subject> subjectList;

    public Student() {
    }

    public Student(String name, byte classRollNumber, long universityRollNumber,
                   char section, byte currentYear, String course) {
        this.name = name;
        this.classRollNumber = classRollNumber;
        this.universityRollNumber = universityRollNumber;
        this.section = section;
        this.currentYear = currentYear;
        this.course = course;
        this.subjectList = new HashMap<SubjectCode, Subject>();
        this.userName = new UserName(PortalCredentialCreator.createUserNameForStudent(this));
        this.password = new Password(PortalCredentialCreator.createPassword());
    }

    public String getName() {
        return name;
    }

    public int getClassRollNumber() {
        return classRollNumber;
    }

    public void setClassRollNumber(byte classRollNumber) {
        this.classRollNumber = classRollNumber;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public long getUniversityRollNumber() {
        return universityRollNumber;
    }

    public char getSection() {
        return section;
    }

    public void setSection(char section) {
        this.section = section;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public Map<SubjectCode, Subject> getSubjectList() {
        return subjectList;
    }

    public void addNewSubject(SubjectCode subjectCode, Subject subject) {
        subjectList.put(subjectCode, subject);
    }

    @Override
    public int compareTo(Student o) {
        return Long.compare(this.getUniversityRollNumber(), o.getUniversityRollNumber());
    }
}
