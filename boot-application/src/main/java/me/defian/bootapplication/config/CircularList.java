package me.defian.bootapplication.config;

import java.util.List;

public class CircularList<T> {
    private final List<T> list;
    private Integer counter = 0;

    public CircularList(List<T> list) {
        this.list = list;
    }

    public T getOne() {
        //slave 가 한개여서 예외처리
//        if (counter + 1 >= list.size()) {
//            counter = -1;
//        }
        return list.get(counter);
    }
}