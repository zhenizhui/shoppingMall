package com.shoppingmall.service;

import com.shoppingmall.common.ServerResponse;
import com.shoppingmall.vo.CartVo;

/**
 * Created by zhenizhui on 2017/6/25.
 */
public interface ICartService {
    ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count);
}
