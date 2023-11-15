package christmas.domain;

import christmas.constants.DecemberSpecialDays;
import christmas.constants.EventMonth;
import christmas.utils.Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Date {
    int vistitDate;
    boolean weekendOrNot = false;
    boolean specialDayOrNot = false;
    List<DecemberSpecialDays> specialDaysInformation = DecemberSpecialDays.getSpecialDays();


    public int getVisitdate() {
        return this.vistitDate;
    }

    public boolean getSpecialDayOrNot() {
        return specialDayOrNot;
    }

    public static void isInRange(int vistitDate) {
        if (vistitDate < EventMonth.DAY_START.getDay()
                | vistitDate > EventMonth.DAY_END.getDay()) {
            throw new IllegalArgumentException();
        }
    }

    public void setVistitDate(int vistitDate) {
        this.vistitDate = vistitDate;
        isWeekend(this.vistitDate);
        isSpecialDay(this.vistitDate);
    }

    public boolean getWeekendOrNot() {
        return weekendOrNot;
    }


    public void isWeekend(int vistitDate) {
        List<Integer> weekendDays = arrangeWeekendDays();
        if (weekendDays.contains(vistitDate)) {
            this.weekendOrNot = true;
        }
    }

    public List<Integer> arrangeWeekendDays() {
        List<Integer> arrangedWeekendDays = new ArrayList<>();
        int FirstWeekendDay = EventMonth.FIRST_WEEKEND_DAY.getDay();
        int SecondWeekendDay = EventMonth.SECOND_WEEKEND_DAY.getDay();

        for (int week = 0; week < 5; week++) {
            arrangedWeekendDays.add(FirstWeekendDay + (7 * week));
            arrangedWeekendDays.add(SecondWeekendDay + (7 * week));
        }
        return arrangedWeekendDays;
    }

    public void isSpecialDay(int vistitDate) {
        List<Integer> specialDays = arrangeSpecialDays();
        if (specialDays.contains(vistitDate)) {
            this.specialDayOrNot = true;
        }
    }

    public List<Integer> arrangeSpecialDays() {
        List<Integer> arrangedSpecialDays = new ArrayList<>();

        for (DecemberSpecialDays specialDayInformation : specialDaysInformation) {
            arrangedSpecialDays.add(specialDayInformation.getSpecialDay());
        }
        return arrangedSpecialDays;
    }

    public int canChristmasDiscount() {
        int christmasDistcountAmount = Calculator.calculateChristmasDistcount(vistitDate);
        return christmasDistcountAmount;
    }

    public int canSpecialDiscount() {
        return Calculator.calculateSpecialDiscount(specialDayOrNot);
    }

}
