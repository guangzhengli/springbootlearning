package com.ligz.tools.validation;

/**
 * 分组验证实例
 * author:ligz
 */
public interface ValidationService { // 缺省可按服务接口区分验证场景，如：@NotNull(groups = ValidationService.class)
    @interface Save{} // 与方法同名接口，首字母大写，用于区分验证场景，如：@NotNull(groups = ValidationService.Save.class)，可选
    void save(ValidationParameter parameter);
    void update(ValidationParameter parameter);
}
