package com.example.seckill.service.impl;

import com.example.seckill.entity.SkUser;
import com.example.seckill.dao.SkUserDao;
import com.example.seckill.model.UserSession;
import com.example.seckill.service.SkUserService;
import com.example.seckill.utils.BaseResult;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * (SkUser)表服务实现类
 *
 * @author makejava
 * @since 2020-06-24 09:29:23
 */
@Service("skUserService")
public class SkUserServiceImpl implements SkUserService {
    @Resource
    private SkUserDao skUserDao;
    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SkUser queryById(Object id) {
        return this.skUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SkUser> queryAllByLimit(int offset, int limit) {
        return this.skUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param skUser 实例对象
     * @return 实例对象
     */
    @Override
    public SkUser insert(SkUser skUser) {
        this.skUserDao.insert(skUser);
        return skUser;
    }

    /**
     * 修改数据
     *
     * @param skUser 实例对象
     * @return 实例对象
     */
    @Override
    public SkUser update(SkUser skUser) {
        this.skUserDao.update(skUser);
        return this.queryById(skUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Object id) {
        return this.skUserDao.deleteById(id) > 0;
    }

    /**
     * 根据条件查询用户
     * @param user
     * @return
     */
    @Override
    public BaseResult login(SkUser user) {
        List<SkUser> list = skUserDao.getUserByNameAndPassWord(user);
        if(list.size() > 0 ) {
            UserSession session = new UserSession();
            Integer id = list.get(0).getId();
            String name = list.get(0).getNickname();
            String password = list.get(0).getPassword();
            String token = id.toString() + name;
            session.setUserId(id);
            session.setUserName(name);
            session.setPassword(password);
            session.setTokne(token);
            redisTemplate.opsForValue().set(token, session,5, TimeUnit.MINUTES);
            return new BaseResult(list);
        }
        return BaseResult.erro("用户名或密码错误");
    }
}