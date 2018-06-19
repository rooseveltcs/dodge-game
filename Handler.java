import java.awt.Graphics;
import java.util.LinkedList;

// loops through all objects in game and updates
public class Handler{

   // list of all game objects
   LinkedList<GameObject> object = new LinkedList<GameObject>();

// loops through all objects and ticks
   public void tick(){
      for(int i = 0; i < object.size(); i++) {
         GameObject tempObject = object.get(i);
         tempObject.tick();
      }
   }
// loops through all objects and renders
   public void render(Graphics g){
      for(int i = 0; i < object.size(); i++) {
         GameObject tempObject = object.get(i);
         tempObject.render(g);
      }
   }
   
   public void addObject(GameObject object){
      this.object.add(object);
   }
   
   public void removeObject(GameObject object){
      this.object.remove(object);
   }

}