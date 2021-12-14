package ru.gb.lesson8.ui.detail;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import ru.gb.lesson8.R;
import ru.gb.lesson8.domain.Tasks;

public class TasksDetailActivity extends AppCompatActivity {
    public static final String EXTRA_TASK = "EXTRA_TASK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks_detail);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
        } else {
            FragmentManager fm = getSupportFragmentManager();

            Tasks tasks = getIntent().getParcelableExtra(EXTRA_TASK);

            fm.beginTransaction()
                    .replace(R.id.containerDetails, TasksDetailFragment.newInstance(tasks))
                    .commit();
        }
    }
}