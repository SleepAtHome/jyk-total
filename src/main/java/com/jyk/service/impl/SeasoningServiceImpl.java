package com.jyk.service.impl;

import com.jyk.dao.Food;
import com.jyk.dao.Seasoning;
import com.jyk.enums.ResponseEnum;
import com.jyk.mapper.SeasoningMapper;
import com.jyk.service.SeasoningService;
import com.jyk.vo.ResponseVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author : Jing Yuankui
 * @description : 调料Service实现类
 * @date : Created in 2024/7/28 14:04
 */
@Service
public class SeasoningServiceImpl implements SeasoningService {

    @Autowired
    SeasoningMapper seasoningMapper;

    @Override
    public ResponseVo<List<Seasoning>> selectAllSeasoning() {
        List<Seasoning> seasonings = seasoningMapper.selectAllSeasoning();
        return ResponseVo.success(seasonings);
    }

    @Override
    public ResponseVo<Integer> insertOneSeasoning(Seasoning seasoning) {
        boolean paramResult = checkParam(seasoning);

        if (!paramResult) {
            return ResponseVo.error(ResponseEnum.PARAM_ERROR);
        }

        // 如果更新人或者创建人为空，默认为景元奎
        if (StringUtils.isEmpty(seasoning.getUpdateBy()) || StringUtils.isEmpty(seasoning.getCreateBy())) {
            seasoning.setUpdateBy("景元奎");
            seasoning.setCreateBy("景元奎");
        }
        Date date = new Date();
        seasoning.setCreateTime(date);
        seasoning.setUpdateTime(date);

        int result = seasoningMapper.insertSeasoning(seasoning);

        if (1 == result) {
            return ResponseVo.success(result);
        }
        return ResponseVo.error(result);
    }

    @Override
    public ResponseVo<List<Seasoning>> getSeasoningByName(String seasoningName) {
        List<Seasoning> seasonings = seasoningMapper.selectSeasoningByNameLike(seasoningName);
        return ResponseVo.success(seasonings);
    }

    /**
     * 校验入参
     * @param seasoning
     * @return
     */
    private boolean checkParam(Seasoning seasoning) {
        boolean result = false;
        if (null != seasoning
                && !StringUtils.isEmpty(seasoning.getSeasoningName())
        ) {
            result = true;
        }
        return result;
    }
}
