package sg.edu.rp.soi.c347.taskmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.attr.description;
import static android.R.attr.id;
import static android.support.v7.appcompat.R.styleable.MenuItem;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<Task> taskArrayList;
    ArrayAdapter aa;
    Button btnTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lvContent);
        btnTask = (Button) findViewById(R.id.btnTask);

        aa = new TaskArrayAdapter(MainActivity.this, R.layout.row, taskArrayList);
        lv.setAdapter(aa);
        registerForContextMenu(lv);

        btnTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), AddActivity.class);
                startActivityForResult(i, 9);
            }
        });
    }
        @Override
        public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
            super.onCreateContextMenu(menu, v, menuInfo);
            //Context menu
            menu.add(Menu.NONE, 1, Menu.NONE, "Edit");
            menu.add(Menu.NONE, 2, Menu.NONE, "Delete");
        }

        @Override
        public boolean onContextItemSelected (MenuItem item){
            AdapterView.AdapterContextMenuInfo menuinfo = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
            long selectid = menuinfo.id;
            int selectpos = menuinfo.position;



        }

            }
}
