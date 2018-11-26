package com.leyou.item.service.impl;

import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import com.leyou.item.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> queryListByParent(long pid) {
        Category category = new Category();
        category.setParentId(pid);
        return categoryMapper.select(category);
    }

    @Override
    public List<Category> queryByBrandId(Long bid) {
        return this.categoryMapper.queryByBrandId(bid);
    }

    @Override
    public List<String> queryNameByIds(List<Long> ids) {
        List<Category> categories = this.categoryMapper.selectByIdList(ids);
        List<String> list = new ArrayList<>();
        for (Category category : categories) {
            String name = category.getName();
            list.add(name);
        }
        return list;
    }


    @Override
    public List<Category> queryCategoryByIds(List<Long> ids) {
        return categoryMapper.selectByIdList(ids);
    }
}
