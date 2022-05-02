import processing.core.PApplet;

public class Sketch extends PApplet {
	
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(400, 400);
  }

  boolean upPressed = false;
  boolean downPressed = false;
  boolean leftPressed = false;
  boolean rightPressed = false;
  public void setup() {
    background(100, 173, 255);
  }
  float circleX = 100;
  float circleY = 100;
  float cloudX = 240;
  float cloudY = 200;
  float moonX = 340;
  float moonY = 80;
  int r;
  int g;
  int b;
  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    setbackground();
    background(r, g, b);
    noStroke();
    fill(255,255,0);
    if (upPressed)
      circleY -= 2;
    if (downPressed)
      circleY += 2;
    if (leftPressed)
      circleX -= 2;
    if (rightPressed)
      circleX += 2; 
    ellipse(circleX, circleY, 50, 50);
    
    if( r == 0 && g == 20 && b == 40) {
      fill(255, 255, 180);
      ellipse(moonX, moonY, 35, 35);
      fill(0, 20, 40);
      ellipse(moonX - 18, moonY - 8, 50, 50); 
    }
    fill(255);
    ellipse(cloudX, cloudY,70, 25);
    ellipse(cloudX + 30, cloudY + 8,60, 22);
    ellipse(cloudX - 20, cloudY + 12,55, 22);
    ellipse(cloudX + 5, cloudY + 18,45, 20);  
  }
  public void mouseClicked() {
    moonX = mouseX;
    moonY = mouseY;
  }
  public void mouseDragged() {
    cloudX = mouseX;
    cloudY = mouseY;
  }

  public void keyPressed() {
    if (keyCode == UP)
      upPressed = true;
    else if (keyCode == DOWN)
      downPressed = true;
    else if (keyCode == LEFT)
      leftPressed = true;
    else if (keyCode == RIGHT)
      rightPressed = true;
  }
  
  public void keyReleased() {
    if (keyCode == UP)
      upPressed = false;
    else if (keyCode == DOWN)
      downPressed = false;
    else if (keyCode == LEFT) 
      leftPressed = false;
    else if (keyCode == RIGHT)
      rightPressed = false;
  }

  public void setbackground(){
    if (cloudX >= circleX - 40 && cloudX <= circleX + 40 && cloudY >= circleY - 15 && cloudY <= circleY + 25) {
      if(circleY < height * 2/3){
        r = 60;
        g = 100;
        b = 150;
      }
      else if (circleY < height + 30){
        r = 200;
        g = 100;
        b = 20;
      }
    }
    else if (circleY < height * 2/3) {
      r = 90;
      g = 180;
      b = 240;
    }
    else if (circleY < height + 30){
      r = 255;
      g = 160;
      b = 40;
    }
    else{
      r = 0;
      g = 20;
      b = 40;
    }
  }
}
  