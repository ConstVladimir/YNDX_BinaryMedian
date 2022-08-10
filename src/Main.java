import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final String inputFile = "input.txt";
    private static final String outputFile = "output.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        int n = Integer.parseInt(reader.readLine());
        List<String> mass = Arrays.stream(reader.readLine().split("")).collect(Collectors.toList());
        reader.close();

        FileWriter file = new FileWriter(outputFile);
        StringBuilder sb = new StringBuilder("-1");

        for (int a=2; a<n+1; a++){
            String medNeed = "";
            int count = 1;
            int needAm = 0;
            int noNeedAm = 0;
            List<String> submass=mass.subList(0,a);
            for (Iterator<String> it = submass.stream().collect(Collectors.toCollection(LinkedList::new)).descendingIterator(); ;){
                String strNow = it.next();

                if (count == 1) {
                    medNeed= strNow;
                    needAm++;
                }
                else {
                    if (strNow.equals(medNeed)){
                        needAm++;
                        if (needAm*2 > count || count == 2){
                            sb.append(" "+ (a-count+1));
                            break;
                        }
                    }
                    else noNeedAm++;
                }
                count++;
                if (!it.hasNext()){
                    sb.append( " -1");
                    break;
                }
            }


        }

        file.write(sb.substring(0));
        file.close();
    }
}
