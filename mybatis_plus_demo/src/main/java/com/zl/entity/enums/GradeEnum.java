package com.zl.entity.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.core.enums.IEnum;

import java.io.Serializable;

/**
 * @Package: com.zl.entity.enums
 * @ClassName: GradeEnum
 * @Author: luzhiwei
 * @Description: TODO
 * @Date: 2019/7/2 13:55
 * @Version: 1.0
 */
public enum GradeEnum {
    PRIMARY(1, "小学"),
    SECONDORY(2, "中学"),
    HIGH(3, "高中");

    GradeEnum(int code, String descp) {
        this.code = code;
        this.descp = descp;
    }

    @EnumValue
    private final int code;

    private final String descp;

    public int getCode() {
        return code;
    }

    public String getDescp() {
        return descp;
    }


}
