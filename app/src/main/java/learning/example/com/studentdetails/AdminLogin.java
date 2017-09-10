package learning.example.com.studentdetails;

import android.Manifest;
import android.content.Intent;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }

    public void adminLoginClick(View view) {
        String name=((EditText)findViewById(R.id.admin_name)).getText().toString();
        String pass=((EditText)findViewById(R.id.admin_pass)).getText().toString();
        if(!name.isEmpty()){
            if(!pass.isEmpty()){
                if(name.compareToIgnoreCase("ADMIN")==0 && pass.compareTo("1234")==0){
                    MainActivity.editPref.putString("login","admin");
                    MainActivity.editPref.commit();
                    startActivity(new Intent(getApplicationContext(),AdminDrawer.class));
                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please Check Admin name and Password",Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(getApplicationContext(),"Admin pass is empty",Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(getApplicationContext(),"Admin name is empty",Toast.LENGTH_SHORT).show();
        }
    }
}
