package pucpid.controles;

import java.awt.Color;

public class Luminance {

   // return the monochrome luminance of given color
   public static double lum(Color color) {
      int r = color.getRed();
      int g = color.getGreen();
      int b = color.getBlue();
      return .299*r + .587*g + .114*b;
   }

   public static Color toGray(Color color) {
      int l = (int) (Math.round(lum(color)));
      Color gray = new Color(l, l, l);
      return gray;
   }

   public static boolean compatible(Color a, Color b) {
      return Math.abs(lum(a) - lum(b)) >= 128.0;
   }
}


