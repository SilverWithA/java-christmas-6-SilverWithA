package christmas.constants;

public enum EventMonth {
    MONTH_START(1),
    MONTH_END(31),
    CHIRSTMAS_DAY(25),
    FIRST_WEEKEND_DAY(1),
    SECOND_WEEKEND_DAY(2);

    private final int day;
    private EventMonth(int day){
        this.day = day;
    }

    public int getDay(){
        return day;
    }
}
