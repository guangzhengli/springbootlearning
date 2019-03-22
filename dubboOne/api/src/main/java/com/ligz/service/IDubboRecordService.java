package com.ligz.service;

import com.ligz.request.PushOrderDto;
import com.ligz.response.BaseResponse;

/**
 * author:ligz
 */
public interface IDubboRecordService {
    public BaseResponse pushOrder(PushOrderDto pushOrderDto);
}
