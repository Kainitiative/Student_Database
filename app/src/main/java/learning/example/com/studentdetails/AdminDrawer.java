package learning.example.com.studentdetails;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.Layout;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdminDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static int id;
    private static String SearchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        id=R.id.admin_view;
        (findViewById(R.id.edit_search)).setEnabled(false);

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
        id = item.getItemId();
        ((EditText) findViewById(R.id.edit_search)).setText("");
        if(id==R.id.admin_view)
            (findViewById(R.id.edit_search)).setEnabled(false);
        if(id==R.id.admin_insert)
            (findViewById(R.id.edit_search)).setEnabled(false);
        if(id==R.id.admin_update)
            (findViewById(R.id.edit_search)).setEnabled(true);
        if(id==R.id.admin_delete)
            (findViewById(R.id.edit_search)).setEnabled(true);
        if(id==R.id.admin_logout){
            MainActivity.editPref.putString("login","");
            MainActivity.editPref.commit();
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        findViewById(R.id.layout_admin_main).setVisibility(View.VISIBLE);
        findViewById(R.id.layout_student).setVisibility(View.INVISIBLE);
        findViewById(R.id.layout_exam).setVisibility(View.INVISIBLE);
        findViewById(R.id.layout_academic).setVisibility(View.INVISIBLE);
        findViewById(R.id.layout_announce).setVisibility(View.INVISIBLE);
        findViewById(R.id.layout_table).setVisibility(View.INVISIBLE);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void funcStudentDetails(View view) {
        if(id==R.id.admin_view){
            ArrayList<StudentPersonalDetails> stud;
            findViewById(R.id.layout_admin_main).setVisibility(View.INVISIBLE);
            findViewById(R.id.layout_table).setVisibility(View.VISIBLE);
            DatabaseCreation db=new DatabaseCreation(getApplicationContext());
            stud=db.getStudentPersonalDetails();
            LinearLayout sc=(LinearLayout) findViewById(R.id.table_id);
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
            for(StudentPersonalDetails s:stud){
                ll=new LinearLayout(this);
                ll.setOrientation(LinearLayout.HORIZONTAL);
                ll.setLayoutParams(llparams);
                tw=new TextView(this);
                tw.setText(s.getRoll());
                tw.setTextSize(12f);
                tw.setPadding(5,5,5,5);
                tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                tw.setLayoutParams(llview);
                ll.addView(tw);
                tw=new TextView(this);
                tw.setText(s.getName());
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
                tw.setText(s.getPhone());
                tw.setTextSize(12f);
                tw.setPadding(5,5,5,5);
                tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                tw.setLayoutParams(llview);
                ll.addView(tw);
                tw=new TextView(this);
                tw.setText(s.getAddress());
                tw.setTextSize(12f);
                tw.setPadding(5,5,5,5);
                tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                tw.setLayoutParams(llview);
                ll.addView(tw);
                sc.addView(ll);
            }
        }
        if(id==R.id.admin_insert){
            findViewById(R.id.layout_admin_main).setVisibility(View.INVISIBLE);
            findViewById(R.id.layout_student).setVisibility(View.VISIBLE);
            ((Button)findViewById(R.id.student_click)).setText("Insert");
            ((EditText) findViewById(R.id.stud_roll_no)).setText("");
            (findViewById(R.id.stud_roll_no)).setEnabled(true);
        }
        if(id==R.id.admin_update){
            SearchText=((EditText)findViewById(R.id.edit_search)).getText().toString();
            if(SearchText.isEmpty()){
                Toast.makeText(getApplicationContext(),"Edit Box is Empty",Toast.LENGTH_SHORT).show();
            }
            else{
                DatabaseCreation db=new DatabaseCreation(getApplicationContext());
                StudentPersonalDetails stud=db.getStudentDetailsToBeUpdated(SearchText);
                if(stud!=null) {
                    findViewById(R.id.layout_admin_main).setVisibility(View.INVISIBLE);
                    findViewById(R.id.layout_student).setVisibility(View.VISIBLE);
                    ((Button) findViewById(R.id.student_click)).setText("Update");
                    (findViewById(R.id.stud_roll_no)).setEnabled(false);
                    ((EditText) findViewById(R.id.stud_roll_no)).setText(SearchText);
                    ((EditText) findViewById(R.id.stud_name)).setText(stud.getName());
                    ((EditText) findViewById(R.id.stud_stream)).setText(stud.getStream());
                    ((EditText) findViewById(R.id.stud_phone)).setText(stud.getPhone());
                    ((EditText) findViewById(R.id.stud_address)).setText(stud.getAddress());
                }
                else{
                    Toast.makeText(getApplicationContext(),"Wrong Roll Number",Toast.LENGTH_SHORT).show();
                }
            }
        }
        if(id==R.id.admin_delete){
            SearchText=((EditText)findViewById(R.id.edit_search)).getText().toString();
            if(SearchText.isEmpty()){
                Toast.makeText(getApplicationContext(),"Edit Box is Empty",Toast.LENGTH_SHORT).show();
            }
            else{
                DatabaseCreation db=new DatabaseCreation(getApplicationContext());
                db.deleteStudentDetials(SearchText);
                Toast.makeText(getApplicationContext(),"Recorded Deleted",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void funcAcademicDetails(View view) {
        if(id==R.id.admin_view){
            ArrayList<AcademicDetails> acad;
            findViewById(R.id.layout_admin_main).setVisibility(View.INVISIBLE);
            findViewById(R.id.layout_table).setVisibility(View.VISIBLE);
            DatabaseCreation db=new DatabaseCreation(getApplicationContext());
            acad=db.getAcademicDetails();
            LinearLayout sc=(LinearLayout) findViewById(R.id.table_id);
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
        if(id==R.id.admin_insert){
            findViewById(R.id.layout_admin_main).setVisibility(View.INVISIBLE);
            findViewById(R.id.layout_academic).setVisibility(View.VISIBLE);
            ((Button)findViewById(R.id.academic_click)).setText("Insert");
        }
        if(id==R.id.admin_update){
            SearchText=((EditText)findViewById(R.id.edit_search)).getText().toString();
            if(SearchText.isEmpty()){
                Toast.makeText(getApplicationContext(),"Edit Box is Empty",Toast.LENGTH_SHORT).show();
            }
            else {
                DatabaseCreation db=new DatabaseCreation(getApplicationContext());
                AcademicDetails acad=db.getAcademicDetailsToBeUpdated(SearchText);
                if(acad!=null) {
                    findViewById(R.id.layout_admin_main).setVisibility(View.INVISIBLE);
                    findViewById(R.id.layout_academic).setVisibility(View.VISIBLE);
                    ((Button) findViewById(R.id.academic_click)).setText("Update");
                    (findViewById(R.id.acad_course)).setEnabled(false);
                    ((EditText) findViewById(R.id.acad_course)).setText(SearchText);
                    ((EditText)findViewById(R.id.acad_stream)).setText(acad.getStream());
                    ((EditText)findViewById(R.id.acad_inst)).setText(acad.getInstname());
                    ((EditText)findViewById(R.id.acad_board)).setText(acad.getBoardname());
                    ((EditText)findViewById(R.id.acad_percent)).setText(acad.getPercentage());
                    ((EditText)findViewById(R.id.acad_pass)).setText(acad.getYearofpass());
                }
                else{
                    Toast.makeText(getApplicationContext(),"Wrong Course Name",Toast.LENGTH_SHORT).show();
                }
            }
        }
        if(id==R.id.admin_delete){
            SearchText=((EditText)findViewById(R.id.edit_search)).getText().toString();
            if(SearchText.isEmpty()){
                Toast.makeText(getApplicationContext(),"Edit Box is Empty",Toast.LENGTH_SHORT).show();
            }
            else{
                DatabaseCreation db=new DatabaseCreation(getApplicationContext());
                db.deleteAcademicDetials(SearchText);
                Toast.makeText(getApplicationContext(),"Recorded Deleted",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void funcExamDetails(View view) {
        if(id==R.id.admin_view){
            ArrayList<ExamDetails> exam;
            findViewById(R.id.layout_admin_main).setVisibility(View.INVISIBLE);
            findViewById(R.id.layout_table).setVisibility(View.VISIBLE);
            DatabaseCreation db=new DatabaseCreation(getApplicationContext());
            exam=db.getExamDetails();
            LinearLayout sc=(LinearLayout) findViewById(R.id.table_id);
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
                tw.setText(s.getExamdate());((EditText) findViewById(R.id.announce_title)).setText(SearchText);
                tw.setTextSize(12f);
                tw.setPadding(5,5,5,5);
                tw.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                tw.setLayoutParams(llview);
                ll.addView(tw);
                sc.addView(ll);
            }
        }
        if(id==R.id.admin_insert){
            findViewById(R.id.layout_admin_main).setVisibility(View.INVISIBLE);
            findViewById(R.id.layout_exam).setVisibility(View.VISIBLE);
            ((Button)findViewById(R.id.exam_click)).setText("Insert");
        }
        if(id==R.id.admin_update){
            SearchText=((EditText)findViewById(R.id.edit_search)).getText().toString();
            if(SearchText.isEmpty()){
                Toast.makeText(getApplicationContext(),"Edit Box is Empty",Toast.LENGTH_SHORT).show();
            }
            else {
                DatabaseCreation db=new DatabaseCreation(getApplicationContext());
                ExamDetails exam=db.getExamDetailsToBeUpdated(SearchText);
                if(exam!=null) {
                    findViewById(R.id.layout_admin_main).setVisibility(View.INVISIBLE);
                    findViewById(R.id.layout_exam).setVisibility(View.VISIBLE);
                    ((Button) findViewById(R.id.exam_click)).setText("Update");
                    (findViewById(R.id.exam_name)).setEnabled(false);
                    ((EditText) findViewById(R.id.exam_name)).setText(SearchText);
                    ((EditText)findViewById(R.id.exam_studid)).setText(exam.getStudid());
                    ((EditText)findViewById(R.id.exam_sem)).setText(exam.getSem());
                    ((EditText)findViewById(R.id.exam_marks)).setText(exam.getMarks());
                    ((EditText)findViewById(R.id.exam_duration)).setText(exam.getDuration());
                    ((EditText)findViewById(R.id.exam_date)).setText(exam.getExamdate());
                }
                else {
                    Toast.makeText(getApplicationContext(),"Wrong Exam Name",Toast.LENGTH_SHORT).show();
                }
            }
        }
        if(id==R.id.admin_delete){
            SearchText=((EditText)findViewById(R.id.edit_search)).getText().toString();
            if(SearchText.isEmpty()){
                Toast.makeText(getApplicationContext(),"Edit Box is Empty",Toast.LENGTH_SHORT).show();
            }
            else{
                DatabaseCreation db=new DatabaseCreation(getApplicationContext());
                db.deleteExamDetials(SearchText);
                Toast.makeText(getApplicationContext(),"Recorded Deleted",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void funcAnnouncementsDetails(View view) {
        if(id==R.id.admin_view){
            ArrayList<AnnounceDetails> announce;
            findViewById(R.id.layout_admin_main).setVisibility(View.INVISIBLE);
            findViewById(R.id.layout_table).setVisibility(View.VISIBLE);
            DatabaseCreation db=new DatabaseCreation(getApplicationContext());
            announce=db.getAnnounceDetails();
            LinearLayout sc=(LinearLayout) findViewById(R.id.table_id);
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
            for(AnnounceDetails s:announce){((EditText) findViewById(R.id.acad_course)).setText(SearchText);
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
        if(id==R.id.admin_insert){
            findViewById(R.id.layout_admin_main).setVisibility(View.INVISIBLE);
            findViewById(R.id.layout_announce).setVisibility(View.VISIBLE);
            ((Button)findViewById(R.id.announce_click)).setText("Insert");
        }
        if(id==R.id.admin_update){
            SearchText=((EditText)findViewById(R.id.edit_search)).getText().toString();
            if(SearchText.isEmpty()){
                Toast.makeText(getApplicationContext(),"Edit Box is Empty",Toast.LENGTH_SHORT).show();
            }
            else {
                DatabaseCreation db=new DatabaseCreation(getApplicationContext());
                AnnounceDetails ann=db.getAnnounceDetailsToBeUpdated(SearchText);
                if(ann!=null) {
                    findViewById(R.id.layout_admin_main).setVisibility(View.INVISIBLE);
                    findViewById(R.id.layout_announce).setVisibility(View.VISIBLE);
                    ((Button) findViewById(R.id.announce_click)).setText("Update");
                    (findViewById(R.id.announce_title)).setEnabled(false);
                    ((EditText) findViewById(R.id.announce_title)).setText(SearchText);
                    ((EditText)findViewById(R.id.announce_date)).setText(ann.getDate());
                    ((EditText)findViewById(R.id.announce_detail)).setText(ann.getDetails());
                    ((EditText)findViewById(R.id.announce_dof)).setText(ann.getDof());
                }
                else {
                    Toast.makeText(getApplicationContext(),"Wrong Title",Toast.LENGTH_SHORT).show();
                }
            }
        }
        if(id==R.id.admin_delete){
            SearchText=((EditText)findViewById(R.id.edit_search)).getText().toString();
            if(SearchText.isEmpty()){
                Toast.makeText(getApplicationContext(),"Edit Box is Empty",Toast.LENGTH_SHORT).show();
            }
            else{
                DatabaseCreation db=new DatabaseCreation(getApplicationContext());
                db.deleteAnnounceDetials(SearchText);
                Toast.makeText(getApplicationContext(),"Recorded Deleted",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void addStudent(View view) {
        if(id==R.id.admin_insert) {
            DatabaseCreation db = new DatabaseCreation(getApplicationContext());
            String roll = ((EditText) findViewById(R.id.stud_roll_no)).getText().toString();
            String name = ((EditText) findViewById(R.id.stud_name)).getText().toString();
            String stream = ((EditText) findViewById(R.id.stud_stream)).getText().toString();
            String phone = ((EditText) findViewById(R.id.stud_phone)).getText().toString();
            String address = ((EditText) findViewById(R.id.stud_address)).getText().toString();
            StudentPersonalDetails stud=new StudentPersonalDetails(roll,name,stream,phone,address);
            db.addStudentDetails(stud);
            ((EditText) findViewById(R.id.stud_roll_no)).setText("");
            ((EditText) findViewById(R.id.stud_name)).setText("");
            ((EditText) findViewById(R.id.stud_stream)).setText("");
            ((EditText) findViewById(R.id.stud_phone)).setText("");
            ((EditText) findViewById(R.id.stud_address)).setText("");
            Toast.makeText(getApplicationContext(),"Student Data Inserted",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.admin_update){
            DatabaseCreation db = new DatabaseCreation(getApplicationContext());
            String roll = ((EditText) findViewById(R.id.stud_roll_no)).getText().toString();
            String name = ((EditText) findViewById(R.id.stud_name)).getText().toString();
            String stream = ((EditText) findViewById(R.id.stud_stream)).getText().toString();
            String phone = ((EditText) findViewById(R.id.stud_phone)).getText().toString();
            String address = ((EditText) findViewById(R.id.stud_address)).getText().toString();
            StudentPersonalDetails stud=new StudentPersonalDetails(roll,name,stream,phone,address);
            db.updateStudentDetails(stud,roll);
            ((EditText) findViewById(R.id.stud_roll_no)).setText("");
            ((EditText) findViewById(R.id.stud_name)).setText("");
            ((EditText) findViewById(R.id.stud_stream)).setText("");
            ((EditText) findViewById(R.id.stud_phone)).setText("");
            ((EditText) findViewById(R.id.stud_address)).setText("");
            Toast.makeText(getApplicationContext(),"Student Data Updated",Toast.LENGTH_SHORT).show();
        }
    }

    public void addAcademic(View view) {
        if(id==R.id.admin_insert) {
            DatabaseCreation db=new DatabaseCreation(getApplicationContext());
            String course=((EditText)findViewById(R.id.acad_course)).getText().toString();
            String stream=((EditText)findViewById(R.id.acad_stream)).getText().toString();
            String inst=((EditText)findViewById(R.id.acad_inst)).getText().toString();
            String board=((EditText)findViewById(R.id.acad_board)).getText().toString();
            String percent=((EditText)findViewById(R.id.acad_percent)).getText().toString();
            String pass=((EditText)findViewById(R.id.acad_pass)).getText().toString();
            AcademicDetails acad=new AcademicDetails(course,stream,inst,board,percent,pass);
            db.addAcademicDetails(acad);
            ((EditText)findViewById(R.id.acad_course)).setText("");
            ((EditText)findViewById(R.id.acad_stream)).setText("");
            ((EditText)findViewById(R.id.acad_inst)).setText("");
            ((EditText)findViewById(R.id.acad_board)).setText("");
            ((EditText)findViewById(R.id.acad_percent)).setText("");
            ((EditText)findViewById(R.id.acad_pass)).setText("");
            Toast.makeText(getApplicationContext(),"Academic Details Inserted",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.admin_update){
            DatabaseCreation db=new DatabaseCreation(getApplicationContext());
            String course=((EditText)findViewById(R.id.acad_course)).getText().toString();
            String stream=((EditText)findViewById(R.id.acad_stream)).getText().toString();
            String inst=((EditText)findViewById(R.id.acad_inst)).getText().toString();
            String board=((EditText)findViewById(R.id.acad_board)).getText().toString();
            String percent=((EditText)findViewById(R.id.acad_percent)).getText().toString();
            String pass=((EditText)findViewById(R.id.acad_pass)).getText().toString();
            AcademicDetails acad=new AcademicDetails(course,stream,inst,board,percent,pass);
            db.updateAcademicDetails(acad,course);
            ((EditText)findViewById(R.id.acad_course)).setText("");
            ((EditText)findViewById(R.id.acad_stream)).setText("");
            ((EditText)findViewById(R.id.acad_inst)).setText("");
            ((EditText)findViewById(R.id.acad_board)).setText("");
            ((EditText)findViewById(R.id.acad_percent)).setText("");
            ((EditText)findViewById(R.id.acad_pass)).setText("");
            Toast.makeText(getApplicationContext(),"Academic Details Updated",Toast.LENGTH_SHORT).show();
        }
    }


    public void addExamDetails(View view) {
        if(id==R.id.admin_insert) {
            DatabaseCreation db=new DatabaseCreation(getApplicationContext());
            String name=((EditText)findViewById(R.id.exam_name)).getText().toString();
            String studid=((EditText)findViewById(R.id.exam_studid)).getText().toString();
            String sem=((EditText)findViewById(R.id.exam_sem)).getText().toString();
            String marks=((EditText)findViewById(R.id.exam_marks)).getText().toString();
            String duration=((EditText)findViewById(R.id.exam_duration)).getText().toString();
            String date=((EditText)findViewById(R.id.exam_date)).getText().toString();
            ExamDetails exam=new ExamDetails(name,studid,sem,marks,duration,date);
            db.addExamDetails(exam);
            ((EditText)findViewById(R.id.exam_name)).setText("");
            ((EditText)findViewById(R.id.exam_studid)).setText("");
            ((EditText)findViewById(R.id.exam_sem)).setText("");
            ((EditText)findViewById(R.id.exam_marks)).setText("");
            ((EditText)findViewById(R.id.exam_duration)).setText("");
            ((EditText)findViewById(R.id.exam_date)).setText("");
            Toast.makeText(getApplicationContext(),"Exam Detials Inserted",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.admin_update){
            DatabaseCreation db=new DatabaseCreation(getApplicationContext());
            String name=((EditText)findViewById(R.id.exam_name)).getText().toString();
            String studid=((EditText)findViewById(R.id.exam_studid)).getText().toString();
            String sem=((EditText)findViewById(R.id.exam_sem)).getText().toString();
            String marks=((EditText)findViewById(R.id.exam_marks)).getText().toString();
            String duration=((EditText)findViewById(R.id.exam_duration)).getText().toString();
            String date=((EditText)findViewById(R.id.exam_date)).getText().toString();
            ExamDetails exam=new ExamDetails(name,studid,sem,marks,duration,date);
            db.updateExamDetails(exam,name);
            ((EditText)findViewById(R.id.exam_name)).setText("");
            ((EditText)findViewById(R.id.exam_studid)).setText("");
            ((EditText)findViewById(R.id.exam_sem)).setText("");
            ((EditText)findViewById(R.id.exam_marks)).setText("");
            ((EditText)findViewById(R.id.exam_duration)).setText("");
            ((EditText)findViewById(R.id.exam_date)).setText("");
            Toast.makeText(getApplicationContext(),"Exam Detials Updated",Toast.LENGTH_SHORT).show();
        }
    }


    public void addAnnounce(View view) {
        if(id==R.id.admin_insert) {
            DatabaseCreation db=new DatabaseCreation(getApplicationContext());
            String title=((EditText)findViewById(R.id.announce_title)).getText().toString();
            String date=((EditText)findViewById(R.id.announce_date)).getText().toString();
            String detail=((EditText)findViewById(R.id.announce_detail)).getText().toString();
            String dof=((EditText)findViewById(R.id.announce_dof)).getText().toString();
            AnnounceDetails ann=new AnnounceDetails(title,date,detail,dof);
            db.addAnnounceDetails(ann);
            ((EditText)findViewById(R.id.announce_title)).setText("");
            ((EditText)findViewById(R.id.announce_date)).setText("");
            ((EditText)findViewById(R.id.announce_detail)).setText("");
            ((EditText)findViewById(R.id.announce_dof)).setText("");
            Toast.makeText(getApplicationContext(),"Announcement Detials Inserted",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.admin_update){
            DatabaseCreation db=new DatabaseCreation(getApplicationContext());
            String title=((EditText)findViewById(R.id.announce_title)).getText().toString();
            String date=((EditText)findViewById(R.id.announce_date)).getText().toString();
            String detail=((EditText)findViewById(R.id.announce_detail)).getText().toString();
            String dof=((EditText)findViewById(R.id.announce_dof)).getText().toString();
            AnnounceDetails ann=new AnnounceDetails(title,date,detail,dof);
            db.updateAnnounceDetails(ann,title);
            ((EditText)findViewById(R.id.announce_title)).setText("");
            ((EditText)findViewById(R.id.announce_date)).setText("");
            ((EditText)findViewById(R.id.announce_detail)).setText("");
            ((EditText)findViewById(R.id.announce_dof)).setText("");
            Toast.makeText(getApplicationContext(),"Announcement Detials Updated",Toast.LENGTH_SHORT).show();
        }
    }
}