package com.shoppingmall.service;

import com.shoppingmall.common.ServerResponse;
import com.shoppingmall.pojo.Shipping;

/**
 * Created by zhenizhui on 2017/6/30.
 */
public interface IShippingService {

    ServerResponse add(Integer userId, Shipping shipping);

    ServerResponse<String> del(Integer userId,Integer shippingId);
}
