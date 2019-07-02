# sudoku-validator
GUI app that validates if a sudoku 9x9 solution is correct.

The goal of Sudoku is to fill in a 9×9 grid with digits so that each column, row, and 3×3 section contain the numbers between 1 to 9.

### Directory Structure
```
├── README.md
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── eraldo
│   │               ├── controllers
│   │               │   └── ThreadController.java
│   │               ├── exceptions
│   │               │   └── IntegerParseException.java
│   │               ├── Main.java
│   │               ├── threads
│   │               │   ├── ColCheckerThread.java
│   │               │   ├── GridsCheckerThread.java
│   │               │   └── RowCheckerThread.java
│   │               ├── Util.java
│   │               └── View.java
│   └── test
│       └── java
│           └── com
│               └── eraldo
│                   ├── UtilTestInt.java
│                   └── UtilTest.java


```

### Sequence Diagram
![Sequence Diagram](https://raw.githubusercontent.com/eraldoforgoli/sudoku-validator/master/docs/validate-sudoku-sequence-diagram.png)

### Screenshots

![Input](http://i63.tinypic.com/zjtgs2.png)  
![Input](http://i68.tinypic.com/2arhcg.png)  
![Input](http://i67.tinypic.com/2dijf6f.png)  
