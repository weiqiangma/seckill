package com.example.seckill.service;

import com.example.seckill.entity.SkOrderInfo;
import java.util.List;

/**
 * (SkOrderInfo)表服务接口
 *
 * @author makejava
 * @since 2020-06-24 09:16:12
 */
public interface SkOrderInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SkOrderInfo queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SkOrderInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param skOrderInfo 实例对象
     * @return 实例对象
     */
    SkOrderInfo insert(SkOrderInfo skOrderInfo);

    /**
     * 修改数据
     *
     * @param skOrderInfo 实例对象
     * @return 实例对象
     */
    SkOrderInfo update(SkOrderInfo skOrderInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}