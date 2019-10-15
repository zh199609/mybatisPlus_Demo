package com.zl.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zl.entity.Person;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Package: com.zl.mapper
 * @ClassName: PersonMapper
 * @Author: luzhiwei
 * @Description: TODO
 * @Date: 2019/6/26 11:40
 * @Version: 1.0
 */
public interface PersonMapper extends BaseMapper<Person> {

    @Select("select id,age from person ${ew.customSqlSegment}")
    List<Person> getAll(@Param(Constants.WRAPPER) Wrapper wrapper);

    @Select("select * from person")
    IPage<Person> selectPageVo(Page page);

    @Insert("insert into person(age,name,email,create_time) values(#{age},#{name},#{email},#{createTime})")
    void savePerson(Person person);

    void deleteMy();
}
