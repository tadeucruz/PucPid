package pucpid.principal;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import pucpid.controles.Pixel;
import pucpid.filtros.Equalizacao_de_Histograma;
import pucpid.filtros.Filtro;
import pucpid.filtros.opBasicas;

public class controleImg {

    private BufferedImage img, saida = null;
    private int[][] imgPixel;
    private File arq;
    int[] rgbs;

    public void reset() {
        saida = null;
    }

    public int getWidth() {
        return img.getWidth();
    }

    public int getHeight() {
        return img.getHeight();
    }

    public void abrir(String path) throws IOException {
        //System.out.println(timestamp("X"));
        img = ImageIO.read(new File(path));
        imgPixel = new int[img.getWidth()][img.getHeight()];
        rgbs = new int[img.getWidth() * img.getHeight()];
        PixelGrabber pixel = new PixelGrabber(img, 0, 0, img.getWidth(), img.getHeight(), rgbs, 0, img.getWidth());
        try {
            pixel.grabPixels();
            int i = 0;
            int w = 0, h = 0;
            for (int control = 0; control < rgbs.length; control++) {
                imgPixel[w++][h] = rgbs[i++];
                //System.out.println(rgbs[i]);
                if (i % img.getWidth() == 0) {
                    h++;
                    w = 0;
                }
            }
            //rgbs = null;
        } catch (InterruptedException ex) {
            Logger.getLogger(controleImg.class.getName()).log(Level.SEVERE, null, ex);
        }
        File folderExisting = new File("tmp/");
        if(!folderExisting.exists()){
            folderExisting.mkdir();
        }
    }

