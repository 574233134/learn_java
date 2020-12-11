package com.lmk.mybatis.dao;

import com.lmk.mybatis.pojo.Order;
import com.lmk.mybatis.pojo.OrderUser;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

public class OrderMapperTest {

    public SqlSession sqlSession;
    public OrderMapper orderMapper;


    @Before
    public void setUp() throws Exception {
        // mybatis-config.xml
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取sqlSession
        sqlSession = sqlSessionFactory.openSession();
        this.orderMapper = sqlSession.getMapper(OrderMapper.class);
    }

    /**
     * 一对一查询 查询订单并且查询出下单人信息
     * 方法一：核心思想扩展Order对象，来完成映射
     * */
    @Test
    public void queryOrderUserByOrderNumber() {
        OrderUser orderUser = this.orderMapper.queryOrderUserByOrderNumber("201807010001");
        System.out.println(orderUser);
    }

    /**
    * 方法二：面向对象的思想，在Order对象中添加User对象
    */
    @Test
    public void queryOrderWithUserByOrderNumber() {
        Order order = this.orderMapper.queryOrderWithUserByOrderNumber("201807010001");
        System.out.println(order.getUser());
    }

    /**
     * 一对多查询 查询订单的下单人信息和订单详情
     * */
    @Test
    public void queryOrderWithUserAndDetailByOrderNumber() throws Exception {
        Order order = orderMapper.queryOrderWithUserAndDetailByOrderNumber("201807010001");
        System.out.println(order.getUser());
        System.out.println(order.getDetailList());
    }


}