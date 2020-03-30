package com.example.shiordomo.bus.mapper;

import com.example.shiordomo.bus.domain.Outport;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 123
 * @since 2020-03-30
 */
public interface OutportMapper extends BaseMapper<Outport> {
    Integer updateOutportBook(@Param("quantity")Integer quantity, @Param("bookid")String bookid);
}
