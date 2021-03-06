package com.example.seckill.dao;

import com.example.seckill.entity.SkGoods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (SkGoods)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-24 09:12:29
 */
@Repository
public interface SkGoodsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SkGoods queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SkGoods> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param skGoods 实例对象
     * @return 对象列表
     */
    List<SkGoods> queryAll(SkGoods skGoods);

    /**
     * 新增数据
     *
     * @param skGoods 实例对象
     * @return 影响行数
     */
    int insert(SkGoods skGoods);

    /**
     * 修改数据
     *
     * @param skGoods 实例对象
     * @return 影响行数
     */
    int update(SkGoods skGoods);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}