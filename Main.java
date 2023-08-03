class Main {
    public static void main(String[] args) {
        int size = 5;

        printPyramid(size);

        System.out.println();

        printSnake(size);

    }

    private static void printPyramid(int size){
        int maxNumber = (int) Math.round(size/2.);
        int numberToPrint;

        for (int rowIndex = 0; rowIndex < size; rowIndex++) {
            for (int columnIndex = 0; columnIndex < size; columnIndex++) {

                if(rowIndex < maxNumber && columnIndex < maxNumber){                 // 2ая четверть
                    numberToPrint = Math.min(rowIndex, columnIndex) + 1;
                } else if (rowIndex < maxNumber){                                    // 1ая четверть
                    numberToPrint = Math.min(size - columnIndex, rowIndex + 1);
                } else if (columnIndex < maxNumber){                                 // 3ья четверть
                    numberToPrint = Math.min(size - rowIndex, columnIndex + 1);
                } else {                                                             // 4ая четверть
                    numberToPrint = Math.min(size - rowIndex, size - columnIndex);
                }

                System.out.printf("%0,2d,", numberToPrint);
            }
            System.out.println();
        }
    }

    private static void printSnake(int size){
        int[][] snakeMatrix = new int[size][size];
        int rowIndex = 0;
        int columnIndex = 0;

        int[] direction = new int[]{0, 1};

        for (int nextNumber = 1; nextNumber <= size * size; nextNumber++) {
            snakeMatrix[rowIndex][columnIndex] = nextNumber;

            if(rowIndex + direction[0] == size || columnIndex + direction[1] == size ||     // выход за пределы
                    rowIndex + direction[0] < 0 || columnIndex + direction[1] < 0 ||
                    snakeMatrix[rowIndex + direction[0]][columnIndex + direction[1]] != 0){ // змея стукнулась в себя
                turnRight(direction);
            }
            if(snakeMatrix[rowIndex + direction[0]][columnIndex + direction[1]] == 0){
                rowIndex += direction[0];
                columnIndex += direction[1];
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%0," + (size * size + "").length() + "d,", snakeMatrix[i][j]);
            }
            System.out.printf("%0," + (size * size + "").length() + "d\n", snakeMatrix[i][size - 1]);
        }
    }

    private static void turnRight(int[] direction){
        if(direction[0] == 0 && direction[1] == 1) {
            direction[0] = 1;
            direction[1] = 0;
        } else if(direction[0] == 0 && direction[1] == -1){
            direction[0] = -1;
            direction[1] = 0;
        } else if(direction[0] == 1 && direction[1] == 0) {
            direction[0] = 0;
            direction[1] = -1;
        } else if(direction[0] == -1 && direction[1] == 0){
            direction[0] = 0;
            direction[1] = 1;
        }
    }

    private static void printMatrix(int[][] matrix){
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrix[rowIndex].length - 1; columnIndex++) {
                System.out.printf("%0,2d,", matrix[rowIndex][columnIndex]);
            }
            System.out.printf("%0,2d\n", matrix[rowIndex][matrix[rowIndex].length - 1]);
        }
    }
}