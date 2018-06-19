import java.awt.Canvas;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.Color;
import java.util.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class Game extends Canvas implements Runnable{

   public static final int WIDTH = 960, HEIGHT = 720;
   
   private Handler handler;
   private Random r;
   private HUD hud;
   
   private Thread thread;
   private boolean running = false;
   
   public Game(){
      r = new Random();
      handler = new Handler();
      this.addKeyListener(new KeyInput(handler));
      new Window(WIDTH, HEIGHT, "Walid's Asteroid Game", this);
      hud = new HUD();
      handler.addObject(new Player(WIDTH / 2 - 12, HEIGHT / 2 - 12, ID.Player, handler));
      //handler.addObject(new Powerup(r.nextInt(WIDTH - 16), r.nextInt(HEIGHT - 16), ID.Enemy, handler, Color.green));
      //handler.addObject(new Player2(WIDTH / 2 - 24, HEIGHT / 2 - 12, ID.Player, handler));  
      spawnEnemies();
   }
   
   public void spawnEnemies() {
      r = new Random();
      for(int i = 0; i < 12; i++){
         handler.addObject(new Enemy(r.nextInt(WIDTH - 16), r.nextInt(HEIGHT - 16), ID.Enemy, handler, Color.red));
         //handler.addObject(new Enemy(r.nextInt(WIDTH - 16), r.nextInt(HEIGHT - 16), ID.Enemy, handler, Color.orange));
         //handler.addObject(new Enemy(r.nextInt(WIDTH - 16), r.nextInt(HEIGHT - 16), ID.Enemy, handler, Color.red));
         handler.addObject(new Enemy(r.nextInt(WIDTH - 16), r.nextInt(HEIGHT - 16), ID.Enemy, handler, Color.magenta));
         //handler.addObject(new Enemy(r.nextInt(WIDTH - 16), r.nextInt(HEIGHT - 16), ID.Enemy, handler, Color.white));
         //handler.addObject(new Enemy(r.nextInt(WIDTH - 16), r.nextInt(HEIGHT - 16), ID.Enemy, handler, Color.green));
      }

   }
   public synchronized void start(){
      thread = new Thread(this);
      thread.start();
      running = true;
   }
  
   public synchronized void stop(){
      try {
         thread.join();
         running = false;
      } catch(Exception e) {
         e.printStackTrace();
      }
   }
 
   // game loop 
   public void run(){
      this.requestFocus();
      long lastTime = System.nanoTime();
      double amountOfTicks = 60.0;
      double ns = 1000000000 / amountOfTicks;
      double delta = 0;
      long timer = System.currentTimeMillis();
      int frames = 0;
      while(running){
         long now = System.nanoTime();
         delta += (now - lastTime) / ns;
         lastTime = now;
         while(delta >= 1) {
            tick();
            delta--;
         }   
         if(running)
            render();
         frames++;
         
         if(System.currentTimeMillis() - timer > 1000) {
            timer += 1000;
            //System.out.println("FPS: " + frames);
         }
      }
      stop();
   }
   
   private void tick() {
      handler.tick();
      hud.tick();
      if(HUD.HEALTH == 0){
         running = false;
         Graphics g = getGraphics();
         endScreen(g);
      }
   }
   
   // creates 3 buffers
   private void render() {
      r = new Random();
      BufferStrategy bs = this.getBufferStrategy();
      if(bs == null) {
         this.createBufferStrategy(3);
         return;
      }
      Graphics g = bs.getDrawGraphics();
      
      g.setColor(Color.darkGray);
      g.fillRect(0, 0, WIDTH, HEIGHT);
      // creates background with moving stars effect
      g.setColor(Color.white);
      g.fillOval(r.nextInt(WIDTH), r.nextInt(HEIGHT), 4, 4);
      handler.render(g);
      
      hud.render(g);
      
      g.dispose();
      bs.show();  
   }
   
   public static int clamp(int var, int min, int max){
      if(var >= max){
         return var = max;
      } else if(var <= min){
         return var = min;
      } else{
         return var;
      }
   }
   
   public void endScreen(Graphics g){
      g.setColor(Color.darkGray);
      g.fillRect(0, 0, WIDTH, HEIGHT);
      g.setColor(Color.red);
      Font lFont = new Font ("Calibri", 1, 40);
      g.setFont(lFont);
      g.drawString("L", WIDTH / 2 - 20, HEIGHT / 2);
      Font scoreFont = new Font ("Calibri", 1, 20);
      g.setFont(scoreFont);
      g.setColor(Color.white);
      g.drawString("score:" + (int)HUD.score, 5, 20);
   }
   
   public static void main (String args[]) {
      new Game();
   }
}