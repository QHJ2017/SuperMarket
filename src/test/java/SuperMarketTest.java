package test.java;

import main.java.*;
import org.junit.Test;
import json.*;

import java.util.ArrayList;

/**
 * Created by ArtistQiu on 2017/6/1.
 */
public class SuperMarketTest {
    @Test
    public void read_goods_Json_txt_test_1() {  //
        // 将文本类读取为Json格式
        JSONArray jsonArray = new JSONArray("[\n" +
                "                {\n" +
                "                 barcode: 'ITEM000003',\n" +
                "                 name: '苹果',\n" +
                "                  unit: '斤',\n" +
                "                  category: '食品',\n" +
                "                  subCategory: '水果',\n" +
                "                  price: 5.50\n" +
                "                }\n" +
                "                ,\n" +
                "                {\n" +
                "                  barcode: 'ITEM000001',\n" +
                "                  name: '羽毛球',\n" +
                "                  unit: '个',\n" +
                "                  category: '运动',\n" +
                "                  subCategory: '球类',\n" +
                "                  price: 1.00\n" +
                "                }\n" +
                "                ,\n" +
                "                {\n" +
                "                  barcode: 'ITEM000005',\n" +
                "                  name: '可口可乐',\n" +
                "                  unit: '瓶',\n" +
                "                  category: '食品',\n" +
                "                  subCategory: '碳酸饮料',\n" +
                "                  price: 3.00\n" +
                "                }\n" +
                "]");
        String[] strings = new String[jsonArray.length()];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = jsonArray.get(i).toString();
            System.out.println(strings[i]);
            /* 读出来格式是这样的：
            {"unit":"斤","subCategory":"水果","price":5.5,"name":"苹果","category":"食品","barcode":"ITEM000003"}
            {"unit":"个","subCategory":"球类","price":1,"name":"羽毛球","category":"运动","barcode":"ITEM000001"}
            {"unit":"瓶","subCategory":"碳酸饮料","price":3,"name":"可口可乐","category":"食品","barcode":"ITEM000005"}
             */
        }
        System.out.println(new JSONObject(strings[0]).getString("barcode"));
    }

    @Test
    public void bao_cun_yi_ge_lei() {
        // 保存一个类
        String good_temp = "{\"unit\":\"斤\",\"subCategory\":\"水果\",\"price\":5.5,\"name\":\"苹果\",\"category\":\"食品\",\"barcode\":\"ITEM000003\"}";
        Good good = new Good(good_temp);
        System.out.println(good.getBarcode());
    }

    @Test
    public void lu_ru_shang_pin_you_hua() {
        // 录入商品优化。
        JSONArray jsonArray = new JSONArray("[\n" +
                "                {\n" +
                "                 barcode: 'ITEM000003',\n" +
                "                 name: '苹果',\n" +
                "                  unit: '斤',\n" +
                "                  category: '食品',\n" +
                "                  subCategory: '水果',\n" +
                "                  price: 5.50\n" +
                "                }\n" +
                "                ,\n" +
                "                {\n" +
                "                  barcode: 'ITEM000001',\n" +
                "                  name: '羽毛球',\n" +
                "                  unit: '个',\n" +
                "                  category: '运动',\n" +
                "                  subCategory: '球类',\n" +
                "                  price: 1.00\n" +
                "                }\n" +
                "                ,\n" +
                "                {\n" +
                "                  barcode: 'ITEM000005',\n" +
                "                  name: '可口可乐',\n" +
                "                  unit: '瓶',\n" +
                "                  category: '食品',\n" +
                "                  subCategory: '碳酸饮料',\n" +
                "                  price: 3.00\n" +
                "                }\n" +
                "]");
        String[] goods = ReadJson.ReadJsonArray(jsonArray);
        System.out.println(goods[0]);
        /* 输出结果：
        {"unit":"斤","subCategory":"水果","price":5.5,"name":"苹果","category":"食品","barcode":"ITEM000003"}
         */
        ArrayList<Good> arrayList_goods = CreateGoods.createGoods(goods);
        for (int i = 0; i < arrayList_goods.size(); i++) {
            System.out.println(arrayList_goods.get(i).getBarcode());
            /*
            输出结果如下：
            ITEM000003
            ITEM000001
            ITEM000005
             */
        }
    }

    @Test
    public void du_qu_jian_dan_sao_ma_zhang_dan() {
        // 读取扫码账单，将信息存入到String[]中。
        JSONArray jsonArray = new JSONArray("[\n" +
                "    'ITEM000001',\n" +
                "    'ITEM000001',\n" +
                "    'ITEM000001',\n" +
                "    'ITEM000001',\n" +
                "    'ITEM000001',\n" +
                "    'ITEM000003',\n" +
                "    'ITEM000005',\n" +
                "    'ITEM000005',\n" +
                "    'ITEM000005'\n" +
                "]");
        String[] str = ReadJson.ReadJsonArray(jsonArray);
        System.out.println(str[0]);
    }

    @Test
    public void tian_jia_zhang_dan() {
        // 添加不带-的账单。
        JSONArray jsonArray = new JSONArray("[\n" +
                "    'ITEM000001',\n" +
                "    'ITEM000001',\n" +
                "    'ITEM000001',\n" +
                "    'ITEM000001',\n" +
                "    'ITEM000001',\n" +
                "    'ITEM000003',\n" +
                "    'ITEM000005',\n" +
                "    'ITEM000005',\n" +
                "    'ITEM000005'\n" +
                "]");
        String[] str = ReadJson.ReadJsonArray(jsonArray);
        ArrayList<Bill> bill = CreateBill.CreateBill(str);
        for (int i = 0; i < bill.size(); i++) {
            System.out.println(bill.get(i).getBarcode() + " : " + bill.get(i).getCount());
        }
    }

    @Test
    public void tian_jia_fu_za_zhang_dan() {
        // 添加带-符号的账单。
        JSONArray jsonArray = new JSONArray("[\n" +
                "    'ITEM000001',\n" +
                "    'ITEM000001',\n" +
                "    'ITEM000001',\n" +
                "    'ITEM000001',\n" +
                "    'ITEM000001',\n" +
                "    'ITEM000003-2',\n" +
                "    'ITEM000005',\n" +
                "    'ITEM000005',\n" +
                "    'ITEM000005'\n" +
                "]");
        String[] str = ReadJson.ReadJsonArray(jsonArray);
        ArrayList<Bill> bill = CreateBill.CreateBill(str);
        for (int i = 0; i < bill.size(); i++) {
            System.out.println(bill.get(i).getBarcode() + " : " + bill.get(i).getCount());
        }
        /*
        输出结果如下：
        ITEM000001 : 5
        ITEM000003 : 2
        ITEM000005 : 3
         */
    }

    @Test
    public void shu_chu_jie_guo() {
        JSONArray jsonArray = new JSONArray("[\n" +
                "                {\n" +
                "                 barcode: 'ITEM000003',\n" +
                "                 name: '苹果',\n" +
                "                  unit: '斤',\n" +
                "                  category: '食品',\n" +
                "                  subCategory: '水果',\n" +
                "                  price: 5.50\n" +
                "                }\n" +
                "                ,\n" +
                "                {\n" +
                "                  barcode: 'ITEM000001',\n" +
                "                  name: '羽毛球',\n" +
                "                  unit: '个',\n" +
                "                  category: '运动',\n" +
                "                  subCategory: '球类',\n" +
                "                  price: 1.00\n" +
                "                }\n" +
                "                ,\n" +
                "                {\n" +
                "                  barcode: 'ITEM000005',\n" +
                "                  name: '可口可乐',\n" +
                "                  unit: '瓶',\n" +
                "                  category: '食品',\n" +
                "                  subCategory: '碳酸饮料',\n" +
                "                  price: 3.00\n" +
                "                }\n" +
                "]");
        String[] goods_temp = ReadJson.ReadJsonArray(jsonArray);
        ArrayList<Good> goods = CreateGoods.createGoods(goods_temp);
        JSONArray jsonArray_bill = new JSONArray("[\n" +
                "    'ITEM000001',\n" +
                "    'ITEM000001',\n" +
                "    'ITEM000001',\n" +
                "    'ITEM000001',\n" +
                "    'ITEM000001',\n" +
                "    'ITEM000003-2',\n" +
                "    'ITEM000005',\n" +
                "    'ITEM000005',\n" +
                "    'ITEM000005'\n" +
                "]");
        String[] str = ReadJson.ReadJsonArray(jsonArray_bill);
        ArrayList<Bill> bill = CreateBill.CreateBill(str);
        SuperMarketPrint.superMarketPrint(goods, bill);
    }
}
