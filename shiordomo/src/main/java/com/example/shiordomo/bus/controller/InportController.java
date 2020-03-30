package com.example.shiordomo.bus.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.shiordomo.bus.domain.Book;
import com.example.shiordomo.bus.domain.Inport;
import com.example.shiordomo.bus.mapper.BookMapper;
import com.example.shiordomo.bus.mapper.InportMapper;
import com.example.shiordomo.bus.service.BookService;
import com.example.shiordomo.bus.service.InportService;
import com.example.shiordomo.bus.vo.InportVo;
import com.example.shiordomo.bus.vo.OrderVo;
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
 * @since 2020-03-27
 */
@RestController
@RequestMapping("/inport")
public class InportController {

    @Autowired
    private InportService inportService;
    @Autowired
    private BookService bookService;
    @Autowired
    private InportMapper inportMapper;

    @RequestMapping("loadInport")
    public DataGridView loadAllInport(InportVo inportVo) {
        IPage<Inport> page = new Page<>(inportVo.getPage(), inportVo.getLimit());
        QueryWrapper<Inport> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq(inportVo.getInporttime()!=null, "inporttime", inportVo.getInporttime());

        queryWrapper.like(StringUtils.isNotBlank(inportVo.getOperateperson()), "operateperson", inportVo.getOperateperson());
        queryWrapper.like(StringUtils.isNotBlank(inportVo.getBookname()), "bookname", inportVo.getBookname());
        queryWrapper.orderByDesc("inporttime");
        this.inportService.page(page, queryWrapper);
        List<Inport> records = page.getRecords();

        return new DataGridView(page.getTotal(), records);
    }
    /**
     * 添加
     * @param
     * @return
     */
    @RequestMapping("addInport")
    public ResultObj addInport(InportVo inportVo) {
        System.out.println("成功进入InportAddController");
        try {
            int num = 0;
            QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
            List<Book> list = new ArrayList<>();
            list = this.bookService.list(queryWrapper);
            System.out.println("inport的bookname是："+inportVo.getBookname());
           for(Book book:list)
           {
               System.out.println(book.getBookname());
               if( (inportVo.getProductcode().equals(book.getProductcode()) ) && (inportVo.getBookname().equals(book.getBookname()) )){
                   System.out.println("进入增加库存");
                   num = this.inportMapper.updateInportBook(inportVo.getQuantity(),inportVo.getBookname());
                   System.out.println("num="+num);
               }
           }
           if(num == 0){
                this.inportMapper.addInportBook(inportVo.getBookname(), inportVo.getPress(), inportVo.getAuthor(),
                        inportVo.getIsbn(), inportVo.getInportprice(), inportVo.getQuantity(), inportVo.getProductcode());
            }
            inportVo.setInporttime(new Date());
            User user=(User) WebUtils.getSession().getAttribute("user");
            inportVo.setOperateperson(user.getName());
            this.inportService.save(inportVo);
            return ResultObj.ADD_SUCCESS;
        }catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }

    }
    /**
     * 修改
     * @return
     */
    @RequestMapping("updateInport")
    public ResultObj updateBook(InportVo inportVo) {

        try{
            this.inportService.updateById(inportVo);

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
    @RequestMapping("deleteInport")
    public ResultObj deleteBook(Integer id) {
        try {
            this.inportService.removeById(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

}

