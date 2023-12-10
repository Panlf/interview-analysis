package com.plf.interview.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * optional 处理null的实践
 * @author Lancer
 * @date 2023-12-10
 */
public class OptionalNull {

    /**
     * 普遍来说，Optional普遍用于方法的返回类型 ， 表示方法可能不返回结果
     *
     *  不推荐使用的场景
     *      1、不应该用于类的字段 ， optional的创建和管理有一定的开销，在类中的字段使用会有一定的内存消耗，
     *         并且会使得对象的序列化变得复杂
     *      2、不应该用作方法的参数，会使得方法的使用和理解变得复杂
     *      3、不应该用作构造器参数，会迫使调用者创建Optional实例
     *      4、不应该用作集合的参数类型，集合已经可以很好的处理空值的情况，没必要使用Optional包装结合
     *      4、不建议使用.get()，容易报异常
     *      5、不建议.isPresent(){.get()}方法组合，已经显式调用，多此一举
     */
    @Test
    public void optionalUsed(){
        String value = "Lancer";

        Optional<String> optionalBox = Optional.of(value);

        System.out.println(optionalBox.isPresent());

        optionalBox.ifPresent(v-> System.out.println(v));
    }


    @Test
    public void optionalNullUsed(){
        String value = null;
        Optional<String> optionalBox = Optional.ofNullable(value);

        System.out.println(optionalBox.isPresent());
    }

    @Test
    public void optionalOrElse(){
        String value = null;
        Optional<String> optionalBox = Optional.ofNullable(value);

        // 不管 是否为空，都执行
        System.out.println(optionalBox.orElse("Default User"));

        // 为空的时候才会执行
        System.out.println(optionalBox.orElseGet(() -> "Default User"));
    }

    @Test
    public void optionalThrow(){
        String value = null;
        Optional<String> optionalBox = Optional.ofNullable(value);

        optionalBox.orElseThrow(()-> new RuntimeException("字符串不能为空"));
    }

}
