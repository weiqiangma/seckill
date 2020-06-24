package com.example.seckill.entity;

import java.io.Serializable;

/**
 * (SkOrder)实体类
 *
 * @author makejava
 * @since 2020-06-24 09:15:22
 */
public class SkOrder implements Serializable {
    private static final long serialVersionUID = 886436890636844745L;
    
    private Long id;
    
    private Long userId;
    
    private Long orderId;
    
    private Long goodsId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

}