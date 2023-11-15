package christmas.domain;

import christmas.constants.DecemberSpecialDays;
import christmas.utils.Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Date {
    int date;
    boolean weekend = false;
    List<DecemberSpecialDays> specialDaysInformation = DecemberSpecialDays.getSpecialDays();
    boolean specialDay = false;

    public int getDate(){
        return this.date;
    }
    public boolean getWeekend() {
        return weekend;
    }
    public boolean getSpecialDay() {
        return specialDay;
    }

    public static void isInRange(int vistitDate) {
        if (vistitDate < 1 | vistitDate > 31) {
            throw new IllegalArgumentException();
        }
    }

    public void setDate(int date) {
        this.date = date;
        isWeekend(this.date);
        isSpecialDay(this.date);
    }


    public void isWeekend(int date) {
        for (int week = 0; week < 5; week++) {
            if (date == (FIRST_DAY + (7 * week)) | date == (SECOND_DAY + (7 * week))) {
                this.weekend = true;
            }
        }
    }

    public void isSpecialDay(int date) {
        List<Integer> specialDays = arrangeSpecialDays();
        if (specialDays.contains(date)) {
            this.specialDay = true;
        }
    }

    public  List<Integer> arrangeSpecialDays(){
        List<Integer> arrangedSpecialDays = new ArrayList<>();

        for(DecemberSpecialDays specialDayInformation : specialDaysInformation){
            arrangedSpecialDays.add(specialDayInformation.getSpecialDay());
        }
        return arrangedSpecialDays;
    }

    public int canChristmasDiscount() {
        int christmasDistcountAmount = Calculator.calculateChristmasDistcount(date);
        return christmasDistcountAmount;
    }

    public int canSpecialDiscount() {
        return Calculator.calculateSpecialDiscount(specialDay);
    }

}
