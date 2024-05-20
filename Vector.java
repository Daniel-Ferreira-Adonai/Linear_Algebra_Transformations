package transformation;

import java.util.Scanner;

public  class Vector {
    //attributes
    private double array[][];
    private int rows;
    private int cols;

    //methods

    public double[][] getArray() {
        return array;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void setRow(int rows) {
        this.rows = rows;
    }

    public void setCol(int cols) {
        this.cols = cols;
    }

    public void setArray(double[][] array) {
        this.array = array;
    }

    public double getValue(int row, int col) {
        return this.array[row][col];
    }

    //se você precisar exibir alguma matrix é so colocar a matrix dentro desse metodo
    public static void exibir(Vector vector) {
        System.out.println("Array:");
        for (int i = 0; i < vector.getRows(); i++) {
            for (int j = 0; j < vector.getCols(); j++) {
                System.out.print(vector.getArray()[i][j] + " ");
            }
            System.out.println();
        }
    }

    // se precisar multiplicar pode chamar esse metodo estatico, metodos estaticos são aqueles que não precisam da classe para ser chamados
    public static Vector dot(Vector vector1, Vector vector2) {
        if (vector1.cols == vector2.rows) {
            Vector resultado = new Vector();
            resultado.setArray(new double[vector1.getRows()][vector2.getCols()]);
            resultado.setCol(vector2.getCols());
            resultado.setRow(vector1.getCols());
            for (int i = 0; i < vector1.getRows(); i++) {
                for (int j = 0; j < vector2.getCols(); j++) {
                    for (int k = 0; k < vector1.getCols(); k++) {
                        resultado.getArray()[i][j] += vector1.getValue(i, k) * vector2.getValue(k, j);
                    }
                }
            }
            System.out.println("Resultado da multiplicação:");
            for (int i = 0; i < resultado.getArray().length; i++) {
                System.out.print("\u001B[34m");

                for (int j = 0; j < resultado.getArray()[i].length; j++) {
                    if(resultado.getArray()[i][j] < 0 ){
                        System.out.print(resultado.getArray()[i][j]+ " " );
                    }
                    else {
                        System.out.print(" " + resultado.getArray()[i][j] + " ");

                    }

                }

                System.out.print("\u001B[0m");
                System.out.println();

            }
            return resultado;
        } else {
            System.out.println("Tamanhos imcompativeis, coluna da matrix1 = " + vector1.cols + ",  é diferente de das linhas da matrix2 = " + vector2.rows);
            return createMatrix(0, 0);
        }

    }

    // esse metodo estatico cria a matrix e a retorna, então voce pode alocar ela em algum lugar
    public static Vector createMatrix(int rows, int cols) {
        Scanner entrada = new Scanner(System.in);
        Vector vector = new Vector();
        vector.setRow(rows);
        vector.setCol(cols);
        vector.setArray(new double[rows][cols]);
        System.out.println("Insira o valor da Matrix");
        for (int i = 0; i < vector.getCols(); i++) {

            for (int j = 0; j < vector.getRows(); j++) {
                System.out.println("a" + (j + 1) + (i + 1));
                vector.getArray()[j][i] = entrada.nextDouble();
            }


        }
        return vector;
    }

    public static Vector mirror(Vector vector, int Number) {
        Vector operação = new Vector();

        if(Number == 1) {
            double[][] xAxis = new double[][]{
                    {1, 0,},
                    {0, -1,}
            };
            operação.setArray(xAxis);
            operação.setRow(2);
            operação.setCol(2);
        }
        if(Number == 2) {
            double[][] yAxis = new double[][]{
                    {-1, 0,},
                    {0, 1,}
            };
            operação.setArray(yAxis);
            operação.setRow(2);
            operação.setCol(2);
        }
        if(Number == 3) {
            double[][] x3dAxis = new double[][]{
                    {1, 0, 0},
                    {0, -1, 0},
                    {0, 0, -1}
            };

            operação.setArray(x3dAxis);
            operação.setRow(3);
            operação.setCol(3);
        }
        if(Number == 4) {
            double[][] y3dAxis = new double[][]{
                    {-1, 0, 0},
                    {0, 1, 0},
                    {0, 0, -1}
            };

            operação.setArray(y3dAxis);
            operação.setRow(3);
            operação.setCol(3);
        }
        if(Number == 5) {
            double[][] z3dAxis = new double[][]{
                    {-1, 0, 0},
                    {0, -1, 0},
                    {0, 0, 1}
            };

            operação.setArray(z3dAxis);
            operação.setRow(3);
            operação.setCol(3);
        }
        operação = Vector.dot(operação, vector);

        return operação;
    }
    public static Vector projeçao(Vector vector, int Number) {
        Vector operação = new Vector();

        if(Number == 1) {
            double[][] xAxis = new double[][]{
                    {1, 0,},
                    {0, 0,}
            };
            operação.setArray(xAxis);
            operação.setRow(2);
            operação.setCol(2);
        }
        if(Number == 2) {
            double[][] yAxis = new double[][]{
                    {0, 0,},
                    {0, 1,}
            };
            operação.setArray(yAxis);
            operação.setRow(2);
            operação.setCol(2);
        }
        if(Number == 3) {
            double[][] x3dAxis = new double[][]{
                    {1, 0, 0},
                    {0, 0, 0},
                    {0, 0, 0}
            };

            operação.setArray(x3dAxis);
            operação.setRow(3);
            operação.setCol(3);
        }
        if(Number == 4) {
            double[][] y3dAxis = new double[][]{
                    {0, 0, 0},
                    {0, 1, 0},
                    {0, 0, 0}
            };

            operação.setArray(y3dAxis);
            operação.setRow(3);
            operação.setCol(3);
        }
        if(Number == 5) {
            double[][] z3dAxis = new double[][]{
                    {0, 0, 0},
                    {0, 0, 0},
                    {0, 0, 1}
            };

            operação.setArray(z3dAxis);
            operação.setRow(3);
            operação.setCol(3);
        }
        operação = Vector.dot(operação, vector);

        return operação;
    }
    public static Vector rotation (Vector vector, double angle, int number  ){
        Vector operação = new Vector();
        if(number == 1){
            double[][] twoD = new double[][]{
                    {Math.cos(Math.toRadians(angle)), -Math.sin(Math.toRadians(angle))},
                    {Math.sin(Math.toRadians(angle)), Math.cos(Math.toRadians(angle))}
            };
            operação.setArray(twoD);
            operação.setRow(2);
            operação.setCol(2);
        }

        if(number == 4 ){
            double[][] Rz = new double[][]{
                    {Math.cos(Math.toRadians(angle)), -Math.sin(Math.toRadians(angle)), 0},
                    { Math.sin(Math.toRadians(angle)), Math.cos(Math.toRadians(angle)), 0},
                    {0, 0, 1}
            };
            operação.setArray(Rz);
            operação.setRow(3);
            operação.setCol(3);
        }
        if(number == 2 ){
            double[][] Rx = new double[][]{
                    {1, 0, 0},
                    {0, Math.cos(Math.toRadians(angle)), -Math.sin(Math.toRadians(angle))},
                    {0, Math.sin(Math.toRadians(angle)), Math.cos(Math.toRadians(angle))},

            };
            operação.setArray(Rx);
            operação.setRow(3);
            operação.setCol(3);
        }
        if(number == 3 ){
            double[][] Ry = new double[][]{
                    {Math.cos(Math.toRadians(angle)),0, Math.sin(Math.toRadians(angle))},
                    {0, 1, 0},
                    {-Math.sin(Math.toRadians(angle)),0, Math.cos(Math.toRadians(angle))},

            };
            operação.setArray(Ry);
            operação.setRow(3);
            operação.setCol(3);
        }
        operação = Vector.dotFixed(operação, vector);
        return operação;
    }







    public static Vector dotFixed(Vector vector1, Vector vector2) {
        if (vector1.cols == vector2.rows) {
            Vector resultado = new Vector();
            resultado.setArray(new double[vector1.getRows()][vector2.getCols()]);
            resultado.setCol(vector2.getCols());
            resultado.setRow(vector1.getCols());
            for (int i = 0; i < vector1.getRows(); i++) {
                for (int j = 0; j < vector2.getCols(); j++) {
                    for (int k = 0; k < vector1.getCols(); k++) {
                        resultado.getArray()[i][j] += vector1.getValue(i, k) * vector2.getValue(k, j);
                    }
                }
            }
            System.out.println("Resultado :");
            for (int i = 0; i < resultado.getArray().length; i++) {
                System.out.print("\u001B[34m");

                for (int j = 0; j < resultado.getArray()[i].length; j++) {
                    if(resultado.getArray()[i][j] < 0 ){
                        System.out.printf("%.2f ", resultado.getArray()[i][j] );
                    }
                    else {
                        System.out.printf(" %.2f ", resultado.getArray()[i][j] );

                    }

                }

                System.out.print("\u001B[0m");
                System.out.println();

            }
            return resultado;
        } else {
            System.out.println("Tamanhos imcompativeis, coluna da matrix1 = " + vector1.cols + ",  é diferente de das linhas da matrix2 = " + vector2.rows);
            return createMatrix(0, 0);
        }

    }

    public static Vector translate(Vector vector, int dx, int dy, int dz, int choice) {
        Vector operação = new Vector();
        double[][] translationArray;

        if (choice == 1) {
            translationArray = new double[][]{
                    {1, 0, dx},
                    {0, 1, dy},
                    {0, 0, 1}
            };
            operação.setArray(translationArray);
            operação.setRow(3);
            operação.setCol(3);
        }
        if (choice == 2) {
            translationArray = new double[][]{
                    {1, 0, 0, dx},
                    {0, 1, 0, dy},
                    {0, 0, 1, dz},
                    {0, 0, 0, 1}
            };
            operação.setArray(translationArray);
            operação.setRow(4);
            operação.setCol(4);
        }


        operação = Vector.dotFixedAgain(operação, vector);

        return operação;
    }

    public static Vector dotFixedAgain(Vector vector1, Vector vector2) {
        if (vector1.cols == vector2.rows) {
            Vector resultado = new Vector();
            resultado.setArray(new double[vector1.getRows()][vector2.getCols()]);
            resultado.setCol(vector2.getCols());
            resultado.setRow(vector1.getCols());
            for (int i = 0; i < vector1.getRows(); i++) {
                for (int j = 0; j < vector2.getCols(); j++) {
                    for (int k = 0; k < vector1.getCols(); k++) {
                        resultado.getArray()[i][j] += vector1.getValue(i, k) * vector2.getValue(k, j);
                    }
                }
            }
            System.out.println("Resultado da multiplicação:");
            for (int i = 0; i < resultado.getArray().length - 1; i++) {
                System.out.print("\u001B[34m");

                for (int j = 0; j < resultado.getArray()[i].length; j++) {
                    if(resultado.getArray()[i][j] < 0 ){
                        System.out.printf("%.1f ", resultado.getArray()[i][j] );
                    }
                    else {
                        System.out.printf(" %.1f ", resultado.getArray()[i][j] );

                    }

                }

                System.out.print("\u001B[0m");
                System.out.println();

            }
            return resultado;
        } else {
            System.out.println("Tamanhos imcompativeis, coluna da matrix1 = " + vector1.cols + ",  é diferente de das linhas da matrix2 = " + vector2.rows);
            return createMatrix(0, 0);
        }

    }

    public static Vector cisalhamento(Vector vector, double dx, double dy ) {
        Vector operação = new Vector();
        double[][] translationArray;


            translationArray = new double[][]{
                    {1, dx},
                    {dy, 1},

            };
            operação.setArray(translationArray);
            operação.setRow(2);
            operação.setCol(2);



        operação = Vector.dot(operação, vector);

        return operação;
    }

}