import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.*;
import java.io.*;
import java.awt.Rectangle;

public class Trail extends GameObject{
   
   private float alpha = 1;
   private Handler handler;
   private Color color;
   private float life;
   private int width, height;
   
   // life = 0.001 to 0.1
   
   public Trail(int x, int y, ID id, Color color, float life, int width, int height, Handler handler){
      super(x, y, id);
      this.handler = handler;
      this.color = color;
      this.life = life;
      this.width = width;
      this.height = height;
   }
   
   public void tick(){
      if(alpha > life) {
         alpha -= (life - 0.0001f);  
      }else{
         handler.removeObject(this);
      }
   }
   
   public void render(Graphics g){
      Graphics2D g2d = (Graphics2D) g;
      g2d.setComposite(makeTransparent(alpha));
      g.setColor(color);
      g.fillRoundRect(x, y, width, height, 8, 8);
      g2d.setComposite(makeTransparent(1));
   }

   public Rectangle getBounds(){
      return null;
   }
   
   private AlphaComposite makeTransparent(float alpha){
      int type = AlphaComposite.SRC_OVER;
      return AlphaComposite.getInstance(type, alpha);
   }
   
}