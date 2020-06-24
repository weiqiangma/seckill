package com.example.seckill.controller;

import com.example.seckill.entity.SkOrderInfo;
import com.example.seckill.service.SkOrderInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SkOrderInfo)表控制层
 *
 * @author makejava
 * @since 2020-06-24 09:16:12
 */
@RestController
@RequestMapping("skOrderInfo")
public class SkOrderInfoController {
    /**
     * 服务对象
     */
    @Resource
    private SkOrderInfoService skOrderInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SkOrderInfo selectOne(Long id) {
        return this.skOrderInfoService.queryById(id);
    }

}