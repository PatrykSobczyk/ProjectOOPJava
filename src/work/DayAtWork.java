package work;

import enums.Day;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 * Implementuje pojedynczy dzien w pracy
 */
public class DayAtWork implements Serializable {
    private Day mDay;
    private int mStartHour;
    private int mHowManyHour;

    /**
     * Konstruktor dnia w pracy
     *
     * @param day
     * @param howManyHour
     * @param startHour
     */
    public DayAtWork(Day day, int howManyHour, int startHour) {
        mDay = day;
        mHowManyHour = howManyHour;
        mStartHour = startHour;
    }

    /**
     * Konstruktor dnia w pracy
     * @param day
     * @param howManyHour
     */
    public DayAtWork(Day day, int howManyHour) {
        mDay = day;
        mHowManyHour = howManyHour;
        mStartHour = 8;
    }

    /**
     * Losowy konstruktor dnia w pracy
     */
    public DayAtWork() {
        mDay = Day.values()[new Random().nextInt(Day.values().length)];
        mHowManyHour = (int) (Math.random() * ((15 - 2) + 1) + 2);
        mStartHour = (int) (Math.random() * (23 + 1));
    }

    /**
     * Zwraca dzien tygodnia
     * @return enum z dniem tygodnia
     */
    public Day getDay() {
        return mDay;
    }

    /**
     * Ustawia dzien tygodnia
     * @param day
     */
    public void setDay(Day day) {
        mDay = day;
    }

    /**
     * Zwrca godzine rozpoczecia
     * @return godzina rozpoczecia
     */
    public int getStartHour() {
        return mStartHour;
    }

    /**
     * Ustawia godzine rozpoczecia
     * @param startHour
     */
    public void setStartHour(int startHour) {
        mStartHour = startHour;
    }

    /**
     * Zwraca ile godzin w pracy
     * @return ile godzin w pracy
     */
    public int getHowManyHour() {
        return mHowManyHour;
    }

    /**
     * Ustawia ile godzin w pracy
     * @param howManyHour
     */
    public void setHowManyHour(int howManyHour) {
        mHowManyHour = howManyHour;
    }

    @Override
    public String toString() {
        return mDay + " start at: " + mStartHour + " for " + mHowManyHour + "hour.";
    }
}
