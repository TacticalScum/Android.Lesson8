package ru.gb.lesson8.domain;

import java.util.ArrayList;
import java.util.List;

import ru.gb.lesson8.R;


public class InMemoryTasksRepository implements TasksRepository {

    @Override
    public List<Tasks> getAllNames() {
        ArrayList<Tasks> result = new ArrayList();
        result.add(new Tasks(R.string.task1, R.string.date1, R.string.descr1, R.string.time1, R.string.totalDescr1));
        result.add(new Tasks(R.string.task2, R.string.date2, R.string.descr2, R.string.time2, R.string.totalDescr2));
        return result;
    }
}