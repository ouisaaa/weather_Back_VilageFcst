package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.domain.WeatherTMXN;

@Mapper
public interface WeatherTMXNMapper {
    @Select("select * from location.tmxn where category=#{category}")
    WeatherTMXN findTM(@Param("category") String category);

    @Insert("insert into weather.weather_TMXN(category,baseDate,baseTime,value,nx,ny) values ({category},{baseDate},{baseTime},{value},{nx},{ny})")
    int insertTM(@Param("category")String category,@Param("baseDate")String baseDate,@Param("baseTime")String baseTime,@Param("value")String value, @Param("nx")int nx, @Param("ny") int ny);

    @Delete("delete from weather_TMXN where category={category}")
    int deleteTM(@Param("category")String category);

}
