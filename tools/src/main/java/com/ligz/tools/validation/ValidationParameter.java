package com.ligz.tools.validation;

import com.sun.istack.internal.NotNull;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 验证的实体类
 * author:ligz
 */
public class ValidationParameter implements Serializable {
    private static final long serialVersionUID = 7158911668568000392L;

    @NotNull // 不允许为空
    @Size(min = 1, max = 20) // 长度或大小范围
    private String name;

    //@NotNull(groups = ValidationService.Save.class) // 保存时不允许为空，更新时允许为空 ，表示不更新该字段
    @Pattern(regexp = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$")
    private String email;

    @Min(18) // 最小值
    @Max(100) // 最大值
    private int age;

    @Past // 必须为一个过去的时间
    private Date loginDate;

    @Future // 必须为一个未来的时间
    private Date expiryDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}