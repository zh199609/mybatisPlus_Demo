package com.zl;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zl.entity.Person;
import com.zl.entity.enums.GradeEnum;
import com.zl.entity.enums.Sex;
import com.zl.mapper.PersonMapper;
import com.zl.service.PersonService;
import org.apache.catalina.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.annotation.security.RunAs;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package: com.zl.test
 * @ClassName: SampleTest
 * @Author: luzhiwei
 * @Description: TODO
 * @Date: 2019/6/26 11:43
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Resource
    private PersonMapper personMapper;

    @Test
    public void testSelect() {
        LambdaQueryWrapper<Person> lambda = new LambdaQueryWrapper<>();
        Person person = new Person();
        person.setId(1L);
        person.setAge(18);
        //person.setEmail("i-leizh@outlook.com");
        person.setName("Solomen");
        person.setGrade(GradeEnum.HIGH);
        person.setSex(Sex.female);
        lambda.eq(Person::getId, person.getId());
        lambda.or();
        lambda.eq(Person::getAge, person.getAge());
        //List<Person> people = personMapper.selectList(lambda);
        //System.out.println(people);
//        List<Person> all = personMapper.getAll(lambda);
//        System.out.println(all);
//         List<Person> all1 = personMapper.getAll(Wrappers.<Person>lambdaQuery().eq(Person::getId, person.getId()));
        Page<Person> page = new Page<>();
        page.setSize(1).setCurrent(2);

        IPage<Person> userIPage = personMapper.selectPageVo(page);
        System.out.println(userIPage.getRecords());

        QueryWrapper<Person> queryWrapper = new QueryWrapper<>();
        Person person1 = new Person();
        person1.setEmail("Jay@facelook.com");
        queryWrapper.setEntity(person1);

        /*List<Person> people = personMapper.selectList(queryWrapper);
        System.out.println(people);*/

        //List<Person> records = personIPage.getRecords();
        //System.out.println(records)
        //personMapper.savePerson(person);
        //personMapper.insert(person);


        UpdateWrapper<Person> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", 1);
        String sqlSet = updateWrapper.getSqlSet();
        System.out.println("sqlSet:" + sqlSet);
        personMapper.update(person, updateWrapper);

        //personMapper.updateById(person);
        System.out.println(person);
    }


    //实体对象插入数据
    @Test
    public void insert() {
        Person person = new Person();
        person.setSex(Sex.female);
        person.setGrade(GradeEnum.HIGH);
        person.setName("张磊");
        person.setEmail("solomen@face.com");
        person.setAge(23);
        //返回插入成功记录数
        int insert = personMapper.insert(person);
       /* for (int i = 1; i < 100; i++) {
            Person person = new Person();
            person.setSex(Sex.female);
            person.setGrade(GradeEnum.HIGH);
            person.setName("用户" + i + "号");
            person.setEmail("solomen@face.com");
            person.setAge(i);
            personMapper.insert(person);
        }*/
    }

    //根据记录
    @Test
    public void deleteById() {
        //删除成功记录数
        //int i = personMapper.deleteById(1L);
//        personMapper.deleteByMap(null);  根据 columnMap 条件，删除记录


        QueryWrapper<Person> wrapper = new QueryWrapper<>();
        Person person = new Person();
        person.setAge(23);
        wrapper.setEntity(person);
        personMapper.delete(wrapper);
    }


    //更新数据
    public void update() {
        Person person = new Person();

        //personMapper.updateById()
//        personMapper.update()
    }

    //查询数据
    @Test
    public void select() {
        /*Integer integer = personMapper.selectCount(null);
        System.out.println(integer);*/

        QueryWrapper<Person> wrapper = new QueryWrapper<>();
        Person person = new Person();
        person.setAge(22);
        wrapper.setEntity(person);
        List<Person> people = personMapper.selectList(wrapper);
        System.out.println(people);

    }


    //自定义sql注入
    @Test
    public void sqlInjection() {
        personMapper.deleteMy();
    }


    //条件构造器
    @Test
    public void testWrapper() {
        QueryWrapper<Person> wrapper = new QueryWrapper<>();
        //设置查询列
        wrapper.select("id", "name");
        System.out.println("select sql column" + wrapper.getSqlSelect());
        //子查询   id in (xxx,xxx,xxx)
        //wrapper.inSql("id","select xxx from table");
        Map<String, Object> map = new HashMap<>();
        map.put("id", 2);
        wrapper.allEq((s, o) -> {
                    System.out.println("key:" + s);
                    System.out.println("value:" + o);
                    return true;
                }
                , map, true);
        List<Person> people = personMapper.selectList(wrapper);
        System.out.println(people);
    }

    @Test
    public void testWrapper2() {
        QueryWrapper<Person> wrapper = new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("id", 2);
        Person person = new Person();
        person.setId(2L);
        wrapper.eq("id", 2L);
//        wrapper.or(o -> o.eq("name", "张磊"));
        wrapper.or();
        wrapper.eq("name", "张磊");
        List<Person> people = personMapper.selectList(wrapper);
        System.out.println(people);
    }

    @Test
    public void testWrapper3() {
        QueryWrapper<Person> wrapper = new QueryWrapper<>();
        //条件之间默认使用and拼接
        wrapper.eq("name", "张磊");
        wrapper.nested(personQueryWrapper ->
                personQueryWrapper.eq("id", 1)
        );
        List<Person> people = personMapper.selectList(wrapper);
        System.out.println(people);
    }

    @Test
    public void testWrapper4() {
        QueryWrapper<Person> wrapper = new QueryWrapper<>();
        Person person = new Person();
        person.setId(2L);
        person.setName("张磊");
        wrapper.setEntity(person);
        List<Person> people = personMapper.selectList(wrapper);
        System.out.println(people);
    }

    @Test
    public void testUpdateWrapper1() {
        UpdateWrapper<Person> wrapper = new UpdateWrapper<>();
        wrapper.set("name", "知你冷暖");

        wrapper.eq("id", 2L);
        //entity中的属性进行set拼接
       /* Person person = new Person();
        person.setName("张磊");*/
        int update = personMapper.update(null, wrapper);
        System.out.println("更新条数：" + update);
    }

    @Test
    public void testPageWrapper() {
        QueryWrapper<Person> wrapper = new QueryWrapper<>();
        Page<Person> page = new Page<>();
//        IPage<Person> page1 = personMapper.selectPageVo(page);
        IPage<Person> page1 = personMapper.selectPage(page, wrapper);
        System.out.println();
        page1.getRecords().forEach(System.out::println);
    }

    @Test
    //测试逻辑删除功能
    //使用wrapper进行查询或者更新是会默认添加逻辑字段
    public void testLogicDelete() {
        QueryWrapper<Person> wrapper = new QueryWrapper<>();
        wrapper.eq("id", 3L);
        int delete = personMapper.delete(wrapper);
       System.out.println("删除的行数:" + delete);
    }
}
