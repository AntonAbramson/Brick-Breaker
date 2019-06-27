import java.awt.*;

public class MapGenerator {
    public int map[][];
    public int map2[][];
    public int map3[][];

    public int brickWidth;
    public int brickHeight;
    public int enemy1 = 2;
    public int enemy2 = 1;
    public int enemy3 = 1;



    public MapGenerator(int row, int col) {
        map = new int[row][col];
       // map2 = new int[row][col];
       // map3 = new int[row][col];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = 1;

            }
        }

        brickWidth = 540 / col;
        brickHeight = 150 / row;
    }

    public void draw(Graphics2D g) {
        //Map 1
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) {
                    g.setColor(Color.white);
                    g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);

                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.BLACK);
                    g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                    if (i == 1 && j == 1) {
                        g.setColor(Color.RED);
                        g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);

                        g.setStroke(new BasicStroke(3));
                        g.setColor(Color.BLACK);
                        g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                        //enemy++;


                    }
                    if (i == 1 && j == 5) {
                        g.setColor(Color.RED);
                        g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);

                        g.setStroke(new BasicStroke(3));
                        g.setColor(Color.BLACK);
                        g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                        //enemy++;
                    }

                    if (i == 0 && j == 4) {
                        g.setColor(Color.ORANGE);
                        g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);

                        g.setStroke(new BasicStroke(3));
                        g.setColor(Color.BLACK);
                        g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                        //enemy++;
                    }
                }
            }
        }
    }
/*
    public void draw2(Graphics2D g) {
        //Map 2
        for (int i = 0; i < map2.length; i++) {
            for (int j = 0; j < map2[0].length; j++) {
                if (map2[i][j] > 0) {
                    g.setColor(Color.white);
                    g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);

                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.BLACK);
                    g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                    if (i == 1 && j == 1) {
                        g.setColor(Color.RED);
                        g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);

                        g.setStroke(new BasicStroke(3));
                        g.setColor(Color.BLACK);
                        g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                        //enemy++;


                    }
                    if (i == 2 && j == 5) {
                        g.setColor(Color.RED);
                        g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);

                        g.setStroke(new BasicStroke(3));
                        g.setColor(Color.BLACK);
                        g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                        //enemy++;
                    }
                }
            }
        }
    }

    public void draw3(Graphics2D g) {
        //Map 3
        for (int i = 0; i < map3.length; i++) {
            for (int j = 0; j < map3[0].length; j++) {
                if (map3[i][j] > 0) {
                    g.setColor(Color.white);
                    g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);

                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.BLACK);
                    g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                    if (i == 2 && j == 1) {
                        g.setColor(Color.RED);
                        g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);

                        g.setStroke(new BasicStroke(3));
                        g.setColor(Color.BLACK);
                        g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                        //enemy++;


                    }
                    if (i == 1 && j == 5) {
                        g.setColor(Color.RED);
                        g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);

                        g.setStroke(new BasicStroke(3));
                        g.setColor(Color.BLACK);
                        g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                        //enemy++;
                    }

                }
            }
        }
    }
*/
    public void setBrickValue(int value, int row, int col){
        map[row][col] = value;
       // map2[row][col] = value;
       // map3[row][col] = value;

    }

}
