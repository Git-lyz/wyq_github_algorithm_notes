package com.company.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TransferExample {
    private static class Account {
        private int balance;
        private final Lock lock = new ReentrantLock();

        public Account(int balance) {
            this.balance = balance;
        }

        public void deposit(int amount) {
            lock.lock();
            try {
                balance += amount;
            } finally {
                lock.unlock();
            }
        }

        public void withdraw(int amount) {
            lock.lock();
            try {
                balance -= amount;
            } finally {
                lock.unlock();
            }
        }

        public int getBalance() {
            return balance;
        }
    }

    public static void transfer(Account from, Account to, int amount) {
        // 获取转出账户的锁
        from.lock.lock();
        try {
            // 获取转入账户的锁
            to.lock.lock();
            try {
                from.withdraw(amount);
                to.deposit(amount);
            } finally {
                // 释放转入账户的锁
                to.lock.unlock();
            }
        } finally {
            // 释放转出账户的锁
            from.lock.unlock();
        }
    }

    public static void main(String[] args) {
        Account accountA = new Account(100);
        Account accountB = new Account(200);

        // 创建多个线程进行转账操作
        Thread thread1 = new Thread(() -> transfer(accountA, accountB, 50));
        Thread thread2 = new Thread(() -> transfer(accountB, accountA, 30));

        thread1.start();
        try {
            thread1.join(); // 等待thread1执行完毕
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread2.start();

        try {
//            thread1.join();
//            thread2.join();
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 打印转账后的账户余额
        System.out.println("Account A balance: " + accountA.getBalance());
        System.out.println("Account B balance: " + accountB.getBalance());
    }
}
