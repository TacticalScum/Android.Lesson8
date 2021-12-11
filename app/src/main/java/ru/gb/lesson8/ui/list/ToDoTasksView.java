package ru.gb.lesson8.ui.list;

import java.util.List;

import ru.gb.lesson8.domain.Tasks;

public interface ToDoTasksView {

    void showTasks(List<Tasks> tasks);
}