package learning.example.com.studentdetails;

/**
 * Created by rishav on 27/8/17.
 */

public class ExamDetails {
    private String examname;
    private String studid;
    private String sem;
    private String marks;
    private String duration;
    private String examdate;

    public ExamDetails(String examname, String studid, String sem, String marks, String duration, String examdate) {
        this.examname = examname;
        this.studid = studid;
        this.sem = sem;
        this.marks = marks;
        this.duration = duration;
        this.examdate = examdate;
    }

    public String getExamname() {
        return examname;
    }

    public String getStudid() {
        return studid;
    }

    public String getSem() {
        return sem;
    }

    public String getMarks() {
        return marks;
    }

    public String getDuration() {
        return duration;
    }

    public String getExamdate() {
        return examdate;
    }
}
