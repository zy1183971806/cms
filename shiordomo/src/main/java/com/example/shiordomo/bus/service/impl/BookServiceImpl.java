package com.example.shiordomo.bus.service.impl;

import com.example.shiordomo.bus.domain.Book;
import com.example.shiordomo.bus.mapper.BookMapper;
import com.example.shiordomo.bus.service.BookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 123
 * @since 2020-03-25
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Override
    public boolean save(Book entity) {
        // TODO Auto-generated method stub
        return super.save(entity);
    }

    @Override
    public boolean updateById(Book entity) {
        // TODO Auto-generated method stub
        return super.updateById(entity);
    }

    @Override
    public boolean removeById(Serializable id) {
        // TODO Auto-generated method stub
        return super.removeById(id);
    }

    @Override
    public Book getById(Serializable id) {
        // TODO Auto-generated method stub
        return super.getById(id);
    }
}
