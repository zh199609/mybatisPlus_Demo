package com.zl.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Package: com.zl.config
 * @ClassName: MybatisObjectHandler
 * @Author: luzhiwei
 * @Description: TODO
 * @Date: 2019/7/2 13:25
 * @Version: 1.0
 */
@Component
//entity属性自动填充（创建时间 更新时间）
public class MybatisObjectHandler implements MetaObjectHandler {
    //新增时 填充的字段
    @Override
    public void insertFill(MetaObject metaObject) {
        setFieldValByName("createTime", new Date(), metaObject);
    }

    //更新是填充的字段
    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("updateTime", new Date(), metaObject);
    }
}
