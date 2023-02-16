package com.changgou.service.goods.controller;

import com.changgou.common.pojo.Result;
import com.changgou.common.pojo.StatusCode;
import com.changgou.service.goods.pojo.Brand;
import com.changgou.service.goods.service.BrandService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author: 樊泽鑫
 * @Project: changgou_parent
 * @Pcakage: com.changgou.service.goods.controller.BrandController
 * @Date: 2023年02月13日 22:38
 * @Description:
 */

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping
    public Result<Brand> queryBrandList(){
        List<Brand> brandList = brandService.queryBrandList();
        return new Result<>(true, StatusCode.OK,"查询品牌列表成功！",brandList);
    }

    @GetMapping("/{id}")
    public Result<Brand> queryBrandById(@PathVariable Integer id){
        Brand brand = brandService.queryBrandById(id);
        return new Result<>(true,StatusCode.OK,"根据id查询品牌信息成功！",brand);
    }

    @PostMapping("/addBrand")
    public Result<String> insertBrand(@RequestBody Brand brand){
        Result<String> result = new Result<>(true, StatusCode.OK, "新增品牌成功！");
        Integer num = brandService.insertBrand(brand);
        if (num < 1 ){
            result.setFlag(false);
            result.setCode(StatusCode.ERROR);
            result.setMessage("新增品牌失败！");
        }
        return result;
    }

    @PostMapping("/updateBrand")
    public Result<String> updateBrand(@RequestBody Brand brand){
        Result<String> result = new Result<>(true, StatusCode.OK, "修改品牌成功！");
        Integer num = brandService.updateBrandById(brand);
        if (num < 1 ){
            result.setFlag(false);
            result.setCode(StatusCode.ERROR);
            result.setMessage("修改品牌失败！");
        }
        return result;
    }

    @DeleteMapping("/{id}")
    public Result<String> deleteBrandById(@PathVariable Integer id){
        Result<String> result = new Result<>(true, StatusCode.OK, "删除品牌成功！");
        Integer num = brandService.deleteBrandById(id);
        if (num < 1 ){
            result.setFlag(false);
            result.setCode(StatusCode.ERROR);
            result.setMessage("删除品牌失败！");
        }
        return result;
    }

    @GetMapping("/page/{page}/{size}")
    public Result<List<Brand>> queryBrandByPage(@RequestBody Brand brand,
                                                @PathVariable Integer page,
                                                @PathVariable Integer size){
        PageHelper.startPage(page,size);
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(brand.getName())){
            criteria.andLike("name","%"+brand.getName()+"%");
        }
        if (StringUtils.isNotBlank(brand.getLetter())){
            criteria.andEqualTo("letter",brand.getLetter());
        }
        List<Brand> brandList = brandService.queryBrandByPage(example);
        return new Result<List<Brand>>(true,StatusCode.OK,"分页条件查询成功！",brandList);
    }




}
