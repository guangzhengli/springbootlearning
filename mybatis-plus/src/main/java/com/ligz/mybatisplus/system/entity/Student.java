package com.ligz.mybatisplus.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ligz
 * @since 2019-01-15
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String className;

    private String teatherName;

    public Integer getId() {
        return id;
    }

    public Student setId(Integer id) {
        this.id = id;
        return this;
    }
    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }
    public String getClassName() {
        return className;
    }

    public Student setClassName(String className) {
        this.className = className;
        return this;
    }
    public String getTeatherName() {
        return teatherName;
    }

    public Student setTeatherName(String teatherName) {
        this.teatherName = teatherName;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
        "id=" + id +
        ", name=" + name +
        ", className=" + className +
        ", teatherName=" + teatherName +
        "}";
    }
}
