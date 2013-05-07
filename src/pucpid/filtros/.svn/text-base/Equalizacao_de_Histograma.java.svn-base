package pucpid.filtros;

import java.util.HashMap;
import java.util.Set;

public class Equalizacao_de_Histograma {

    private int vetor_local[];
    private double vet_retorno[];
    private int tamanho_horizontal, tamanho_vertical;
    private int NC;//niveis de cinza

    public Equalizacao_de_Histograma(int imagem[][]) {
        tamanho_horizontal = imagem.length;
        tamanho_vertical = imagem[0].length;
        int contador = 0; // posicao vetor

        vetor_local = new int[tamanho_horizontal * tamanho_vertical];
        //passando a imagem para um vetor
        for (int x = 0; x < tamanho_horizontal; x++) {
            for (int y = 0; y < tamanho_vertical; y++) {
                vetor_local[contador] = imagem[x][y];
                contador++;
            }// fim for
        }// fim for

        NC = NiveisdeCinzadaImagem(imagem);

    }// fim construtor

    // ==========================================================
    /**
     * A cada posi��o da matriz, soma-se os valores de cada pixel (acumular).
     */
    private double[] Histograma_Acumalado() {
        double HA[] = new double[vetor_local.length];
        int somador = 0;

        for (int x = 0; x < vetor_local.length; x++) {
            somador += vetor_local[x];
            HA[x] = somador;
        }//fim for

        return HA;
    }//fim Histograma_Acumulado

    // ===========================================================
    /**
     * Pega cada posi��o da matriz e divide pelo tamanho da imagem.
     */
    private double[] Histograma_Normalizado(double HA[]) {
        double HN[] = new double[vetor_local.length];

        for (int x = 0; x < vetor_local.length; x++) {
            HN[x] = (HA[x] / HA[vetor_local.length - 1]);
        }//fim for

        return HN;
    }//fim Histograma_Normalizado

    // ==========================================================
    /**
     * Cada posi��o da matriz � multiplicado pelo n�vel de cinza. Todo o valor
     * obtido ser� arredondado para cima.
     */
    private double[] Histograma_Novo(double HN[]) {
        double H_Novo[] = new double[vetor_local.length];
        H_Novo = EqualizaVetor(HN);
        //============
        // System.out.println("NC: " + NC);
        // System.out.println("H_Equalizado");
        // Imprimir(H_Novo);
        //============
        int valor = 0;
        for (int x = 0; x < vetor_local.length; x++) {
            valor = (int) HN[x];
            if (HN[x] - valor >= 0.5) {
                H_Novo[x] = (int) Math.ceil(HN[x]);//arredonda para cima
            } else {
                H_Novo[x] = (int) Math.floor(HN[x]);//arredonda para baixo
            }
        }//fim for

        return H_Novo;
    }//fim Histograma_Novo

    // ===========================================================
    /**
     * Utiliza o histograma novo para criar a distribui��o das cores no
     * histograma final.
     */
    private double[] Histograma_Final(double H_Novo[]) {
        double HFinal[] = new double[H_Novo.length];
        HashMap<Integer, Integer> controle = new HashMap<Integer, Integer>();

        for (int i = 0; i < H_Novo.length; i++) {
            int pos = (int)H_Novo[i];
            controle.put(pos, 0);;
        }

        for (int i = 0; i < H_Novo.length; i++) {
            int pos = (int)H_Novo[i];
            int valor = controle.get(pos);
            valor = valor+vetor_local[i];
            controle.put(pos, valor);
        }

        Set<Integer> per = controle.keySet();
        for(Integer i: per){
            HFinal[(int)i] = controle.get(i);
        }


        return HFinal;
    }
//===================================================================

    public void Equalizar_Histograma() {

        vet_retorno = Histograma_Acumalado();
        System.out.println("Saindo do Acumulado");
        vet_retorno = Histograma_Normalizado(vet_retorno);
        System.out.println("Saindo do Normalizado");
        vet_retorno = Histograma_Novo(vet_retorno);
        System.out.println("Saindo do Histograma Novo");
        vet_retorno = Histograma_Final(vet_retorno);
        System.out.println("Saindo do Histograma Final");
    }
//=========================================================================
    //Esse m�todo dever� ser removido ap�s o teste do programa

    public double[] Imprimir() {
        return vet_retorno;
    }//fim Imprimir
//=======================================================================

    /**
     * Quantos niveis de cinza tem a imagem
     */
    private int NiveisdeCinzadaImagem(int imagem[][]) {
        int nc = 0;

        for (int x = 0; x < tamanho_horizontal; x++) {
            for (int y = 0; y < tamanho_vertical; y++) {
                //verifica se o pixel é ou nao preto
                //se for preto eu nao conto
                if (imagem[x][y] != 0) {
                    nc++;
                }
            }// fim for
        }// fim for

        return nc;
    }
//=======================================================================	

/*    public static void main(String[] args) {
        int img[][] = new int[1][8];
//        //esta imagem que estamos testando é um exemplo do professor  da lista de exercicio 01
        img[0][0] = 5;
        img[0][1] = 15;
        img[0][2] = 20;
        img[0][3] = 10;
        img[0][4] = 0;
        img[0][5] = 5;
        img[0][6] = 25;
        img[0][7] = 20;

        Equalizacao_de_Histograma Exec = new Equalizacao_de_Histograma(img);
        Exec.Equalizar_Histograma();
    }*/

    /**
     * Este metodo somente foi criado para poder mostrar o vetor original.
     * Pode-se despreza-lo
     */
//    private double[] Passa_vetor_para_Double() {
//        double vet[] = new double[vetor_local.length];
//
//        for (int x = 0; x < vet.length; x++) {
//            vet[x] = vetor_local[x] * 1.0;
//        }//fim for
//
//        return vet;
//    }
    /**
     * Multiplica cada posiçao do vetor pelo nivel de cinza
     */
    private double[] EqualizaVetor(double[] HN) {

        for (int x = 0; x < HN.length; x++) {
            HN[x] = HN[x] * (NC - 1);
        }
        return HN;
    }
}
