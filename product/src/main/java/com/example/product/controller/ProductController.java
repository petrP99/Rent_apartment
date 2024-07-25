package com.example.product.controller;

import com.example.product.dto.TestObjectDto;
import com.example.product.service.services.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

        /*

     Чтобы его запустить, достаточно вставить свой ключ доступа
     к API в значение переменной access_key и выполнить этот код с помощью интерпретатора.

# insert your real key here!
access_key = "your_key"

headers = {
    "X-Yandex-Weather-Key": access_key
}

query = """{
  weatherByPoint(request: { lat: 52.37125, lon: 4.89388 }) {
    now {
      temperature
    }
  }
}"""

response = requests.post('https://api.weather.yandex.ru/graphql/query', headers=headers, json={'query': query})
print(response.content)

curl 'https://api.weather.yandex.ru/graphql/query' -H 'X-Yandex-Weather-Key: <Key>' -H 'Content-Type: application/json'
 --data-binary '{"query":"{\n  weatherByPoint(request: { lat: 52.37125, lon: 4.89388 })\n
 {\n    now {\n      temperature\n    }\n  }\n}\n"}' --compressed


    * Вам нужно передать этот текст в парметре body POST-запроса.
    * HTTP-запрос выполняется по адресу https://api.weather.yandex.ru/graphql/query.
    * */


    private static final String KEY_API_YANDEX = "9c67cbf6-a373-4c63-8416-c34413bdf444";

    private final WeatherService weatherService;

    @PostMapping("/product")
    public String getProduct(@RequestHeader String token, @RequestBody TestObjectDto testObjectDto) {
        return testObjectDto.toString();
    }

    @PostMapping("/weather")
    public String getWeatherInCity(@RequestBody String sql_query, @RequestHeader String header) {

        return weatherService.getWeather(KEY_API_YANDEX);
    }

}
