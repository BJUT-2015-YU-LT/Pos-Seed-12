package run;


import domains.Item;
import domains.ShoppingChart;
import domains.ShoppingListChart;
import domains.Pos;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by 枫 on 2016/1/5 0005.
 */
public class Run {
    public static void main(String[] args) throws Exception {
        Run run = new Run();
        ShoppingChart shoppingChart = run.Index();
        ShoppingListChart shoppingListChart = new ShoppingListChart(shoppingChart);
        Pos pos = new Pos();
        String result = pos.getShoppingList(shoppingListChart);
        System.out.println(result);
    }
    /*
    功能：根据索引表导出购物清单，创建商品对象
    参数：无
    返回值：购物车清单ShoppingChart，若读取时出错，则跳过该清单并提示出错的编码barCode
    */
    public ShoppingChart Index() throws  Exception
    {
        Run run = new Run();
        String pathindex = "C:\\Users\\hp\\IdeaProjects\\Pos\\index.json";
        String JsonContext = run.ReadFile(pathindex);
        String pathlist = "C:\\Users\\hp\\IdeaProjects\\Pos\\list.json";
        String JsonContextlist = run.ReadFile(pathlist);
        JSONArray jsonArray = JSONArray.fromObject(JsonContext);
        JSONArray jsonArraylist = JSONArray.fromObject(JsonContextlist);
        ShoppingChart shoppingChart=new ShoppingChart();
        int size = jsonArray.size();
        for(int i=0;i<size;i++)
        {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String barCode=jsonObject.getString("barcode");
            double price = Double.parseDouble(jsonObject.getString("price"));
            double discount;
            Item item;
            if(jsonObject.getString("isdiscount").equals("true"))
                discount = Double.parseDouble(jsonObject.getString("discount"));
            else
                discount = 1.0;
            item = new Item(barCode,jsonObject.getString("name"),jsonObject.getString("unit"),price,
                    discount,jsonObject.getBoolean("isdiscount"),jsonObject.getBoolean("promotion"));
            if(!item.iseffect())
            {
                System.out.println("Discount or price has wrong,barcode"+item.getBarCode());
            }
            if(!item.isNull()){
                int j = 0;
                while(j<jsonArraylist.size()) {
                    if (jsonArraylist.get(j).equals(item.getBarCode())) {
                        shoppingChart.add(item);
                    }
                    j++;
                }
            }
            else {
                System.out.println("Read error,item barcode: " + barCode);
            }
        }
        return  shoppingChart;
    }
    /*
    功能：通过文件路径打开文件并读取内容
    参数：文件路径path
    返回值：文件内容
     */
    public String ReadFile(String path){
        File file = new File(path);
        BufferedReader reader = null;
        String laststr = "";
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                laststr = laststr+tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return laststr;
    }

}
