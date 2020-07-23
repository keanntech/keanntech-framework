package com.keanntech.framework.common.util;

import com.baidu.fsg.uid.UidGenerator;

public class UidGeneratorUtil {

    public static long getUid() {
        UidGenerator uidGenerator = SpringBeanUtil.getBean(UidGenerator.class);
        return uidGenerator.getUID();
    }

}
