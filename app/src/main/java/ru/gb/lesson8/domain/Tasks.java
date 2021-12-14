package ru.gb.lesson8.domain;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.StringRes;

public class Tasks implements Parcelable {

    @StringRes
    private final int TaskName;

    @StringRes
    private final int TaskDate;

    @StringRes
    private final int TaskDescription;

    @StringRes
    private final int TaskTime;

    @StringRes
    private final int TaskTotalDescription;

    public Tasks(int taskName, int taskDate, int taskDescription, int taskTime, int taskTotalDescription) {
        this.TaskName = taskName;
        this.TaskDate = taskDate;
        this.TaskDescription = taskDescription;
        this.TaskTime = taskTime;
        this.TaskTotalDescription = taskTotalDescription;
    }

    protected Tasks(Parcel in) {
        TaskName = in.readInt();
        TaskDate = in.readInt();
        TaskDescription = in.readInt();
        TaskTime = in.readInt();
        TaskTotalDescription = in.readInt();
    }

    public static final Creator<Tasks> CREATOR = new Creator<Tasks>() {
        @Override
        public Tasks createFromParcel(Parcel in) {
            return new Tasks(in);
        }

        @Override
        public Tasks[] newArray(int size) {
            return new Tasks[size];
        }
    };

    public int getTaskName() {
        return TaskName;
    }

    public int getTaskDate() {
        return TaskDate;
    }

    public int getTaskDescription() {
        return TaskDescription;
    }

    public int getTaskTime() {
        return TaskTime;
    }

    public int getTaskTotalDescription() {
        return TaskTotalDescription;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(TaskName);
        dest.writeInt(TaskDate);
        dest.writeInt(TaskDescription);
        dest.writeInt(TaskTime);
        dest.writeInt(TaskTotalDescription);
    }
}
