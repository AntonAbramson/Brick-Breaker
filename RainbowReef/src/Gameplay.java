import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
    private boolean play = false;
    private int score = 0;
    private int lives = 3;
    private int level = 1;
    double speedBoost = -0.25;
    //private boolean level2 = false;
    //private boolean level3 = false;



    private int totalBricks;

    private Timer timer;
    private int delay = 8;

    private int playerX = 310;

    private int ballposX = 350;
    private int ballposY = 400;
    private int ballXdir = -1;
    private double ballYdir = -2.0;

    private MapGenerator map;
    //private Map2Generator map2;


    public Gameplay() {
        map = new MapGenerator(3,7);

        /*
        if(level2 == true){
            map2 = new Map2Generator(3,7);
            level =2;
        }
        */

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g) {


        // background
        g.setColor(Color.black);
        g.fillRect(1,1,692, 592);

        // drawing map
        map.draw((Graphics2D)g);
/*
        if(level2 == true){
            map2.draw((Graphics2D)g);
        }
*/

        //borders
        g.setColor(Color.YELLOW);
        g.fillRect(0,0,3,592);
        g.fillRect(0,0,692,3);
        g.fillRect(683,0,3,592);

        // score, lives & level display
        g.setColor(Color.white);
        g.setFont(new Font("serif", Font.BOLD,18));
        g.drawString("Score: "+score, 590, 30);
        //g.setColor(Color.RED);
       // g.setFont(new Font("serif", Font.BOLD,25));
        g.drawString("Lives: "+lives, 5, 30);
        g.drawString("Level: "+level, 100, 30);

        // paddle
        g.setColor(Color.green);
        g.fillRect(playerX, 550, 100, 8);

        // ball
        //while (play = false) {
            g.setColor(Color.yellow);
            g.fillOval(ballposX, ballposY, 20, 20);
        //}
/*
        if(totalBricks <= 0) {
            play = false;
            ballYdir = 0;
            ballYdir = 0;
            g.setColor(Color.RED);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("You Won, Score: "+score, 190, 300);

            g.setFont(new Font("serif", Font.BOLD, 20));
            g.drawString("Press Enter to Restart", 230, 350);


        }
        */

        if(ballposY > 570) {
            //lives--;
            play = false;

            //ballYdir = 0;
            //ballXdir = 0;
            ballposX = 350;
            ballposY = 400;
            lives--;

        }


        if(lives == 0) {

            g.setColor(Color.RED);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("Game Over, Score: " + score, 190, 300);

            g.setFont(new Font("serif", Font.BOLD, 20));
            g.drawString("Press Enter to Restart", 230, 350);
        }

        if(map.enemy1 == 0){

            play = false;

            g.setColor(Color.RED);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("Level Cleared, Score: " + score, 190, 300);

            g.setFont(new Font("serif", Font.BOLD, 20));
            g.drawString("Press 2 to Advance", 230, 350);
            g.drawString("Press Enter to Restart", 230, 370);

        }

        g.dispose();

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if(play) {
            if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX,550, 100, 8))){
                ballYdir = -ballYdir + speedBoost;
                
            }
          A:  for(int i =0; i<map.map.length; i++){
                for(int j =0; j<map.map[0].length; j++){
                    if(map.map[i][j] > 0) {
                        int brickX = j* map.brickWidth+80;
                        int brickY = i* map.brickHeight + 50;
                        int brickWidth = map.brickWidth;
                        int brickHeight = map.brickHeight;

                        Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                        Rectangle ballRect = new Rectangle(ballposX, ballposY, 20, 20);
                        Rectangle brickRect = rect;

                        if(ballRect.intersects(brickRect)){
                            map.setBrickValue(0,i,j);
                            totalBricks--;
                            score += 5;

                            if (i == 1 && j == 1) {
                                map.enemy1--;
                                System.out.println("Enemy Down");

                            }

                            if (i == 1 && j == 5) {
                                map.enemy1--;
                                System.out.println("Enemy Down");

                            }

                            if (i == 0 && j == 4) {
                            lives++;
                                System.out.println("Plus Life");

                            }




                                if(ballposX + 19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width) {
                                ballXdir = -ballXdir;
                            } else {
                                ballYdir = -ballYdir;
                            }
                            break A;
                        }
                    }
                }
            }
/*
                if(!level2){
            B:  for(int i =0; i<map2.map.length; i++){
                for(int j =0; j<map2.map[0].length; j++){
                    if(map2.map[i][j] > 0) {
                        int brickX = j* map2.brickWidth+80;
                        int brickY = i* map2.brickHeight + 50;
                        int brickWidth = map2.brickWidth;
                        int brickHeight = map2.brickHeight;

                        Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                        Rectangle ballRect = new Rectangle(ballposX, ballposY, 20, 20);
                        Rectangle brickRect = rect;

                        if(ballRect.intersects(brickRect)) {
                            map2.setBrickValue(0, i, j);
                            totalBricks--;
                            score += 5;

                            if (i == 2 && j == 2) {
                                map2.enemy1--;
                                System.out.println("Enemy Down");

                            }

                            if (i == 1 && j == 5) {
                                map2.enemy1--;
                                System.out.println("Enemy Down");

                            }


                            if (ballposX + 19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width) {
                                ballXdir = -ballXdir;
                            } else {
                                ballYdir = -ballYdir;
                            }
                            break B;
                        }
                        }
                    }
                }
            }
*/


            ballposX += ballXdir;
            ballposY += ballYdir;
            if (ballposX < 0) {
                ballXdir = -ballXdir;
            }
            if (ballposY < 0) {
                ballYdir = -ballYdir;
            }
            if (ballposX > 670) {
                ballXdir = -ballXdir;
            }
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (playerX >= 600) {
                playerX = 600;
            } else {
                moveRight();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (playerX < 10) {
                playerX = 10;
            } else {
                moveLeft();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!play) {
                //play = true;
                ballposX = 350;
                ballposY = 400;
                ballXdir = -1;
                ballYdir = -2;
                playerX = 310;
                lives = 3;
                score = 0;
                totalBricks = 21;
                map = new MapGenerator(3, 7);
                repaint();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (lives != 0 && !play) {
                play = true;
                ballXdir = -1;
                ballYdir = -2.0;
            }
        }
/*
        if (e.getKeyCode() == KeyEvent.VK_2) {
            if (map.enemy1 == 0) {
                level2 = true;

            }
        }
*/
    }
    public void moveRight() {
        playerX+=20;
    }

    public void moveLeft() {
        playerX-=20;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
