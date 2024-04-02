package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.DAO.LocationDao;
import java.util.List;

@Mapper
public interface LocationMapper {
    @Select("select location.nx,location.ny from location.location")
    List<LocationDao> tester();
    @Select("select nx,ny from location.location where city=#{city} and district=#{district} and neighborhood=#{neighborhood}")
    LocationDao find(@Param("city") String city,@Param("district") String district,@Param("neighborhood") String neighborhood );
}
