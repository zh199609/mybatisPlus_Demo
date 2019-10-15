package com.zl.config;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * @ClassName MyMethod
 * @Description TODO
 * @Date 2019/10/10 16:53
 * @Author albertzh
 **/
public class MyMethod extends AbstractMethod {
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        String sql = "delete from " + tableInfo.getTableName() + " where id = 1";
        System.out.println("sql注入器：" + sql);
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        return this.addDeleteMappedStatement(mapperClass, "deleteMy", sqlSource);
    }
}
