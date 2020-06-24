package com.example.seckill.service.impl;

import com.example.seckill.entity.SkOrderInfo;
import com.example.seckill.dao.SkOrderInfoDao;
import com.example.seckill.service.SkOrderInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SkOrderInfo)表服务实现类
 *
 * @author makejava
 * @since 2020-06-24 09:16:12
 */
@Service("skOrderInfoService")
public class SkOrderInfoServiceImpl implements SkOrderInfoService {
    @Resource
    private SkOrderInfoDao skOrderInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SkOrderInfo queryById(Long id) {
        return this.skOrderInfoDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SkOrderInfo> queryAllByLimit(int offset, int limit) {
        return this.skOrderInfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param skOrderInfo 实例对象
     * @return 实例对象
     */
    @Override
    public SkOrderInfo insert(SkOrderInfo skOrderInfo) {
        this.skOrderInfoDao.insert(skOrderInfo);
        return skOrderInfo;
    }

    /**
     * 修改数据
     *
     * @param skOrderInfo 实例对象
     * @return 实例对象
     */
    @Override
    public SkOrderInfo update(SkOrderInfo skOrderInfo) {
        this.skOrderInfoDao.update(skOrderInfo);
        return this.queryById(skOrderInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.skOrderInfoDao.deleteById(id) > 0;
    }
}