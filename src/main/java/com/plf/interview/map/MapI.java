package com.plf.interview.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lancer
 * @date 2023/4/15
 */
public class MapI {
    public static void main(String[] args) {

        //下面的会报错
        //Map<String,List> map = new HashMap<String,List<String>>();

        //这样的 Map 泛型定义 Map<String, List> map = new HashMap<String, List<String>>();
        // Java 编译时为什么会报错呢？

        /*
        由于 Java 范型的限制，也是 Java 语言规范（JLS）的一部分，在 JLS 4.4 Type Variables 中有提到：
        “If no bound is given for a type variable, Object is assumed.”，
        所以编译器翻译则是：
            Map<String, List<Object>> map = new HashMap<String, List<String>>();
        明显地，在编译器看来，List<Object> 和 List<String> 并不是同一类型。
         */

    }
}
