package creatematrix;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 生成终局
 */
public class SudokuPuzzleMatrixGenerator {

    /**
     * 待转换的数组种子数组
     */
    private int[][] sampleArray;

    public SudokuPuzzleMatrixGenerator createSampleArray() {
        sampleArray = SeedSudokuMatrixFactory
                .retrieveSeedSudokuArrayByRandom();
        return this;
    }

    /**
     * 交换
     *
     * @return
     */
    public SudokuPuzzleMatrixGenerator generateSudokuArray() {
        List<Integer> randomList = buildRandomList();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    if (sampleArray[i][j] == (randomList.get(k))) {
                        sampleArray[i][j] = randomList.get((k + 1) % 9);
                        break;
                    }
                }
            }
        }
        return this;
    }

    public SudokuPuzzleMatrixGenerator formatMatrix() {
        int first = sampleArray[0][0];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(sampleArray[i][j]==first){
                    sampleArray[i][j] = 2;
                    continue;
                }
                if(sampleArray[i][j]==2){
                    sampleArray[i][j]=first;
                }
            }
        }

        return this;
    }

    /**
     * 挖空
     *
     * @return
     */
    public SudokuPuzzleMatrixGenerator createEmptySpace() {
        Random r = new Random();
        int emptyNum = r.nextInt(20);
        int x;
        int y;
        for (int i = 0; i < emptyNum; i++) {
            x = r.nextInt(8);
            y = r.nextInt(8);
            sampleArray[x][y] = 0;
        }
        return this;
    }

    public int[][] build() {
        return sampleArray;
    }

    private List<Integer> buildRandomList() {
        List<Integer> result = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(result);
        return result;
    }

}