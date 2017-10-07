package learning.example.com.studentdetails;


public class AcademicDetails {
    private String course;
    private String instname;
    private String stream;
    private String boardname;
    private String percentage;
    private String yearofpass;

    public AcademicDetails(String course,  String stream,String instname, String boardname, String percentage, String yearofpass) {
        this.course = course;
        this.instname = instname;
        this.stream = stream;
        this.boardname = boardname;
        this.percentage = percentage;
        this.yearofpass = yearofpass;
    }

    public String getCourse() {
        return course;
    }

    public String getInstname() {
        return instname;
    }

    public String getStream() {
        return stream;
    }

    public String getBoardname() {
        return boardname;
    }

    public String getPercentage() {
        return percentage;
    }

    public String getYearofpass() {
        return yearofpass;
    }
}
