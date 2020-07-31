package vn.daikon.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
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
        sinh.setInputType(InputType.TYPE_CLASS_DATETIME);
        que = (EditText) findViewById(R.id.que);
        chuyen = (Spinner) findViewById(R.id.chuyen);
        chuc = (Spinner) findViewById(R.id.chuc);
        phong = (Spinner) findViewById(R.id.phong);
        trinh = (Spinner) findViewById(R.id.trinh);
        ArrayAdapter<String> a = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item, NhanVien.getChucVu());
        chuc.setAdapter(a);
        ArrayAdapter<String> b = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item, NhanVien.getChuyenMon());
        chuyen.setAdapter(b);
        ArrayAdapter<String> c = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item, NhanVien.getPhong());
        phong.setAdapter(c);
        ArrayAdapter<String> d = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item, NhanVien.getTrinhDo());
        trinh.setAdapter(d);
        state = State.getInstance();
        updateView();
        cmsn();

    }
    private void cmsn(){

    }
    void updateView(){
        NhanVien nhanVien = state.nhanVien;
        user.setText(nhanVien.user);
        pass.setText(nhanVien.password);
        ho.setText(nhanVien.ho);
        ten.setText(nhanVien.ten);
        sinh.setText(nhanVien.namSinh);
        que.setText(nhanVien.queQuan);
        String chuyen = nhanVien.chuyenMon.name();
        String chuc = nhanVien.chucVu.name();
        String phong = nhanVien.phong.name();
        String trinh = nhanVien.trinhDo.name();

        this.chuyen.setSelection(NhanVien.ChuyenMon.valueOf(chuyen).ordinal());
        this.chuc.setSelection(NhanVien.ChucVu.valueOf(chuc).ordinal());
        this.phong.setSelection(NhanVien.Phong.valueOf(phong).ordinal());
        this.trinh.setSelection(NhanVien.TrinhDo.valueOf(trinh).ordinal());
    }
    public void onClick(View view){
        String user = this.user.getText().toString();
        String pass = this.pass.getText().toString();
        String ho = this.ho.getText().toString();
        String ten = this.ten.getText().toString();
        String sinh = this.sinh.getText().toString();
        String que = this.que.getText().toString();
        String chuyen = this.chuyen.getSelectedItem().toString();
        String chuc = this.chuc.getSelectedItem().toString();
        String phong = this.phong.getSelectedItem().toString();
        String trinh = this.trinh.getSelectedItem().toString();
        state.updateNhanVien(new NhanVien(user,pass,ho,ten,que,sinh,NhanVien.ChuyenMon.valueOf(chuyen),
                NhanVien.ChucVu.valueOf(chuc),NhanVien.TrinhDo.valueOf(trinh),NhanVien.Phong.valueOf(phong)));

        updateView();
    }

}