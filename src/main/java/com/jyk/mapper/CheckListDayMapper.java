package com.jyk.mapper;

import com.jyk.dao.CheckListDay;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author : Jing Yuankui
 * @description : 每日清单Mapper
 * @date : Created in 2024/8/14 23:07
 */
@Mapper
public interface CheckListDayMapper {
    List<CheckListDay> selectAllMappers();


    List<CheckListDay> selectMappersByCondition(CheckListDay checkListDay);

    int insertOneMapper(CheckListDay checkListDay);

    int updateOneMapper(CheckListDay checkListDay);
}
