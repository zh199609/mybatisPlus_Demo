package com.zl.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonValue;
import com.zl.entity.enums.GradeEnum;
import com.zl.entity.enums.Sex;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Package: com.zl.entity
 * @ClassName: Person
 * @Author: luzhiwei
 * @Description: TODO
 * @Date: 2019/6/26 11:39
 * @Version: 1.0
 */
public class Person implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField(strategy = FieldStrategy.NOT_EMPTY)
    private String name;
    private Integer age;
    @TableField(condition = SqlCondition.LIKE)
    @JsonValue
    private String email;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    private GradeEnum grade;

    private Sex sex;
    @TableLogic
    private Integer deleted;

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public GradeEnum getGrade() {
        return grade;
    }

    public void setGrade(GradeEnum grade) {
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                ", grade=" + grade +
                ", sex=" + sex +
                '}';
    }
}
