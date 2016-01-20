import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
	 public static void main(String[] args) throws IOException {
		 
		 double threshold = 1000.0;
		 int elementsPerPeak = 5;
		 
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
				 double wavelenght = valueX.get(value);
				 System.out.println(wavelenght);
				 System.out.println(ElementFinder.mySQLHandler(wavelenght, elementsPerPeak));
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



