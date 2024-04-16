package org.example.openAPI;

import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class APIResult {
    private JSONArray jsonArray;


    public APIResult(JSONArray jsonArray){
        this.jsonArray=new JSONArray(jsonArray);
    }

    //openAPI 응답값 + 체감온도 형태의 JSON
    public JSONObject parsingJson(){
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("response_source","VilageFcst");


        jsonObject.put("weather_data",dateRefactoring(jsonArray.getJSONObject(0).getString("baseDate")));

        return jsonObject;
    }

    public JSONObject dateRefactoring(String strDate){
        LocalDate date = LocalDate.parse(strDate, DateTimeFormatter.ofPattern("yyyyMMdd"));
        String basisDate;
        String currentTime= LocalTime.now().getHour()+"00";
        String[] label={"today","tomorrow","threeDays"};

        JSONObject result = new JSONObject();
        JSONArray list;

        for(int j=0;j<3;j++){
            basisDate=date.plusDays(j).format(DateTimeFormatter.BASIC_ISO_DATE);
//            System.out.println(basisDate);
//            System.out.println(jsonArray.getJSONObject(0).getString("fcstDate").equals(basisDate));
            list=new JSONArray();
            if(j==0){
                for(int i=0;i<jsonArray.length();i++){
                    if(jsonArray.getJSONObject(i).getString("fcstDate").equals(basisDate)&&
                            Integer.parseInt(jsonArray.getJSONObject(i).getString("fcstTime"))>=Integer.parseInt(currentTime)
                    ){
                        list.put(jsonArray.getJSONObject(i));
                    }
                }
            }else{
                for(int i=0;i<jsonArray.length();i++){
                    if(jsonArray.getJSONObject(i).getString("fcstDate").equals(basisDate)){
                        list.put(jsonArray.getJSONObject(i));
                    }
                }
            }
            result.put(label[j],list);
        }
        return result;
    }

}
