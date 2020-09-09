import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class mainClass {
	public static void main(String[] args) throws IOException {
		// Define variables to manage user input
		FillInPuzzle fillin = new FillInPuzzle();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		fillin.loadPuzzle(br);
		}
}
