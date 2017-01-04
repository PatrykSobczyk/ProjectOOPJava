package work;

import enums.Day;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 */
public class DayAtWork implements Serializable {
    private Day mDay;
    private int mStartHour;
    private int mHowManyHour;

    public DayAtWork(Day day, int howManyHour, int startHour) {
        mDay = day;
        mHowManyHour = howManyHour;
        mStartHour = startHour;
    }

    public DayAtWork(Day day, int howManyHour) {
        mDay = day;
        mHowManyHour = howManyHour;
        mStartHour = 8;
    }

    public DayAtWork() {
        mDay = Day.values()[new Random().nextInt(Day.values().length)];
        mHowManyHour = (int) (Math.random() * ((15 - 2) + 1) + 2);
        mStartHour = (int) (Math.random() * (23 + 1));
    }

    public Day getDay() {
        return mDay;
    }

    public void setDay(Day day) {
        mDay = day;
    }

    public int getStartHour() {
        return mStartHour;
    }

    public void setStartHour(int startHour) {
        mStartHour = startHour;
    }

    public int getHowManyHour() {
        return mHowManyHour;
    }

    public void setHowManyHour(int howManyHour) {
        mHowManyHour = howManyHour;
    }

    @Override
    public String toString() {
        return mDay + " start at: " + mStartHour + " for " + mHowManyHour + "hour.";
    }
}
