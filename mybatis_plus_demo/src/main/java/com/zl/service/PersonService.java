package com.zl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zl.entity.Person;
import com.zl.mapper.PersonMapper;
import org.springframework.stereotype.Service;

/**
 * @Package: com.zl.service
 * @ClassName: PersonService
 * @Author: luzhiwei
 * @Description: TODO
 * @Date: 2019/7/2 16:20
 * @Version: 1.0
 */
@Service
public class PersonService extends ServiceImpl<PersonMapper, Person> {


}
