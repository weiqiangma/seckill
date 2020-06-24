package com.example.seckill.service.impl;

import com.example.seckill.entity.SkOrder;
import com.example.seckill.dao.SkOrderDao;
import com.example.seckill.service.SkOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SkOrder)表服务实现类
 *
 * @author makejava
 * @since 2020-06-24 09:15:22
 */
@Service("skOrderService")
public class SkOrderServiceImpl implements SkOrderService {
    @Resource
    private SkOrderDao skOrderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SkOrder queryById(Long id) {
        return this.skOrderDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SkOrder> queryAllByLimit(int offset, int limit) {
        return this.skOrderDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param skOrder 实例对象
     * @return 实例对象
     */
    @Override
    public SkOrder insert(SkOrder skOrder) {
        this.skOrderDao.insert(skOrder);
        return skOrder;
    }

    /**
     * 修改数据
     *
     * @param skOrder 实例对象
     * @return 实例对象
     */
    @Override
    public SkOrder update(SkOrder skOrder) {
        this.skOrderDao.update(skOrder);
        return this.queryById(skOrder.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.skOrderDao.deleteById(id) > 0;
    }
}