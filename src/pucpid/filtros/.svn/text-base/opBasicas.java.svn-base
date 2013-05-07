package pucpid.filtros;

import pucpid.controles.Pixel;

public class opBasicas {

    private int [][] imgPixel,controImgPixel;
    private int width,width0,height,height0;
    private int maiorw, maiorh;
    private int menorw,menorh;

    public int getMaiorh() {
        return maiorh;
    }

    public int getMaiorw() {
        return maiorw;
    }

    

    public opBasicas(int[][] imgPixel, int[][] controImgPixel, int width, int height , int width0, int height0) {
        this.imgPixel = imgPixel;
        this.controImgPixel = controImgPixel;
        this.width = width;
        this.width0 = width0;
        this.height = height;
        this.height0 = height0;
    }

    public int[][] somarImagem() {
        
        if(width > width0){
            maiorw = width;
            menorw = width0;
        }else {
            maiorw = width0;
            menorw = width;
        }
        if(height > height0){
            maiorh = height;
            menorh = height0;
        }else {
            maiorh = height0;
            menorh = height;
        }
        System.out.println(maiorw);
        System.out.println(maiorh);
        int [][] soma = new int [maiorw][maiorh];
        System.out.println(soma.length);
        for(int i = 0;i<maiorh;i++){
            for(int y = 0;y<maiorw;y++){
                soma[y][i] = 0;
            }
        }
        for(int h = 0;h<menorh;h++){
            for(int w = 0;w<menorw;w++){
                Pixel p = new Pixel();
                soma[w][h] = p.somaRgb(imgPixel[w][h],controImgPixel[w][h]);
            }
        }
        return soma;
    }

    public int[][] multImagem() {

        if(width > width0){
            maiorw = width;
            menorw = width0;
        }else {
            maiorw = width0;
            menorw = width;
        }
        if(height > height0){
            maiorh = height;
            menorh = height0;
        }else {
            maiorh = height0;
            menorh = height;
        }
        System.out.println(maiorw);
        System.out.println(maiorh);
        int [][] soma = new int [maiorw][maiorh];
        System.out.println(soma.length);
        for(int i = 0;i<maiorh;i++){
            for(int y = 0;y<maiorw;y++){
                soma[y][i] = 0;
            }
        }
        for(int h = 0;h<menorh;h++){
            for(int w = 0;w<menorw;w++){
                Pixel p = new Pixel();
                soma[w][h] = p.multiplicarRgb(imgPixel[w][h],controImgPixel[w][h]);
            }
        }
        return soma;
    }

        public int[][] divImagem() {

        if(width > width0){
            maiorw = width;
            menorw = width0;
        }else {
            maiorw = width0;
            menorw = width;
        }
        if(height > height0){
            maiorh = height;
            menorh = height0;
        }else {
            maiorh = height0;
            menorh = height;
        }
        System.out.println(maiorw);
        System.out.println(maiorh);
        int [][] soma = new int [maiorw][maiorh];
        System.out.println(soma.length);
        for(int i = 0;i<maiorh;i++){
            for(int y = 0;y<maiorw;y++){
                soma[y][i] = 0;
            }
        }
        for(int h = 0;h<menorh;h++){
            for(int w = 0;w<menorw;w++){
                Pixel p = new Pixel();
                soma[w][h] = p.divRgb(imgPixel[w][h],controImgPixel[w][h]);
            }
        }
        return soma;
    }

    public int[][] subImagem() {

        if(width > width0){
            maiorw = width;
            menorw = width0;
        }else {
            maiorw = width0;
            menorw = width;
        }
        if(height > height0){
            maiorh = height;
            menorh = height0;
        }else {
            maiorh = height0;
            menorh = height;
        }
        System.out.println(maiorw);
        System.out.println(maiorh);
        int [][] soma = new int [maiorw][maiorh];
        System.out.println(soma.length);
        for(int i = 0;i<maiorh;i++){
            for(int y = 0;y<maiorw;y++){
                soma[y][i] = 0;
            }
        }
        for(int h = 0;h<menorh;h++){
            for(int w = 0;w<menorw;w++){
                Pixel p = new Pixel();
                soma[w][h] = p.subRgb(imgPixel[w][h],controImgPixel[w][h]);
            }
        }
        return soma;
    }
}
