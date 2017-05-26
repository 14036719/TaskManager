package sg.edu.rp.soi.c347.taskmanager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class AddActivity extends AppCompatActivity {
    EditText etName, etDescription, etRemind;
    Button btnAddTask, btnCancel;
    int reqCode = 12345;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);

        etName = (EditText)findViewById(R.id.etName);
        etDescription = (EditText)findViewById(R.id.etDescription);
        etRemind = (EditText)findViewById(R.id.etRemind);
        btnAddTask = (Button)findViewById(R.id.btnAddTask);
        btnCancel = (Button)findViewById(R.id.btnCancel);

        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(AddActivity.this);
                String name = etName.getText().toString();
                String des = etDescription.getText().toString();
                int remind = Integer.parseInt(etRemind.getText().toString());
                dbh.insertTask(name, des);

                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.SECOND, remind);

                Intent i = new Intent(AddActivity.this, TaskBroadcastReceiver.class);
                i.putExtra("name", name);
                i.putExtra("description", des);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(AddActivity.this, reqCode, i, PendingIntent.FLAG_CANCEL_CURRENT);

                AlarmManager am = (AlarmManager) getSystemService(Activity.ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);
                setResult(RESULT_OK);
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
