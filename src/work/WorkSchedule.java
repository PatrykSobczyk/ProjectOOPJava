package work;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 */
public class WorkSchedule implements Serializable {
    private List<DayAtWork> mDaysAtWorks = new ArrayList<>();

    public WorkSchedule(List<DayAtWork> daysAtWorks) {
        mDaysAtWorks = daysAtWorks;
    }

    public WorkSchedule(DayAtWork dayAtWork) {
        for (DayAtWork x : mDaysAtWorks) {
            if (x.getDay() == dayAtWork.getDay()) {
                mDaysAtWorks.remove(x);
            }
        }
        mDaysAtWorks.add(dayAtWork);
    }

    public WorkSchedule() {
        mDaysAtWorks.add(new DayAtWork());
        for (int i = 0; i < 7; i++) {
            ArrayList<String> list = new ArrayList<>();
            for (DayAtWork x : mDaysAtWorks) {
                list.add(x.getDay().toString());
            }
            DayAtWork dayAtWork = new DayAtWork();
            if (!list.contains(dayAtWork.getDay().toString())) {
                mDaysAtWorks.add(dayAtWork);
            }

        }
    }

    public WorkSchedule(DayAtWork... args) {
        for (DayAtWork x : args) {
            mDaysAtWorks.add(x);
        }
    }

    public List<DayAtWork> getDaysAtWorks() {
        return mDaysAtWorks;
    }

    public void setDaysAtWorks(List<DayAtWork> daysAtWorks) {
        mDaysAtWorks = daysAtWorks;
    }

    @Override
    public String toString() {
        String string = "";
        string += "My day at work - ";
        for (DayAtWork x : mDaysAtWorks) {
            string += x.toString();
        }
        return string;
    }
}
