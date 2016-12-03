package work;

import java.util.List;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 */
public class WorkSchedule {
 private List<DayAtWork> mDaysAtWorks;

    public List<DayAtWork> getDaysAtWorks() {
        return mDaysAtWorks;
    }

    public void setDaysAtWorks(List<DayAtWork> daysAtWorks) {
        mDaysAtWorks = daysAtWorks;
    }
}
