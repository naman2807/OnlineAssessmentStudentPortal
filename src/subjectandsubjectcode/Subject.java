package subjectandsubjectcode;

import java.util.Objects;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: subjectandsubjectcode
 * Project Name: OnlineAssessmentStudentPortal
 * Date: 28-03-2021
 */

public class Subject {
    private final String subjectName;

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "i=" +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(subjectName, subject.subjectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectName);
    }

    /**
     * @return subject name
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * @param prefix
     * @return subject code
     */
    public SubjectCode getSubjectCode(String prefix) {
        return new SubjectCode(subjectName, prefix);
    }
}
