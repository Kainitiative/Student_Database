package learning.example.com.studentdetails;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class StudentLogin extends AppCompatActivity {

    public static String stud_roll_no;
    public static String stud_stream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }

    public void studentLoginClick(View view) {
        String roll=((EditText)findViewById(R.id.stud_login_roll)).getText().toString();
        String pass=((EditText)findViewById(R.id.stud_login_pass)).getText().toString();
        if(roll.isEmpty()){
            Toast.makeText(getApplicationContext(),"Roll Number field is Empty",Toast.LENGTH_SHORT).show();
        }
        else {
            if(pass.isEmpty()){
                Toast.makeText(getApplicationContext(),"Password field is Empty",Toast.LENGTH_SHORT).show();
            }
            else {
                DatabaseCreation db=new DatabaseCreation(getApplicationContext());
                StudentPersonalDetails stud=db.getStudentDetails(roll);
                String genpass=stud.getPhone().substring(0,3);
                if(genpass.compareTo(pass)==0) {
                    stud_roll_no=roll;
                    stud_stream=stud.getStream();
                    MainActivity.editPref.putString("login","student");
                    MainActivity.editPref.commit();
                    startActivity(new Intent(getApplicationContext(), StudentDrawer.class));
                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Renter the password",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
