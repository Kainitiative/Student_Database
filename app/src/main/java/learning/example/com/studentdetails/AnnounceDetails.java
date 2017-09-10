package learning.example.com.studentdetails;

/**
 * Created by rishav on 27/8/17.
 */

public class AnnounceDetails {
    private String title,date,dof,details;

    public AnnounceDetails(String title, String date, String details,String dof) {
        this.title = title;
        this.date = date;
        this.dof = dof;
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getDof() {
        return dof;
    }

    public String getDetails() {
        return details;
    }
}
