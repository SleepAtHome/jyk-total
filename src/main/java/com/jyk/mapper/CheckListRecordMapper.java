package com.jyk.mapper;

import com.jyk.dao.CheckListRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author : Jing Yuankui
 * @description : 每日清单记录Mapper
 * @date : Created in 2024/8/15 23:07
 */
@Mapper
public interface CheckListRecordMapper {


    //List<CheckListRecord> selectMappersByCondition(CheckListRecord checkListRecord);

    List<CheckListRecord> selectTodayMappersByCondition(CheckListRecord checkListRecord);

    int insertOneMapperRecordCondition(CheckListRecord checkListRecord);

    //int updateOneMapper(CheckListRecord checkListRecord);
}
