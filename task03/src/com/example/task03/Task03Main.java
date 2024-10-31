package com.example.task03;

public class Task03Main {
    public static void main(String[] args) {
        TimeUnit unit1 = new Seconds(10000);
        printTimeUnit(unit1);

        System.out.println(TimeUnitUtils.toMillis(new Minutes(1)));
    }

    private static void printTimeUnit(TimeUnit unit) {
        System.out.println(String.format("Milliseconds: %d", unit.toMillis()));
        System.out.println(String.format("Seconds:      %d", unit.toSeconds()));
        System.out.println(String.format("Minutes:      %d", unit.toMinutes()));
        System.out.println(String.format("Hours:      %d", unit.toHours()));
    }
}
