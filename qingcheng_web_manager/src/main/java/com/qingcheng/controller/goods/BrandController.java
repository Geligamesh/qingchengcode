package com.qingcheng.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.entity.PageResult;
import com.qingcheng.entity.Result;
import com.qingcheng.pojo.goods.Brand;
import com.qingcheng.service.goods.BrandService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<Brand> findAll(){
        return brandService.findAll();
    }

    //分页查询
    @GetMapping("/findPage")
    public PageResult<Brand> findPage(int page,int size){
        return  brandService.findPage(page,size);
    }

    //条件查询
    @PostMapping("/findList")
    public List<Brand> findList( @RequestBody Map searchMap){
        return brandService.findList(searchMap);
    }

    //分页和条件查询
    @PostMapping("/findPage")
    public PageResult<Brand>  findPage(@RequestBody Map searchMap,int page,int size ){
        return brandService.findPage(searchMap,page,size);
    }

    //根据id查询商标信息
    @GetMapping("/findById")
    public Brand findById(Integer id){
        return brandService.findById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Brand brand){
        brandService.update(brand);
        return new Result();
    }

    @GetMapping("delete")
    public Result delete(Integer id){
        brandService.delete(id);
        return new Result();
    }

}
