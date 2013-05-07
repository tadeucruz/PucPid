package pucpid.filtros;

import javax.swing.JOptionPane;
import pucpid.controles.Pixel;

/**
 * Classe Pid
 *
 * @author 
 */
public class Filtro {
    //======== Declaracao das variaveis globais ===================

    /**
     * matriz_mediana: Matriz que sera usada para armazenar a matriz aplicada ao filtro mediana
     * matriz_media:Matriz que sera usada para armazenar a matriz aplicada ao filtro media
     * matriz_max: Matriz que sera usada para armazenar a matriz aplida ao filtro max
     */
    public static int matriz_mediana[][], matriz_media[][], matriz_max[][], vet[][];
    /**
     * matriz_min: Matriz que sera usada para armazenar a matriz aplicada ao filtro min
     * matriz_moda: Matriz que sera usada para armazenar a matriz aplicada ao filtro moda
     * vetor: Vetor usado por varios metodos para poder capturar os valores da matris que
     *        serao trabalhado naquele momento
     */
    public static int matriz_min[][], matriz_moda[][], vetor[];
    /**
     * media: Valor central do vetor para ser usado ma nova imagem
     * mascara: Valor que diz o tamanho do filtro que sera aplicado sobre a imagem
     * linhaM: Variavel para trabalhar com a linha das matrizes
     * colunaM: Variavel para trabalhar com as colunas das matrizes
     */
    public static int media, mascara, linhaM, colunaM;
    public static int s_h[][], s_v[][];

    //=========================================================
    /**
     * CONSTRUTOR DA CLASSE
     *
     * Responsavel por inicializar as variaveis globais.
     *
     * @param lin:
     * @param col:
     * @param masc:
     *
     */
    public Filtro(int lin, int col, int masc, int[][] imagem) {
        vet = imagem;
        mascara = masc; //mascara
        linhaM = lin; //linha da matriz
        colunaM = col; // coluna da matriz
        //---------- Matrizes -----------
        matriz_mediana = new int[lin][col];//mediana
        matriz_media = new int[lin][col];//media
        matriz_min = new int[lin][col];//minimo
        matriz_max = new int[lin][col];//maximo
        matriz_moda = new int[lin][col];//moda

        vetor = new int[masc * masc];
        setVetor(); // dimensionar a posicao central do vetor

        //inicializa a matriz media e a media com valores iguais a zero
        for (int x = 0; x < linhaM; x++) {
            for (int y = 0; y < colunaM; y++) {
                matriz_mediana[x][y] = 0;
                matriz_media[x][y] = 0;
            }//fim for
        }//fim for
    }//fim Pid
    //=========================================================

    //=========================================================
    /**
     * CONSTRUTOR DA CLASSE
     * 
     * Responsavel por inicializar as variaveis globais.
     *
     * @param lin:
     * @param col:
     * @param masc:
     *
     */
    public Filtro(int lin, int col, int masc) {
        mascara = masc; //mascara
        linhaM = lin; //linha da matriz
        colunaM = col; // coluna da matriz
        //---------- Matrizes -----------
        matriz_mediana = new int[lin][col];//mediana
        matriz_media = new int[lin][col];//media
        matriz_min = new int[lin][col];//minimo
        matriz_max = new int[lin][col];//maximo
        matriz_moda = new int[lin][col];//moda

        vetor = new int[masc * masc];
        setVetor(); // dimensionar a posicao central do vetor

        //inicializa a matriz media e a media com valores iguais a zero
        for (int x = 0; x < linhaM; x++) {
            for (int y = 0; y < colunaM; y++) {
                matriz_mediana[x][y] = 0;
                matriz_media[x][y] = 0;
            }//fim for
        }//fim for
    }//fim Pid
    //=========================================================

