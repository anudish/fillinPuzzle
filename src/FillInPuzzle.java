import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FillInPuzzle{

	private static int backtracknumber=0;	// to track the number of times choices made were backtracked
	private ArrayList<int[]> horizontalSpaces= new ArrayList<int[]>(); // stores information of spaces in the puzzle which are horizontal
	private ArrayList<int[]> verticalSpaces= new ArrayList<int[]>();	// stores information of spaces in the puzzle which are vertical
	private ArrayList<String> words=new ArrayList<String>();	//stores all the words that are to be inserted 
	
	int noOfRows = 0, noOfColumns = 0, rowNum = 0, colNum = 0;
	String typeofWord = "";
	int[] wordLength;
	char[][] grid;
	ArrayList<String> horizontalSpaceOfWords = new ArrayList<String>();
	ArrayList<String> verticalSpaceOfWords = new ArrayList<String>();
	
	private int noOfWords=0,rows,columns;
	private char[][] structure;	// 2-dimensional array to create the puzzle


	/*
	 * reads the user input from the console and use the input to define structure,
	 * get information of spaces and get words that are to be placed to the
	 * structure
	 */
	public boolean loadPuzzle(BufferedReader streamline) throws IOException {
		// TODO Auto-generated method stub
		StringTokenizer input = new StringTokenizer(streamline.readLine());
		noOfColumns = Integer.parseInt(input.nextToken());
		noOfRows = Integer.parseInt(input.nextToken());
		noOfWords = Integer.parseInt(input.nextToken());
		wordLength = new int[noOfWords];
		grid = new char[noOfRows][noOfColumns];

		try {
		for (int i = 0; i < noOfRows; i++) {
			for (int j = 0; j < noOfColumns; j++) {
				grid[i][j] = '-';
			}
		}
		
		for(int i=0; i< noOfWords;i++) {
			StringTokenizer inputString = new StringTokenizer(streamline.readLine());
			colNum = Integer.parseInt(inputString.nextToken());
			rowNum = Integer.parseInt(inputString.nextToken());
			int len = Integer.parseInt(inputString.nextToken());
			typeofWord = inputString.nextToken();

			if (!(typeofWord.equalsIgnoreCase("h") || typeofWord.equalsIgnoreCase("v"))) {
				System.out.println("Incorrect input..Please enter correct input");
			} else {
				wordLength[i] = len;
				String combine = Integer.toString(colNum) + ' ' + Integer.toString(rowNum) + ' '
						+ Integer.toString(wordLength[i]) + ' ' + typeofWord;
	
				if (typeofWord.contains("h")) {
					horizontalSpaceOfWords.add(combine);
					for (int p = 0; p < wordLength[i]; p++) {
						if (colNum >= 0 && rowNum >= 0) {
							grid[rowNum][colNum] = '#';
							colNum++;
						} else {
							System.out.println("Grid column mismatch");
						}
					}
				} else if (typeofWord.contains("v")) {
					verticalSpaceOfWords.add(combine);
					for (int p = 0; p < wordLength[i]; p++) {
						if (colNum >= 0 && rowNum >= 0) {
							grid[rowNum][colNum] = '#';
							rowNum--;
						} else {
							System.out.println("Grid row mismatch");
						}

					}
				}
			}

		}
		for (int i = 0; i < wordLength.length; i++) {
			String acceptWord = streamline.readLine();
			words.add(acceptWord);
		}
		System.out.println("VerticalSpaceOfWords : " + verticalSpaceOfWords);
		System.out.println("HorizontalSpaceOfWords : " + horizontalSpaceOfWords);
		System.out.println("words : " + words);
		System.out.println("Grid is : ");
		print();
		solve();
		
		return true;

	} catch (Exception e) {
		// TODO: handle exception
	}
	return false;
	}

	public void checkHorizontal( ArrayList<String> horizontalSpaceValue, ArrayList<String> wordList, char [][]grid) {
		String [] str;
		
		for(String s:horizontalSpaceValue) {
			str=s.split(" ");
			System.out.println("String is : "+Arrays.deepToString(str));
			for(int i=0;i<wordList.size();i++) {
				int len = wordList.get(i).length();
				String wrd = wordList.get(i);
				if(Integer.parseInt(str[2]) == len) {
					
					int x = Integer.parseInt(str[0]);
					int y = Integer.parseInt(str[1]);
					for(int p=0;p<wrd.length();p++) {
						grid[y][x]= wrd.charAt(p);
						x++;
					}
					
			}
			
			}
			break;
		}
	print();
	}
	
	public void checkVertical( ArrayList<String> verticalSpaceValue, ArrayList<String> wordList, char [][]grid) {
		String [] str;
		for(String s:verticalSpaceValue) {
			str=s.split(" ");
			System.out.println("String is : "+Arrays.deepToString(str));
			for(int i=0;i<wordList.size();i++) {
				int len = wordList.get(i).length();
				String wrd = wordList.get(i);
				if(Integer.parseInt(str[2]) == len) {
					int x = Integer.parseInt(str[0]);
					int y = Integer.parseInt(str[1]);
					for(int p=0;p<wrd.length();p++) {
						grid[y][x]= wrd.charAt(p);
						y--;
					}
					
			}
				
			}
			break;
		}
		print();
	}

	public void print() {
		for (int i = noOfRows - 1; i >= 0; i--) {
			for (int j = 0; j < noOfColumns; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	/*
	 * this method uses the information gathered on puzzle and use it to solve the
	 * puzzle
	 */
	public Boolean solve( ) {
		checkHorizontal(horizontalSpaceOfWords, words, grid );
		checkVertical(verticalSpaceOfWords, words, grid );
		return false;
	}
}

