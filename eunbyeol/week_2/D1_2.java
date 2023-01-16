import java.io.*;

public class Main
{
    public static void main(String args[]) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        if (A > B) {
            System.out.println("A");
        }
        else if (A < B) {
            System.out.println("B");
        }
        else {
            System.out.println("same");
        }
    }
}