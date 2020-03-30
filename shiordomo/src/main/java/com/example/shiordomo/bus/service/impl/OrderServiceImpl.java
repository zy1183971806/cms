package com.example.shiordomo.bus.service.impl;

import com.example.shiordomo.bus.domain.Order;
import com.example.shiordomo.bus.mapper.OrderMapper;
import com.example.shiordomo.bus.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 123
 * @since 2020-03-27
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
