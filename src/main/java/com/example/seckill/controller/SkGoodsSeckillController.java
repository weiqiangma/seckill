package com.example.seckill.controller;

import com.example.seckill.entity.SkGoodsSeckill;
import com.example.seckill.service.SkGoodsSeckillService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SkGoodsSeckill)表控制层
 *
 * @author makejava
 * @since 2020-06-24 09:15:03
 */
@RestController
@RequestMapping("skGoodsSeckill")
public class SkGoodsSeckillController {
    /**
     * 服务对象
     */
    @Resource
    private SkGoodsSeckillService skGoodsSeckillService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SkGoodsSeckill selectOne(Long id) {
        return this.skGoodsSeckillService.queryById(id);
    }

}