package subjectandsubjectcode;

import java.util.Objects;
import java.util.Random;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: subjectandsubjectcode
 * Project Name: OnlineAssessmentStudentPortal
 * Date: 28-03-2021
 */

public class SubjectCode {
    private final String subjectName;
    private final String prefix;

    public SubjectCode(String subjectName, String prefix) {
        this.subjectName = subjectName;
        this.prefix = prefix;
    }

    @Override
    public String toString() {
        return prefix + subjectName + new Random().nextInt(100);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectCode that = (SubjectCode) o;
        return Objects.equals(subjectName, that.subjectName) && Objects.equals(prefix, that.prefix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectName, prefix);
    }
}
