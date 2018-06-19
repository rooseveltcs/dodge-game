import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

   private Handler handler;
   
   private boolean Up = false;
   private boolean Down = false;
   private boolean Right = false;
   private boolean Left = false;
   private boolean Up2 = false;
   private boolean Down2 = false;
   private boolean Right2 = false;
   private boolean Left2 = false;
   

   
   public KeyInput(Handler handler){
      this.handler = handler;
   }

   public void keyPressed(KeyEvent e){
      int key = e.getKeyCode();
      
      for(int i = 0; i < handler.object.size(); i++){
         GameObject tempObject = handler.object.get(i);
         
         if(tempObject.getId() == ID.Player){
            if(key == KeyEvent.VK_UP){
               Up = true;
               tempObject.setSpeedY(-8);   
            }
            if(key == KeyEvent.VK_DOWN){
               Down = true;
               tempObject.setSpeedY(8);   
            }
            if(key == KeyEvent.VK_RIGHT){
               Right = true;
               tempObject.setSpeedX(8);   
            }
            if(key == KeyEvent.VK_LEFT){
               Left = true;
               tempObject.setSpeedX(-8);   
            }
         }
         
         if(tempObject.getId() == ID.Player2){
            if(key == KeyEvent.VK_W){
               Up2 = true;
               tempObject.setSpeedY(-8);   
            }
            if(key == KeyEvent.VK_S){
               Down2 = true;
               tempObject.setSpeedY(8);   
            }
            if(key == KeyEvent.VK_D){
               Right2 = true;
               tempObject.setSpeedX(8);   
            }
            if(key == KeyEvent.VK_A){
               Left2 = true;
               tempObject.setSpeedX(-8);   
            }
         }
      }
   }

   public void keyReleased(KeyEvent e){
      int key = e.getKeyCode();
      
      for(int i = 0; i < handler.object.size(); i++){
         GameObject tempObject = handler.object.get(i);
         
         if(tempObject.getId() == ID.Player){
            if(key == KeyEvent.VK_UP){
               Up = false;
               if(Up){
                  tempObject.setSpeedY(-8);
               } else {
                  tempObject.setSpeedY(0);   
               }
            }
            if(key == KeyEvent.VK_DOWN){
               Down = false;
               if(Down){
                  tempObject.setSpeedY(8);
               } else {
                  tempObject.setSpeedY(0);   
               }
            }
            if(key == KeyEvent.VK_RIGHT){
               Right = false;
               if(Right){
                  tempObject.setSpeedX(8);
               } else {
                  tempObject.setSpeedX(0);   
               }
            }
            if(key == KeyEvent.VK_LEFT){
               Left = false;
               if(Left){
                  tempObject.setSpeedX(-8);
               } else {
                  tempObject.setSpeedX(0);   
               }
            }
         }
         
         if(tempObject.getId() == ID.Player2){
            if(key == KeyEvent.VK_W){
               Up = false;
               if(Up2){
                  tempObject.setSpeedY(-8);
               } else {
                  tempObject.setSpeedY(0);   
               }
            }
            if(key == KeyEvent.VK_S){
               Down = false;
               if(Down2){
                  tempObject.setSpeedY(8);
               } else {
                  tempObject.setSpeedY(0);   
               }
            }
            if(key == KeyEvent.VK_D){
               Right = false;
               if(Right2){
                  tempObject.setSpeedX(8);
               } else {
                  tempObject.setSpeedX(0);   
               }
            }
            if(key == KeyEvent.VK_A){
               Left = false;
               if(Left2){
                  tempObject.setSpeedX(-8);
               } else {
                  tempObject.setSpeedX(0);   
               }
            }
         }

         
         if(key == KeyEvent.VK_ESCAPE) {
            System.exit(1);
         }
      }
   }
}

         
         