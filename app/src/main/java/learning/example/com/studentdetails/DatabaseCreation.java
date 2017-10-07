package learning.example.com.studentdetails;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Annotation;

import java.util.ArrayList;



public class DatabaseCreation extends SQLiteOpenHelper {

    private String StudTable="StudentPersonalDetails";
    private String AcademicTable="AcademicDetails";
    private String ExamTable="ExamDetails";
    private String AnTable="Announcements";

    public DatabaseCreation(Context context) {
        super(context, R.string.app_name+"",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
        String createStudentDetails="create table "+StudTable+"(id integer," +
                "roll text,"+
                "name text,"+
                "stream text,"+
                "phoneno text,"+
                "address text)";
        db.execSQL(createStudentDetails);
        String createAcademicDetails="create table "+AcademicTable+"(id integer,"+
                "course text,"+
                "stream text,"+
                "instname text,"+
                "boardname text,"+
                "percentage text,"+
                "yearofpass text)";
        db.execSQL(createAcademicDetails);
        String createExamDetails="create table "+ExamTable+"(id integer,"+
                "examname text,"+
                "studid text,"+
                "sem text,"+
                "marks text,"+
                "duration text,"+
                "examdate text)";
        db.execSQL(createExamDetails);
        String createAnDetails="create table "+AnTable+"(id integer," +
                "title text," +
                "date text," +
                "dof text," +
                "details text)";
        db.execSQL(createAnDetails);}catch (Exception e){}
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table "+AcademicTable);
        db.execSQL("drop table "+ExamTable);
        db.execSQL("drop table "+ AnTable);
        db.execSQL("drop table "+StudTable);
    }

    public ArrayList<StudentPersonalDetails> getStudentPersonalDetails(){
        ArrayList<StudentPersonalDetails> arr=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cur=db.rawQuery("select * from "+StudTable,null);
        while(cur.moveToNext()){
            StudentPersonalDetails stud=new StudentPersonalDetails(cur.getString(1),
                    cur.getString(2),
                    cur.getString(3),
                    cur.getString(4),
                    cur.getString(5));
            arr.add(stud);
        }
        return arr;
    }

    public void addStudentDetails(StudentPersonalDetails stud){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cur=db.rawQuery("select * from "+StudTable,null);
        int i=0;
        while(cur.moveToNext()){
            i++;
        }
        ContentValues values=new ContentValues();
        values.put("id",i+1);
        values.put("roll",stud.getRoll());
        values.put("name",stud.getName());
        values.put("stream",stud.getStream());
        values.put("phoneno",stud.getPhone());
        values.put("address",stud.getAddress());
        db.insert(StudTable,null,values);
    }

    public StudentPersonalDetails getStudentDetailsToBeUpdated(String roll){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cur=db.query(StudTable,new String[]{"roll","name","stream","phoneno","address"},"roll=?",new String[]{roll},null,null,null,null);
        cur.moveToFirst();
        if(cur.isLast()) {
            StudentPersonalDetails stud = new StudentPersonalDetails(cur.getString(0),
                    cur.getString(1),
                    cur.getString(2),
                    cur.getString(3),
                    cur.getString(4));
            return stud;
        }
        else{
            return null;
        }
    }

    public void updateStudentDetails(StudentPersonalDetails stud,String roll){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",stud.getName());
        values.put("stream",stud.getStream());
        values.put("phoneno",stud.getPhone());
        values.put("address",stud.getAddress());
        db.update(StudTable,values,"roll=?",new String[]{roll});
    }

    public void deleteStudentDetials(String roll){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(StudTable,"roll=?",new String[]{roll});
    }

    public ArrayList<AcademicDetails> getAcademicDetails(){
        ArrayList<AcademicDetails> arr=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cur=db.rawQuery("select * from "+AcademicTable,null);
        while(cur.moveToNext()){
            AcademicDetails stud=new AcademicDetails(cur.getString(1),
                    cur.getString(2),
                    cur.getString(3),
                    cur.getString(4),
                    cur.getString(5),
                    cur.getString(6));
            arr.add(stud);
        }
        return arr;
    }

    public void addAcademicDetails(AcademicDetails acad){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cur=db.rawQuery("select * from "+AcademicTable,null);
        int i=0;
        while(cur.moveToNext()){
            i++;
        }
        ContentValues values=new ContentValues();
        values.put("id",i+1);
        values.put("course",acad.getCourse());
        values.put("stream",acad.getStream());
        values.put("instname",acad.getInstname());
        values.put("boardname",acad.getBoardname());
        values.put("percentage",acad.getPercentage());
        values.put("yearofpass",acad.getYearofpass());
        db.insert(AcademicTable,null,values);
    }

    public AcademicDetails getAcademicDetailsToBeUpdated(String course){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cur=db.query(AcademicTable,new String[]{"course","stream","instname","boardname","percentage","yearofpass"},"course=?",new String[]{course},null,null,null,null);
        cur.moveToFirst();
        if(cur.isLast()) {
            AcademicDetails acad = new AcademicDetails(cur.getString(0),
                    cur.getString(1),
                    cur.getString(2),
                    cur.getString(3),
                    cur.getString(4),
                    cur.getString(5));
            return acad;
        }
        else{
            return null;
        }
    }

