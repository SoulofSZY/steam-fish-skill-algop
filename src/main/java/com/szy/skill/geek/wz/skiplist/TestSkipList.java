package com.szy.skill.geek.wz.skiplist;

/**
 * 〈一句话功能简述〉<br>
 * 〈跳表〉
 * 跳表的一种实现方法。
 * 跳表中存储的是正整数，并且存储的是不重复的。
 *
 * @author sunzhengyu
 * @create 2019/8/29
 * @since 1.0.0
 */
public class TestSkipList {


    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        skipList.insert(1);
        skipList.insert(2);
        skipList.insert(3);
        skipList.insert(4);
        skipList.insert(5);
    }

}