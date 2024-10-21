package com.todevelop.todevelop.utils;

import java.util.UUID;

public enum ResourceTypeEnum {
    MEMBER("mbr"),
    CLIENT("cli"),
    PRODUCT("prd"),
    PRODUCT_CLIENT("pdc");

    private final String prefix;

    ResourceTypeEnum(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public static String getRandomId(ResourceTypeEnum resourceType) {
        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 32);
        return resourceType.getPrefix() + "_" + uuid;
    }


    public static ResourceTypeEnum getPrefix(String prefix) {
        for (ResourceTypeEnum resourceTypeEnum : values()) {
            if (resourceTypeEnum.getPrefix().equals(prefix)) {
                return resourceTypeEnum;
            }
        }
        throw new IllegalArgumentException("Resource type not found");
    }
}
