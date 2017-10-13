import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

import java.util.ArrayList;

public class ItemUtils {


    private ArrayList<Item> items;

    public ArrayList<Item> getItems() {
        return items;
    }

    public ItemUtils() {
        final String OSRS_JSON_URL = "http://mooshe.pw/files/items_osrs.json";
        final int STATUS_SUCCESS = 200;
        HttpResponse<String> response = null;
        try {
            response = Unirest.get(OSRS_JSON_URL)
                    .asString();
        } catch (Exception e) {
            System.err.println(e.toString());
            System.exit(-1);
        }
        if (response.getStatus() != STATUS_SUCCESS) {
            System.err.println("Retrieval Error: " + response.getStatus());
            System.exit(-1);
        }
        Gson gson = new Gson();
        items = gson.fromJson(response.getBody(), ItemUtils.class).items;
    }

    public void listAllModelIDs() {
        for (Item item : items) {
            System.out.println(item.getModelid());
        }
    }

}
