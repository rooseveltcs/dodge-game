import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import java.io.*;
import java.awt.Rectangle;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;

public class Player2 extends GameObject{

   Handler handler;
   //public Clip sound = loadClip("/punch.wav");
   
   public Player2(int x, int y, ID id, Handler handler){
      super(x, y, id);
      this.handler = handler;
   }
   
   public Rectangle getBounds(){
      return new Rectangle(x, y, 8, 8);
   }
   /*
   public Clip loadClip(String filename){
      Clip clip = null;
      
      try{
         AudioInputStream audioIn = AudioSystem.getAudioInputStream(getClass().getResource(filename));
         clip = AudioSystem.getClip();
         clip.open(audioIn);
      }
      catch(Exception e){
         e.printStackTrace();
      }
      return clip;
   }
   
   
   public void playClip(Clip clip){
      stopClip(clip);
      clip.start();
   }
   
   public void stopClip(Clip clip){
      if(clip.isRunning()){
         clip.stop();
      }
      clip.setFramePosition(0);
   }
   
   */
   
   public void tick(){
      x += speedX;
      y += speedY;
      
      x = Game.clamp(x, 0, Game.WIDTH - 22);
      y = Game.clamp(y, 0, Game.HEIGHT - 46);
   
      collision();
      handler.addObject(new Trail(x, y, ID.Trail, Color.orange, 0.12f, 10, 10, handler));
   }   
   
   
   private void collision(){
      for(int i = 0; i < handler.object.size(); i++){
      
         GameObject tempObject = handler.object.get(i);
      
         if(tempObject .getId() == ID.Enemy){
           // if player rect is touching any enemy objects
           if(getBounds().intersects(tempObject.getBounds())){
              HUD.HEALTH -= 10;
             // playClip(sound);
           }
         }    
      }
   }
   
   public void render(Graphics g){
      if(id == ID.Player2) {
         g.setColor(Color.orange);
         g.fillRect(x, y, 8, 8);
         //g.setColor(Color.white);
         //g.drawString("u r gay", x, y);
      }
   }
}