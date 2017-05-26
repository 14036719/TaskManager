package sg.edu.rp.soi.c347.taskmanager;

import java.io.Serializable;

/**
 * Created by 14036719 on 26/5/2017.
 */

public class Task implements Serializable {
    private int id;
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Task(String name, String description, int id) {

        this.name = name;
        this.description = description;
        this.id =id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
