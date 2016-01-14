package domains;

/**
 * Created by 枫 on 2016/1/5 0005.
 */
public class Item {
    protected String barCode;
    protected String name;
    protected String unit;
    protected double price;
    protected double discount;
    protected boolean isdiscount;
    protected boolean promotion;
    public Item(){}

    public Item(String barCode, String name, String unit, double price,double discount,boolean isdiscount,boolean promotion) {
        this.barCode = barCode;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.discount = discount;
        this.isdiscount = isdiscount;
        this.promotion = promotion;
    }

    public boolean isNull()
    {
        return this.barCode==null||barCode.equals("");
    }

    public boolean iseffect()//商品价格是否有效
    {
        if(discount>1||discount<0)
            return false;
        if(price<0)
            return false;
        if(isdiscount==true&&promotion==true)
            return false;
        return true;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() { return discount; }

    public void setDiscount(double discount) { this.discount = discount; }
}