    /**
     * Este metodo e responsavel por aplicar a mascara sobre a matriz imagem.
     * A tecnica aplicada aqui e o calculo da media.
     *
     * @param img
     *
     */
    public void Mascaramento_Media(int img[][]) {
        int x, x_aux = 0, masc_x = mascara; //vari�veis de x
        int y, y_aux = 0, masc_y = mascara; // vari�veis de y
        int cont, linha = mascara / 2, coluna = mascara / 2, somadorAzul = 0, somadorVermelho = 0, somadorVerde = 0, somadorAlfa = 0, somador = 0;
        int medialocalAzul = 0, medialocalVermelho = 0, medialocalVerde = 0, medialocalAlfa = 0;

        while (x_aux + mascara <= linhaM && y_aux + mascara <= colunaM) {
            for (x = x_aux; x < masc_x; x++) {
                //System.out.println();
                for (y = y_aux; y < masc_y; y++) {
                    Pixel p = new Pixel(img[x][y]);
                    somadorAlfa += p.getAlfa();
                    somadorAzul += p.getAzul();
                    somadorVerde += p.getVerde();
                    somadorVermelho += p.getVermelho();
                    somador += img[x][y];
                }//fim for
            }//fim for
            //System.out.println();
            SelectionSort();
            if (masc_y == colunaM) {
                x_aux++;
                masc_x++;
                y_aux = 0;
                masc_y = mascara;
                cont = 0;
                medialocalAlfa = somadorAlfa / (mascara * mascara);
                medialocalAzul = somadorAzul / (mascara * mascara);
                medialocalVerde = somadorVerde / (mascara * mascara);
                medialocalVermelho = somadorVermelho / (mascara * mascara);
                Add_Media(linha, coluna, medialocalAlfa, medialocalAzul, medialocalVerde, medialocalVermelho);
                linha++;
                coluna = mascara / 2;
                somadorAlfa = 0;
                somadorAzul = 0;
                somadorVerde = 0;
                somadorVermelho = 0;
            }//fim if
            else {
                medialocalAlfa = somadorAlfa / (mascara * mascara);
                medialocalAzul = somadorAzul / (mascara * mascara);
                medialocalVerde = somadorVerde / (mascara * mascara);
                medialocalVermelho = somadorVermelho / (mascara * mascara);
                //System.out.println("mediaLocal: "+medialocal);
                Add_Media(linha, coluna, medialocalAlfa, medialocalAzul, medialocalVerde, medialocalVermelho);
                y_aux++;
                masc_y++;
                cont = 0;
                coluna++;
                somadorAlfa = 0;
                somadorAzul = 0;
                somadorVerde = 0;
                somadorVermelho = 0;
            }//fim else
            somador = 0;
        }//fim while
    }//fim Mascaramento_Media

    //=============================================================================
    /**
     * Este m�todo percorre a matriz imagem fazendo aplica��o da
     * m�scara. Ainda executa o m�todo de ordena��o Selection Sort
     * e atribui a mediana � nova matriz.
     * PREVIS�O: EXECUTAR MEDIANA - MAX E MIM
     *
     * @param img[][]:
     * @param filtro:
     *
     */
    public void Mascaramento(int img[][], String filtro) {
        int x, x_aux = 0, masc_x = mascara; //vari�veis de x
        int y, y_aux = 0, masc_y = mascara; // vari�veis de y
        int cont = 0, linha = mascara / 2, coluna = mascara / 2;

        while (x_aux + mascara <= linhaM && y_aux + mascara <= colunaM) {
            for (x = x_aux; x < masc_x; x++) {
                //System.out.println();
                for (y = y_aux; y < masc_y; y++) {
                    //System.out.print(img[x][y] + "\t");
                    vetor[cont] = img[x][y];
                    cont++;

                }//fim for
            }//fim for
            //System.out.println();
            SelectionSort();

            if (masc_y == colunaM) {//se a m�scara atingiu a �ltima coluna
                x_aux++;
                masc_x++;
                y_aux = 0;
                masc_y = mascara;
                cont = 0;
                if (filtro.equals("mediana")) {
                    Add_Mediana(linha, coluna);
                } else if (filtro.equals("min")) {
                    Add_Min(linha, coluna);
                } else if (filtro.equals("max")) {
                    Add_Max(linha, coluna);
                } else {
                    Add_Moda(linha, coluna, Localizar_Moda());
                }
                linha++;
                coluna = mascara / 2;
            }//fim if
            else {
                if (filtro.equals("mediana")) {
                    Add_Mediana(linha, coluna);
                } else if (filtro.equals("min")) {
                    Add_Min(linha, coluna);
                } else if (filtro.equals("max")) {
                    Add_Max(linha, coluna);
                } else {
                    Add_Moda(linha, coluna, Localizar_Moda());
                }
                y_aux++;
                masc_y++;
                cont = 0;
                coluna++;

            }//fim else

        }//fim while
    }//fim Mediana
    //=========================================================

    /**
     * Este m�todo tem por objetivo identificar o meio do vetor
     * na hora de identificar o elemento do meio para fazer a mediana.
     * Este elemento do meio ser� adicionado em uma nova matriz
     */
    public void setVetor() {
        media = (int) Math.ceil((vetor.length) / 2);
    }//fim getVetor()
    //=========================================================

