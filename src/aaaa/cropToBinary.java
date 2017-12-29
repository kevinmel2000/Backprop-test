/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aaaa;

import java.awt.image.BufferedImage;

/**
 *
 * @author Nanda-PC
 */
public class cropToBinary {
    BufferedImage img1;
    BufferedImage img2;
    BufferedImage img3;
    BufferedImage img4;
    BufferedImage img5;
    BufferedImage img6;
    
    public cropToBinary(){
        
    }
    
    public void setImage(BufferedImage img1,BufferedImage img2,BufferedImage img3,BufferedImage img4,BufferedImage img5,BufferedImage img6){
        this.img1=img1;
        this.img2=img2;
        this.img3=img3;
        this.img4=img4;
        this.img5=img5;
        this.img6=img6;
    }
    
    private void grayscale(){
        Grayscale g1 = new Grayscale(img1);
        g1.process();
        img1=g1.getGrayScale();
        
        Grayscale g2 = new Grayscale(img2);
        g2.process();
        img2=g2.getGrayScale();
        
        Grayscale g3 = new Grayscale(img3);
        g3.process();
        img3=g3.getGrayScale();
        
        Grayscale g4 = new Grayscale(img4);
        g4.process();
        img4=g4.getGrayScale();
        
        Grayscale g5 = new Grayscale(img5);
        g5.process();
        img5=g5.getGrayScale();
        
        Grayscale g6 = new Grayscale(img6);
        g6.process();
        img6=g6.getGrayScale();
    }
    
  public void process(){
       grayscale();
       
       
        Binary b1 = new Binary(img1);
        b1.process();
        img1=b1.getBinary();
        
        Binary b2 = new Binary(img2);
        b2.process();
        img2=b2.getBinary();
        
        
        Binary b3 = new Binary(img3);
        b3.process();
        img3=b3.getBinary();
        
        
        Binary b4 = new Binary(img4);
        b4.process();
        img4=b4.getBinary();
        
        
        Binary b5 = new Binary(img5);
        b5.process();
        img5=b5.getBinary();
        
        
        Binary b6 = new Binary(img6);
        b6.process();
        img6=b6.getBinary();
      
  }
  
    public BufferedImage getbag1(){
       return img1;
   }
   
   public BufferedImage getbag2(){
       return img2;
   }
   
    public BufferedImage getbag3(){
       return img3;
   }
    
     public BufferedImage getbag4(){
       return img4;
   }
     
     public BufferedImage getbag5(){
       return img5;
   }
     
   public BufferedImage getbag6(){
       return img6;
   }
}
