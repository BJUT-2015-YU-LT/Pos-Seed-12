package domains;

import java.math.BigDecimal;

/**
 * Created by 枫 on 2016/1/5 0005.
 */
public class ListItem extends Item{
    private int amount;
    private double subTotal;
    private double saveMoney;
    private boolean canPromotion;
    private int num;
    public ListItem(Item item) {
        this.barCode = item.barCode;
        this.name = item.name;
        this.unit = item.unit;
        this.price = item.price;
        this.discount = item.discount;
        this.amount = 1;
        this.subTotal = this.price*this.discount;
        BigDecimal b1 = new BigDecimal(Double.toString(1));
        BigDecimal b2 = new BigDecimal(Double.toString(discount));
        double a = b1.subtract(b2).doubleValue();
        this.saveMoney = this.price*a;
        this.canPromotion = item.promotion;
        this.num = 0;
    }

    public void add()
    {
        this.amount+=1;
        this.subTotal+=this.price*this.discount;
        this.saveMoney+=this.price*(1-this.discount);
        this.num = this.amount/3;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getSaveMoney() {
        return saveMoney;
    }

    public void setSaveMoney(double saveMoney) {
        this.saveMoney = saveMoney;
    }

    public int getNum() {return  num;}

    public void setNum(int num) { this.num = num; }

    public boolean canBePromotion()
    {
        return canPromotion;
    }

    public void getResult() {
        subTotal-=num*price;
        saveMoney+=num*price;
    }
}
