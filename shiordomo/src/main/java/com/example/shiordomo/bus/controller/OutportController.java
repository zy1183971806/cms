package com.example.shiordomo.bus.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.shiordomo.bus.domain.Book;
import com.example.shiordomo.bus.domain.Outport;
import com.example.shiordomo.bus.service.BookService;
import com.example.shiordomo.bus.service.OutportService;
import com.example.shiordomo.bus.vo.OutportVo;
import com.example.shiordomo.sys.common.DataGridView;
import com.example.shiordomo.sys.common.ResultObj;
import com.example.shiordomo.sys.common.WebUtils;
import com.example.shiordomo.sys.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 123
 * @since 2020-03-30
 */
@RestController
@RequestMapping("/bus/outport")
public class OutportController {

    @Autowired
    private OutportService outportService;

    @Autowired
    private BookService bookService;

    /**
     * 查询
     */
    @RequestMapping("loadAllOutport")
    public DataGridView loadAllOutport(OutportVo outportVo) {
        IPage<Outport> page = new Page<>(outportVo.getPage(), outportVo.getLimit());
        QueryWrapper<Outport> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(outportVo.getBookid()!=null&&outportVo.getBookid()!=0,"goodsid",outportVo.getBookid());
        queryWrapper.ge(outportVo.getOutporttime()!=null, "outputtime", outportVo.getOutporttime());

        queryWrapper.like(StringUtils.isNotBlank(outportVo.getOperateperson()), "operateperson", outportVo.getOperateperson());

        queryWrapper.orderByDesc("outporttime");
        this.outportService.page(page, queryWrapper);
        List<Outport> records = page.getRecords();
        for (Outport outport : records) {

            Book book = this.bookService.getById(outport.getBookid());
            if(null!=book) {
                outport.setBookname(book.getBookname());
            }
        }
        return new DataGridView(page.getTotal(), records);
    }

    /**
     * 添加退货信息
     */
    @RequestMapping("addOutport")
    public ResultObj addOutport(Integer id, Integer number, String remark) {
        System.out.println("成功进入InportAddController");
        try {
            int num = 0;
            QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
            List<Book> list = new ArrayList<>();
            list = this.bookService.list(queryWrapper);
            System.out.println("inport的bookname是："+OutportVo.getBookname());
            for(Book book:list)
            {
                System.out.println(book.getBookname());
                if( (OutportVo.getProductcode().equals(book.getProductcode()) ) && (OutportVo.getBookname().equals(book.getBookname()) )){
                    System.out.println("进入增加库存");
                    num = this.inportMapper.updateInportBook(OutportVo.getQuantity(),OutportVo.getBookname());
                    System.out.println("num="+num);
                }
            }
            if(num == 0){
                this.inportMapper.addInportBook(OutportVo.getBookname(), OutportVo.getPress(), OutportVo.getAuthor(),
                        OutportVo.getIsbn(), OutportVo.getInportprice(), OutportVo.getQuantity(), OutportVo.getProductcode());
            }
            OutportVo.setInporttime(new Date());
            User user=(User) WebUtils.getSession().getAttribute("user");
            OutportVo.setOperateperson(user.getName());
            this.inportService.save(OutportVo);
            return ResultObj.ADD_SUCCESS;
        }catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

}

