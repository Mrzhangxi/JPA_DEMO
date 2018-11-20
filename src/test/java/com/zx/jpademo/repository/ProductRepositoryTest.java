package com.zx.jpademo.repository;

import com.zx.jpademo.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testSave() {
        Product product = new Product();
        product.setId("005");
        product.setProductId("p001");
        product.setProductDesc("test");
        product.setProductName("testProduct1");
        product.setProductPrice(10.12);
        product.setProductStock(10);
        productRepository.save(product);
    }

    @Test
    public void testGetAll(){
        List<Product> list = productRepository.findAll();
        log.info("list: " + list.get(0).toString());
    }

    @Test
    public void testGetById() {
        Product product = productRepository.findById("001");
        log.info(product.toString());
    }

    @Test
    public void testGetAllByProductDesc(){
        List<Product> list = productRepository.findAllByProductDesc("test");
        log.info("list: " + list.toString());
    }

    @Test
    public void testUpdate(){
        Product product = new Product();
        product.setId("001");
        product.setProductId("p001");
        product.setProductDesc("test");
        product.setProductName("testProduct1");
        product.setProductPrice(10.12);
        product.setProductStock(100);
        productRepository.save(product);
    }

    @Test
    public void testDelete(){
        Product product = new Product();
        product.setId("001");
        product.setProductId("p001");
        product.setProductDesc("test");
        product.setProductName("testProduct1");
        product.setProductPrice(10.12);
        product.setProductStock(10);
        productRepository.delete(product);
    }

    @Test
    public void testPage(){
        PageRequest request = new PageRequest(1, 2);
        Page<Product> page = productRepository.findAllByProductDesc("test", request);

        System.out.println(page.getContent().toString());
        System.out.println("页面大小:" + page.getSize() + "页面从0页开始");
        System.out.println("总页面数: " + page.getTotalPages());
        System.out.println("总记录数：" + page.getTotalElements());
        System.out.println("当前页面：" + page.getNumber());
    }
}