package com.cun.utils;

import java.util.HashMap;

public class R extends HashMap<String, Object> {

    public R() {
        put("code", 0);
        put("msg", "success");
    }

    public static R success(Object data) {
        R map = new R();
        map.put("code", 200);
        map.put("message", "success");
        map.put("data", data);
        return map;
    }

    public static R success(Object data, String msg) {
        R map = new R();
        map.put("code", 200);
        map.put("message", msg);
        map.put("data", data);
        return map;
    }

    public static R fail() {
        R map = new R();
        map.put("code", 400);
        map.put("message", "error");
        return map;
    }

    public static R fail(String msg) {
        R map = new R();
        map.put("code", 400);
        map.put("message", msg);
        return map;
    }

}