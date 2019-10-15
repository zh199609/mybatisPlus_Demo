package com.zl.entity.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 * @Package: com.zl.entity.enums
 * @ClassName: Sex
 * @Author: luzhiwei
 * @Description: TODO
 * @Date: 2019/7/2 14:10
 * @Version: 1.0
 */
public enum Sex implements IEnum<Integer> {
    male(1, "男"),
    female(0, "女");

    private final int value;
    private final String desc;

    Sex(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }
}
