package com.handson.chatbot.service;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.springframework.stereotype.Service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.handson.chatbot.model.FanFavorites;

@Service
public class ImdbService {


    private String getTop250Html(String keyword) throws IOException {
            OkHttpClient client = new OkHttpClient().newBuilder()
            .build();
            Request request = new Request.Builder()
            .url("https://www.imdb.com/chart/fan-favorites/?ref_=nv_mv_250")
            .method("GET", null)
            .addHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
            .addHeader("accept-language", "he-IL,he;q=0.9,en;q=0.8")
            .addHeader("cache-control", "max-age=0")
            .addHeader("cookie", "session-id-time=2082787201l; ad-oo=0; ci=e30; session-id=138-0539178-6044610; ubid-main=133-9671415-3300408; session-token=lRpWpsKEs9TG5dz8rqatG9x5WQGmo1/dPur+iHrjyEArplsHjncaeG5Rc9K0SvYLdbcjpvHfK/vLEQdU/h1G5ZSafgMz1+lUiX7h80DTEU5T6RUVu8/1bOHe4cwhNwWh6i6hKQZZMV7Gk2n1itWDxjuX7vcuH4/5V+KsZKf7OtqwsDgQ5AgD55voMH0RkhHBmN8H/VQm4Ph7zBgBrb1i+wZKb9m2DSUWPG6c33jaV07fUKWU7FZ0KeaN9w8e7HkF1Uh2iOqNvJzIGASxNPth6iyNvcVVH5Fcnl2DFBNa1FNlQVuooT6KD559W3mZklMeucpzSQk/LVupuc3dKMn+sak6L792eV+V; csm-hit=tb:s-B9SZ6HV5MY9Z2N5KYZBC|1731226131328&t:1731226131498&adb:adblk_yes; session-id=138-0539178-6044610; session-id-time=2082787201l; session-token=lRpWpsKEs9TG5dz8rqatG9x5WQGmo1/dPur+iHrjyEArplsHjncaeG5Rc9K0SvYLdbcjpvHfK/vLEQdU/h1G5ZSafgMz1+lUiX7h80DTEU5T6RUVu8/1bOHe4cwhNwWh6i6hKQZZMV7Gk2n1itWDxjuX7vcuH4/5V+KsZKf7OtqwsDgQ5AgD55voMH0RkhHBmN8H/VQm4Ph7zBgBrb1i+wZKb9m2DSUWPG6c33jaV07fUKWU7FZ0KeaN9w8e7HkF1Uh2iOqNvJzIGASxNPth6iyNvcVVH5Fcnl2DFBNa1FNlQVuooT6KD559W3mZklMeucpzSQk/LVupuc3dKMn+sak6L792eV+V")
            .addHeader("dnt", "1")
            .addHeader("priority", "u=0, i")
            .addHeader("referer", "https://www.imdb.com/?ref_=nv_home")
            .addHeader("sec-ch-ua", "\"Chromium\";v=\"130\", \"Google Chrome\";v=\"130\", \"Not?A_Brand\";v=\"99\"")
            .addHeader("sec-ch-ua-mobile", "?0")
            .addHeader("sec-ch-ua-platform", "\"Windows\"")
            .addHeader("sec-fetch-dest", "document")
            .addHeader("sec-fetch-mode", "navigate")
            .addHeader("sec-fetch-site", "same-origin")
            .addHeader("sec-fetch-user", "?1")
            .addHeader("upgrade-insecure-requests", "1")
            .addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Safari/537.36")
            .build();
          Response response = client.newCall(request).execute();
          return response.body().string();

    }

    public static final Pattern PRODUCT_PATTERN = Pattern.compile("\"name\":\"(.*?)\".*?\"ratingValue\":([0-9.]+)");

    public String searchProducts(String keyword) throws IOException {
        return parseProductHtml(getTop250Html(keyword));
    }

    private String parseProductHtml(String html) {
        String res = "";
        Matcher matcher = PRODUCT_PATTERN.matcher(html);
        while (matcher.find()) {
            res += matcher.group(1) + " - " + matcher.group(2) +"\n";
        }
        return res;
    }

