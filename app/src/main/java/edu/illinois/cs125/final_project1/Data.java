package edu.illinois.cs125.final_project1;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class Data {
    String player = null;
    String league = null;
    int season;
    String date;
    boolean playoffs;

    public Data(String inputPlayer, String inputLeague, final int inputSeason, final boolean inputPlayoffs) {
        player = inputPlayer;
        league = inputLeague;
        season = inputSeason;
        playoffs = inputPlayoffs;
    }
    public String urlBuilder() {
        String url;
        if (league.equals("NBA") && !playoffs) {
            if (season == 2016) {
                date = "2015-2016";
            } else if (season == 2017) {
                date = "2016-2017";
            } else {
                date = "2017-2018";
            }
            url = "https://api.mysportsfeeds.com/v1.2/pull/nba/" + date + "-regular/cumulative_player_stats.json?player=" + player;
            return url;
        }
        if (league.equals("NBA") && playoffs) {
            if (season == 2016) {
                date = "2016";
            } else if (season == 2017) {
                date = "2017";
            } else {
                date = "2018";
            }
            url = "https://api.mysportsfeeds.com/v1.2/pull/nba/" + date + "-playoff/cumulative_player_stats.json?player=" + player;
            return url;
        }
        if (league.equals("NFL")) {
            if (season == 2016) {
                date = "2016";
            } else if (season == 2017) {
                date = "2017";
            } else {
                date = "2018";
            }
            if (!playoffs) {
                url = "https://api.mysportsfeeds.com/v1.2/pull/nfl/" + date + "-regular/cumulative_player_stats.json?player=" + player;
            } else {
                url = "https://api.mysportsfeeds.com/v1.2/pull/nfl/" + date + "-playoff/cumulative_player_stats.json?player=" + player;
            }
            return url;
        }

        if (league.equals("MLB")) {
            if (season == 2016) {
                date = "2016";
            } else if (season == 2017) {
                date = "2017";
            } else {
                date = "2018";
            }
            url = "https://api.mysportsfeeds.com/v1.2/pull/mlb/" + date + "-regular/cumulative_player_stats.json?player=" + player;
            return url;
        }
        return null;
    }


    public String apiGetData(){
        try {
                URL url = new URL (urlBuilder());
                String username = "1kishan:CS125Project";
                byte[] user = username.getBytes();
                String encoding = Base64.getEncoder().encodeToString(user);

                byte[] encodedBytes = Base64.getEncoder().encode("Test".getBytes());
                System.out.println("encodedBytes " + new String(encodedBytes));
                byte[] decodedBytes = Base64.getDecoder().decode(encodedBytes);
                System.out.println("decodedBytes " + new String(decodedBytes));

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                //connection.setDoOutput(true);
                connection.setRequestProperty("Authorization", "Basic " + encoding);
                InputStream content = (InputStream)connection.getInputStream();
                BufferedReader in =
                        new BufferedReader(new InputStreamReader(content));
                String line;
            String a = "";
            while ((line = in.readLine()) != null) {
                    a += line;
                }
                return a;
            } catch(Exception e) {
            e.printStackTrace();

            }
            return null;
        }


}



