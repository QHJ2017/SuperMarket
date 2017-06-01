package main.java;

import java.util.ArrayList;

/**
 * Created by ArtistQiu on 2017/6/1.
 */
public class CreateGoods {
    public static ArrayList<Good> createGoods(String[] goods) {
        ArrayList<Good> arrayList_goods = new ArrayList<>();
        for (int i = 0; i < goods.length; i++) {
            arrayList_goods.add(new Good(goods[i]));
        }
        return arrayList_goods;
    }
}
