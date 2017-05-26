package sg.edu.rp.soi.c347.taskmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<Task> al;
    ArrayAdapter aa;
    Button btnTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTask = (Button) findViewById(R.id.btnTask);
        lv = (ListView) findViewById(R.id.lv);

        DBHelper dbh = new DBHelper(MainActivity.this);
        al = new ArrayList<String>();
        al.addAll(dbh.getAllTasks());
        aa = new ArrayAdapter<String>(this, al);
        lv.setAdapter(aa);

        btnTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(i, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            DBHelper dbh = new DBHelper(this);
            al.clear();
            al.addAll(dbh.getAllTasks());
            dbh.close();
            aa.notifyDataSetChanged();
        }
    }
}
