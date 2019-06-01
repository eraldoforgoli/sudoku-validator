
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

import com.eraldo.Util;

public class UtilTest {

    @Test
    public void allRowsContain1To9Test() {
        int[][] tableData = getIncorrectSudokuData();
        assertEquals(true, Util.allRowsContain1To9(tableData));
    }

    @Test
    public void allColsContain1To9Test() {
        int[][] tableData = getIncorrectSudokuData();
        assertEquals(false, Util.allColumnsContain1To9(tableData));
    }

    @Test
    public void allGridsContain1To9Test() {
        int[][] tableData = getIncorrectSudokuData();
        assertEquals(false, Util.all3X3GridsContain1to9(tableData));
    }

    @Test
    public void allRowsContain1To9True() {
        int[][] tableData = getCorrectSudokuData();
        assertEquals(true, Util.all3X3GridsContain1to9(tableData));
    }

    @Test
    public void allColsContain1To9True() {
        int[][] tableData = getCorrectSudokuData();
        assertEquals(true, Util.allColumnsContain1To9(tableData));
    }

    @Test
    public void allGridsContain1To9True() {
        int[][] tableData = getCorrectSudokuData();
        assertEquals(true, Util.all3X3GridsContain1to9(tableData));
    }


    public int[][] getIncorrectSudokuData() {
        int[][] data = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9}
        };
        return data;
    }

    public int[][] getCorrectSudokuData() {
        int[][] data = {
                {5, 8, 2, 9, 6, 1, 7, 4, 3},
                {4, 6, 7, 3, 8, 5, 1, 9, 2},
                {1, 3, 9, 7, 4, 2, 6, 5, 8},
                {7, 9, 5, 8, 2, 6, 3, 1, 4},
                {3, 2, 1, 4, 5, 7, 9, 8, 6},
                {6, 4, 8, 1, 9, 3, 5, 2, 7},
                {8, 1, 6, 2, 7, 9, 4, 3, 5},
                {2, 7, 3, 5, 1, 4, 8, 6, 9},
                {9, 5, 4, 6, 3, 8, 2, 7, 1}
        };
        return data;
    }
}


