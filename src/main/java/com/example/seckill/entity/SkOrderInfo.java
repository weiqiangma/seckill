package com.example.seckill.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (SkOrderInfo)实体类
 *
 * @author makejava
 * @since 2020-06-24 09:16:12
 */
public class SkOrderInfo implements Serializable {
    private static final long serialVersionUID = 709535677685027511L;
    
    private Long id;
    
    private Long userId;
    
    private Long goodsId;
    
    private Long deliveryAddrId;
    
    private String goodsName;
    
    private Integer goodsCount;
    
    private Double goodsPrice;
    /**
    * 订单渠道，1在线，2android，3ios
    */
    private Object orderChannel;
    /**
    * 订单状态，0新建未支付，1已支付，2已发货，3已收货，4已退款，5已完成
    */
    private Object status;
    
    private Date createDate;
    
    private Date payDate;


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

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getDeliveryAddrId() {
        return deliveryAddrId;
    }

    public void setDeliveryAddrId(Long deliveryAddrId) {
        this.deliveryAddrId = deliveryAddrId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Object getOrderChannel() {
        return orderChannel;
    }

    public void setOrderChannel(Object orderChannel) {
        this.orderChannel = orderChannel;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

}