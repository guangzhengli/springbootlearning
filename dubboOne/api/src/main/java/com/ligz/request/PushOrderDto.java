package com.ligz.request;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 商品下单的实体类
 * author:ligz
 */
@Data
@ToString
public class PushOrderDto implements Serializable {
    //商品id
    private Integer itemId;

    //下单数量
    private Integer total;

    //客户姓名
    private String customerName;

}
