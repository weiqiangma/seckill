package com.example.seckill.service.impl;

import com.example.seckill.entity.SkUser;
import com.example.seckill.dao.SkUserDao;
import com.example.seckill.service.SkUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SkUser)表服务实现类
 *
 * @author makejava
 * @since 2020-06-24 09:29:23
 */
@Service("skUserService")
public class SkUserServiceImpl implements SkUserService {
    @Resource
    private SkUserDao skUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SkUser queryById(Object id) {
        return this.skUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SkUser> queryAllByLimit(int offset, int limit) {
        return this.skUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param skUser 实例对象
     * @return 实例对象
     */
    @Override
    public SkUser insert(SkUser skUser) {
        this.skUserDao.insert(skUser);
        return skUser;
    }

    /**
     * 修改数据
     *
     * @param skUser 实例对象
     * @return 实例对象
     */
    @Override
    public SkUser update(SkUser skUser) {
        this.skUserDao.update(skUser);
        return this.queryById(skUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Object id) {
        return this.skUserDao.deleteById(id) > 0;
    }
}