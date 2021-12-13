package ru.gb.lesson8.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Layout;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentResultListener;

import com.google.android.material.navigation.NavigationView;

import ru.gb.lesson8.R;
import ru.gb.lesson8.AboutFragment;

import ru.gb.lesson8.domain.Tasks;
import ru.gb.lesson8.ui.detail.TasksDetailActivity;
import ru.gb.lesson8.ui.detail.TasksDetailFragment;
import ru.gb.lesson8.ui.list.ToDoTasksFragment;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private Layout layout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().setFragmentResultListener(ToDoTasksFragment.RESULT_KEY, this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                Tasks tasks = result.getParcelable(ToDoTasksFragment.ARG_TASK);

                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.landscape_container_details, TasksDetailFragment.newInstance(tasks))
                            .commit();
                } else {
                    Intent intent = new Intent(MainActivity.this, TasksDetailActivity.class);
                    intent.putExtra(TasksDetailActivity.EXTRA_TASK, tasks);
                    startActivity(intent);
                }
            }
        });


        drawerLayout = (DrawerLayout) findViewById(R.id.menu);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        Toolbar toolbar = findViewById(R.id.toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.about_app:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragment_container, new AboutFragment(), "AboutFragment")
                                .addToBackStack("AboutFragment")
                                .commit();

                        drawerLayout.closeDrawer(GravityCompat.START);

                        return true;
                }
                return false;
            }
        });

    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();
            showAlertDialog();

    }

    public void showAlertDialog() {

            new AlertDialog.Builder(this)
                    .setTitle(R.string.quit)
                    .setMessage(R.string.dialog_message)
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton(R.string.no, null)
                    .setCancelable(false)
                    .show();

    }
}