package com.zl.config;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName MySqlInjector
 * @Description 自定义sql注入
 * @Date 2019/10/10 17:05
 * @Author albertzh
 **/
@Component
public class MySqlInjector extends DefaultSqlInjector {
    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);
        //增加自定义方法
        methodList.add(new MyMethod());
        return methodList;
    }
}
