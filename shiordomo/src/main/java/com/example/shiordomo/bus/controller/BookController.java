package com.example.shiordomo.bus.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.shiordomo.bus.domain.Book;
import com.example.shiordomo.bus.service.BookService;
import com.example.shiordomo.bus.vo.BookVo;
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
 * @since 2020-03-25
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    /**
     * 查询
     */
    @RequestMapping("loadAllBook")
    public DataGridView loadAllBook(BookVo bookVo) {
        System.out.println("成功进入bookLoadController");
        IPage<Book> page = new Page<>(bookVo.getPage(), bookVo.getLimit());
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();

        queryWrapper.like(StringUtils.isNotBlank(bookVo.getBookname()), "bookname", bookVo.getBookname());
        queryWrapper.like(StringUtils.isNotBlank(bookVo.getIsbn()), "isbn", bookVo.getIsbn());
        queryWrapper.like(StringUtils.isNotBlank(bookVo.getPress()), "press", bookVo.getPress());
        this.bookService.page(page, queryWrapper);
        List<Book> records = page.getRecords();
        System.out.println("records里数据:"+records);

        return new DataGridView(page.getTotal(), records);
    }

    /**
     * 添加
     * @param bookVo
     * @return
     */
    @RequestMapping("addBook")
    public ResultObj addBook(BookVo bookVo) {
        System.out.println("成功进入bookAddController");
        try {
            this.bookService.save(bookVo);
            return ResultObj.ADD_SUCCESS;
        }catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }

    }

    /**
     * 修改
     * @param BookVo
     * @return
     */
    @RequestMapping("updateBook")
    public ResultObj updateBook(BookVo BookVo) {

        try{
            this.bookService.updateById(BookVo);

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
    @RequestMapping("deleteBook")
    public ResultObj deleteBook(Integer id) {
        try {
            this.bookService.removeById(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }


}


