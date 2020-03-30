package com.example.shiordomo.bus.vo;

import com.example.shiordomo.bus.domain.Book;
import com.example.shiordomo.bus.domain.Order;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OrderVo extends Order {


    private static final long serialVersionUID = 1L;

    private Integer page = 1;
    private Integer limit = 10;

}