package ma.tamount.backend.utils;

import java.time.LocalDate;
import java.time.Period;

public abstract class Utils {

    private Utils() {}

    public static Integer calculateAge(LocalDate brithDate) {
        LocalDate currentDate = LocalDate.now();
        return Period.between(brithDate, currentDate).getYears();
    }
}
