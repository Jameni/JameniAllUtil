package com.jameni.allutillib.common;


public class PageNum {

    /**
     * 判断是否关闭尾部
     *
     * @Title: isHideFooder
     * @Description: TODO(...) Administrator 欧祥斌 2014-8-28
     *
     * size 数量
     * num 每页的数量
     */
    public static boolean isHideFooder(int size, int num) {

        if (size == 0 || num == 0 || size % num != 0) {

            return true;
        } else {
            return false;
        }

    }

}
