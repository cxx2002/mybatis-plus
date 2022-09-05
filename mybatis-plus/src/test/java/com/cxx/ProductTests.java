package com.cxx;

import com.cxx.mapper.ProductMapper;
import com.cxx.pojo.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ProductTests {
    @Resource
    private ProductMapper productMapper;

    @Test
    void test1() {
        //模拟场景
        //1.小李获取商品价格
        Product productLi = productMapper.selectById(1);
        System.out.println("小李获取的商品价格为：" + productLi.getPrice());

        //2.小王获取商品价格
        Product productWang = productMapper.selectById(1);
        System.out.println("小王获取的商品价格为：" + productWang.getPrice());

        //3.小李修改商品价格+50
        productLi.setPrice(productLi.getPrice()+50);
        productMapper.updateById(productLi);

        //4.小王修改商品价格-30
        productWang.setPrice(productWang.getPrice()-30);
        productMapper.updateById(productWang);

        //5.老板查询商品价格
        Product productBoss = productMapper.selectById(1);
        System.out.println("老板获取的商品价格为：" + productBoss.getPrice());
    }

    @Test
    void test2() {
        //模拟场景   优化执行流程
        //1.小李获取商品价格
        Product productLi = productMapper.selectById(1);
        System.out.println("小李获取的商品价格为：" + productLi.getPrice());

        //2.小王获取商品价格
        Product productWang = productMapper.selectById(1);
        System.out.println("小王获取的商品价格为：" + productWang.getPrice());

        //3.小李修改商品价格+50
        productLi.setPrice(productLi.getPrice()+50);
        productMapper.updateById(productLi);

        //4.小王修改商品价格-30
        productWang.setPrice(productWang.getPrice()-30);
        int result = productMapper.updateById(productWang);
        if(result == 0){
            //操作失败，重试
            Product productNew = productMapper.selectById(1);
            productNew.setPrice(productNew.getPrice()-30);
            productMapper.updateById(productNew);
        }

        //5.老板查询商品价格
        Product productBoss = productMapper.selectById(1);
        System.out.println("老板获取的商品价格为：" + productBoss.getPrice());
    }


}