    public void updateAcademicDetails(AcademicDetails acc,String cour){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("stream",acc.getStream());
        values.put("instname",acc.getInstname());
        values.put("boardname",acc.getBoardname());
        values.put("percentage",acc.getPercentage());
        values.put("yearofpass",acc.getYearofpass());
        db.update(AcademicTable,values,"course=?",new String[]{cour});
    }

    public void deleteAcademicDetials(String course){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(AcademicTable,"course=?",new String[]{course});
    }

    public ArrayList<ExamDetails> getExamDetails(){
        ArrayList<ExamDetails> arr=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cur=db.rawQuery("select * from "+ExamTable,null);
        while(cur.moveToNext()){
            ExamDetails stud=new ExamDetails(cur.getString(1),
                    cur.getString(2),
                    cur.getString(3),
                    cur.getString(4),
                    cur.getString(5),
                    cur.getString(6));
            arr.add(stud);
        }
        return arr;
    }

    public void addExamDetails(ExamDetails exam){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cur=db.rawQuery("select * from "+ExamTable,null);
        int i=0;
        while(cur.moveToNext()){
            i++;
        }
        ContentValues values=new ContentValues();
        values.put("id",i+1);
        values.put("examname",exam.getExamname());
        values.put("studid",exam.getStudid());
        values.put("sem",exam.getSem());
        values.put("marks",exam.getMarks());
        values.put("duration",exam.getDuration());
        values.put("examdate",exam.getExamdate());
        db.insert(ExamTable,null,values);
    }

    public ExamDetails getExamDetailsToBeUpdated(String examname){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cur=db.query(ExamTable,new String[]{"examname","studid","sem","marks","duration","examdate"},"examname=?",new String[]{examname},null,null,null,null);
        cur.moveToFirst();
        if(cur.isLast()) {
            ExamDetails exam = new ExamDetails(cur.getString(0),
                    cur.getString(1),
                    cur.getString(2),
                    cur.getString(3),
                    cur.getString(4),
                    cur.getString(5));
            return exam;
        }
        else{
            return null;
        }
    }

    public void updateExamDetails(ExamDetails exam,String examname){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("studid",exam.getStudid());
        values.put("sem",exam.getSem());
        values.put("marks",exam.getMarks());
        values.put("duration",exam.getDuration());
        values.put("examdate",exam.getExamdate());
        db.update(ExamTable,values,"examname=?",new String[]{examname});
    }

    public void deleteExamDetials(String examname){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(ExamTable,"examname=?",new String[]{examname});
    }

    public ArrayList<AnnounceDetails> getAnnounceDetails(){
        ArrayList<AnnounceDetails> arr=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cur=db.rawQuery("select * from "+AnTable,null);
        while(cur.moveToNext()){
            AnnounceDetails stud=new AnnounceDetails(cur.getString(1),
                    cur.getString(2),
                    cur.getString(3),
                    cur.getString(4));
            arr.add(stud);
        }
        return arr;
    }

    public void addAnnounceDetails(AnnounceDetails ann){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cur=db.rawQuery("select * from "+AnTable,null);
        int i=0;
        while(cur.moveToNext()){
            i++;
        }
        ContentValues values=new ContentValues();
        values.put("id",i+1);
        values.put("title", ann.getTitle());
        values.put("date",ann.getDate());
        values.put("dof",ann.getDof());
        values.put("details",ann.getDetails());
        db.insert(AnTable,null,values);
    }

    public AnnounceDetails getAnnounceDetailsToBeUpdated(String title){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cur=db.query(AnTable,new String[]{"title","date","dof","details"},"title=?",new String[]{title},null,null,null,null);
        cur.moveToFirst();
        if(cur.isLast()) {
            AnnounceDetails ann = new AnnounceDetails(cur.getString(0),
                    cur.getString(1),
                    cur.getString(2),
                    cur.getString(3));
            return ann;
        }
        else{
            return null;
        }
    }

    public void updateAnnounceDetails(AnnounceDetails ann,String title){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("date",ann.getDate());
        values.put("dof",ann.getDof());
        values.put("details",ann.getDetails());
        db.update(ExamTable,values,"title=?",new String[]{title});
    }

    public void deleteAnnounceDetials(String title){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(AnTable,"title=?",new String[]{title});
    }

    public StudentPersonalDetails getStudentDetails(String roll){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cur=db.query(StudTable,new String[]{"roll","name","stream","phoneno","address"},"roll=?",new String[]{roll},null,null,null,null);
        cur.moveToFirst();
        StudentPersonalDetails stud=new StudentPersonalDetails(cur.getString(0),
                cur.getString(1),
                cur.getString(2),
                cur.getString(3),
                cur.getString(4));
        return stud;
    }

    public ArrayList<AcademicDetails> getAcademicResults(String stream){
        ArrayList<AcademicDetails> arr=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cur=db.rawQuery("select course,instname,a.stream,boardname,percentage,yearofpass from "+StudTable+" s,"+AcademicTable+" a where a.stream=s.stream",null);
        while(cur.moveToNext()){
            AcademicDetails acad=new AcademicDetails(cur.getString(0),
                    cur.getString(1),
                    cur.getString(2),
                    cur.getString(3),
                    cur.getString(4),
                    cur.getString(5));
            arr.add(acad);
        }
        return  arr;
    }
}
