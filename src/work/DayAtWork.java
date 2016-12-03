package work;

import java.util.Date;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 */
public class DayAtWork {
    private Date mDate;
    private Date mStartHour;
    private Double mHowLong;

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public Date getStartHour() {
        return mStartHour;
    }

    public void setStartHour(Date startHour) {
        mStartHour = startHour;
    }

    public Double getHowLong() {
        return mHowLong;
    }

    public void setHowLong(Double howLong) {
        mHowLong = howLong;
    }
}
