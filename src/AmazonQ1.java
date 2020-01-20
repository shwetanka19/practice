import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AmazonQ1 {
    public static void main(String [] args){
        int result = getExpenditure(2, 8, 5, 50);

        System.out.println("Result: "+result);
    }

    public static int getExpenditure(int userId, int locationId, int netStart, int netEnd) {
        String base = "https://jsonmock.hackerrank.com/api/transactions/search?userId=";
        Double res = 0.0;
        int cp = 1;
        long tp = 1;
        while (cp <= tp){
            try {
                String finalUrl = base+userId;
                if (cp > 1){
                    finalUrl+= "&page="+cp;
                }
                URL url = new URL(finalUrl);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                int responseCode = con.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK){
                    StringBuffer response = new StringBuffer();
                    try (BufferedReader bf = new BufferedReader(new InputStreamReader(con.getInputStream()))){

                        String rLine;
                        while ((rLine = bf.readLine()) != null){
                            response.append(rLine);
                        }
                    }
                    System.out.println(response.toString());
                    JSONParser parser = new JSONParser();
                    JSONObject json = (JSONObject) parser.parse(response.toString());
                    long totalPages = (Long) json.get("total_pages");
                    if (cp == 1){
                        tp = totalPages;
                    }
                    JSONArray data = (JSONArray) json.get("data");
                    for (Object obj : data){
                        JSONObject jobj = (JSONObject) obj;
                        JSONObject loc = (JSONObject) jobj.get("location");
                        long lId = (Long) loc.get("id");
                        String ipr = (String) jobj.get("ip");
                        int fb = Integer.valueOf(ipr.split("\\.")[0]);
                        if (lId == locationId && fb >= netStart && fb <= netEnd){
                            String amStr = (String)jobj.get("amount");
                            amStr = amStr.replaceAll(",", "").substring(1);
                            Double amt = Double.valueOf(amStr);
                            res += amt;
                        }
                    }
                    cp++;


                }else {
                    return 0;
                }
            }catch (Exception e){
                e.printStackTrace();
                return 0;
            }

        }
        return res.intValue();
    }
}
