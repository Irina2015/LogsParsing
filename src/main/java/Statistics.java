import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by asus on 24.05.2015.
 */
public class Statistics {

    // Checking if the map contains a given key
    public static void checkMap(Map<String, Integer> map, String key) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
    }

    // Method for counting the number of planes arrived to each airport
    public static Map countPlanesArrived(List<PlanesLogs> listOfLogs) {
        Map<String, Integer> arrived = new HashMap<String, Integer>();
        for (PlanesLogs temp : listOfLogs) {
            String s = temp.getDest();
            checkMap(arrived, s);
        }
        return arrived;
    }

    // Method for counting the number of planes departed from each airport
    public static Map countPlanesDeparted(List<PlanesLogs> listOfLogs) {
        Map<String, Integer> departed = new HashMap<String, Integer>();
        for (PlanesLogs temp : listOfLogs) {
            String s = temp.getOrigin();
            checkMap(departed, s);
        }
        return departed;
    }

    // Searching for difference between “Planes left the airport” and “Planes came to airport”
    public static Map CheckDiff(Map<String, Integer> arrived, Map<String, Integer> departed) {
        Map<String, String> diff = new HashMap<String, String>();
        for (String key : arrived.keySet()) {
            if (departed.containsKey(key) && (!departed.get(key).equals(arrived.get(key)))) {
                String temp = "Arrived: " + arrived.get(key) + " Departed: " + departed.get(key);
                diff.put(key, temp);
            }
            // Checking case when departed map doesn't contain key from arrived map
            if (!departed.containsKey(key)) {
                String temp = "Arrived: " + arrived.get(key) + " Departed: 0 ";
                diff.put(key, temp);
            }
        }
        // Checking case when arrived map doesn't contain key from departed map
        for (String key : departed.keySet()) {
            if (!arrived.containsKey(key)) {
                String temp = "Arrived: 0   Departed: " + departed.get(key);
                diff.put(key, temp);
            }
        }
        return diff;
    }

    public static void writeArrivedToCsv(String path, Map<String, Integer> map) {
        try {
            FileWriter writer;
            writer = new FileWriter(path, false);  //True = Append to file, false = Overwrite
            for (String key : map.keySet()) {
                writer.write(key);
                writer.write(";");
                writer.write(map.get(key).toString());
                writer.write("\r\n");
            }
            System.out.println("Write success!");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeDiffToCsv(String path, Map<String, String> map) {
        try {
            FileWriter writer;
            writer = new FileWriter(path, false);  //True = Append to file, false = Overwrite
            for (String key : map.keySet()) {
                writer.write(key);
                writer.write(";");
                writer.write(map.get(key));
                writer.write("\r\n");
            }
            System.out.println("Write success!");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
