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

import static android.R.id.content;

/**
 * Created by 14036719 on 26/5/2017.
 */

public class AddActivity extends AppCompatActivity {
    EditText etName, etDescription;
    Button btnAddTask, btnCancel;
    int reqCode = 12345;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);

        etName = (EditText)findViewById(R.id.etName);
        etDescription = (EditText)findViewById(R.id.etDescription);

        btnAddTask = (Button)findViewById(R.id.btnAddTask);
        btnCancel = (Button)findViewById(R.id.btnCancel);

        btnAddTask.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String description = etDescription.getText().toString();

                DBHelper db = new DBHelper(AddActivity.this);

                db.insertTask(new Task(id,name,description));
                Toast.makeText(AddActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
                db.close();


                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.SECOND, 5);

                Intent intent = new Intent(AddActivity.this,
                        TaskBroadcastReceiver.class);
                intent.putExtra("name",name);
                intent.putExtra("content",content);

                PendingIntent pendingIntent = PendingIntent.getBroadcast(
                        AddActivity.this, reqCode,
                        intent, PendingIntent.FLAG_CANCEL_CURRENT);

                AlarmManager am = (AlarmManager)
                        getSystemService(Activity.ALARM_SERVICE);

                am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),
                        pendingIntent);

                Intent returnIntent = new Intent();
                setResult(RESULT_OK,returnIntent);
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                setResult(RESULT_OK,returnIntent);
                finish();
            }
        });
    }
        }
