/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aaaa;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Nanda-PC
 */
public class WriteBinary {
    BufferedImage img1;
    BufferedImage img2;
    BufferedImage img3;
    BufferedImage img4;
    BufferedImage img5;
    BufferedImage img6;
    
    int bag1,bag2,bag3,bag4,bag5,bag6;
    public WriteBinary(){
        
    }
    
    public void setImage(BufferedImage img1,BufferedImage img2,BufferedImage img3,BufferedImage img4,BufferedImage img5,BufferedImage img6){
        this.img1=img1;
        this.img2=img2;
        this.img3=img3;
        this.img4=img4;
        this.img5=img5;
        this.img6=img6;
    }
    
    private int countBlack(BufferedImage img){
        int h= img.getHeight();
        int w= img.getWidth();
        
        Color white = Color.WHITE;
        Color black = Color.BLACK;
        int threshold = 100;
        Color[][] color = new Color[w][h];
        int[][] temp = new int[w][h];
         for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                color[i][j]= new Color(img.getRGB(i, j));
            }
        }
         int count=0;
         for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                Color c = color [i][j];
                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();
                if (r==0|| g==0 || b==0) { //bila hitam
                    count++;
                }
            }
        }
       
       return count++;
    }
    
    private int  minimum(int count, int avg,int min){
         
        avg= avg-min;
        
        if (count>avg) {
            count=1;
        }
        else if (count==0 || count<=3) {
            count=0;
        }
        else{
            count=0;
        }
        return count;
    }
   
    private int getMin(int[] val){
        int possibleMin=val[0];
        for (int i = 0; i < 6; i++) {
            if (possibleMin>=val[i]) {
                possibleMin=val[i];
            }
        }
       return possibleMin;
    }
    
    public void process(){
        int min;
        int[] val = new int[6];
         
        bag1=countBlack(img1);
        bag2=countBlack(img2);        
        bag3=countBlack(img3);       
        bag4=countBlack(img4);     
        bag5=countBlack(img5); 
        bag6=countBlack(img6);
        
        val[0]=bag1;
        val[1]=bag2;
        val[2]=bag3;
        val[3]=bag4;
        val[4]=bag5;
        val[5]=bag6;
        
        min=getMin(val);
        
        int avg = (bag1+bag2+bag3+bag4+bag5+bag6)/6;
        System.out.print("min: "+min);
        System.out.print("avg: "+avg);
        
        System.out.print(" 1:"+bag1);
        System.out.print(" 2:"+bag2);
        System.out.print(" 3:"+bag3);
        System.out.print(" 4:"+bag4);
        System.out.print(" 5:"+bag5);
        System.out.print(" 6:"+bag6);
        
        bag1=minimum(bag1,avg,min);
        bag2=minimum(bag2,avg,min);
        bag3=minimum(bag3,avg,min);
        bag4=minimum(bag4,avg,min);
        bag5=minimum(bag5,avg,min);
        bag6=minimum(bag6,avg,min);
        
        
        
        
        
    }
    
    public int getbag1(){
       return bag1;
   }
   
   public int getbag2(){
       return bag2;
   }
   
    public int getbag3(){
       return bag3;
   }
    
     public int getbag4(){
       return bag4;
   }
     
     public int getbag5(){
       return bag5;
   }
     
   public int getbag6(){
       return bag6;
   }
    
}
