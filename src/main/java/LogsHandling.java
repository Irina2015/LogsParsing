
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.GZIPInputStream;

/**
 * Created by asus on 24.05.2015.
 */
public class LogsHandling {

    public static void main(String[] args) {

        String line = "";
        String SplitBy = ",";
        List<PlanesLogs> logsData = new ArrayList<PlanesLogs>();
        BufferedReader br = null;
        String pathForArrivedStat = "D:\\Java\\numberOfPlanesArrived.csv";
        String pathForDiffStat = "D:\\Java\\diffDepartedArrived.csv";

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter absolute file path");
        String filePath = sc.nextLine();
        sc.close();
        Path path = Paths.get(filePath);

        Checks.checkFile(path);
        Checks.checkExtension(path, "gz");

        try {
            GZIPInputStream gzip = new GZIPInputStream(new FileInputStream(path.toString()));
            InputStreamReader reader = new InputStreamReader(gzip);
            br = new BufferedReader(reader);
            // Before reading the entire data in a while loop br.readLine() is used in order to eliminate the first line of csv file
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] splitted = line.replaceAll("\"", "").split(SplitBy);
                logsData.add(new PlanesLogs(splitted[0], splitted[1], splitted[2], splitted[3], splitted[4], splitted[5], splitted[6], splitted[7]));
            }
            br.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Map containing number of planes arrived to each airport
        Map<String, Integer> numberOfPlanesArrived = new HashMap<String, Integer>();
        numberOfPlanesArrived = Statistics.countPlanesArrived(logsData);

        // Map containing number of planes departedfrom each airport
        Map<String, Integer> numberOfPlanesDeparted = new HashMap<String, Integer>();
        numberOfPlanesDeparted = Statistics.countPlanesDeparted(logsData);

        // Map containing information about difference between “Planes left the airport” and “Planes came to airport”
        Map<String, String> diffDepartedArrived = new HashMap<String, String>();
        diffDepartedArrived = Statistics.CheckDiff(numberOfPlanesArrived, numberOfPlanesDeparted);

        Statistics.writeArrivedToCsv(pathForArrivedStat, numberOfPlanesArrived);
        Statistics.writeDiffToCsv(pathForDiffStat, diffDepartedArrived);
    }
}
