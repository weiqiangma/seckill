package com.example.seckill.controller;

import com.example.seckill.entity.SkOrder;
import com.example.seckill.service.SkOrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SkOrder)表控制层
 *
 * @author makejava
 * @since 2020-06-24 09:15:22
 */
@RestController
@RequestMapping("skOrder")
public class SkOrderController {
    /**
     * 服务对象
     */
    @Resource
    private SkOrderService skOrderService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SkOrder selectOne(Long id) {
        return this.skOrderService.queryById(id);
    }

}