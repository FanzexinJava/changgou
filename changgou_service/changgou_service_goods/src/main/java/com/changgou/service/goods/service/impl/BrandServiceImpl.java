package com.changgou.service.goods.service.impl;

import com.changgou.service.goods.mapper.BrandMapper;
import com.changgou.service.goods.pojo.Brand;
import com.changgou.service.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author: 樊泽鑫
 * @Project: changgou_parent
 * @Pcakage: com.changgou.service.goods.service.impl.BrandServiceImpl
 * @Date: 2023年02月13日 22:41
 * @Description:
 */

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> queryBrandList() {
        List<Brand> brandList = brandMapper.selectAll();
        return brandList;
    }

    @Override
    public Brand queryBrandById(Integer id) {
        Brand brand = brandMapper.selectByPrimaryKey(id);
        return brand;
    }

    @Override
    public Integer insertBrand(Brand brand) {
        int num = brandMapper.insertSelective(brand);
        return num;
    }

    @Override
    public Integer updateBrandById(Brand brand) {
        int num = brandMapper.updateByPrimaryKey(brand);
        return num;
    }

    @Override
    public Integer deleteBrandById(Integer id) {
        int num = brandMapper.deleteByPrimaryKey(id);
        return num;
    }

    @Override
    public List<Brand> queryBrandByPage(Example example) {
        List<Brand> brandList = brandMapper.selectByExample(example);
        return brandList;
    }
}
