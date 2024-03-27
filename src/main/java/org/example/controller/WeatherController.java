package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.openAPI.APIResult;
import org.example.service.WeatherService;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;
    //test
    @GetMapping("/test")
    public void testGet(){
        System.out.println(weatherService.test());

    }
    //주소를 입력해 GET 요청시 DB에 좌표값 변환 후 OpenAPI 통신 하여 얻은 날씨 예보 값과 체감온도를 계산하여 다시 프론트 단으로 전송
    @GetMapping("/getWeather")
    public ResponseEntity<String> testGet2(@RequestParam String city, @RequestParam String district, @RequestParam String neighborhood){
//        System.out.println(weatherService.httpResultJSON(weatherService.searchLocation(city, district, neighborhood)));
        log.info("주소: \""+city+" "+district+" "+neighborhood+" \" 의 초단기실황 조회 요청");

        return ResponseEntity.ok().body(weatherService.httpResultJSON(weatherService.searchLocation(city, district, neighborhood)).toString());
    }

    @GetMapping("/districtList")
    public ResponseEntity<String> getDistrictList(@RequestParam String city){
        log.info("시/구/군 찾기 요청");


        return ResponseEntity.ok().body(weatherService.searchDistrict(city).toString());
    }
    @GetMapping("/neighborhoodList")
    public ResponseEntity<List<String>> getNeighborhoodList(@RequestParam String district){
        log.info("동/읍/리 찾기 요청");

        return ResponseEntity.ok().body(weatherService.searchNeighborhood(district));
    }

}