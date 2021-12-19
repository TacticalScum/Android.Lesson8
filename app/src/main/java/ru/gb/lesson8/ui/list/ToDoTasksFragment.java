package ru.gb.lesson8.ui.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;
import java.util.zip.Inflater;


import ru.gb.lesson8.R;
import ru.gb.lesson8.domain.InMemoryTasksRepository;
import ru.gb.lesson8.domain.Tasks;

public class ToDoTasksFragment extends Fragment implements ToDoTasksView {



    public static final String ARG_TASK = "ARG_TASK";
    public static final String RESULT_KEY = "ToDoTasksFragment_RESULT";

    private LinearLayout toDoContainer;
    private TasksListPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new TasksListPresenter(this, new InMemoryTasksRepository());


    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_todo_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        toDoContainer = view.findViewById(R.id.toDoContainer);

        presenter.refresh();
    }

    @Override
    public void showTasks(List<Tasks> tasks) {

        LayoutInflater layoutInflater = getLayoutInflater();

        for (Tasks task : tasks) {

            View itemView = LayoutInflater.from(requireContext()).inflate(R.layout.item_tasks, toDoContainer, false);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Bundle data = new Bundle();
                    data.putParcelable(ARG_TASK, task);

                    getParentFragmentManager().setFragmentResult(RESULT_KEY, data);
                }
            });


            TextView taskName = itemView.findViewById(R.id.taskNameView);
            taskName.setText(task.getTaskName());

            TextView taskDate = itemView.findViewById(R.id.taskDateView);
            taskDate.setText(task.getTaskDate());

            TextView taskDescription = itemView.findViewById(R.id.taskDescriptionView);
            taskDescription.setText(task.getTaskDescription());

            TextView taskTime = itemView.findViewById(R.id.taskTimeView);
            taskTime.setText(task.getTaskTime());

            ImageView taskIcon = itemView.findViewById(R.id.taskDescriptionIconImage);
            taskIcon.setImageResource(task.getTaskIcon());

            toDoContainer.addView(itemView);
        }
    }
}