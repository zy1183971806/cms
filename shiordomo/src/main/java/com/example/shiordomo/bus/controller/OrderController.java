package com.example.shiordomo.bus.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.example.shiordomo.bus.domain.Order;
import com.example.shiordomo.bus.mapper.OrderMapper;
import com.example.shiordomo.bus.service.OrderService;

import com.example.shiordomo.bus.vo.BookVo;
import com.example.shiordomo.bus.vo.OrderVo;
import com.example.shiordomo.sys.common.DataGridView;
import com.example.shiordomo.sys.common.ResultObj;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 123
 * @since 2020-03-27
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private  OrderMapper orderMapper;
    @Autowired
    private OrderService orderService;

    @RequestMapping("loadAllOrder")
    public DataGridView loadAllBook(OrderVo orderVo) {
        System.out.println("成功进入bookLoadController");
        IPage<Order> page = new Page<>(orderVo.getPage(), orderVo.getLimit());
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();

        queryWrapper.like(StringUtils.isNotBlank(orderVo.getBookname()), "bookname",orderVo.getBookname());
        queryWrapper.like(StringUtils.isNotBlank(orderVo.getIsbn()), "isbn", orderVo.getIsbn());
        queryWrapper.like(StringUtils.isNotBlank(orderVo.getPerson()), "isbn", orderVo.getPerson());

        this.orderService.page(page, queryWrapper);
        List<Order> records = page.getRecords();
        System.out.println("records里数据:"+records);

        return new DataGridView(page.getTotal(), records);
    }

    /**
     * 添加
     * @param
     * @return
     */
    @RequestMapping("addOrder")
    public ResultObj addBook(OrderVo orderVo) {
        System.out.println("成功进入OrderAddController");
        try {
            this.orderService.save(orderVo);
            return ResultObj.ADD_SUCCESS;
        }catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }

    }
    /**
     * 修改
     * @param orderVo
     * @return
     */
    @RequestMapping("updateOrder")
    public ResultObj updateBook(OrderVo orderVo) {

        try{
            this.orderService.updateById(orderVo);

            return ResultObj.UPDATE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("deleteOrder")
    public ResultObj deleteBook(Integer id) {
        try {
            this.orderService.removeById(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}

