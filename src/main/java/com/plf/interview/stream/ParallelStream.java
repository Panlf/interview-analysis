package com.plf.interview.stream;

import java.util.*;

/**
 * @author Lancer
 * @date 2023/4/30
 */
public class ParallelStream {

    public static void main(String[] args) {
        // 并发下ArrayList的add方法非线程安全
        List<Integer> result = new ArrayList<>();

        Set<Integer> sets = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));

        //多线程问题
        sets.parallelStream().forEach(i->{
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            result.add(i);
        });
        //结果 14 数据缺失问题
        System.out.println(result.size());


        /**
         * 解决方案
         *  1、将parallelStream改为stream，并行改串行
         *  2、使用Vector集合，Vector的add方法是安全的，用了synchronized修饰
         *  3、使用包装类List list = Collections.synchronizedList(new ArrayList())
         *  4、使用List copyOnWriteArrayList = new CopyOnWriteArrayList<>(),这个是线程安全的类，CopyOnWriteArrayList在add操作时
         *      使用ReentrantLock进行加锁，防止并发写。不过CopyOnWriteArrayList，每次add操作都是把原数组的元素拷贝一份到新数组中，
         *      然后在新数组中添加新元素，最后再把引用指向新数组。这会导致频繁的对象创建，况且数组还是需要一块连续的内存空间，如果大量add操作，
         *      慎用。
         */
    }

}
