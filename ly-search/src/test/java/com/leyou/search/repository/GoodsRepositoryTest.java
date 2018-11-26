package com.leyou.search.repository;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.pojo.Spu;
import com.leyou.search.FeginClients.GoodsClient;
import com.leyou.search.LySearchApplication;
import com.leyou.search.pojo.Goods;
import com.leyou.search.service.SearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LySearchApplication.class)
public class GoodsRepositoryTest {
    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private GoodsClient goodsClient;

    @Autowired
    private SearchService searchService;
    //@Test
    public void createIndex(){
        // 创建索引
        this.elasticsearchTemplate.createIndex(Goods.class);
        // 配置映射
        this.elasticsearchTemplate.putMapping(Goods.class);
    }

    @Test
    public void loadData(){
        // 创建索引
        this.elasticsearchTemplate.createIndex(Goods.class);
        // 配置映射
        this.elasticsearchTemplate.putMapping(Goods.class);
        int page = 1;
        int rows = 100;
        int size = 0;
        do {
            // 查询分页数据
            PageResult<Spu> result = this.goodsClient.querySpuByPage(page, rows, true, null);
            List<Spu> spus = result.getItems();
            size = spus.size();
            // 创建Goods集合
            List<Goods> goodsList = new ArrayList<>();
            // 遍历spu
            for (Spu spu : spus) {
                try {
                    Goods goods = this.searchService.buildGoods(spu);
                    goodsList.add(goods);
                } catch (Exception e) {
                    break;
                }
            }

            this.goodsRepository.saveAll(goodsList);
            page++;
        } while (size == 100);
    }

    @Test
    public void test(){
        MyThread myThread1 = new MyThread(1,System.currentTimeMillis());
        MyThread myThread2 = new MyThread(2,System.currentTimeMillis());

        myThread1.start();
        myThread2.start();
    }

    public class MyThread extends Thread{

        private int i;

        private long currentTime;

        MyThread(int i,long currentTime){
            this.i=i;
            this.currentTime=currentTime;
        }

        @Override
        public void run() {

            for(int i=0;i<10;i++){
                System.out.println("输出"+i+currentTime);
            }

        }
    }
}