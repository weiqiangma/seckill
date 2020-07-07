package com.example.seckill.controller;

import com.example.seckill.entity.SkGoods;
import com.example.seckill.service.SkGoodsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SkGoods)表控制层
 *
 * @author makejava
 * @since 2020-06-24 09:12:31
 */
@RestController
@RequestMapping("skGoods")
public class SkGoodsController {
    /**
     * 服务对象
     */
    @Resource
    private SkGoodsService skGoodsService;

    /**
     * 获取商品列表
     * @param goods
     * @return
     */
    @RequestMapping("list")
    public List<SkGoods> list(SkGoods goods) {
        return this.skGoodsService.list(goods);
    }

    @RequestMapping("test")
    public String test(SkGoods goods) {
        return "hello";
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SkGoods selectOne(Long id) {
        return this.skGoodsService.queryById(id);
    }

}