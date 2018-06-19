import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class HUD{

   public static int HEALTH = 100;
   public static double score = 0;
   
   public void tick(){
      HEALTH = Game.clamp(HEALTH, 0, 100);
      score += 0.015;
   }

   public void render(Graphics g){
      // draws health bar
      //if(HEALTH >= 66){
      //   g.setColor(Color.green);
      //} else if(HEALTH >= 33){
        // g.setColor(Color.orange);
      //} else{
      g.setColor(Color.green);
      //}
      g.fillRect(15, 15, HEALTH, 10);
      g.setColor(Color.white);
      g.drawRect(15, 15, 100, 10);
      
      // draws health inside of bar
      Font healthFont = new Font ("Calibri", 1, 12);
      g.setFont(healthFont);
      g.drawString("health", 50, 24);
      // draws time
      Font scoreFont = new Font ("Calibri", 1, 20);
      g.setFont(scoreFont);
      g.drawString("" + (int)score, 130, 26);
   }
}