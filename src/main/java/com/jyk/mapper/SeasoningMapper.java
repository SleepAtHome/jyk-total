package com.jyk.mapper;

import com.jyk.dao.Seasoning;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : Jing Yuankui
 * @description : 调料Mapper
 * @date : Created in 2024/7/28 14:01
 */
@Mapper
public interface SeasoningMapper {
    List<Seasoning> selectAllSeasoning();

    List<Seasoning> selectSeasoningByNameLike(@Param("name") String name);

    int insertSeasoning(Seasoning seasoning);
}
