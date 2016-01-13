package domains;

/**
 * Created by 枫 on 2016/1/5 0005.
 */
import java.util.ArrayList;

public class ShoppingChart {
    private ArrayList<Item> items = new ArrayList<Item>();

    public ShoppingChart(){}

    public void add(Item item) {
        this.items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
