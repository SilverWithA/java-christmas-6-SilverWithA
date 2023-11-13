package christmas.constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Menu {
    양송이수프("양송이수프",6000,"에피타이저"),
    타파스("타파스",6000,"에피타이저"),
    시저샐러드("시저샐러드",6000,"에피타이저"),

    티본스테이크("티본스테이크",55000,"메인"),
    바비큐립("바비큐립",54000,"메인"),
    해산물파스타("해산물파스타",35000,"메인"),
    크리스마스파스타("크리스마스파스타",25000,"메인"),

    초코케이크("초코케이크",15000,"디저트"),
    아이스크림("아이스크림",5000,"디저트"),

    제로콜라("제로콜라",3000,"음료"),
    레드와인("레드와인",60000,"음료"),
    샴페인("샴페인",25000,"음료");

    private final String menuName;
    private final int price;
    private final String type;
    private Menu(String menuName, int price, String type){
        this.menuName = menuName;
        this.price = price;
        this.type = type;
    }


    public String getName(){
        return menuName;
    }

    public String getType(){
        return type;
    }

    public int getPrice() {
        return price;
    }

    private static final Map<String, Menu> MEUE_NAME_MAP =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(Menu::getName, Function.identity())));
    private static final Map<String, Integer> MEUE_PRICE_MAP =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(Menu::getName,Menu::getPrice)));

    private static final Map<String, String> MEUE_TYPE_MAP =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(Menu::getName,Menu::getType)));
    public static List<String> getMenuNames(){
        List<String> menuNames = new ArrayList<>();
        for(String name : MEUE_NAME_MAP.keySet()){
            menuNames.add(name);
        }
        return menuNames;
    }

    public static Integer priceOf(String menuName){
        return MEUE_PRICE_MAP.get(menuName);
    }

    public static String typeOf(String menuName){
        return MEUE_TYPE_MAP.get(menuName);
    }
}
