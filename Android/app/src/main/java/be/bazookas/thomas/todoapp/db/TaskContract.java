package be.bazookas.thomas.todoapp.db;

/**
 * Created by Administrator on 24/02/2016.
 */

import android.provider.BaseColumns;

public class TaskContract {
    public static final String DB_NAME = "be.bazookas.thomas.todoapp.db.tasks";
    public static final int DB_VERSION = 1;
    public static final String TABLE = "tasks";

    public class Columns {
        public static final String TASK = "task";
        public static final String _ID = BaseColumns._ID;
    }
}
