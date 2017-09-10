package learning.example.com.studentdetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class StudentDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        studentPersonal();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            drawer.openDrawer(GravityCompat.START);
            Toast.makeText(getApplicationContext(),"Please Logout",Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        ((LinearLayout)findViewById(R.id.stud_table_view)).removeAllViews();
        if(id==R.id.stud_personal) {
            studentPersonal();
        }
        if(id==R.id.stud_academic){
            academicDetails();
        }
        if(id==R.id.stud_exam){
            examDetails();
        }
        if(id==R.id.stud_announce){
            announceDetails();
        }
        if(id==R.id.stud_logout){
            MainActivity.editPref.putString("login","");
            MainActivity.editPref.commit();
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void studentPersonal(){
        StudentPersonalDetails stud;
        DatabaseCreation db=new DatabaseCreation(getApplicationContext());
        stud=db.getStudentDetails(StudentLogin.stud_roll_no);
        LinearLayout sc=(LinearLayout) findViewById(R.id.stud_table_view);
        sc.removeAllViews();
        LinearLayout.LayoutParams llparams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,5f);
        LinearLayout ll=new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.setLayoutParams(llparams);
        TextView tw=new TextView(this);
        LinearLayout.LayoutParams llview=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,1f);
        tw.setText("Roll");
        tw.setTextSize(18f);
        tw.setPadding(5,5,5,5);
        tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tw.setLayoutParams(llview);
        ll.addView(tw);
        tw=new TextView(this);
        tw.setText("Name");
        tw.setTextSize(18f);
        tw.setPadding(5,5,5,5);
        tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tw.setLayoutParams(llview);
        ll.addView(tw);
        tw=new TextView(this);
        tw.setText("Stream");
        tw.setTextSize(18f);
        tw.setPadding(5,5,5,5);
        tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tw.setLayoutParams(llview);
        ll.addView(tw);
        tw=new TextView(this);
        tw.setText("Phone Number");
        tw.setTextSize(18f);
        tw.setPadding(5,5,5,5);
        tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tw.setLayoutParams(llview);
        ll.addView(tw);
        tw=new TextView(this);
        tw.setText("Address");
        tw.setTextSize(18f);
        tw.setPadding(5,5,5,5);
        tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tw.setLayoutParams(llview);
        ll.addView(tw);
        sc.addView(ll);
        ll=new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.setLayoutParams(llparams);
        tw=new TextView(this);
        tw.setText(stud.getRoll());
        tw.setTextSize(12f);
        tw.setPadding(5,5,5,5);
        tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tw.setLayoutParams(llview);
        ll.addView(tw);
        tw=new TextView(this);
        tw.setText(stud.getName());
        tw.setTextSize(12f);
        tw.setPadding(5,5,5,5);
        tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tw.setLayoutParams(llview);
        ll.addView(tw);
        tw=new TextView(this);
        tw.setText(stud.getStream());
        tw.setTextSize(12f);
        tw.setPadding(5,5,5,5);
        tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tw.setLayoutParams(llview);
        ll.addView(tw);
        tw=new TextView(this);
        tw.setText(stud.getPhone());
        tw.setTextSize(12f);
        tw.setPadding(5,5,5,5);
        tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tw.setLayoutParams(llview);
        ll.addView(tw);
        tw=new TextView(this);
        tw.setText(stud.getAddress());
        tw.setTextSize(12f);
        tw.setPadding(5,5,5,5);
        tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tw.setLayoutParams(llview);
        ll.addView(tw);
        sc.addView(ll);
    }

    public void academicDetails(){
        ArrayList<AcademicDetails> acad;
        DatabaseCreation db=new DatabaseCreation(getApplicationContext());
        acad=db.getAcademicResults(StudentLogin.stud_stream);
        LinearLayout sc=(LinearLayout) findViewById(R.id.stud_table_view);
        sc.removeAllViews();
        LinearLayout.LayoutParams llparams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,6f);
        LinearLayout ll=new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.setLayoutParams(llparams);
        TextView tw=new TextView(this);
        LinearLayout.LayoutParams llview=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,1f);
        tw.setText("Course");
        tw.setTextSize(18f);
        tw.setPadding(5,5,5,5);
        tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tw.setLayoutParams(llview);
        ll.addView(tw);
        tw=new TextView(this);
        tw.setText("Institute");
        tw.setTextSize(18f);
        tw.setPadding(5,5,5,5);
        tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tw.setLayoutParams(llview);
        ll.addView(tw);
        tw=new TextView(this);
        tw.setText("Stream");
        tw.setTextSize(18f);
        tw.setPadding(5,5,5,5);
        tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tw.setLayoutParams(llview);
        ll.addView(tw);
        tw=new TextView(this);
        tw.setText("Board Name");
        tw.setTextSize(18f);
        tw.setPadding(5,5,5,5);
        tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tw.setLayoutParams(llview);
        ll.addView(tw);
        tw=new TextView(this);
        tw.setText("Percentage");
        tw.setTextSize(18f);
        tw.setPadding(5,5,5,5);
        tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tw.setLayoutParams(llview);
        ll.addView(tw);
        tw=new TextView(this);
        tw.setText("Passing Year");
        tw.setTextSize(18f);
        tw.setPadding(5,5,5,5);
        tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tw.setLayoutParams(llview);
        ll.addView(tw);
        sc.addView(ll);
        for(AcademicDetails s:acad){
            ll=new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);
            ll.setLayoutParams(llparams);
            tw=new TextView(this);
            tw.setText(s.getCourse());
            tw.setTextSize(12f);
            tw.setPadding(5,5,5,5);
            tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tw.setLayoutParams(llview);
            ll.addView(tw);
            tw=new TextView(this);
            tw.setText(s.getInstname());
            tw.setTextSize(12f);
            tw.setPadding(5,5,5,5);
            tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tw.setLayoutParams(llview);
            ll.addView(tw);
            tw=new TextView(this);
            tw.setText(s.getStream());
            tw.setTextSize(12f);
            tw.setPadding(5,5,5,5);
            tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tw.setLayoutParams(llview);
            ll.addView(tw);
            tw=new TextView(this);
            tw.setText(s.getBoardname());
            tw.setTextSize(12f);
            tw.setPadding(5,5,5,5);
            tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tw.setLayoutParams(llview);
            ll.addView(tw);
            tw=new TextView(this);
            tw.setText(s.getPercentage());
            tw.setTextSize(12f);
            tw.setPadding(5,5,5,5);
            tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tw.setLayoutParams(llview);
            ll.addView(tw);
            tw=new TextView(this);
            tw.setText(s.getYearofpass());
            tw.setTextSize(12f);
            tw.setPadding(5,5,5,5);
            tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tw.setLayoutParams(llview);
            ll.addView(tw);
            sc.addView(ll);
        }
    }

    public void examDetails(){
        ArrayList<ExamDetails> exam;
        DatabaseCreation db=new DatabaseCreation(getApplicationContext());
        exam=db.getExamDetails();
        LinearLayout sc=(LinearLayout) findViewById(R.id.stud_table_view);
        sc.removeAllViews();
        LinearLayout.LayoutParams llparams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,6f);
        LinearLayout ll=new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.setLayoutParams(llparams);
        TextView tw=new TextView(this);
        LinearLayout.LayoutParams llview=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,1f);
        tw.setText("Exam Name");
        tw.setTextSize(18f);
        tw.setPadding(5,5,5,5);
        tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tw.setLayoutParams(llview);
        ll.addView(tw);
        tw=new TextView(this);
        tw.setText("Stud ID");
        tw.setTextSize(18f);
        tw.setPadding(5,5,5,5);
        tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tw.setLayoutParams(llview);
        ll.addView(tw);
        tw=new TextView(this);
        tw.setText("Semester");
        tw.setTextSize(18f);
        tw.setPadding(5,5,5,5);
        tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tw.setLayoutParams(llview);
        ll.addView(tw);
        tw=new TextView(this);
        tw.setText("Marks");
        tw.setTextSize(18f);
        tw.setPadding(5,5,5,5);
        tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tw.setLayoutParams(llview);
        ll.addView(tw);
        tw=new TextView(this);
        tw.setText("Duration");
        tw.setTextSize(18f);
        tw.setPadding(5,5,5,5);
        tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tw.setLayoutParams(llview);
        ll.addView(tw);
        tw=new TextView(this);
        tw.setText("Exam Date");
        tw.setTextSize(18f);
        tw.setPadding(5,5,5,5);
        tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tw.setLayoutParams(llview);
        ll.addView(tw);
        sc.addView(ll);
        for(ExamDetails s:exam){
            ll=new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);
            ll.setLayoutParams(llparams);
            tw=new TextView(this);
            tw.setText(s.getExamname());
            tw.setTextSize(12f);
            tw.setPadding(5,5,5,5);
            tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tw.setLayoutParams(llview);
            ll.addView(tw);
            tw=new TextView(this);
            tw.setText(s.getStudid());
            tw.setTextSize(12f);
            tw.setPadding(5,5,5,5);
            tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tw.setLayoutParams(llview);
            ll.addView(tw);
            tw=new TextView(this);
            tw.setText(s.getSem());
            tw.setTextSize(12f);
            tw.setPadding(5,5,5,5);
            tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tw.setLayoutParams(llview);
            ll.addView(tw);
            tw=new TextView(this);
            tw.setText(s.getMarks());
            tw.setTextSize(12f);
            tw.setPadding(5,5,5,5);
            tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tw.setLayoutParams(llview);
            ll.addView(tw);
            tw=new TextView(this);
            tw.setText(s.getDuration());
            tw.setTextSize(12f);
            tw.setPadding(5,5,5,5);
            tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tw.setLayoutParams(llview);
            ll.addView(tw);
            tw=new TextView(this);
            tw.setText(s.getExamdate());
            tw.setTextSize(12f);
            tw.setPadding(5,5,5,5);
            tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tw.setLayoutParams(llview);
            ll.addView(tw);
            sc.addView(ll);
        }
    }

    public void announceDetails(){
        ArrayList<AnnounceDetails> announce;
        DatabaseCreation db=new DatabaseCreation(getApplicationContext());
        announce=db.getAnnounceDetails();
        LinearLayout sc=(LinearLayout) findViewById(R.id.stud_table_view);
        sc.removeAllViews();
        LinearLayout.LayoutParams llparams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,6f);
        LinearLayout ll=new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.setLayoutParams(llparams);
        TextView tw=new TextView(this);
        LinearLayout.LayoutParams llview=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,1f);
        tw.setText("Title");
        tw.setTextSize(18f);
        tw.setPadding(5,5,5,5);
        tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tw.setLayoutParams(llview);
        ll.addView(tw);
        tw=new TextView(this);
        tw.setText("Date");
        tw.setTextSize(18f);
        tw.setPadding(5,5,5,5);
        tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tw.setLayoutParams(llview);
        ll.addView(tw);
        tw=new TextView(this);
        tw.setText("Date of Expiry");
        tw.setTextSize(18f);
        tw.setPadding(5,5,5,5);
        tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tw.setLayoutParams(llview);
        ll.addView(tw);
        tw=new TextView(this);
        tw.setText("Details");
        tw.setTextSize(18f);
        tw.setPadding(5,5,5,5);
        tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tw.setLayoutParams(llview);
        ll.addView(tw);
        sc.addView(ll);
        for(AnnounceDetails s:announce){
            ll=new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);
            ll.setLayoutParams(llparams);
            tw=new TextView(this);
            tw.setText(s.getTitle());
            tw.setTextSize(12f);
            tw.setPadding(5,5,5,5);
            tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tw.setLayoutParams(llview);
            ll.addView(tw);
            tw=new TextView(this);
            tw.setText(s.getDate());
            tw.setTextSize(12f);
            tw.setPadding(5,5,5,5);
            tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tw.setLayoutParams(llview);
            ll.addView(tw);
            tw=new TextView(this);
            tw.setText(s.getDof());
            tw.setTextSize(12f);
            tw.setPadding(5,5,5,5);
            tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tw.setLayoutParams(llview);
            ll.addView(tw);
            tw=new TextView(this);
            tw.setText(s.getDetails());
            tw.setTextSize(12f);
            tw.setPadding(5,5,5,5);
            tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tw.setLayoutParams(llview);
            ll.addView(tw);
            sc.addView(ll);
        }
    }
}
