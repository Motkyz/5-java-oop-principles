package com.example.task02;

public class DiscountBill extends Bill {
    public int Discount;

    public DiscountBill(int discount)
    {
        Discount = discount;
    }

    public int getDiscount()
    {
        return Discount;
    }

    public long getAbsDiscount() {
        return super.getPrice() * (Discount / 100);
    }

    public long getPrice() {
        return super.getPrice() - super.getPrice() * (Discount / 100);
    }
}
