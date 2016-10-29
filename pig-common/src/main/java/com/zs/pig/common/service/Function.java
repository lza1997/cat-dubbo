package com.zs.pig.common.service;

public interface Function<T, E> {

    public T callback(E e);

}
