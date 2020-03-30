package com.example.shiordomo.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.example.shiordomo.sys.domain.Dept;
import com.example.shiordomo.sys.mapper.DeptMapper;
import com.example.shiordomo.sys.service.DeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 123
 * @since 2020-03-09
 */
@Service
@Transactional
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {

    /**
     * 为缓存做准备，进行重写部门的CRUD
     */
    @Override
    public Dept getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    public boolean updateById(Dept entity) {
        return super.updateById(entity);
    }

    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    @Override
    public boolean save(Dept entity) {
        return super.save(entity);
    }
}
