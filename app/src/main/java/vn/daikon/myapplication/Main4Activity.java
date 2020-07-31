package vn.daikon.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import vn.daikon.myapplication.model.NhanVien;

public class Main4Activity extends AppCompatActivity {
    EditText user,pass,ho,ten,quequan;
    DatePicker namsinh;
    State state;
    Spinner trindo, chuyenmon,phong,chucvu;
    NhanVien nhanVien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        init();
    }
    private void init(){
        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
        ho = (EditText) findViewById(R.id.ho);
        ten = (EditText) findViewById(R.id.ten);
        namsinh = (DatePicker) findViewById(R.id.namsinh);
        quequan = (EditText) findViewById(R.id.quequan);
        trindo = (Spinner) findViewById(R.id.trinhdo);
        chuyenmon = (Spinner) findViewById(R.id.chuyenmon);
        chucvu = (Spinner) findViewById(R.id.chucvu);
        phong = (Spinner) findViewById(R.id.phong);
        state = State.getInstance();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item, NhanVien.getTrinhDo());
        trindo.setAdapter(adapter);
        adapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,NhanVien.getChucVu());
        chucvu.setAdapter(adapter);
        adapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,NhanVien.getChuyenMon());
        chuyenmon.setAdapter(adapter);
        adapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,NhanVien.getPhong());
        phong.setAdapter(adapter);
        nhanVien = (NhanVien) state.list.get(getIntent().getIntExtra("user",0));
        user.setText(nhanVien.user);
        pass.setText(nhanVien.password);
        ho.setText(nhanVien.ho);
        ten.setText(nhanVien.ten);
        quequan.setText(nhanVien.queQuan);






    }
    public void onClick(View view ){
        String user = this.user.getText().toString();
        String pass =  this.pass.getText().toString();
        String ho =  this.ho.getText().toString();
        String ten = this.ten.getText().toString();
        String namsinh = this.namsinh.toString();
        String quequan = this.quequan.getText().toString();
        NhanVien nhanVien = new NhanVien(user,pass,ho,ten,quequan,namsinh, NhanVien.ChuyenMon.KE_TOAN, NhanVien.ChucVu.TRUONG_PHONG, NhanVien.TrinhDo.CU_NHAN, NhanVien.Phong.PHAN_MEM);
        state.updateNhanVien(nhanVien);

        finish();
    }
}
