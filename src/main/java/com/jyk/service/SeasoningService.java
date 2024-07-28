package com.jyk.service;

import com.jyk.dao.Seasoning;
import com.jyk.vo.ResponseVo;

import java.util.List;

/**
 * @author : Jing Yuankui
 * @description : 调料Service
 * @date : Created in 2024/7/28 14:03
 */
public interface SeasoningService {
    ResponseVo<List<Seasoning>> selectAllSeasoning();
    ResponseVo<Integer> insertOneSeasoning(Seasoning seasoning);
    ResponseVo<List<Seasoning>> getSeasoningByName(String seasoningName);
}
