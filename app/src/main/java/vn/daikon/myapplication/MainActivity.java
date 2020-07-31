package vn.daikon.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import vn.daikon.myapplication.model.NhanVien;
import vn.daikon.myapplication.repo.NhanVienRepo;

public class MainActivity extends AppCompatActivity {
    EditText ed_1,ed_2;
    State state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        ed_1 = (EditText) findViewById(R.id.et_1);
        ed_2 = (EditText) findViewById(R.id.et_2);
        state = State.getInstance();
        state.setRepo(new NhanVienRepo(this));
    }
    public void onClick1(View view){
        String user = ed_1.getText().toString();
        String pass = ed_2.getText().toString();
        if (user.equals("admin") && pass.equals("admin")){
            state.nhanVien = new NhanVien(user,pass);
            Intent intent = new Intent(MainActivity.this,MainActivity1.class);
            startActivity(intent);
        }
        else {
            if (state.login(user,pass)) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
            else  Toast.makeText(this,"That bai",Toast.LENGTH_LONG);
        }
    }
    public void onClick2(View view){
        Intent intent = new Intent(MainActivity.this,MainActivity3.class);
        startActivity(intent);
    }
}
