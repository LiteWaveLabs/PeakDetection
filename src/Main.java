import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
	 public static void main(String[] args) throws IOException {
		 
		 double threshold = 500.0;
		 
		 List<Double> valueX = new ArrayList<Double>();
	     List<Double> valueY = new ArrayList<Double>();
	     
	     valueX = parseFile("outputX.txt");
	     valueY = parseFile("outputY.txt");
		
		 Map<Integer, Double> maxima = new HashMap<Integer, Double>();
		 
		 maxima = LiteWaveUtils.peakDetection(valueY, threshold).get(0); //Maximas

		 for(int value = 0; value < valueY.size(); value++)
		 {
			 Double peak = maxima.get(value);
			 if (peak != null) {
				 System.out.println(valueX.get(value));
			 }
		 }
	 }


public static List<Double> parseFile(String fileName) throws IOException {

    BufferedReader br = new BufferedReader(new FileReader(fileName));
    String line = null;
    List<Double> outputList = new ArrayList<Double>();
    try {
    	line = br.readLine();
    	while (line != null)  {
           double d = Double.parseDouble(line);
           //System.out.println(f);
           outputList.add(d);
           line = br.readLine();
    	}
       } finally {
           br.close();
       }
    return outputList;
   }
}



