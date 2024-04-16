package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.DAO.LocationDao;
import org.example.domain.WeatherTMXN;
import org.example.mapper.LocationMapper;
import org.example.mapper.WeatherTMXNMapper;
import org.example.openAPI.APIResult;
import org.example.openAPI.openAPIRequest;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WeatherService {
    private final LocationMapper locationMapper;
    private final openAPIRequest openAPIRequest;
    private final WeatherTMXNMapper weatherTMXNMapper;

    public List<LocationDao> test(){
        return locationMapper.tester();
    }

    public LocationDao searchLocation(String city, String district, String neighborhood){
       return locationMapper.find(city, district, neighborhood);
//        openAPIRequest.openAPIRequestHttp(findLocation.getNx(), findLocation.getNy());
    }
    public JSONObject httpResultJSON(LocationDao location,String nowDate, String nowTime){
        APIResult apiResult =openAPIRequest.VilageFcst(location.getNx(), location.getNy(),nowDate,nowTime);
        //checkingData();
        return apiResult.parsingJson();
    }
//    public void checkingData(String date, String time){
//        WeatherTMXN dbTMX = searchTMX();
//        if(dbTMX.getBaseDate()==date && )
//    }
//    public WeatherTMXN searchTMX(){
//        return weatherTMXNMapper.findTM("TMX");
//    }
//    public WeatherTMXN searchTMN(){
//        return weatherTMXNMapper.findTM("TMN");
//    }

}
