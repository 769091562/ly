package com.leyou.item.service;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.pojo.Brand;
import com.leyou.item.pojo.Category;
import com.leyou.item.vo.BrandVo;

import java.util.List;

public interface BrandService {
    PageResult<Brand> queryBrandByPageAndSort(Integer page, Integer rows, String sortBy, Boolean desc, String key);

    void saveBrand(Brand brand, List<Long> cids);

    List<Category> queryCategoryByBid(Long bid);

    void updateBrand(BrandVo brandVo);

    void deleteBrand(Long bid);

    List<Brand> queryBrandByCid(Long cid);

    Brand queryBrandByBid(Long id);

    List<Brand> queryBrandByIds(List<Long> ids);
}
