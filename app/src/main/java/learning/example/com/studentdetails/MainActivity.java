package learning.example.com.studentdetails;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static String prefName="StudentDBMS";
    public static SharedPreferences pref;
    public static SharedPreferences.Editor editPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref=getSharedPreferences(prefName,MODE_PRIVATE);
        editPref=pref.edit();
        if(pref.getString("login", "").compareTo("admin")==0){
            startActivity(new Intent(getApplicationContext(),AdminDrawer.class));
            finish();
        }
        if(pref.getString("login", "").compareTo("student")==0){
            editPref.putString("login","");
            editPref.commit();
    }
        DatabaseCreation db=new DatabaseCreation(getApplicationContext());
        //db.onUpgrade(db.getReadableDatabase(),1,2);
        db.onCreate(db.getWritableDatabase());
    }

    public void studentLogin(View view) {
        startActivity(new Intent(getApplicationContext(),StudentLogin.class));
        finish();
    }

    public void adminLogin(View view) {
        startActivity(new Intent(getApplicationContext(),AdminLogin.class));
        finish();
    }
}
