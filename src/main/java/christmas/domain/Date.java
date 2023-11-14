package christmas.domain;

import christmas.utils.Calculator;

import java.util.List;
import java.util.Arrays;

public class Date {
    int date;
    int FIRST_DAY = 1;
    int SECOND_DAY = 2;
    boolean weekend = false;
    List<Integer> SPECIAL_DAYS = Arrays.asList(3, 10, 17, 24, 25, 31);
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
        if (SPECIAL_DAYS.contains(date)) {
            this.specialDay = true;
        }
    }

    public int canChristmasDiscount() {
        int christmasDistcountAmount = Calculator.calculateChristmasDistcount(date);
        return christmasDistcountAmount;
    }

    public int canSpecialDiscount() {
        return Calculator.calculateSpecialDiscount(specialDay);
    }

}
