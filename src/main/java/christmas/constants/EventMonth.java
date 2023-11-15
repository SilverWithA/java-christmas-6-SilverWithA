package christmas.constants;

public enum EventMonth {
    DAY_START(1),
    DAY_END(31),
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
