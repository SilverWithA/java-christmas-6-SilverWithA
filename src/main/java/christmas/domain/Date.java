package christmas.domain;

import christmas.utils.Calculator;

import java.util.List;

public class Date {
    int date;
    int FIRST_DAY = 1;
    int SECOND_DAY = 2;
    boolean weekend = false;
    List<Integer> SPECIAL_DAYS;
    boolean specialDay = false;

    // 주문 날짜
    public void setDate(int date) {
        this.date = date;
        isWeekend(this.date);
        isSpecialDay(this.date);
    }

    public boolean getWeekend(){
        return weekend;
    }



    public void isWeekend(int date) {
        for (int week = 1; week < 4; week++) {
            if (date == (FIRST_DAY + 7) * week | date == (SECOND_DAY + 7) * week) {
                this.weekend = true;
            }
        }
    }

    public void isSpecialDay(int date) {
        if(SPECIAL_DAYS.contains(date)){
            this.specialDay = true;
        }
    }

    public int canChristmasDiscount(){
        int christmasDistcountAmount = Calculator.calculateChristmasDistcount(date);
        return christmasDistcountAmount;
    }

    public int canSpecialDiscount(){
        return Calculator.calculateSpecialDiscount(specialDay);
    }

}
