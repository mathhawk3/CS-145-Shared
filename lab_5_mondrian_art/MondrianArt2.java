import java.awt.*;
import java.util.Random;
public class MondrianArt2{
    private static final int INITIAL_WIDTH = 700;
    private static final int INITIAL_HEIGHT = 700;
    private static final int MIN_SPLIT_SIZE = 20;
    private static final int COLOR_VARIATION = 30;

    private static Random random = new Random();

    public static void main(String[] args){
        DrawingPanel panel = new DrawingPanel(INITIAL_WIDTH, INITIAL_HEIGHT);
        draw(panel.getGraphics(), 0, 0 , INITIAL_WIDTH, INITIAL_HEIGHT, new int[]{128, 128, 128});
    }

    public static void draw(Graphics g, int x, int y, int width, int height, int[] colorVals){
        for(int i = 0; i < 3; i++) {
            colorVals[i] += random.nextInt(COLOR_VARIATION * 2) - COLOR_VARIATION;
            if(colorVals[i] < 0) {
                colorVals[i] = 0;
            } else if(colorVals[i] > 255) {
                colorVals[i] = 255;
            }
        }

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
            draw(g, x, y, splitX, splitY, colorVals.clone());
            draw(g, x + splitX, y, width - splitX, splitY, colorVals.clone());
            draw(g, x, y + splitY, splitX, height - splitY, colorVals.clone());
            draw(g, x + splitX, y + splitY, width - splitX, height - splitY, colorVals.clone());
        }
        else if (hSplit) {
            draw(g, x, y, splitX, height, colorVals.clone());
            draw(g, x + splitX, y, width - splitX, height, colorVals.clone());
        }
        else if (vSplit) {
            draw(g, x, y, width, splitY, colorVals.clone());
            draw(g, x, y + splitY, width, height - splitY, colorVals.clone());
        }
        else {
            g.setColor(new Color(colorVals[0], colorVals[1], colorVals[2]));
            g.fillRect(x, y, width, height);
            g.setColor(Color.BLACK);
            for(int i = 0; i < random.nextInt(3) + 1; i++){
                g.drawRect(x + i, y + i, width - 2 * i, height - 2 * i);
            }
        }
    }
}