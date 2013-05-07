package pucpid.filtros;


import javax.swing.JOptionPane;

public class Matriz {

    public static int l1, l2, c1, c2, menorlin, menorcol, maiorlin, maiorcol;
    public static int[][] soma;

    public static void encontra_Maior_Menor_Linha_Coluna(int[][] m1, int[][] m2) {
        l1 = m1.length;
        c1 = m1[0].length;
        l2 = m2.length;
        c2 = m2[0].length;

        if (l1 <= l2) {
            menorlin = l1;
            maiorlin = l2;
        } else {
            menorlin = l2;
            maiorlin = l1;
        }
        if (c1 <= c2) {
            menorcol = c1;
            maiorcol = c2;
        } else {
            menorcol = c2;
            maiorcol = c1;
        }
        System.out.println("MaiorL:" + maiorlin + "\tmenorl:" + menorlin + "\tMaiorC:" + maiorcol + "\tmenorc:" + menorcol);
    }

    public static void main(String args[]) {

        int[][] x, y;
        int l, c;
        
        l = Integer.parseInt(JOptionPane.showInputDialog("Tamanho Linha Matriz"));
        c = Integer.parseInt(JOptionPane.showInputDialog("Tamanho Coluna Matriz"));

        x = new int[l][c];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                x[i][j] = 1;
            }
        }
        System.out.println("Matriz A [" + x.length + "] [" + x[0].length + "]");
        Mostrar(x);

        l = Integer.parseInt(JOptionPane.showInputDialog("Tamanho Linha Matriz"));
        c = Integer.parseInt(JOptionPane.showInputDialog("Tamanho Coluna Matriz"));
        y = new int[l][c];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                y[i][j] = 2;
            }
        }
        System.out.println("Matriz B [" + y.length + "] [" + y[0].length + "]");
        Mostrar(y);

        encontra_Maior_Menor_Linha_Coluna(x, y);
        soma = new int[maiorlin][maiorcol];
        System.out.println("Matriz Soma [" + soma.length + "] [" + soma[0].length + "]");
        somaMatriz(x, y);
        Mostrar(soma);


    }

    public static void somaMatriz(int[][] x, int[][] y) {

        //Captura a interseção das imagens
        for (int i = 0; i < menorlin; i++) {
            for (int j = 0; j < menorcol; j++) {
                soma[i][j] = x[i][j] + y[i][j];
            }
        }
        //Captura resto da matriz
        //LINHA
        //Neste if eu tenho certeza que a Matriz/Imagem maior com relação a linha é a primeira
        if (maiorlin == x.length) {
            for (int i = menorlin; i < maiorlin; i++) {
                for (int j = 0; j < x[0].length; j++) {
                    soma[i][j] = x[i][j];
                }
            }
        } else {
            //Aqui é a segunda
            for (int i = menorlin; i < maiorlin; i++) {
                for (int j = 0; j < y[0].length; j++) {
                    soma[i][j] = y[i][j];
                }
            }
        }
        //COLUNA
        //Neste if eu tenho certeza que a Matriz/Imagem maior com relação a coluna é a primeira
        if (maiorcol == x[0].length) {
            for (int i = 0; i < x.length; i++) {
                for (int j = menorcol; j < maiorcol; j++) {
                    soma[i][j] = x[i][j];
                }
            }
        } else {
            //aqui é a segunda
            for (int i = 0; i < y.length; i++) {
                for (int j = menorcol; j < maiorcol; j++) {
                    soma[i][j] = y[i][j];
                }
            }
        }
    }

    private static void Mostrar(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }
}

/**
 * * * * * * * * * * * * * * * * *
 * * * * Testes Realizados * * * *

Matriz A [2] [2]
1        1

1        1

Matriz B [3] [3]
2        2        2

2        2        2

2        2        2

Matriz Soma [3] [3]
3        3        2

3        3        2

2        2        2

 * * * * * * * * * * * * * * * *

Matriz A [3] [4]
1        1        1        1

1        1        1        1

1        1        1        1

Matriz B [4] [3]
2        2        2

2        2        2

2        2        2

2        2        2

Matriz Soma [4] [4]
3        3        3        1

3        3        3        1

3        3        3        1

2        2        2        0

 * * * * * * * * * * * * * * * * *

Matriz A [2] [6]
1        1        1        1        1        1

1        1        1        1        1        1

Matriz B [4] [5]
2        2        2        2        2

2        2        2        2        2

2        2        2        2        2

2        2        2        2        2

Matriz Soma [4] [6]
3        3        3        3        3        1

3        3        3        3        3        1

2        2        2        2        2        0

2        2        2        2        2        0

 * * * * * * * * * * * * * * * * *

Matriz A [5] [2]
1        1

1        1

1        1

1        1

1        1

Matriz B [3] [4]
2        2        2        2

2        2        2        2

2        2        2        2

MaiorL:5        menorl:3        MaiorC:4        menorc:2
Matriz Soma [5] [4]
3        3        2        2

3        3        2        2

3        3        2        2

1        1        0        0

1        1        0        0

 */