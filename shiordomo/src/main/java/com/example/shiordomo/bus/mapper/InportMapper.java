package com.example.shiordomo.bus.mapper;

import com.example.shiordomo.bus.domain.Book;
import com.example.shiordomo.bus.domain.Inport;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 123
 * @since 2020-03-27
 */
public interface InportMapper extends BaseMapper<Inport> {

    Integer addInportBook(@Param("bookname")String bookname, @Param("press")String press, @Param("author")String author,
                             @Param("isbn")String isbn, @Param("inportprice")Double inportprice,
                             @Param("quantity")Integer quantity, @Param("productcode")String productcode);

    Integer updateInportBook(@Param("quantity")Integer quantity,@Param("bookname")String bookname);

}
