import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Queue<String> snakeQueue = new LinkedList();
        snakeQueue.add("Down");
        snakeQueue.add("Right");
        snakeQueue.add("Up");
        snakeQueue.add("Right");

        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Enter an array of symbols:");
        String inputString = inputScanner.nextLine();
        int arrayLength = inputString.length();
        int columnSize = arrayLength%2==0?arrayLength/2:(arrayLength/2)+1;
        char[][] snakeMatrix = new char[2][columnSize];
        snakeMatrix[0][0] = inputString.charAt(0);
        int columnCounter = 0;
        int rowCounter = 0;
        for(int i=1;i<arrayLength;i++){

            String direction = snakeQueue.peek();
            snakeQueue.add(snakeQueue.poll());
            if(direction == "Down"){
                rowCounter++;
                snakeMatrix[rowCounter][columnCounter] = inputString.charAt(i);
            }
            else if(direction == "Right"){
                columnCounter++;
                snakeMatrix[rowCounter][columnCounter] = inputString.charAt(i);
            }
            else if(direction == "Up"){
                rowCounter--;
                snakeMatrix[rowCounter][columnCounter] = inputString.charAt(i);
            }
        }
        for(int i=0;i<2;i++){
            for(int j=0;j<columnSize;j++){
                if(snakeMatrix[i][j] == 0){
                    continue;
                }
                System.out.print(snakeMatrix[i][j]);
            }
            System.out.println("\r");
        }
    }
}