    /**
     * Adiciona os valores m�nimos na nova matriz m�nimo.
     *
     * @param x:
     * @param y:
     */
    public void Add_Min(int x, int y) {
        matriz_min[x][y] = vetor[0];
        //System.out.println(vetor[0] + " m�nimo");
    }//fim Add_Min
    //===========================================================

    /**
     * Atribui o valor da m�dia em uma nova matriz (global)
     *
     * @param medialocal:
     * @param x:
     * @param y:
     */
    public void Add_Media(int x, int y, int medialocal) {
        matriz_media[x][y] = medialocal;
        //System.out.println(medialocal + " medialocal");
    }//fim Add_Media
    //=========================================================

    /**
     * Atribui a uma nova matriz (global) o valor da mediana
     *
     * @param x:
     * @param y:
     */
    public void Add_Mediana(int x, int y) {
        matriz_mediana[x][y] = vetor[media];
    }//fim Add_Mediana
    //============================================================

    /**
     *
     * @param x
     * @param y
     */
    public void Add_Max(int x, int y) {
        matriz_max[x][y] = vetor[vetor.length - 1];
        //System.out.println(vetor[vetor.length - 1] + " m�ximo");
    }//fim Add_Max
    //==========================================================

    /**
     *
     * @param x
     * @param y
     * @param moda
     */
    public void Add_Moda(int x, int y, int moda) {
        matriz_moda[x][y] = moda;
        System.out.println(moda + " moda");
    }//fim Add_Moda
    //==========================================================

    /**
     *
     */
    public void Filtro_Min() {
        Mascaramento(Adicionar_Aleatorio(), "min");
    }//fim Filtro_Min
    //============================================================

    /**
     *
     */
    public void Filtro_Mediana() {
        Mascaramento(Adicionar_Aleatorio(), "mediana");
    }//fim Filtro_Mediana
    //============================================================

    /**
     *
     */
    public void Filtro_Max() {
        Mascaramento(Adicionar_Aleatorio(), "max");
    }//fim Filtro_Max
    //============================================================

    /**
     *
     */
    public void Filtro_Media() {
        Mascaramento_Media(Adicionar_Aleatorio());
    }//fim Filtro_Media
    //=========================================================

    /**
     *
     */
    public void Filtro_Moda() {
        Mascaramento(Adicionar_Aleatorio(), "moda");
    }//fim Filtro_Moda()
    //========================================================

    /**
     *
     */
    public void Executa_Sobel() {
        int v[][] = Adicionar_Aleatorio();
        Filtro_Sobel(v);
    }//fim
    //=========================================================

    /**
     * Detector de bordas
     *
     * @param img
     */
    public void Filtro_Sobel(int img[][]) {
        int sobel_h[][] = new int[3][3];
        int sobel_v[][] = new int[3][3];

        sobel_h[0][0] = -1;
        sobel_h[0][1] = -2;
        sobel_h[0][2] = -1;
        sobel_h[1][0] = 0;
        sobel_h[1][1] = 0;
        sobel_h[1][2] = 0;
        sobel_h[2][0] = 1;
        sobel_h[2][1] = 2;
        sobel_h[2][2] = 1;

        s_h = Mascaramento_Sobel_Prewitt(sobel_h, img);

        sobel_v[0][0] = 1;
        sobel_v[0][1] = 2;
        sobel_v[0][2] = 1;
        sobel_v[1][0] = 0;
        sobel_v[1][1] = 0;
        sobel_v[1][2] = 0;
        sobel_v[2][0] = -1;
        sobel_v[2][1] = -2;
        sobel_v[2][2] = -1;

        s_v = Mascaramento_Sobel_Prewitt(sobel_v, img);
    }//fim Filtro_Sobel_Horizontal()
    //==========================================================

    public int[][] imprimeSobelH() {
        return s_h;
    }

    public int[][] imprimeSobelV() {
        return s_v;
    }

    /**
     *
     * @param img
     */
    public void Filtro_Prewitt(int img[][]) {
        int prewitt[][] = new int[3][3];

        prewitt[0][0] = -1;
        prewitt[0][1] = 0;
        prewitt[0][2] = 1;
        prewitt[1][0] = -1;
        prewitt[1][1] = 0;
        prewitt[1][2] = 1;
        prewitt[2][0] = -1;
        prewitt[2][1] = 0;
        prewitt[2][2] = 1;

       s_v = Mascaramento_Sobel_Prewitt(prewitt, img);
    }//fim Filtro_Prewitt()
    //==========================================================

