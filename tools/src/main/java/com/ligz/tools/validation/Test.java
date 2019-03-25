package com.ligz.tools.validation;

import java.util.Date;
import java.util.Map;

/**
 * 验证 validition和 hibernate-validator的测试
 * author:ligz
 */
public class Test {
    public static void main(String[] args) {
        ValidationParameter parameter = new ValidationParameter();

        parameter.setName("ligz");
        parameter.setAge(11);
        parameter.setExpiryDate(new Date());
        parameter.setEmail("ligz_7@163.com");

        ValidationResult result = ValidationUtils.validateEntity(parameter);

        Map<String, String> map = result.getErrorMsg();
        boolean isError = result.isHasErrors();
        System.out.println("isError: " +isError);
        System.out.println(map);

    }
}
