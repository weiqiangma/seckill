package com.example.seckill.service;

import com.example.seckill.entity.SkOrder;
import java.util.List;

/**
 * (SkOrder)表服务接口
 *
 * @author makejava
 * @since 2020-06-24 09:15:22
 */
public interface SkOrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SkOrder queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SkOrder> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param skOrder 实例对象
     * @return 实例对象
     */
    SkOrder insert(SkOrder skOrder);

    /**
     * 修改数据
     *
     * @param skOrder 实例对象
     * @return 实例对象
     */
    SkOrder update(SkOrder skOrder);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}