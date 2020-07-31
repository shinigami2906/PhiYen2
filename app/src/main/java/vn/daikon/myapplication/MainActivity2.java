package vn.daikon.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import vn.daikon.myapplication.model.NhanVien;

public class MainActivity2 extends AppCompatActivity {
    EditText user,pass,ho,ten,sinh,que;
    Spinner chuyen,trinh,phong,chuc;
    State state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }
    private void init(){
        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
        ho = (EditText) findViewById(R.id.ho);
        ten = (EditText) findViewById(R.id.ten);
        sinh = (EditText) findViewById(R.id.sinh);
        que = (EditText) findViewById(R.id.que);
        chuyen = (Spinner) findViewById(R.id.chuyen);
        chuc = (Spinner) findViewById(R.id.chuc);
        phong = (Spinner) findViewById(R.id.phong);
        trinh = (Spinner) findViewById(R.id.trinh);
        ArrayAdapter<String> a = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item, NhanVien.getChucVu());
        chuc.setAdapter(a);
        a = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item, NhanVien.getChuyenMon());
        chuyen.setAdapter(a);
        a = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item, NhanVien.getPhong());
        phong.setAdapter(a);
        a = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item, NhanVien.getTrinhDo());
        trinh.setAdapter(a);
        state = State.getInstance();
        updateView();


    }
    void updateView(){
        NhanVien nhanVien = state.nhanVien;
        user.setText(nhanVien.user);
        pass.setText(nhanVien.password);
        ho.setText(nhanVien.ho);
        ten.setText(nhanVien.ten);
        sinh.setText(nhanVien.namSinh);
        que.setText(nhanVien.queQuan);
    }
    public void onClick(View view){
        String user = this.user.getText().toString();
        String pass = this.pass.getText().toString();
        String ho = this.ho.getText().toString();
        String ten = this.ten.getText().toString();
        String sinh = this.sinh.getText().toString();
        String que = this.que.getText().toString();
        state.updateNhanVien(new NhanVien(user,pass,ho,ten,que,sinh,NhanVien.ChuyenMon.KE_TOAN,NhanVien.ChucVu.NHAN_VIEN,NhanVien.TrinhDo.CAP3,NhanVien.Phong.KIEM_DINH));
        updateView();
    }

}