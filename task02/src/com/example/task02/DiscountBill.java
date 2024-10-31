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

    public double getAbsDiscount() {
        return super.getPrice() * (Discount / 100.0);
    }
}
