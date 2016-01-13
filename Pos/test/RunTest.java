
import domains.Pos;
import domains.ShoppingChart;
import domains.ShoppingListChart;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by gjz on 2016/1/5.
 */
public class RunTest {

    @Test
    public void testMain() throws Exception {

    }

    @Test
    public void testIndex() throws Exception {

    }

    @Test
    public void testReadFile() throws Exception {

    }
    public void test() throws Exception{

        ShoppingChart shoppingChart = new ShoppingChart();
        ShoppingListChart shoppingListChart = new ShoppingListChart(shoppingChart);
        Pos pos = new Pos();

        assertEquals(    "***商店购物清单***\n"
                + "----------------------\n"
                +" 打印时间：2016年01月05日10时05分29秒\n"
                +      "  ----------------------\n"
                + "名称：可口可乐，数量：5瓶，单价：3.00(元)，小计：15.00(元)\n"
                +        "名称：雪碧，数量：2瓶，单价：3.00(元)，小计：6.00(元)\n"
                +         "名称：电池，数量：1个，单价：2.00(元)，小计：2.00(元)\n"
                +        " **********************\n",pos.getShoppingList(shoppingListChart));
    }
}