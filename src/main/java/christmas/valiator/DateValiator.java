package christmas.valiator;

public class DateValiator {
    public static void isInRange(int Date){
        if(Date < 1 | Date > 32){
            throw new IllegalArgumentException();
        }
    }
}
