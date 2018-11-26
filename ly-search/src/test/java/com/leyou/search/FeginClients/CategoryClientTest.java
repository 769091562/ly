package com.leyou.search.FeginClients;

import com.leyou.item.pojo.Category;
import com.leyou.search.LySearchApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LySearchApplication.class)
public class CategoryClientTest {

    @Autowired
    private CategoryClient categoryClient;

    @Test
    public void testQueryCategories() {
        List<Category> names = this.categoryClient.queryByIds(Arrays.asList(1L, 2L, 3L));
        names.forEach(System.out::println);
    }
}