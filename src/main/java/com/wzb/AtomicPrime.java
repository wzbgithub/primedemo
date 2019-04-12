package com.wzb;

public class AtomicPrime extends PrimeDemo{
    public void isPrime(int i) {
        int flag = 1;
        for (int j = 2; j <= Math.ceil(Math.sqrt(i)); j++) {
            if (i % j == 0) {
                flag = 0;
            }
        }
        if (flag == 1) {

            count++;
            System.out.println(i + "是素数");
        }
    }
}
