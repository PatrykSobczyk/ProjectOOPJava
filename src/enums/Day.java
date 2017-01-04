package enums;

/**
 * Created by Patryk Sobczyk on 29/12/2016.
 * * enum z dniami tygodnia
 */

import java.io.Serializable;

public enum Day implements Serializable {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    @Override
    public String toString() {
        return super.toString();
    }
}
