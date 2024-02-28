import java.awt.*;
import java.util.Random;
public class MondrianArt2{
    private static final int INITIAL_WIDTH = 700;
    private static final int INITIAL_HEIGHT = 700;
    private static final int MIN_SPLIT_SIZE = 20;

    private static Random random = new Random();

    public static void main(String[] args){
        DrawingPanel panel = new DrawingPanel(INITIAL_WIDTH, INITIAL_HEIGHT);
        draw(panel.getGraphics(), 0, 0 , INITIAL_WIDTH, INITIAL_HEIGHT);
    }

    public static void draw(Graphics g, int x, int y, int width, int height){
        int randomSplitWidth;
        if((int)(width * 1.5 - MIN_SPLIT_SIZE) > 0) {
            randomSplitWidth = random.nextInt((int)(width * 1.5 - MIN_SPLIT_SIZE)) + MIN_SPLIT_SIZE;
        } else {
            randomSplitWidth = MIN_SPLIT_SIZE;
        }

        int randomSplitHeight;
        if((int)(height * 1.5 - MIN_SPLIT_SIZE) > 0) {
            randomSplitHeight = random.nextInt((int)(height * 1.5 - MIN_SPLIT_SIZE)) + MIN_SPLIT_SIZE;
        } else {
            randomSplitHeight = MIN_SPLIT_SIZE;
        }

        int splitX = (int)(width * (random.nextDouble() * 0.34 + 0.33));
        int splitY = (int)(height * (random.nextDouble() * 0.34 + 0.33));

        boolean hSplit = false;
        boolean vSplit = false;

        if(width > INITIAL_WIDTH / 2 && height > INITIAL_HEIGHT / 2){
            hSplit = true;
            vSplit = true;
        }
        else if (width > INITIAL_WIDTH / 2) {
            hSplit = true;
        }
        else if (height > INITIAL_HEIGHT / 2) {
            vSplit = true;
        }
        else if (randomSplitWidth < width && randomSplitHeight < height) {
            hSplit = true;
            vSplit = true;
        }
        else if (randomSplitWidth < width) {
            hSplit = true;
        }
        else if (randomSplitHeight < height) {
            vSplit = true;
        }

        if (hSplit && vSplit) {
            draw(g, x, y, splitX, splitY);
            draw(g, x + splitX, y, width - splitX, splitY);
            draw(g, x, y + splitY, splitX, height - splitY);
            draw(g, x + splitX, y + splitY, width - splitX, height - splitY);
        }
        else if (hSplit) {
            draw(g, x, y, splitX, height);
            draw(g, x + splitX, y, width - splitX, height);
        }
        else if (vSplit) {
            draw(g, x, y, width, splitY);
            draw(g, x, y + splitY, width, height - splitY);
        }
        else {
            if(random.nextBoolean()) {
                int colorSelector = random.nextInt(3);
                // switch(colorSelector) {
                //     case 0:
                //         g.setColor(Color.BLUE);
                //         break;
                //     case 1:
                //         g.setColor(Color.YELLOW);
                //         break;
                //     case 2:
                //         g.setColor(Color.RED);
                //         break;
                // }
                g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
                g.fillRect(x, y, width, height);
            }
            g.setColor(Color.BLACK);
            g.drawRect(x, y, width, height);
        }
    }
}