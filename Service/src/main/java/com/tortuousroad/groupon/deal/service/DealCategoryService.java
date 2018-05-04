package com.tortuousroad.groupon.deal.service;

import com.tortuousroad.groupon.deal.dao.DealCategoryDAO;
import com.tortuousroad.groupon.deal.entity.DealCategory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DealCategoryService {

    @Autowired
    private DealCategoryDAO dealCategoryDAO;

    /**********************混用**************************/

    /**
     * 查询所有分类,按顺序显示
     *
     * @return
     */
    public List<DealCategory> getCategories() {
        List<DealCategory> dealCategories = getAllWithoutDeleted();//从缓存或数据库中查询全部
        return null;
    }


    /**
     * 查询所有未删除的商品类别
     *
     * @return
     */
    private List<DealCategory> getAllWithoutDeleted() {
        List<DealCategory> allCategories = null;
        if (allCategories == null || allCategories.size() == 0) {
            allCategories = dealCategoryDAO.getAllWithoutDeleted();
        }
        return allCategories;
    }
}
