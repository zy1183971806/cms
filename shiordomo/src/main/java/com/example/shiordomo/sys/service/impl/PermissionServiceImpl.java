package com.example.shiordomo.sys.service.impl;

import com.example.shiordomo.sys.domain.Permission;
import com.example.shiordomo.sys.mapper.PermissionMapper;
import com.example.shiordomo.sys.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 123
 * @since 2020-03-07
 */
@Service
@Transactional
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

}
