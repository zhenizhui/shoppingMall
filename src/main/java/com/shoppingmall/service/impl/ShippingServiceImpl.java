package com.shoppingmall.service.impl;

import com.google.common.collect.Maps;
import com.shoppingmall.common.ServerResponse;
import com.shoppingmall.dao.ShippingMapper;
import com.shoppingmall.pojo.Shipping;
import com.shoppingmall.service.IShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by zhenizhui on 2017/6/30.
 */
@Service("iShippingService")
public class ShippingServiceImpl implements IShippingService{

    @Autowired
    private ShippingMapper shippingMapper;

    public ServerResponse add(Integer userId, Shipping shipping) {
        shipping.setUserId(userId);
        // insert后能立刻得到id，通过shipping.getId()能得到这个id
        int rowCount = shippingMapper.insert(shipping);
        if(rowCount > 0){
            Map result = Maps.newHashMap();
            result.put("shippingId",shipping.getId());
            return ServerResponse.createBySuccess("新建地址成功",result);
        }
        return ServerResponse.createByErrorMessage("新建地址失败");
    }
}
