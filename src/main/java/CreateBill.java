package main.java;

import java.util.ArrayList;

/**
 * Created by ArtistQiu on 2017/6/1.
 */
public class CreateBill {
    /*
    本类用于将已经转换为String[]类型的以下数据新建Bill链表：
    [
        'ITEM000001',
        'ITEM000001',
        'ITEM000001',
        'ITEM000001',
        'ITEM000001',
        'ITEM000003-2',
        'ITEM000005',
        'ITEM000005',
        'ITEM000005'
    ]
     */
    public static ArrayList<Bill> CreateBill(String[] str) {
        ArrayList<Bill> bill = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            String[] str_temp = str[i].split("-");
            int location = locationBill(str_temp[0], bill);

            if (str_temp.length == 2) {  // 有个数的情况。
                if (location < 0) {  // 当前扫码不存在。
                    bill.add(new Bill(str_temp[0], Integer.parseInt(str_temp[1])));
                } else {
                    bill.get(location).setCount(bill.get(location).getCount() + Integer.parseInt(str_temp[1]));
                }
            } else {  // 无个数情况。
                if (location < 0) {  // 当前扫码项商品不存在。
                    bill.add(new Bill(str_temp[0], 1));
                } else {
                    bill.get(location).setCount(bill.get(location).getCount() + 1);
                }
            }
        }
        return bill;
    }

    private static int locationBill(String s, ArrayList<Bill> bill) {
        for (int i = 0; i < bill.size(); i++) {
            if (bill.get(i).getBarcode().equals(s)) {
                return i;
            }
        }
        return -1;
    }
}
