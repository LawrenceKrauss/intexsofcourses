class Main {
    public static void main(String[] args) {
        var snake = new SnakeMatrix(10,10);
        var pyramid = new PyramidMatrix(10, 10);

        MatrixPrinter.print(snake);
        System.out.println();
        MatrixPrinter.print(pyramid);
    }
}