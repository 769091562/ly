package com.leyou.item.service;

import com.leyou.item.pojo.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> queryListByParent(long pid);

    List<Category> queryByBrandId(Long bid);

    List<String> queryNameByIds(List<Long> ids);

    List<Category> queryCategoryByIds(List<Long> ids);
}
