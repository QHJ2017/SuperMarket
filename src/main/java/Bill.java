package main.java;

/**
 * Created by ArtistQiu on 2017/6/1.
 */
public class Bill {
    private String barcode;
    private int count;

    public Bill(String barcode, int count) {
        this.barcode = barcode;
        this.count = count;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