    public int[][] imprimePrewitt() {
        return s_v;
    }

    /**
     * Realiza a m�scara com Sobel (horizontal e vertical) e Prewitt
     *
     * @param matriz
     * @param img
     * @return
     */
    public int[][] Mascaramento_Sobel_Prewitt(int matriz[][], int img[][]) {
        int matrizProcessada[][] = new int[img.length][img[0].length];
        int altura = img.length, largura = img[0].length;

        int convPixel, im, ip, jm, jp;

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {

                convPixel = 0;

                for (ip = i - 1, im = 0; ip <= (ip + 1) && im <= 2; ip++, im++) {
                    for (jp = j - 1, jm = 0; jp <= jp + 1 && jm <= 2; jp++, jm++) {
                        try {
                            convPixel += matriz[im][jm] * img[ip][jp];
                        } catch (ArrayIndexOutOfBoundsException e) {
                        }
                    }
                }

                if (convPixel > 255) {
                    convPixel = 255;
                } else if (convPixel < 0) {
                    convPixel = 0;
                }
                matrizProcessada[i][j] = convPixel;

            }
        }

        return matrizProcessada;
    }//Mascaramento_Sobel_Prewitt()
    //===========================================================

    /**
     * Este m�todo apenas inicializa uma matriz simulando uma matriz de
     * imagem. Essa matriz � utlizada para calcular a m�dia e a mediana.
     */
    public int[][] Adicionar_Aleatorio() {
        return vet;
    }//fim Adicionar()
    //===========================================================

    /**
     * Site: http://pt.wikipedia.org/wiki/Selection_sort
     */
    public void SelectionSort() {
        int index_min,
                aux;

        for (int i = 0; i < vetor.length; i++) {
            index_min = i;
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[index_min]) {
                    index_min = j;
                }//fim if
            }//fim for
            if (index_min != i) {
                aux = vetor[index_min];
                vetor[index_min] = vetor[i];
                vetor[i] = aux;
            }//fim if
        }//fim fot

        //return v;
    }//fim SelectionSort

    //=========================================================
    /**
     * M�todo de menor import�ncia. Utilizado para imprimir a matriz
     * final na tela para an�lise.
     */
    public int[][] Imprimir_Mediana() {
        return matriz_mediana;
    }//fim Imprimir
    //=========================================================

    /**
     * M�todo de menor import�ncia. Utilizado para imprimir a matriz
     * final na tela para an�lise.
     */
    public int[][] Imprimir_Media() {
        return matriz_media;
    }//fim Imprimir

    //================================================================================
    /**
     * M�todo de menor import�ncia. Utilizado para imprimir a matriz
     * final na tela para an�lise.
     */
    public int[][] Imprimir_Min() {
        return matriz_min;
    }//fim Imprimir

    //================================================================================
    /**
     * M�todo de menor import�ncia. Utilizado para imprimir a matriz
     * final na tela para an�lise.
     */
    public int[][] Imprimir_Max() {
        System.out.println("Matriz Max final" + "\n");
        return matriz_max;
    }//fim Imprimir

    //================================================================================
    /**
     * M�todo de menor import�ncia. Utilizado para imprimir a matriz
     * final na tela para an�lise.
     */
    public void Imprimir_Moda() {
        System.out.println("\n" + "Matriz Moda final" + "\n");
        for (int x = 0; x < linhaM; x++) {
            System.out.println();
            for (int y = 0; y < colunaM; y++) {
                System.out.print(matriz_moda[x][y] + "\t");
            }//fim for
        }//fim for

    }//fim Imprimir

    //================================================================================
    /**
     * 
     * @return
     */
    public int Localizar_Moda() {

        int moda = 0, aux = 0, valor = 0; //valor � o elemento da moda
        for (int x = 0; x < vetor.length; x++) {
            if (aux > moda) {
                moda = aux;
                valor = vetor[x - 1];
            }//fim if
            aux = 0;
            for (int y = x; y < vetor.length; y++) {
                if (vetor[x] == vetor[y]) {
                    aux++;
                }
            }//fim for
        }
        if (moda == 1) {
            return vetor[0];
        } else {
            return valor;
        }
    }//fim

    private void Add_Media(int linha, int coluna, int medialocalAlfa, int medialocalAzul, int medialocalVerde, int medialocalVermelho) {
        Pixel p = new Pixel(medialocalAzul, medialocalVermelho, medialocalVerde, medialocalAlfa);
        matriz_media[linha][coluna] = p.voltaRGB();
    }
    //================================================================================
}//fim class Pid

