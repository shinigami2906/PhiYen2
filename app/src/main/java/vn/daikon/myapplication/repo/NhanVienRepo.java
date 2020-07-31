package vn.daikon.myapplication.repo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vn.daikon.myapplication.model.NhanVien;

public class NhanVienRepo extends SQLiteOpenHelper {
    private static String KEY_CHUYEN_MON = "chuyen_mon";
    private static String KEY_CHUC_VU = "chuc_vu";
    private static String KEY_TRINH_DO = " trinh_do";
    private static String KEY_HO= "ho";
    private static String KEY_TEN = " ten";
    private static String KEY_NAM_SINH ="nam_sinh";
    private static String KEY_QUE_QUAN = "que_quan";
    private static String KEY_PHONG="phong";
    private static String KEY_USER="user";
    private static String KEY_PASSWORD = "password";
    private static String TABLE_NAME = "nhan_vien";
    private static int VERSION = 1;
    public NhanVienRepo(@Nullable Context context) {
        super(context, TABLE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = String.format("CREATE TABLE %s(%s TEXT,%s TEXT,%s TEXT,%s TEXT,%s TEXT,%s TEXT,%s TEXT,%s TEXT,%s TEXT,%s TEXT )",TABLE_NAME,
                KEY_USER,KEY_PASSWORD,KEY_HO,KEY_TEN,KEY_QUE_QUAN,KEY_NAM_SINH,KEY_CHUYEN_MON,KEY_CHUC_VU,KEY_TRINH_DO,KEY_PHONG);
        db.execSQL(sql);
    }

    public void addNhanVien(NhanVien nhanVien){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_USER,nhanVien.user);
        values.put(KEY_PASSWORD,nhanVien.password);
        values.put(KEY_HO,nhanVien.ho);
        values.put(KEY_TEN,nhanVien.ten);
        values.put(KEY_NAM_SINH,nhanVien.namSinh);
        values.put(KEY_QUE_QUAN,nhanVien.queQuan);
        values.put(KEY_TRINH_DO,nhanVien.trinhDo.toString());
        values.put(KEY_CHUC_VU,nhanVien.chucVu.toString());
        values.put(KEY_CHUYEN_MON,nhanVien.chuyenMon.toString());
        values.put(KEY_PHONG,nhanVien.phong.toString());
        db.insert(TABLE_NAME,null,values);
    }
    public NhanVien getNhanVien(String user){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, null, KEY_USER + " = ?", new String[] { String.valueOf(user) },null, null, null);
        if(cursor != null)
            cursor.moveToFirst();

        if (cursor == null || cursor.getCount() == 0) return null;

        NhanVien nhanVien = new NhanVien(
                cursor.getString(0), cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4), cursor.getString(5),
                NhanVien.ChuyenMon.valueOf(cursor.getString(6)),
                NhanVien.ChucVu.valueOf(cursor.getString(7)),
                NhanVien.TrinhDo.valueOf(cursor.getString(8)),
                NhanVien.Phong.valueOf(cursor.getString(9)));
        return nhanVien;
    }
    public List<NhanVien> getAllNhanVien(){
        List<NhanVien> studentList = new ArrayList<>();
        String query =  " SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor == null ) return null;
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) {
            NhanVien nhanVien = new NhanVien(
                    cursor.getString(0), cursor.getString(1), cursor.getString(2),
                    cursor.getString(3), cursor.getString(4), cursor.getString(5),
                    NhanVien.ChuyenMon.valueOf(cursor.getString(6)),
                    NhanVien.ChucVu.valueOf(cursor.getString(7)),
                    NhanVien.TrinhDo.valueOf(cursor.getString(8)),
                    NhanVien.Phong.valueOf(cursor.getString(9)));
            studentList.add(nhanVien);
            cursor.moveToNext();
        }
        return studentList;
    }
    public void updateNhanVien(NhanVien nhanVien){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_HO,nhanVien.ho);
        values.put(KEY_TEN,nhanVien.ten);
        values.put(KEY_NAM_SINH,nhanVien.namSinh);
        values.put(KEY_QUE_QUAN,nhanVien.queQuan);
        values.put(KEY_TRINH_DO,nhanVien.trinhDo.toString());
        values.put(KEY_CHUC_VU,nhanVien.chucVu.toString());
        values.put(KEY_CHUYEN_MON,nhanVien.chuyenMon.toString());
        values.put(KEY_PHONG,nhanVien.phong.toString());
        db.update(TABLE_NAME, values, KEY_USER + " = ?", new String[] { String.valueOf(nhanVien.user) });
        db.close();

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
