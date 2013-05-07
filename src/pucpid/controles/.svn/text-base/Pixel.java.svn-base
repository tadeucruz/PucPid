/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pucpid.controles;

import java.awt.Color;

/**
 *
 * @author tadeucruz
 */
public class Pixel {

    private int azul;
    private int vermelho;
    private int verde;
    private int alfa;

    public Pixel(int valor) {
        Color c = new Color(valor);
        this.azul = c.getBlue();
        this.vermelho = c.getRed();
        this.verde = c.getGreen();
        this.alfa = c.getAlpha();
    }

    public Pixel() {
    }

    public Pixel(int azul, int vermelho, int verde, int alfa) {
        this.azul = azul;
        this.vermelho = vermelho;
        this.verde = verde;
        this.alfa = alfa;
    }

    public int valorOriginal(){
        Color c = new Color(vermelho, verde, azul, alfa);
        return c.getRGB();
    }

    /**
     * @return the azul
     */
    public int getAzul() {
        return azul;
    }

    /**
     * @param azul the azul to set
     */
    public void setAzul(int azul) {
        this.azul = azul;
    }

    /**
     * @return the vermelho
     */
    public int getVermelho() {
        return vermelho;
    }

    /**
     * @param vermelho the vermelho to set
     */
    public void setVermelho(int vermelho) {
        this.vermelho = vermelho;
    }

    /**
     * @return the verde
     */
    public int getVerde() {
        return verde;
    }

    /**
     * @param verde the verde to set
     */
    public void setVerde(int verde) {
        this.verde = verde;
    }

    /**
     * @return the alfa
     */
    public int getAlfa() {
        return alfa;
    }

    /**
     * @param alfa the alfa to set
     */
    public void setAlfa(int alfa) {
        this.alfa = alfa;
    }

    public int somaRgb(int val1, int val2) {
        Pixel p1 = new Pixel(val1);
        Pixel p2 = new Pixel(val2);
        p1.setAlfa(p1.getAlfa() + p2.getAlfa());
        p1.setAzul(p1.getAzul() + p2.getAzul());
        p1.setVerde(p1.getVerde() + p2.getVerde());
        p1.setVermelho(p1.getVermelho() + p2.getVermelho());
        return p1.voltaRGB();
    }

    public int subRgb(int val1, int val2) {
        Pixel p1 = new Pixel(val1);
        Pixel p2 = new Pixel(val2);
        p1.setAlfa(p1.getAlfa() - p2.getAlfa());
        p1.setAzul(p1.getAzul() - p2.getAzul());
        p1.setVerde(p1.getVerde() - p2.getVerde());
        p1.setVermelho(p1.getVermelho() - p2.getVermelho());
        return p1.voltaRGB();
    }

    public int multiplicarRgb(int val1, int val2) {
        Pixel p1 = new Pixel(val1);
        Pixel p2 = new Pixel(val2);
        p1.setAlfa(p1.getAlfa() * p2.getAlfa());
        p1.setAzul(p1.getAzul() * p2.getAzul());
        p1.setVerde(p1.getVerde() * p2.getVerde());
        p1.setVermelho(p1.getVermelho() * p2.getVermelho());
        return p1.voltaRGB();
    }

    public int divRgb(int val1, int val2) {
        Pixel p1 = new Pixel(val1);
        Pixel p2 = new Pixel(val2);
        p1.setAlfa(p1.getAlfa() / p2.getAlfa());
        p1.setAzul(p1.getAzul() / p2.getAzul());
        p1.setVerde(p1.getVerde() / p2.getVerde());
        p1.setVermelho(p1.getVermelho() / p2.getVermelho());
        return p1.voltaRGB();
    }

    public int voltaRGB() {
        if (vermelho >= 256) {
            vermelho = 255;
        }
        if (verde >= 256) {
            verde = 255;
        }
        if (azul >= 256) {
            azul = 255;
        }
        if (alfa >= 256) {
            alfa = 255;
        }
        if (vermelho <= 0) {
            vermelho = 0;
        }
        if (verde <= 0) {
            verde = 0;
        }
        if (azul <= 0) {
            azul = 0;
        }
        if (alfa <= 0) {
            alfa = 0;
        }
        Color c2 = new Color(vermelho, verde, azul, alfa);
        return c2.getRGB();
    }
}
