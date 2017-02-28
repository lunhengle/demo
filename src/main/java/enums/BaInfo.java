package enums;

import java.util.HashMap;
import java.util.Map;

/**
 * ba 信息.
 * Created by lunhengle on 2017/2/21.
 */
public enum BaInfo {
    BA_INFO_ROLE_CODE_TRAINER(1),
    BA_INFO_ROLE_CODE_COACH(2),
    BA_INFO_ROLE_CODE_CLERK(3),
    BA_INFO_ROLE_CODE_CONSUMER(4);
    private int value;

    BaInfo(final int v) {
        this.value = v;
    }

    public final int getValue() {
        return this.value;
    }

    public static final Map<Integer, String> getTypes() {
        Map<Integer, String> map = new HashMap();
        map.put(BA_INFO_ROLE_CODE_TRAINER.value, "培训师");
        map.put(BA_INFO_ROLE_CODE_COACH.value, "COACH");
        map.put(BA_INFO_ROLE_CODE_CLERK.value, "店员");
        map.put(BA_INFO_ROLE_CODE_CONSUMER.value, "消费者");
        return map;
    }
}
