
import org.junit.Test;
import com.eraldo.SudokuController;

import static junit.framework.TestCase.assertEquals;

public class SudokuControllerTest {
    SudokuController sudokuController = new SudokuController();

    @Test
    public void allRowsContain1To9Test(){
        int[][] tableData = get2DArray();
        assertEquals(true, sudokuController.allRowsContain1To9(tableData));
    }

    @Test
    public void allColsContain1To9Test(){
        int[][] tableData = get2DArray();
        assertEquals(false, sudokuController.allColumnsContain1To9(tableData));
    }

    @Test
    public void allGridsContain1To9Test(){
        int[][] tableData = get2DArray();
        assertEquals(false, sudokuController.allGridsContain1to9(tableData));
    }



    public int[][] get2DArray(){
        int[][] data = {
            { 1,2,3,4,5,6,7,8,9},
            { 1,2,3,4,5,6,7,8,9},
            { 1,2,3,4,5,6,7,8,9},
            { 1,2,3,4,5,6,7,8,9},
            { 1,2,3,4,5,6,7,8,9},
            { 1,2,3,4,5,6,7,8,9},
            { 1,2,3,4,5,6,7,8,9},
            { 1,2,3,4,5,6,7,8,9},
            { 1,2,3,4,5,6,7,8,9}
        };
        return data;
    }
}


