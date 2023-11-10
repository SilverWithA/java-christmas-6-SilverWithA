package christmas.constants;

public enum Menu {
    양송이수프("양송이수프",6000,"에피타이저"),
    타파스("양송이수프",6000,"에피타이저"),
    시저샐러드("양송이수프",6000,"에피타이저"),

    티본스테이크("양송이수프",55000,"메인"),
    바비큐립("양송이수프",54000,"메인"),
    해산물파스타("양송이수프",35000,"메인"),
    크리스마스파스타("양송이수프",25000,"메인"),

    초코케이크("양송이수프",15000,"디저트"),
    아이스크림("양송이수프",5000,"디저트"),

    제로콜라("양송이수프",3000,"음료"),
    레드와인("양송이수프",60000,"음료"),
    샴페인("양송이수프",25000,"음료");

    private final String name;
    private final int price;
    private final String type;
    private Menu(String name, int price, String type){
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

    public int getPrice() {
        return price;
    }
}
