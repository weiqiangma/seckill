package com.example.seckill.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Date 2020/6/24 14:17
 * @Author mawkun
 */
@Data
public class UserSession implements Serializable {
    private static final long serialVersionUID = 6922630105135340310L;
    private Integer userId;
    private String userName;
    private String password;
    private String tokne;
}
