package ru.gb.lesson8.ui.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import ru.gb.lesson8.R;
import ru.gb.lesson8.domain.Tasks;

public class TasksDetailFragment extends Fragment {
    private static final String ARG_TASKS = "ARG_TASKS";

    public static TasksDetailFragment newInstance(Tasks tasks) {
        TasksDetailFragment fragment = new TasksDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_TASKS, tasks);
        fragment.setArguments(args);
        return fragment;
    }

    public TasksDetailFragment() {
        super(R.layout.fragment_tasks_detail);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Tasks taskName = requireArguments().getParcelable(ARG_TASKS);

        TextView taskNameDetail = view.findViewById(R.id.taskNameDetail);
        taskNameDetail.setText(taskName.getTaskName());

        TextView taskDescriptionDetail = view.findViewById(R.id.taskDescriptionDetail);
        taskDescriptionDetail.setText(taskName.getTaskTotalDescription());
    }
}