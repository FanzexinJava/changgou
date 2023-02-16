package com.changgou.service.goods.service;

import com.changgou.service.goods.pojo.Brand;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author: 樊泽鑫
 * @Project: changgou_parent
 * @Pcakage: com.changgou.service.goods.service.BrandService
 * @Date: 2023年02月13日 22:41
 * @Description:
 */

public interface BrandService{

    List<Brand> queryBrandList();

    Brand queryBrandById(Integer id);

    Integer insertBrand(Brand brand);

    Integer updateBrandById(Brand brand);

    Integer deleteBrandById(Integer id);

    List<Brand> queryBrandByPage(Example example);
}
