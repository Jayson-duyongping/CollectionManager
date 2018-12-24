package com.jayson.collection.util.file;

import java.util.UUID;

/**
 * 生成文件名
 */
public class UUIDUtils {
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
