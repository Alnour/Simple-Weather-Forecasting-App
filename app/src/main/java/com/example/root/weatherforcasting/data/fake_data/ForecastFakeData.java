package com.example.root.weatherforcasting.data.fake_data;

import com.example.root.weatherforcasting.models.api_models.CityResponse;
import com.example.root.weatherforcasting.models.api_models.WeeklyResponse;
import com.google.gson.Gson;

/**
 * Created by root on 23/06/17.
 */

public class ForecastFakeData {
    public static CityResponse getSampleCityResponse(){
        String cityData = "{\n"+
                "    \"coord\": {\n"+
                "        \"lon\": -0.13,\n"+
                "        \"lat\": 51.51\n"+
                "    },\n"+
                "    \"weather\": [\n"+
                "        {\n"+
                "            \"id\": 802,\n"+
                "            \"main\": \"Clouds\",\n"+
                "            \"description\": \"scattered clouds\",\n"+
                "            \"icon\": \"03d\"\n"+
                "        }\n"+
                "    ],\n"+
                "    \"base\": \"stations\",\n"+
                "    \"main\": {\n"+
                "        \"temp\": 290,\n"+
                "        \"pressure\": 1016,\n"+
                "        \"humidity\": 63,\n"+
                "        \"temp_min\": 289.15,\n"+
                "        \"temp_max\": 291.15\n"+
                "    },\n"+
                "    \"visibility\": 10000,\n"+
                "    \"wind\": {\n"+
                "        \"speed\": 8.7,\n"+
                "        \"deg\": 270\n"+
                "    },\n"+
                "    \"clouds\": {\n"+
                "        \"all\": 44\n"+
                "    },\n"+
                "    \"dt\": 1498204200,\n"+
                "    \"sys\": {\n"+
                "        \"type\": 1,\n"+
                "        \"id\": 5091,\n"+
                "        \"message\": 0.0244,\n"+
                "        \"country\": \"GB\",\n"+
                "        \"sunrise\": 1498189425,\n"+
                "        \"sunset\": 1498249312\n"+
                "    },\n"+
                "    \"id\": 2643743,\n"+
                "    \"name\": \"London\",\n"+
                "    \"cod\": 200\n"+
                "}";
        Gson gson = new Gson();
        CityResponse dailyResponse = gson.fromJson(cityData, CityResponse.class);
        return dailyResponse;
    }

