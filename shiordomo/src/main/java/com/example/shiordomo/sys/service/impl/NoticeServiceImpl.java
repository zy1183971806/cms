package com.example.shiordomo.sys.service.impl;

import com.example.shiordomo.sys.domain.Notice;
import com.example.shiordomo.sys.mapper.NoticeMapper;
import com.example.shiordomo.sys.service.NoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

}
