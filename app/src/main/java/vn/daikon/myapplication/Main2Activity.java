package vn.daikon.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import vn.daikon.myapplication.adpater.MyAdapter;
import vn.daikon.myapplication.model.NhanVien;

public class Main2Activity extends AppCompatActivity {
    State state;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }

    private void init(){
        state = State.getInstance();
        lv = (ListView) findViewById(R.id.lv);
        state.setList();
        final MyAdapter myAdapter = new MyAdapter(state.list);
        lv.setAdapter(myAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Main2Activity.this,Main4Activity.class);
                intent.putExtra("user", position);

                startActivity(intent);
            }
        });

    }
    public void onClick(View view){
        Intent intent = new Intent(Main2Activity.this,Main3Activity.class);
        startActivity(intent);
    }
}
