import java.io.*;

public class Main
{
    public static void main(String args[]) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        for (int i=0; i<N; i++) {
            String[] input = buffer.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            System.out.printf("Case #%d: %d\n", i+1, A+B);
        }
    }
}