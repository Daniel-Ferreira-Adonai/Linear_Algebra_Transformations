package transformation;

import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        // Criação do scanner
        Scanner entrada = new Scanner(System.in);
        // inicialização da matrix 1, matrix 2 começa vazia e se entrar na condição ela é preenchida;
        Vector resultado = null;
        Vector vector2 = null;
        System.out.print("Digite as linhas do vetor ou matriz de vetores: ");
        int row1 = entrada.nextInt();
        System.out.print("Digite as colunas do vetor ou matriz de vetores: ");
        int col1 = entrada.nextInt();
        Vector vector1 = Vector.createMatrix(row1, col1);
        System.out.println("Deseja criar uma segunda matrix ?\nSim = 1\nNão = 2");

        // condição que verifica a criação da matrix2, (implementar no menu posteriormente)
        if (entrada.nextInt() == 1) {
            System.out.print("Digite as linhas do segundo vetor ou matriz de vetores: ");
            int row2 = entrada.nextInt();
            System.out.print("Digite as colunas do segundo vetor ou matriz de vetores: ");
            int col2 = entrada.nextInt();

            vector2 = Vector.createMatrix(row2, col2);
        }

        // loop do menu
        while (true) {
            System.out.println("---------MENU----------\nDigite 0 para encerrar\nDigite 1 para Multiplicação\n" +
                    "Digite 2 para reflexão\nDigite 3 para translação\nDigite 4 para rotação\nDigite 5 para projeção\nDigite 6 para cisalhamento\nDigite 10 para recriar vetor/matriz1 ou 2\n");
            System.out.println("---------MENU----------");
            int menu = entrada.nextInt();
            if (menu == 0) {
                break;
            }
            if (menu == 1 && vector2 != null) {
                resultado = Vector.dot(vector1, vector2);
            }
            if (menu == 2) {

                System.out.println("digite o valor da reflexão\nxAxis = 1\nyAxis = 2\nx3dAxis = 3\ny3dAxis = 4\nz3dAxis = 5");
                int number = entrada.nextInt();
                System.out.println("Qual vetor ou matrix de vetores deseja utilizar ?\nMatrix1 = 1\nMatrix2 = 2\nMatrixResultado = 3");
                int number2 = entrada.nextInt();
                if (number2 == 1) {
                    resultado = Vector.mirror(vector1, number);
                }
                if (number2 == 2 && vector2 != null) {
                    resultado = Vector.mirror(vector2, number);
                }
                if (number2 == 2 && vector2 == null) {
                    System.out.println("Matrix ou vetor 2 esta vazia");
                }
                if (number2 == 3) {
                    resultado = Vector.mirror(resultado, number);
                }

            }
            if (menu == 10) {
                System.out.println("1 para matrix1\n2 para matrix2\n");
                int number = entrada.nextInt();
                if (number == 2) {
                    System.out.print("Digite as linhas da segunda matrix ou vetor: ");
                    int row2 = entrada.nextInt();
                    System.out.print("Digite as colunas da segunda matrix ou vetor: ");
                    int col2 = entrada.nextInt();

                    vector2 = Vector.createMatrix(row2, col2);
                }
                if (number == 1) {
                    System.out.print("Digite as linhas do vetor ou matriz de vetores: ");
                    row1 = entrada.nextInt();
                    System.out.print("Digite as colunas do vetor ou matriz de vetores: ");
                    col1 = entrada.nextInt();

                    vector1 = Vector.createMatrix(row1, col1);
                }

            }
            if (menu == 3) {
                System.out.print("Digite o deslocamento em x: ");
                int dx = entrada.nextInt();
                System.out.print("Digite o deslocamento em y: ");
                int dy = entrada.nextInt();
                int dz = 0;

                System.out.println(" Digite a operação\nDigite 1 para 2d\nDigite 2 para 3d");
                int choice2 = entrada.nextInt();
                if(choice2 == 2){
                    System.out.println("digite o valor de dz");
                     dz = entrada.nextInt();
                }
                System.out.println("Qual vetor ou matriz de vetores deseja utilizar para a translação?\nMatrix1 = 1\nMatrix2 = 2\nMatrixResultado = 3");
                int choice = entrada.nextInt();
                if (choice == 1) {
                    resultado = Vector.translate(vector1, dx, dy, dz, choice2);
                } else if (choice == 2 && vector2 != null) {
                    resultado = Vector.translate(vector2, dx, dy, dz, choice2);
                } else if (choice == 3 && resultado != null) {
                    resultado = Vector.translate(resultado, dx, dy, dz,choice2);
                } else {
                    System.out.println("Opção inválida ou matrix vazia");
                }
            }

                if (menu == 4) {
                    System.out.println("Digite o tipo de rotação:\nRotação2d = 1\nRotação3d EixoX = 2\nRotação3d EixoY = 3\nRotação3d EixoZ = 4");
                    int number = entrada.nextInt();
                    System.out.println("Digite o ângulo da rotação");
                    int angle = entrada.nextInt();


                    System.out.println("Qual vetor ou matriz de vetores deseja utilizar ?\nMatriz1 = 1\nMatriz2 = 2\nMatrizResultado = 3");
                    int number2 = entrada.nextInt();
                    if (number2 == 1) {
                        resultado = Vector.rotation(vector1, angle, number );
                    }
                    if (number2 == 2 && vector2 != null) {
                        resultado = Vector.rotation(vector2, angle, number );
                    }
                    if (number2 == 2 && vector2 == null) {
                        System.out.println("Matrix ou vetor 2 esta vazia");
                    }
                    if (number2 == 3) {
                        resultado = Vector.rotation(resultado, angle, number);
                    }


                }
                if (menu == 5) {

                    System.out.println("digite o valor da Projecao\nProjecao em 2dx = 1\nProjecao em 2dy = 2\nProjecao em 3dx = 3\nProjecao em 3dy = 4\nProjecao em 3dz = 5");
                    int number = entrada.nextInt();
                    System.out.println("Qual vetor ou matrix de vetores deseja utilizar ?\nMatrix1 = 1\nMatrix2 = 2\nMatrixResultado = 3");
                    int number2 = entrada.nextInt();
                    if (number2 == 1) {
                        resultado = Vector.projeçao(vector1, number);
                    }
                    if (number2 == 2 && vector2 != null) {
                        resultado = Vector.projeçao(vector2, number);
                    }
                    if (number2 == 2 && vector2 == null) {
                        System.out.println("Matrix ou vetor 2 esta vazia");
                    }
                    if (number2 == 3) {
                        resultado = Vector.projeçao(resultado, number);
                    }

                }
            if (menu == 6) {
                System.out.print("Digite o cisalhamento em x: ");
                double dx = entrada.nextDouble();
                System.out.print("Digite o cisalhamento em y: ");
                double dy = entrada.nextDouble();


                System.out.println("Qual vetor ou matriz de vetores deseja utilizar para a translação?\nMatrix1 = 1\nMatrix2 = 2\nMatrixResultado = 3");
                int choice = entrada.nextInt();
                if (choice == 1) {
                    resultado = Vector.cisalhamento(vector1, dx, dy );
                }
                else if (choice == 2 && vector2 != null) {
                    resultado = Vector.cisalhamento(vector2, dx, dy);
                } else if (choice == 3 && resultado != null) {
                    resultado = Vector.cisalhamento(resultado, dx, dy);
                } else {
                    System.out.println("Opção inválida ou matrix vazia");
                }
            }

        }
    }
}