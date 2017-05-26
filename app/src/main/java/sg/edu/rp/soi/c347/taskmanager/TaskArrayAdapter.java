package sg.edu.rp.soi.c347.taskmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 14036719 on 26/5/2017.
 */

public class TaskArrayAdapter {
    Context context;
    transient
    ArrayList<Task> tasks;
    TextView tvName, tvDescription;
    int resource;


    public TaskArrayAdaptor(Context context, int resource, ArrayList<Task> tasks) {
        super(context, resource, tasks);
        this.context = context;
        this.tasks = tasks;
        this.resource = resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(resource, parent, false);
        //Match the UI components with Java variables
        tvName = (TextView)rowView.findViewById(R.id.tvName);
        tvDescription = (TextView)rowView.findViewById(R.id.tvDescription);

        Task task = tasks.get(position);
        tvName.setText((position+1)+" "+task.getName());
        tvDescription.setText(task.getDescription());

        return rowView;
    }
}
