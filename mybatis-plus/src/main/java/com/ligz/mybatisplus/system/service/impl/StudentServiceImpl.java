package com.ligz.mybatisplus.system.service.impl;

import com.ligz.mybatisplus.system.entity.Student;
import com.ligz.mybatisplus.system.mapper.StudentMapper;
import com.ligz.mybatisplus.system.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ligz
 * @since 2019-01-15
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
