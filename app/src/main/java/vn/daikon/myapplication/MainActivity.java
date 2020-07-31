package vn.daikon.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import vn.daikon.myapplication.model.NhanVien;
import vn.daikon.myapplication.repo.NhanVienRepo;

public class MainActivity extends AppCompatActivity {
    TextView et_1,et_2;
    State state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        et_1 = (TextView) findViewById(R.id.et_1);
        et_2 = (TextView) findViewById(R.id.et_2);
        state = State.getInstance();
        state.setRepo(new NhanVienRepo(this));
    }
    public void onClick(View view){
        String user = et_1.getText().toString();
        String pass = et_2.getText().toString();
        if (et_1.getText().toString().equals("admin") && et_2.getText().toString().equals("admin")){
            state.nhanVien = new NhanVien("admin","admin");
            Intent intent = new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
        }
        else {
            boolean kq = state.login(et_1.getText().toString(),et_2.getText().toString());
            if (kq == false) Toast.makeText(this,"That bai",Toast.LENGTH_LONG).show();
            else {
                Toast.makeText(this,"Thanh cong",Toast.LENGTH_LONG).show();
            }
        }
    }
}
