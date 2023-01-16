import java.io.*;

public class Main
{
    public static void main(String args[]) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int workingMinutes = 0;
        for (int i=0; i<5; i++) {
            String[] input = buffer.readLine().split(" ");
            String[] start = input[0].split(":");
            String[] finish = input[1].split(":");
            int startMinutes = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            int finishMinutes = Integer.parseInt(finish[0]) * 60 + Integer.parseInt(finish[1]);
            workingMinutes += finishMinutes - startMinutes;
        }
        System.out.println(workingMinutes);
    }
}