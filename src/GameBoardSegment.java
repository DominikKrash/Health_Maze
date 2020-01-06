import java.awt.*;
import java.io.FileReader;

public class GameBoardSegment{
    private static String[] patternNames = {"src/Resources/Patterns/segment1.txt"};
    private static int[][] segmentPattern;
    private static int blockNumber; // how many blocks segment has
    private int blockSize; //pixel width
    GameBoardSegment(int blockNumber,int blockSize){
        this.blockNumber = blockNumber;
        this.blockSize = blockSize;
    }

    public static void setBlockNumber(int blockNumber) {
        GameBoardSegment.blockNumber = blockNumber;
    }

    static void getSegmentPatterns(){
        segmentPattern = new int[patternNames.length][blockNumber * blockNumber];
        FileReader in = null;
        try{
            for(int i = 0;i < patternNames.length;i++) {
                in = new FileReader(patternNames[i]);
                int nextSign;
                int counter = 0;
                while((nextSign = in.read()) != -1 || counter < blockNumber * blockNumber){
                    segmentPattern[i][counter] = Character.getNumericValue(nextSign);
                    counter++;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
