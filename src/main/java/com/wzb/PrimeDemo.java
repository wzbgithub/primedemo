package com.wzb;

import java.util.concurrent.atomic.AtomicReference;

public class PrimeDemo {
    public static int count;
    public static void main(String[] args) {

        AtomicPrime pn = new AtomicPrime();
        Thread1 t1 = pn.new Thread1(2, 250000);
        Thread1 t2 = pn.new Thread1(250000, 500000);
        Thread1 t3 = pn.new Thread1(500000, 750000);
        Thread1 t4 = pn.new Thread1(750000, 1000000);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class Thread1 extends Thread{
        private int  start;
        private int end;

        public Thread1(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            AtomicPrime primeMethod1=null;
            for (int i=start+1;i<end;i++){
                AtomicPrime primeMethod = new AtomicPrime();
                AtomicReference<AtomicPrime> atomicReference = new AtomicReference<AtomicPrime>(primeMethod);
                primeMethod1 = atomicReference.get();
                primeMethod1.isPrime(i);
            }
            System.out.println("总共有素数"+primeMethod1.count+"个");
        }


    }

}
