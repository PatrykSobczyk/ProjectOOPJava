package person;

import vehicles.Vehicle;
import work.WorkSchedule;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 */
public class Provider {
    private String mPESEL;
    private WorkSchedule mWorkSchedule;
    /// DRIVER CAT
    private Vehicle mVehicle;

    public String getPESEL() {
        return mPESEL;
    }

    public void setPESEL(String PESEL) {
        mPESEL = PESEL;
    }

    public WorkSchedule getWorkSchedule() {
        return mWorkSchedule;
    }

    public void setWorkSchedule(WorkSchedule workSchedule) {
        mWorkSchedule = workSchedule;
    }

    public Vehicle getVehicle() {
        return mVehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        mVehicle = vehicle;
    }
}
