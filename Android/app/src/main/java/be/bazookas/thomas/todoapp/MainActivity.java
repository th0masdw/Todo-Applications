package be.bazookas.thomas.todoapp;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import be.bazookas.thomas.todoapp.db.TaskContract;
import be.bazookas.thomas.todoapp.db.TaskDBHelper;

public class MainActivity extends AppCompatActivity {

    private TaskDBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        updateUI();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_add_task) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Add a task");
            builder.setMessage("What do you want to do?");
            final EditText inputField = new EditText(this);
            builder.setView(inputField);
            builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String task = inputField.getText().toString();
                    Log.d("MainActivity", task);

                    helper = new TaskDBHelper(MainActivity.this);
                    SQLiteDatabase db = helper.getWritableDatabase();
                    ContentValues values = new ContentValues();

                    values.clear();
                    values.put(TaskContract.Columns.TASK, task);

                    db.insertWithOnConflict(TaskContract.TABLE, null, values, SQLiteDatabase.CONFLICT_IGNORE);

                    updateUI();
                }
            });

            builder.setNegativeButton("Cancel", null);

            builder.create().show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void doneTask(View view) {
        View v = (View) view.getParent();
        TextView taskTextView = (TextView) v.findViewById(R.id.task_textview);
        String task = taskTextView.getText().toString();

        String sql = String.format("DELETE FROM %s WHERE %s = '%s'", TaskContract.TABLE, TaskContract.Columns.TASK, task);

        helper = new TaskDBHelper(MainActivity.this);
        SQLiteDatabase sqlDB = helper.getWritableDatabase();
        sqlDB.execSQL(sql);
        updateUI();
    }

    private void updateUI() {
        helper = new TaskDBHelper(MainActivity.this);
        SQLiteDatabase sqlDB = helper.getReadableDatabase();
        Cursor cursor = sqlDB.query(TaskContract.TABLE, new String[]{TaskContract.Columns._ID, TaskContract.Columns.TASK}, null, null, null, null, null);

        ListAdapter adapter = new SimpleCursorAdapter(this, R.layout.task_view, cursor, new String[]{TaskContract.Columns.TASK}, new int[]{R.id.task_textview}, 0);
        ListView view = (ListView) findViewById(R.id.list);
        view.setAdapter(adapter);
    }
}
