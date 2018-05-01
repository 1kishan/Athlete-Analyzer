package edu.illinois.cs125.final_project1;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class Data {
    String player = null;
    String league = null;

    public Data(String inputPlayer, String inputLeague) {
        player = inputPlayer;
        league = inputLeague;
    }
    public String urlBuilder() {
        String url;
        if (league.equals("NBA")) {
            url = "https://api.mysportsfeeds.com/v1.2/pull/nba/2017-2018-regular/cumulative_player_stats.json?player="+player;
            return url;
        }
        if (league.equals("NFL")) {
            url = "https://api.mysportsfeeds.com/v1.2/pull/nfl/2017-regular/cumulative_player_stats.json?player="+player;
            return url;
        }
        if (league.equals("MLB")) {
            url = "https://api.mysportsfeeds.com/v1.2/pull/mlb/2017-regular/cumulative_player_stats.json?player="+player;
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
            System.out.println(a);
                return a;
            } catch(Exception e) {
                e.printStackTrace();
            }
            return null;
        }


}



