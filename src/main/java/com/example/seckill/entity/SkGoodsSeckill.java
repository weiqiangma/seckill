package com.example.seckill.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (SkGoodsSeckill)实体类
 *
 * @author makejava
 * @since 2020-06-24 09:15:03
 */
public class SkGoodsSeckill implements Serializable {
    private static final long serialVersionUID = 624335210330473952L;
    /**
    * 秒杀商品id
    */
    private Long id;
    /**
    * 商品id
    */
    private Long goodsId;
    /**
    * 秒杀价
    */
    private Double seckillPrice;
    /**
    * 库存数量
    */
    private Integer stockCount;
    /**
    * 秒杀开始时间
    */
    private Date startDate;
    /**
    * 秒杀结束时间
    */
    private Date endDate;
    /**
    * 并发版本控制
    */
    private Integer version;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Double getSeckillPrice() {
        return seckillPrice;
    }

    public void setSeckillPrice(Double seckillPrice) {
        this.seckillPrice = seckillPrice;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}