    public void salvar(String path) throws IOException {

        /*String nomeArq = null;

        do{
        nomeArq = JOptionPane.showInputDialog("Nome do Arquivo");
        }while (nomeArq == null || nomeArq.equals(""));*/

        try {
            //arq = new File("tmp/" + cal.get(Calendar.HOUR_OF_DAY) + cal.get(Calendar.MINUTE) + cal.get(Calendar.SECOND) + "GAMBI1" + nomeArq);
            //arq = new File("tmp/" + nomeArq);
            if (saida == null) {
                saida = img;
            }
            arq = new File(path);
            ImageIO.write(saida, "JPG", arq);
        } catch (IOException ex) {
            Logger.getLogger(controleImg.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public File aplicarFiltroMax(String nomeArq, int mascara) {
        //Calendar cal = new GregorianCalendar();
        Filtro fil = new Filtro(img.getWidth(), img.getHeight(), mascara, imgPixel);
        fil.Filtro_Max();

        //BufferedImage saida = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        saida = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        WritableRaster raster = saida.getRaster();
        int[][] teste = fil.Imprimir_Max();
        for (int h = 0; h < img.getHeight(); h++) {
            for (int w = 0; w < img.getWidth(); w++) {
                int[] t = new int[4];
                Pixel p = new Pixel(teste[w][h]);
                t[0] = p.getVermelho();
                t[1] = p.getVerde();
                t[2] = p.getAzul();
                t[3] = p.getAlfa();
                raster.setPixel(w, h, t);
            }
        }
        try {
            //arq = new File("tmp/" + cal.get(Calendar.HOUR_OF_DAY) + cal.get(Calendar.MINUTE) + cal.get(Calendar.SECOND) + "MAX" + nomeArq);
            arq = new File("tmp/" + timestamp("MAX") + nomeArq);
            ImageIO.write(saida, "JPG", arq);
        } catch (IOException ex) {
            Logger.getLogger(controleImg.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arq;
    }

    public File aplicarFiltroMin(String nomeArq, int mascara) {
        //Calendar cal = new GregorianCalendar();
        Filtro fil = new Filtro(img.getWidth(), img.getHeight(), mascara, imgPixel);
        fil.Filtro_Min();

        //BufferedImage
        saida = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        WritableRaster raster = saida.getRaster();
        int[][] teste = fil.Imprimir_Min();
        for (int h = 0; h < img.getHeight(); h++) {
            for (int w = 0; w < img.getWidth(); w++) {
                int[] t = new int[4];
                Pixel p = new Pixel(teste[w][h]);
                t[0] = p.getVermelho();
                t[1] = p.getVerde();
                t[2] = p.getAzul();
                t[3] = p.getAlfa();
                raster.setPixel(w, h, t);
            }
        }
        try {
            //arq = new File("tmp/" + cal.get(Calendar.HOUR_OF_DAY) + cal.get(Calendar.MINUTE) + cal.get(Calendar.SECOND) + "MIN" + nomeArq);
            arq = new File("tmp/" + timestamp("MIN") + nomeArq);
            ImageIO.write(saida, "JPG", arq);
        } catch (IOException ex) {
            Logger.getLogger(controleImg.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arq;
    }

    public File aplicarFiltroMediana(String nomeArq, int mascara) {
        //Calendar cal = new GregorianCalendar();
        Filtro fil = new Filtro(img.getWidth(), img.getHeight(), mascara, imgPixel);
        fil.Filtro_Mediana();

        //BufferedImage
        saida = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        WritableRaster raster = saida.getRaster();
        int[][] teste = fil.Imprimir_Mediana();
        for (int h = 0; h < img.getHeight(); h++) {
            for (int w = 0; w < img.getWidth(); w++) {
                int[] t = new int[4];
                Pixel p = new Pixel(teste[w][h]);
                t[0] = p.getVermelho();
                t[1] = p.getVerde();
                t[2] = p.getAzul();
                t[3] = p.getAlfa();
                raster.setPixel(w, h, t);
            }
        }
        try {
            //arq = new File("tmp/" + cal.get(Calendar.HOUR_OF_DAY) + cal.get(Calendar.MINUTE) + cal.get(Calendar.SECOND) + "MEDIANA" + nomeArq);
            arq = new File("tmp/" + timestamp("MEDIANA") + nomeArq);
            ImageIO.write(saida, "JPG", arq);
        } catch (IOException ex) {
            Logger.getLogger(controleImg.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arq;
    }

    public File aplicarFiltroMedia(String nomeArq, int mascara) {
        //Calendar cal = new GregorianCalendar();
        Filtro fil = new Filtro(img.getWidth(), img.getHeight(), mascara, imgPixel);
        fil.Filtro_Media();

        //BufferedImage
        saida = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        WritableRaster raster = saida.getRaster();
        int[][] teste = fil.Imprimir_Media();
        for (int h = 0; h < img.getHeight(); h++) {
            for (int w = 0; w < img.getWidth(); w++) {
                int[] t = new int[4];
                Pixel p = new Pixel(teste[w][h]);
                t[0] = p.getVermelho();
                t[1] = p.getVerde();
                t[2] = p.getAzul();
                t[3] = p.getAlfa();
                raster.setPixel(w, h, t);
            }
        }
        try {
            //arq = new File("tmp/" + cal.get(Calendar.HOUR_OF_DAY) + cal.get(Calendar.MINUTE) + cal.get(Calendar.SECOND) + "MEDIANA" + nomeArq);
            arq = new File("tmp/" + timestamp("MEDIA") + nomeArq);
            ImageIO.write(saida, "JPG", arq);
        } catch (IOException ex) {
            Logger.getLogger(controleImg.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arq;
    }

    public File aplicarFiltroModa(String nomeArq, int mascara) {
        //Calendar cal = new GregorianCalendar();
        Filtro fil = new Filtro(img.getWidth(), img.getHeight(), mascara, imgPixel);
        fil.Filtro_Mediana();

        //BufferedImage
        saida = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        WritableRaster raster = saida.getRaster();
        int[][] teste = fil.Imprimir_Mediana();
        for (int h = 0; h < img.getHeight(); h++) {
            for (int w = 0; w < img.getWidth(); w++) {
                int[] t = new int[4];
                Pixel p = new Pixel(teste[w][h]);
                t[0] = p.getVermelho();
                t[1] = p.getVerde();
                t[2] = p.getAzul();
                t[3] = p.getAlfa();
                raster.setPixel(w, h, t);
            }
        }
        try {
            //arq = new File("tmp/" + cal.get(Calendar.HOUR_OF_DAY) + cal.get(Calendar.MINUTE) + cal.get(Calendar.SECOND) + "MODA" + nomeArq);
            arq = new File("tmp/" + timestamp("MODA") + nomeArq);
            ImageIO.write(saida, "JPG", arq);
        } catch (IOException ex) {
            Logger.getLogger(controleImg.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arq;
    }

    public File aplicarSoma(String nomeArq, String caminho) throws IOException, Exception {
        //Calendar cal = new GregorianCalendar();
        BufferedImage controleImg = ImageIO.read(new File(caminho));
        if (controleImg.getWidth() != img.getWidth()) {
            throw new Exception("Imagem de tamanhos diferentes");
        } else if (controleImg.getHeight() != img.getHeight()) {
            throw new Exception("Imagem de tamanhos diferentes");
        }
        int[][] controImgPixel = new int[controleImg.getWidth()][controleImg.getHeight()];
        int[] rgbs = new int[controleImg.getWidth() * controleImg.getHeight()];
        PixelGrabber pixel = new PixelGrabber(controleImg, 0, 0, controleImg.getWidth(), controleImg.getHeight(), rgbs, 0, controleImg.getWidth());
        try {
            pixel.grabPixels();
            int i = 0;
            int w = 0, h = 0;
            for (int control = 0; control < rgbs.length; control++) {
                controImgPixel[w++][h] = rgbs[i++];
                if (i % controleImg.getWidth() == 0) {
                    h++;
                    w = 0;
                }
            }
            rgbs = null;
        } catch (InterruptedException ex) {
            Logger.getLogger(controleImg.class.getName()).log(Level.SEVERE, null, ex);
        }
        opBasicas ob = new opBasicas(imgPixel, controImgPixel, img.getWidth(), img.getHeight(), controleImg.getWidth(), controleImg.getHeight());
        int[][] teste = ob.somarImagem();

        //BufferedImage
        saida = new BufferedImage(ob.getMaiorw(), ob.getMaiorh(), BufferedImage.TYPE_INT_RGB);
        WritableRaster raster = saida.getRaster();
        for (int h = 0; h < img.getHeight(); h++) {
            for (int w = 0; w < img.getWidth(); w++) {
                int[] t = new int[4];
                Pixel p = new Pixel(teste[w][h]);
                t[0] = p.getVermelho();
                t[1] = p.getVerde();
                t[2] = p.getAzul();
                t[3] = p.getAlfa();
                raster.setPixel(w, h, t);
            }
        }
        try {
            //arq = new File("tmp/" + cal.get(Calendar.HOUR_OF_DAY) + cal.get(Calendar.MINUTE) + cal.get(Calendar.SECOND) + "GAMBI1" + nomeArq);
            arq = new File("tmp/" + timestamp("SOMA") + nomeArq);
            ImageIO.write(saida, "JPG", arq);
        } catch (IOException ex) {
            Logger.getLogger(controleImg.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arq;
    }

    public File aplicarSub(String nomeArq, String caminho) throws IOException, Exception {
        Calendar cal = new GregorianCalendar();
        BufferedImage controleImg = ImageIO.read(new File(caminho));
        if (controleImg.getWidth() != img.getWidth()) {
            throw new Exception("Imagem de tamanhos diferentes");
        } else if (controleImg.getHeight() != img.getHeight()) {
            throw new Exception("Imagem de tamanhos diferentes");
        }
        int[][] controImgPixel = new int[controleImg.getWidth()][controleImg.getHeight()];
        int[] rgbs = new int[controleImg.getWidth() * controleImg.getHeight()];
        PixelGrabber pixel = new PixelGrabber(controleImg, 0, 0, controleImg.getWidth(), controleImg.getHeight(), rgbs, 0, controleImg.getWidth());
        try {
            pixel.grabPixels();
            int i = 0;
            int w = 0, h = 0;
            for (int control = 0; control < rgbs.length; control++) {
                controImgPixel[w++][h] = rgbs[i++];
                if (i % controleImg.getWidth() == 0) {
                    h++;
                    w = 0;
                }
            }
            rgbs = null;
        } catch (InterruptedException ex) {
            Logger.getLogger(controleImg.class.getName()).log(Level.SEVERE, null, ex);
        }
        opBasicas ob = new opBasicas(imgPixel, controImgPixel, img.getWidth(), img.getHeight(), controleImg.getWidth(), controleImg.getHeight());
        int[][] teste = ob.subImagem();

        //BufferedImage
        saida = new BufferedImage(ob.getMaiorw(), ob.getMaiorh(), BufferedImage.TYPE_INT_RGB);
        WritableRaster raster = saida.getRaster();
        for (int h = 0; h < img.getHeight(); h++) {
            for (int w = 0; w < img.getWidth(); w++) {
                int[] t = new int[4];
                Pixel p = new Pixel(teste[w][h]);
                t[0] = p.getVermelho();
                t[1] = p.getVerde();
                t[2] = p.getAzul();
                t[3] = p.getAlfa();
                raster.setPixel(w, h, t);
            }
        }
        try {
            //arq = new File("tmp/" + cal.get(Calendar.HOUR_OF_DAY) + cal.get(Calendar.MINUTE) + cal.get(Calendar.SECOND) + "GAMBI1" + nomeArq);
            arq = new File("tmp/" + timestamp("SUB") + nomeArq);
            ImageIO.write(saida, "JPG", arq);
        } catch (IOException ex) {
            Logger.getLogger(controleImg.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arq;
    }

    public File aplicarMult(String nomeArq, String caminho) throws IOException, Exception {
        //Calendar cal = new GregorianCalendar();
        BufferedImage controleImg = ImageIO.read(new File(caminho));
        if (controleImg.getWidth() != img.getWidth()) {
            throw new Exception("Imagem de tamanhos diferentes");
        } else if (controleImg.getHeight() != img.getHeight()) {
            throw new Exception("Imagem de tamanhos diferentes");
        }
        int[][] controImgPixel = new int[controleImg.getWidth()][controleImg.getHeight()];
        int[] rgbs = new int[controleImg.getWidth() * controleImg.getHeight()];
        PixelGrabber pixel = new PixelGrabber(controleImg, 0, 0, controleImg.getWidth(), controleImg.getHeight(), rgbs, 0, controleImg.getWidth());
        try {
            pixel.grabPixels();
            int i = 0;
            int w = 0, h = 0;
            for (int control = 0; control < rgbs.length; control++) {
                controImgPixel[w++][h] = rgbs[i++];
                if (i % controleImg.getWidth() == 0) {
                    h++;
                    w = 0;
                }
            }
            rgbs = null;
        } catch (InterruptedException ex) {
            Logger.getLogger(controleImg.class.getName()).log(Level.SEVERE, null, ex);
        }
        opBasicas ob = new opBasicas(imgPixel, controImgPixel, img.getWidth(), img.getHeight(), controleImg.getWidth(), controleImg.getHeight());
        int[][] teste = ob.multImagem();

        //BufferedImage
        saida = new BufferedImage(ob.getMaiorw(), ob.getMaiorh(), BufferedImage.TYPE_INT_RGB);
        WritableRaster raster = saida.getRaster();
        for (int h = 0; h < img.getHeight(); h++) {
            for (int w = 0; w < img.getWidth(); w++) {
                int[] t = new int[4];
                Pixel p = new Pixel(teste[w][h]);
                t[0] = p.getVermelho();
                t[1] = p.getVerde();
                t[2] = p.getAzul();
                t[3] = p.getAlfa();
                raster.setPixel(w, h, t);
            }
        }
        try {
            //arq = new File("tmp/" + cal.get(Calendar.HOUR_OF_DAY) + cal.get(Calendar.MINUTE) + cal.get(Calendar.SECOND) + "GAMBI1" + nomeArq);
            arq = new File("tmp/" + timestamp("MULT") + nomeArq);
            ImageIO.write(saida, "JPG", arq);
        } catch (IOException ex) {
            Logger.getLogger(controleImg.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arq;
    }

    public File aplicarDiv(String nomeArq, String caminho) throws IOException, Exception {
        //Calendar cal = new GregorianCalendar();
        BufferedImage controleImg = ImageIO.read(new File(caminho));
        if (controleImg.getWidth() != img.getWidth()) {
            throw new Exception("Imagem de tamanhos diferentes");
        } else if (controleImg.getHeight() != img.getHeight()) {
            throw new Exception("Imagem de tamanhos diferentes");
        }
        int[][] controImgPixel = new int[controleImg.getWidth()][controleImg.getHeight()];
        int[] rgbs = new int[controleImg.getWidth() * controleImg.getHeight()];
        PixelGrabber pixel = new PixelGrabber(controleImg, 0, 0, controleImg.getWidth(), controleImg.getHeight(), rgbs, 0, controleImg.getWidth());
        try {
            pixel.grabPixels();
            int i = 0;
            int w = 0, h = 0;
            for (int control = 0; control < rgbs.length; control++) {
                controImgPixel[w++][h] = rgbs[i++];
                if (i % controleImg.getWidth() == 0) {
                    h++;
                    w = 0;
                }
            }
            rgbs = null;
        } catch (InterruptedException ex) {
            Logger.getLogger(controleImg.class.getName()).log(Level.SEVERE, null, ex);
        }
        opBasicas ob = new opBasicas(imgPixel, controImgPixel, img.getWidth(), img.getHeight(), controleImg.getWidth(), controleImg.getHeight());
        int[][] teste = ob.divImagem();

        //BufferedImage
        saida = new BufferedImage(ob.getMaiorw(), ob.getMaiorh(), BufferedImage.TYPE_INT_RGB);
        WritableRaster raster = saida.getRaster();
        for (int h = 0; h < img.getHeight(); h++) {
            for (int w = 0; w < img.getWidth(); w++) {
                int[] t = new int[4];
                Pixel p = new Pixel(teste[w][h]);
                t[0] = p.getVermelho();
                t[1] = p.getVerde();
                t[2] = p.getAzul();
                t[3] = p.getAlfa();
                raster.setPixel(w, h, t);
            }
        }
        try {
            //arq = new File("tmp/" + cal.get(Calendar.HOUR_OF_DAY) + cal.get(Calendar.MINUTE) + cal.get(Calendar.SECOND) + "GAMBI1" + nomeArq);
            arq = new File("tmp/" + timestamp("DIV") + nomeArq);
            ImageIO.write(saida, "JPG", arq);
        } catch (IOException ex) {
            Logger.getLogger(controleImg.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arq;
    }

    public double[] valoresHistograma() {

        double[] volta = new double[img.getWidth() * img.getHeight()];
        for (int i = 0; i < rgbs.length; i++) {
            Pixel p = new Pixel(rgbs[i]);
            int r = p.getVermelho();
            int g = p.getVerde();
            int b = p.getAzul();
            volta[i] = (r * 0.3) + (g * 0.59) + (b * 0.11);
            //volta[i] = (-1) * rgbs[i];
            //System.out.println(volta[i]);
        }
        return volta;
    }

    public ArrayList<double[]> valoresHistogramaRGB() {
        double[] vermelho = new double[img.getWidth() * img.getHeight()];
        double[] azul = new double[img.getWidth() * img.getHeight()];
        double[] verde = new double[img.getWidth() * img.getHeight()];
        ArrayList<double[]> volta = new ArrayList<double[]>();
        for (int i = 0; i < rgbs.length; i++) {
            Pixel p = new Pixel(rgbs[i]);
            vermelho[i] = p.getVermelho();
            azul[i] = p.getAzul();
            verde[i] = p.getVerde();
            //System.out.println(volta[i]);
        }
        volta.add(vermelho);
        volta.add(azul);
        volta.add(verde);
        return volta;
    }

    public File aplicarLimiar(String nomeArq, int limiar) {

        //Calendar cal = new GregorianCalendar();
        //Filtro fil = new Filtro(img.getWidth(), img.getHeight(), mascara, imgPixel);
        //fil.Filtro_Mediana();

        //BufferedImage
        saida = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        //WritableRaster raster = saida.getRaster();
        //int[][] teste = fil.Imprimir_Mediana();
        for (int h = 0; h < img.getHeight(); h++) {
            for (int w = 0; w < img.getWidth(); w++) {
                //int[] t = new int[4];
                Pixel p = new Pixel(img.getRGB(w, h));
                //t[0] = p.getVermelho();
                //t[1] = p.getVerde();
                //t[2] = p.getAzul();
                //t[3] = p.getAlfa();
                int r = p.getVermelho();
                int g = p.getVerde();
                int b = p.getAzul();
                int NC = (int) Math.floor((r * 0.3) + (g * 0.59) + (b * 0.11) + 0.5);

                if (NC > limiar) //saida.setRGB(w, h, (Color.BLACK).getRGB());
                {
                    saida.setRGB(w, h, (Color.WHITE).getRGB());
                } else //saida.setRGB(w, h, p.voltaRGB());
                //saida.setRGB(w, h, (Color.WHITE).getRGB());
                {
                    saida.setRGB(w, h, (Color.BLACK).getRGB());
                }

                //img.setRGB(w, h, NC);
                //raster.setPixel(w, h, t);
            }
        }
        try {
            //arq = new File("tmp/" + cal.get(Calendar.HOUR_OF_DAY) + cal.get(Calendar.MINUTE) + cal.get(Calendar.SECOND) + "LIMIAR" + nomeArq);
            arq = new File("tmp/" + timestamp("LIMIAR") + nomeArq);
            ImageIO.write(saida, "JPG", arq);
        } catch (IOException ex) {
            Logger.getLogger(controleImg.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arq;

    }

    public File aplicarObamizador(String nomeArq) {

        //BufferedImage
        saida = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        //WritableRaster raster = saida.getRaster();
        for (int h = 0; h < img.getHeight(); h++) {
            for (int w = 0; w < img.getWidth(); w++) {
                Pixel p = new Pixel(img.getRGB(w, h));
                int r = p.getVermelho();
                int g = p.getVerde();
                int b = p.getAzul();
                int NC = (int) Math.floor((r * 0.3) + (g * 0.59) + (b * 0.11) + 0.5);

                if (NC > 180) {
                    saida.setRGB(w, h, (new Color(253, 245, 230)).getRGB()); // OldLace
                } else if (NC > 170) {
                    saida.setRGB(w, h, (new Color(230, 230, 250)).getRGB()); // Lavender
                } else if (NC > 140) {
                    saida.setRGB(w, h, (new Color(188, 210, 238)).getRGB()); // LightSteelBlue2
                } else if (NC > 110) {
                    saida.setRGB(w, h, (Color.RED).getRGB()); // Vermelho
                } else {
                    saida.setRGB(w, h, (new Color(10, 50, 115)).getRGB()); // Azul Escuro
                }
            }
        }
        try {
            //arq = new File("tmp/" + cal.get(Calendar.HOUR_OF_DAY) + cal.get(Calendar.MINUTE) + cal.get(Calendar.SECOND) + "OBAMIZER" + nomeArq);
            arq = new File("tmp/" + timestamp("OBAMIZER") + nomeArq);
            ImageIO.write(saida, "JPG", arq);
        } catch (IOException ex) {
            Logger.getLogger(controleImg.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arq;

    }

    public double[] aplicarEqualizacao() {

        int largura = img.getWidth();
        int altura = img.getHeight();
        int[][] imgPixel2 = new int[altura][largura];
        Color pixel;
        for (int x = 0; x < largura; x++) {
            for (int y = 0; y < altura; y++) {
                pixel = new Color(img.getRGB(x, y)); // obtem o pixel
                imgPixel2[y][x] = pixel.getRed();
            }
        }

        Equalizacao_de_Histograma Exec = new Equalizacao_de_Histograma(imgPixel2);
        Exec.Equalizar_Histograma();

        //BufferedImage saida = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        saida = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        WritableRaster raster = saida.getRaster();
        double[] teste1 = Exec.Imprimir();
        return teste1;
        /*int[][] teste = new int[img.getWidth()][img.getHeight()];
        int i = 0;
        int w = 0, h = 0;
        for (int control = 0; control < teste1.length; control++) {
        teste[w++][h] = (int) teste1[i++];
        //System.out.println(teste1[i]);
        if (i % img.getWidth() == 0) {
        h++;
        w = 0;
        }
        }
        for (h = 0; h < img.getHeight(); h++) {
        for (w = 0; w < img.getWidth(); w++) {
        int[] t = new int[4];
        Pixel p = new Pixel(teste[w][h]);
        t[0] = p.getVermelho();
        t[1] = p.getVerde();
        t[2] = p.getAzul();
        t[3] = p.getAlfa();
        raster.setPixel(w, h, t);
        }
        }
        try {
        //arq = new File("tmp/" + cal.get(Calendar.HOUR_OF_DAY) + cal.get(Calendar.MINUTE) + cal.get(Calendar.SECOND) + "MAX" + nomeArq);
        arq = new File("tmp/" + timestamp("MAX") + nomeArq);
        ImageIO.write(saida, "JPG", arq);
        } catch (IOException ex) {
        Logger.getLogger(controleImg.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arq;*/
    }

    public File aplicarDFT(String nomeArq) {

        //BufferedImage
        saida = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        //WritableRaster raster = saida.getRaster();

        int N = rgbs.length;
        double[] mag = new double[N];
        double[] c = new double[N];
        double[] s = new double[N];
        double twoPi = 2 * Math.PI;

        System.out.println("Aplicando o DFT");
        System.out.println(N);
        for (int i = 0; i < N; i++) {
            c[i] = 0;
            s[i] = 0;
            for (int j = 0; j < N; j++) {
                c[i] += rgbs[j] * Math.cos(i * j * twoPi / N);
                s[i] -= rgbs[j] * Math.sin(i * j * twoPi / N);
                //System.out.println(""+c[i]+" _ "+s[i]);
            }
            //c[i] /= N;
            //s[i] /= N;

            //c[i] = (c[i]/N);
            //s[i] = (c[i]/N);

            mag[i] = Math.sqrt(c[i] * c[i] + s[i] * s[i]);

            //System.out.println(""+mag[i]);
        }

        System.out.println("FIM do DFT");

        System.out.println("Iniciando o salvamento");
        WritableRaster raster = saida.getRaster();
        int[][] teste = new int[img.getWidth()][img.getHeight()];
        int w = 0, h = 0, i = 0;
        for (int control = 0; control < mag.length; control++) {
            teste[w++][h] = (int) mag[i++];
            //System.out.println(rgbs[i]);
            if (i % img.getWidth() == 0) {
                h++;
                w = 0;
            }
        }
        for (h = 0; h < img.getHeight(); h++) {
            for (w = 0; w < img.getWidth(); w++) {
                int[] t = new int[4];
                Pixel p = new Pixel(teste[w][h]);
                t[0] = p.getVermelho();
                t[1] = p.getVerde();
                t[2] = p.getAzul();
                t[3] = p.getAlfa();
                raster.setPixel(w, h, t);
            }
        }



        try {
            //arq = new File("tmp/" + cal.get(Calendar.HOUR_OF_DAY) + cal.get(Calendar.MINUTE) + cal.get(Calendar.SECOND) + "OBAMIZER" + nomeArq);
            arq = new File("tmp/" + timestamp("DTF") + nomeArq);
            ImageIO.write(saida, "JPG", arq);
        } catch (IOException ex) {
            Logger.getLogger(controleImg.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arq;

    }

    public File aplicarSobelH(String nomeArq) {
        //Calendar cal = new GregorianCalendar();
        int largura = img.getWidth();
        int altura = img.getHeight();
        int[][] imgPixel2 = new int[altura][largura];
        Color pixel;
        for (int x = 0; x < largura; x++) {
            for (int y = 0; y < altura; y++) {
                pixel = new Color(img.getRGB(x, y)); // obtem o pixel
                imgPixel2[y][x] = pixel.getRed();
            }
        }
        Filtro fil = new Filtro(img.getWidth(), img.getHeight(), 0, imgPixel2);
        fil.Executa_Sobel();

        //BufferedImage saida = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        saida = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster raster = saida.getRaster();
        int[][] teste = fil.imprimeSobelH();
        for (int h = 0; h < img.getHeight(); h++) {
            for (int w = 0; w < img.getWidth(); w++) {
                raster.setSample(w, h, 0, teste[h][w]);
            }
        }
        try {
            //arq = new File("tmp/" + cal.get(Calendar.HOUR_OF_DAY) + cal.get(Calendar.MINUTE) + cal.get(Calendar.SECOND) + "MAX" + nomeArq);
            arq = new File("tmp/" + timestamp("SOBELH") + nomeArq);
            ImageIO.write(saida, "JPG", arq);
        } catch (IOException ex) {
            Logger.getLogger(controleImg.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arq;
    }

    public File aplicarSobelV(String nomeArq) {
        //Calendar cal = new GregorianCalendar();
        int largura = img.getWidth();
        int altura = img.getHeight();
        int[][] imgPixel2 = new int[altura][largura];
        Color pixel;
        for (int x = 0; x < largura; x++) {
            for (int y = 0; y < altura; y++) {
                pixel = new Color(img.getRGB(x, y)); // obtem o pixel
                imgPixel2[y][x] = pixel.getRed();
            }
        }
        Filtro fil = new Filtro(img.getWidth(), img.getHeight(), 0, imgPixel2);
        fil.Executa_Sobel();

        //BufferedImage saida = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        saida = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster raster = saida.getRaster();
        int[][] teste = fil.imprimeSobelV();
        for (int h = 0; h < img.getHeight(); h++) {
            for (int w = 0; w < img.getWidth(); w++) {
                raster.setSample(w, h, 0, teste[h][w]);
            }
        }
        try {
            //arq = new File("tmp/" + cal.get(Calendar.HOUR_OF_DAY) + cal.get(Calendar.MINUTE) + cal.get(Calendar.SECOND) + "MAX" + nomeArq);
            arq = new File("tmp/" + timestamp("SOBELV") + nomeArq);
            ImageIO.write(saida, "JPG", arq);
        } catch (IOException ex) {
            Logger.getLogger(controleImg.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arq;
    }

    public File aplicarPrewitt(String nomeArq) {
        //Calendar cal = new GregorianCalendar();
        int largura = img.getWidth();
        int altura = img.getHeight();
        int[][] imgPixel2 = new int[altura][largura];
        Color pixel;
        for (int x = 0; x < largura; x++) {
            for (int y = 0; y < altura; y++) {
                pixel = new Color(img.getRGB(x, y)); // obtem o pixel
                imgPixel2[y][x] = pixel.getRed();
            }
        }
        Filtro fil = new Filtro(img.getWidth(), img.getHeight(), 0, imgPixel2);
        fil.Filtro_Prewitt(imgPixel2);

        //BufferedImage saida = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        saida = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster raster = saida.getRaster();
        int[][] teste = fil.imprimePrewitt();
        for (int h = 0; h < img.getHeight(); h++) {
            for (int w = 0; w < img.getWidth(); w++) {
                raster.setSample(w, h, 0, teste[h][w]);
            }
        }
        try {
            //arq = new File("tmp/" + cal.get(Calendar.HOUR_OF_DAY) + cal.get(Calendar.MINUTE) + cal.get(Calendar.SECOND) + "MAX" + nomeArq);
            arq = new File("tmp/" + timestamp("Prewitt") + nomeArq);
            ImageIO.write(saida, "JPG", arq);
        } catch (IOException ex) {
            Logger.getLogger(controleImg.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arq;
    }

    public void toGrayScale() {

        Color pixel, cinza;

        int largura = img.getWidth();
        int altura = img.getHeight();

        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                pixel = getPixel(x, y);
                cinza = pixel.GRAY;
                setPixel(x, y, cinza);
            }
        }
    }

    private Color getPixel(int i, int j) {
        return new Color(img.getRGB(i, j));
    }

    private void setPixel(int i, int j, Color c) {
        img.setRGB(i, j, c.getRGB());
    }

    private String timestamp(String metodo) {

        Calendar cal = new GregorianCalendar();
        int mes = cal.get(cal.MONTH), dia = cal.get(cal.DAY_OF_MONTH);
        String s = "", mess = "" + mes, diaa = "" + dia;

        if (mes < 10) {
            mess = "0" + mess;
        }

        if (dia < 10) {
            diaa = "0" + diaa;
        }

        s += cal.get(cal.YEAR) + "-" + mess + "-" +
                diaa + "_" + cal.get(cal.HOUR_OF_DAY) +
                "." + cal.get(cal.MINUTE) + "." + cal.get(cal.SECOND) +
                "." + cal.get(cal.MILLISECOND) + "_" + metodo + "_";

        return s;

    }

    public BufferedImage resize(int width, int height) {
        BufferedImage resizedImage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(this.img, 0, 0, width, height, null);
        g.dispose();

        return resizedImage;
    }

    public BufferedImage resizePercentual(int width, int height) {

        //int largura = (int)Math.floor((img.getWidth()*width)+0.5);
        //int altura = (int)Math.floor((img.getHeight()*height)+0.5);
        BufferedImage resizedImage = new BufferedImage(
                width, height,
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(this.img, 0, 0, width, height, null);
        g.dispose();

        return resizedImage;
    }

    public ArrayList<File> canaisRGB(String nomeArq) {
        ArrayList<File> volta = new ArrayList<File>(3);
        double[] vermelho = new double[img.getWidth() * img.getHeight()];
        double[] azul = new double[img.getWidth() * img.getHeight()];
        double[] verde = new double[img.getWidth() * img.getHeight()];
        double[] alpha = new double[img.getWidth() * img.getHeight()];
        for (int i = 0; i < rgbs.length; i++) {
            Pixel p = new Pixel(rgbs[i]);
            vermelho[i] = p.getVermelho();
            azul[i] = p.getAzul();
            verde[i] = p.getVerde();
            alpha[i] = p.getAlfa();
            //System.out.println(volta[i]);
        }
        int[][] Avermelho = new int[img.getWidth()][img.getHeight()];
        int[][] Aazul = new int[img.getWidth()][img.getHeight()];
        int[][] Averde = new int[img.getWidth()][img.getHeight()];
        int[][] Aalpha = new int[img.getWidth()][img.getHeight()];
        int w = 0, h = 0, i = 0;
        for (int control = 0; control < rgbs.length; control++) {
            Avermelho[w][h] = (int) vermelho[i];
            Aazul[w][h] = (int) azul[i];
            Averde[w][h] = (int) verde[i];
            Aalpha[w][h] = (int) alpha[i];
            w++;
            i++;
            //System.out.println(rgbs[i]);
            if (i % img.getWidth() == 0) {
                h++;
                w = 0;
            }
        }
        BufferedImage saidaVermelho = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        WritableRaster rasterVermelho = saidaVermelho.getRaster();
        BufferedImage saidaAzul = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        WritableRaster rasterAzul = saidaAzul.getRaster();
        BufferedImage saidaVerde = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        WritableRaster rasterVerde = saidaVerde.getRaster();
        for (h = 0; h < img.getHeight(); h++) {
            for (w = 0; w < img.getWidth(); w++) {
                int[] t = new int[4];
                Pixel p = new Pixel(Aazul[w][h], Avermelho[w][h], Averde[w][h], Aalpha[w][h]);
                t[0] = p.getVermelho();
                t[1] = 0;
                t[2] = 0;
                t[3] = p.getAlfa();
                rasterVermelho.setPixel(w, h, t);
                t[0] = 0;
                t[1] = 0;
                t[2] = p.getAzul();
                t[3] = p.getAlfa();
                rasterAzul.setPixel(w, h, t);
                t[0] = 0;
                t[1] = p.getVerde();
                t[2] = 0;
                t[3] = p.getAlfa();
                rasterVerde.setPixel(w, h, t);
            }
        }
        try {

            //arq = new File("tmp/" + cal.get(Calendar.HOUR_OF_DAY) + cal.get(Calendar.MINUTE) + cal.get(Calendar.SECOND) + "GAMBI1" + nomeArq);
            arq = new File("tmp/" + timestamp("RGBVERMELHO") + nomeArq);
            ImageIO.write(saidaVermelho, "JPG", arq);
            volta.add(arq);
            arq = new File("tmp/" + timestamp("RGBAZUL") + nomeArq);
            ImageIO.write(saidaAzul, "JPG", arq);
            volta.add(arq);
            arq = new File("tmp/" + timestamp("RGBVERDE") + nomeArq);
            ImageIO.write(saidaVerde, "JPG", arq);
            volta.add(arq);
        } catch (IOException ex) {
            Logger.getLogger(controleImg.class.getName()).log(Level.SEVERE, null, ex);
        }
        return volta;
    }
}
