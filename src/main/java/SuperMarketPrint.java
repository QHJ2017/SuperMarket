package main.java;

import java.util.ArrayList;

/**
 * Created by ArtistQiu on 2017/6/1.
 */
public class SuperMarketPrint {
    public static void superMarketPrint(ArrayList<Good> goods, ArrayList<Bill> bill) {
        double price_total = 0;
        System.out.println("***<秋的店>购物清单***");
        for (int i = 0; i < bill.size(); i++) {
            String name_temp = goods.get(locationBill(bill.get(i).getBarcode(), goods)).getName();
            int count_temp = bill.get(i).getCount();
            String unit = count_temp + goods.get(locationBill(bill.get(i).getBarcode(), goods)).getUnit();
            double price_temp = goods.get(locationBill(bill.get(i).getBarcode(), goods)).getPrice();
            System.out.println("名称：" + name_temp + "，数量：" + unit + "，单价：" + price_temp
                    + "（元），小计：" + (count_temp * price_temp) + "（元）"
            );
            price_total += (count_temp * price_temp);
        }
        System.out.println("----------------------------------");
        System.out.println("总计：" + price_total);
        System.out.println("******************************");
    }

    private static int locationBill(String s, ArrayList<Good> goods) {
        for (int i = 0; i < goods.size(); i++) {
            if (goods.get(i).getBarcode().equals(s)) {
                return i;
            }
        }
        return -1;
    }
}
