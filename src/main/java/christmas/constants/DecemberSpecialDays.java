package christmas.constants;

import java.util.ArrayList;
import java.util.List;

public enum DecemberSpecialDays {
    DAY_3(3),
    DAY_10(10),
    DAY_17(17),
    DAY_24(24),
    DAY_25(25),
    DAY_31(31);

    private int specialDay;
    DecemberSpecialDays(int specialDay){
        this.specialDay = specialDay;
    }

    private static final List<DecemberSpecialDays> specialDays = new ArrayList<>();

    static {
        for(DecemberSpecialDays day : values()){
            specialDays.add(day);
        }
    }

    public static List<DecemberSpecialDays> getSpecialDays(){
        return specialDays;
    }

    public int getSpecialDay(){
        return specialDay;
    }
}
