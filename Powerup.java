import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import java.io.*;
import java.awt.Rectangle;

public class Powerup extends GameObject{
   
   private Random r;
   private Handler handler;
   private Color color;
   
   public Powerup(int x, int y, ID id, Handler handler, Color color){
      super(x, y, id);
      r = new Random();
      this.handler = handler;
      this.color = color;
      speedX = 2;
      speedY = 2;
   }
   
   public Rectangle getBounds(){
      return new Rectangle(x, y, 24, 24);
   }
   
   public void tick(){

      x += speedX;
      y += speedY;
       
      if(y <= -100|| y >= Game.HEIGHT + 200){
         speedY *= -1;
      }
      if(x <= -100|| x >= Game.WIDTH + 200){
         speedX *= -1;
      }
      
      handler.addObject(new Trail(x, y, ID.Trail, color, 0.30f, 24, 24, handler));
   }
   
   public void render(Graphics g){
      r = new Random();
      if(id == ID.Powerup){
         g.setColor(color);
         //g.fillRoundRect(x, y, 10, r.nextInt(156), 24, 24);
         g.fillRoundRect(x, y, 24, 24, 4, 4);
         //g.setColor(Color.white);
         //g.drawString("no, u", x, y);
      }
   }
}