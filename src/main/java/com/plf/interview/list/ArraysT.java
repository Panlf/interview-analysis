package com.plf.interview.list;

import java.util.Arrays;
import java.util.List;

/**
 * @author Lancer
 * @date 2023/4/30
 */
public class ArraysT {
    public static void main(String[] args) {


        //Arrays.asList返回的ArrayList是Arrays类的内部类
        //它继承了AbstractList类，重写了很多方法，比如contains方法，但是没有重写add方法
        //所以我们调用的时候会报异常
        List<String> lists = Arrays.asList("1", "2");
        //java.lang.UnsupportedOperationException

        //lists.add("3");
    }
}