    private String getFanFaverte() throws IOException{
        OkHttpClient client = new OkHttpClient().newBuilder()
        .build();

        Request request = new Request.Builder()
        .url("https://api.graphql.imdb.com/?operationName=FanFavorites&variables=%7B%22first%22%3A48%2C%22includeUserRating%22%3Afalse%2C%22locale%22%3A%22he-IL%22%7D&extensions=%7B%22persistedQuery%22%3A%7B%22sha256Hash%22%3A%227c01e0d9d8581975bf64701df0c96b02aaec777fdfc75734d68d009bde984b99%22%2C%22version%22%3A1%7D%7D")
        .method("GET",null)
        .addHeader("accept", "application/graphql+json, application/json")
        .addHeader("accept-language", "he-IL,he;q=0.9,en;q=0.8")
        .addHeader("content-type", "application/json")
        .addHeader("cookie", "session-id-time=2082787201l; ad-oo=0; ci=e30; session-id=138-0539178-6044610; ubid-main=133-9671415-3300408; session-token=lRpWpsKEs9TG5dz8rqatG9x5WQGmo1/dPur+iHrjyEArplsHjncaeG5Rc9K0SvYLdbcjpvHfK/vLEQdU/h1G5ZSafgMz1+lUiX7h80DTEU5T6RUVu8/1bOHe4cwhNwWh6i6hKQZZMV7Gk2n1itWDxjuX7vcuH4/5V+KsZKf7OtqwsDgQ5AgD55voMH0RkhHBmN8H/VQm4Ph7zBgBrb1i+wZKb9m2DSUWPG6c33jaV07fUKWU7FZ0KeaN9w8e7HkF1Uh2iOqNvJzIGASxNPth6iyNvcVVH5Fcnl2DFBNa1FNlQVuooT6KD559W3mZklMeucpzSQk/LVupuc3dKMn+sak6L792eV+V; session-id=138-0539178-6044610; session-id-time=2082787201l; session-token=nwYbFa8urWJAJfvYQRpMCsbFZ8j7TJRjANIKyGCwyybayDBMNG5nQ20unUIgQMVqJPgAD+62VKHDjiGVEcJZKrfp7QfB3vfIZBBJKIxCd0NgGVx9I4sNcFBn3hi6LlBSjdXTN9HhAvt0bPMHpqGcw+4IZflpgJKIKDpcw/9rhTUYLyBVkwyaaSY1PGhRdvC2uo+56KAeXlp/wlBR7JoIszev68sCnU32V+IRNobpLjM4Y+yRmscYF5Hpp9XaqFrMvxSLSXmtmqkbJfAwcmJG+9CYxvOY02M6Tx9EUNCzn7C4jC5VPHMHeUEJlQgiZUhp6uxnWUogVpL3wccn9bf3+Vu+bnBMht+K")
        .addHeader("dnt", "1")
        .addHeader("origin", "https://www.imdb.com")
        .addHeader("priority", "u=1, i")
        .addHeader("referer", "https://www.imdb.com/")
        .addHeader("sec-ch-ua", "\"Chromium\";v=\"130\", \"Google Chrome\";v=\"130\", \"Not?A_Brand\";v=\"99\"")
        .addHeader("sec-ch-ua-mobile", "?0")
        .addHeader("sec-ch-ua-platform", "\"Windows\"")
        .addHeader("sec-fetch-dest", "empty")
        .addHeader("sec-fetch-mode", "cors")
        .addHeader("sec-fetch-site", "same-site")
        .addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Safari/537.36")
        .addHeader("x-amzn-sessionid", "138-0539178-6044610")
        .addHeader("x-imdb-client-name", "imdb-web-next")
        .addHeader("x-imdb-client-rid", "5P3GQ7DCRFCPQE0RZ8ZV")
        .addHeader("x-imdb-user-country", "IL")
        .addHeader("x-imdb-user-language", "he-IL")
        .addHeader("x-imdb-weblab-treatment-overrides", "{\"IMDB_NAV_PRO_FLY_OUT_NOV_PROMO_1087903\":\"T1\"}")
        .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public String fanFavert() throws IOException{
       ObjectMapper mapper = new ObjectMapper();
       String result=getFanFaverte();
       StringBuilder res = new StringBuilder();
       FanFavorites response = mapper.readValue(result, FanFavorites.class);
       response.getData().getFanPicksTitles().getEdges().forEach(x->{
            res.append(x.getNode().getTitleText().getText())
           .append(" - ")
           .append(x.getNode().getRatingsSummary().getAggregateRating())
           .append("\n");
       });
        return res.toString();
        
    }
}
