package com.ligz.service;

import com.ligz.response.BaseResponse;

/**
 * author:ligz
 */
public interface IDubboItemService {
    public BaseResponse listItems();

    public BaseResponse listPageItems(Integer pageNo, Integer pageSize);

    public BaseResponse listPageItemsParams(Integer pageNo, Integer pageSize, String search);
}
