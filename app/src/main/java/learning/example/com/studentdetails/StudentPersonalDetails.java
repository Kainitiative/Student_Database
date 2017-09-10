package learning.example.com.studentdetails;

/**
 * Created by rishav on 27/8/17.
 */

public class StudentPersonalDetails {
    private String roll;
    private String name;
    private String stream;
    private String phone;
    private String address;
    public StudentPersonalDetails(String r,String n,String s,String p,String add){
        this.roll=r;
        this.name=n;
        this.stream=s;
        this.phone=p;
        this.address=add;
    }

    public String getRoll() {
        return roll;
    }

    public String getName() {
        return name;
    }

    public String getStream() {
        return stream;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}
