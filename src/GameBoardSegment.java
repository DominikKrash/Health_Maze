import java.awt.*;
import java.io.FileReader;
import java.util.Random;

public class GameBoardSegment{
    private static String[] patternNames = {"src/Resources/Patterns/segment1.txt",
            "src/Resources/Patterns/segment2.txt",
            "src/Resources/Patterns/segment3.txt",
            "src/Resources/Patterns/segment4.txt"};
    private static int[][] segmentPattern;
    private static int blockNumber; // how many blocks segment has

    private int[] pattern;
    GameBoardSegment(){
        int num;
        pattern = new int[blockNumber * blockNumber];
        Random r = new Random();
        num = r.nextInt(patternNames.length);
        for(int i = 0;i<blockNumber*blockNumber;i++){
            pattern[i] = segmentPattern[num][i];
        }
    }

    public int[] getPattern() {
        return pattern;
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
                while((nextSign = in.read()) != -1 && (counter < (blockNumber * blockNumber))){
                    segmentPattern[i][counter] = Character.getNumericValue(nextSign);
                    counter++;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