    public static WeeklyResponse getWeeklyResponse(){
        String data = "{\n" +
                "    \"city\": {\n" +
                "        \"id\": 524901,\n" +
                "        \"name\": \"Moscow\",\n" +
                "        \"coord\": {\n" +
                "            \"lon\": 37.6156,\n" +
                "            \"lat\": 55.7522\n" +
                "        },\n" +
                "        \"country\": \"RU\",\n" +
                "        \"population\": 0\n" +
                "    },\n" +
                "    \"cod\": \"200\",\n" +
                "    \"message\": 0.1066539,\n" +
                "    \"cnt\": 7,\n" +
                "    \"list\": [\n" +
                "        {\n" +
                "            \"dt\": 1498294800,\n" +
                "            \"temp\": {\n" +
                "                \"day\": 290.65,\n" +
                "                \"min\": 286.68,\n" +
                "                \"max\": 291.31,\n" +
                "                \"night\": 286.68,\n" +
                "                \"eve\": 290.99,\n" +
                "                \"morn\": 290.65\n" +
                "            },\n" +
                "            \"pressure\": 998.62,\n" +
                "            \"humidity\": 66,\n" +
                "            \"weather\": [\n" +
                "                {\n" +
                "                    \"id\": 801,\n" +
                "                    \"main\": \"Clouds\",\n" +
                "                    \"description\": \"few clouds\",\n" +
                "                    \"icon\": \"02d\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"speed\": 2.06,\n" +
                "            \"deg\": 307,\n" +
                "            \"clouds\": 20\n" +
                "        },\n" +
                "        {\n" +
                "            \"dt\": 1498381200,\n" +
                "            \"temp\": {\n" +
                "                \"day\": 291.32,\n" +
                "                \"min\": 287.51,\n" +
                "                \"max\": 292.8,\n" +
                "                \"night\": 291.55,\n" +
                "                \"eve\": 292.8,\n" +
                "                \"morn\": 287.51\n" +
                "            },\n" +
                "            \"pressure\": 1001.32,\n" +
                "            \"humidity\": 65,\n" +
                "            \"weather\": [\n" +
                "                {\n" +
                "                    \"id\": 802,\n" +
                "                    \"main\": \"Clouds\",\n" +
                "                    \"description\": \"scattered clouds\",\n" +
                "                    \"icon\": \"03d\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"speed\": 4.22,\n" +
                "            \"deg\": 220,\n" +
                "            \"clouds\": 48\n" +
                "        },\n" +
                "        {\n" +
                "            \"dt\": 1498467600,\n" +
                "            \"temp\": {\n" +
                "                \"day\": 295.99,\n" +
                "                \"min\": 288.19,\n" +
                "                \"max\": 296.92,\n" +
                "                \"night\": 288.19,\n" +
                "                \"eve\": 294.3,\n" +
                "                \"morn\": 290.18\n" +
                "            },\n" +
                "            \"pressure\": 996.84,\n" +
                "            \"humidity\": 71,\n" +
                "            \"weather\": [\n" +
                "                {\n" +
                "                    \"id\": 502,\n" +
                "                    \"main\": \"Rain\",\n" +
                "                    \"description\": \"heavy intensity rain\",\n" +
                "                    \"icon\": \"10d\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"speed\": 6.11,\n" +
                "            \"deg\": 221,\n" +
                "            \"clouds\": 48,\n" +
                "            \"rain\": 14.19\n" +
                "        },\n" +
                "        {\n" +
                "            \"dt\": 1498554000,\n" +
                "            \"temp\": {\n" +
                "                \"day\": 288.23,\n" +
                "                \"min\": 284.82,\n" +
                "                \"max\": 288.23,\n" +
                "                \"night\": 284.82,\n" +
                "                \"eve\": 287.12,\n" +
                "                \"morn\": 287.86\n" +
                "            },\n" +
                "            \"pressure\": 995.21,\n" +
                "            \"humidity\": 0,\n" +
                "            \"weather\": [\n" +
                "                {\n" +
                "                    \"id\": 501,\n" +
                "                    \"main\": \"Rain\",\n" +
                "                    \"description\": \"moderate rain\",\n" +
                "                    \"icon\": \"10d\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"speed\": 9.94,\n" +
                "            \"deg\": 258,\n" +
                "            \"clouds\": 30,\n" +
                "            \"rain\": 8.93\n" +
                "        },\n" +
                "        {\n" +
                "            \"dt\": 1498640400,\n" +
                "            \"temp\": {\n" +
                "                \"day\": 295.65,\n" +
                "                \"min\": 286.66,\n" +
                "                \"max\": 295.65,\n" +
                "                \"night\": 286.66,\n" +
                "                \"eve\": 291.82,\n" +
                "                \"morn\": 290.44\n" +
                "            },\n" +
                "            \"pressure\": 1003.86,\n" +
                "            \"humidity\": 0,\n" +
                "            \"weather\": [\n" +
                "                {\n" +
                "                    \"id\": 500,\n" +
                "                    \"main\": \"Rain\",\n" +
                "                    \"description\": \"light rain\",\n" +
                "                    \"icon\": \"10d\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"speed\": 6.75,\n" +
                "            \"deg\": 263,\n" +
                "            \"clouds\": 0,\n" +
                "            \"rain\": 0.74\n" +
                "        },\n" +
                "        {\n" +
                "            \"dt\": 1498726800,\n" +
                "            \"temp\": {\n" +
                "                \"day\": 294.13,\n" +
                "                \"min\": 287.83,\n" +
                "                \"max\": 294.13,\n" +
                "                \"night\": 287.83,\n" +
                "                \"eve\": 290,\n" +
                "                \"morn\": 292.09\n" +
                "            },\n" +
                "            \"pressure\": 1004.13,\n" +
                "            \"humidity\": 0,\n" +
                "            \"weather\": [\n" +
                "                {\n" +
                "                    \"id\": 502,\n" +
                "                    \"main\": \"Rain\",\n" +
                "                    \"description\": \"heavy intensity rain\",\n" +
                "                    \"icon\": \"10d\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"speed\": 3.13,\n" +
                "            \"deg\": 94,\n" +
                "            \"clouds\": 94,\n" +
                "            \"rain\": 13.58\n" +
                "        },\n" +
                "        {\n" +
                "            \"dt\": 1498813200,\n" +
                "            \"temp\": {\n" +
                "                \"day\": 298.61,\n" +
                "                \"min\": 292.63,\n" +
                "                \"max\": 298.61,\n" +
                "                \"night\": 292.63,\n" +
                "                \"eve\": 296.38,\n" +
                "                \"morn\": 293.46\n" +
                "            },\n" +
                "            \"pressure\": 997.33,\n" +
                "            \"humidity\": 0,\n" +
                "            \"weather\": [\n" +
                "                {\n" +
                "                    \"id\": 502,\n" +
                "                    \"main\": \"Rain\",\n" +
                "                    \"description\": \"heavy intensity rain\",\n" +
                "                    \"icon\": \"10d\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"speed\": 4.73,\n" +
                "            \"deg\": 156,\n" +
                "            \"clouds\": 37,\n" +
                "            \"rain\": 13.17\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        Gson gson = new Gson();
        WeeklyResponse weeklyResponse = gson.fromJson(data, WeeklyResponse.class);
        return weeklyResponse;
    }

}
