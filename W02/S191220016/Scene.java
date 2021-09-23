package W02.S191220016;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;



public class Scene {

    public static void main(final String[] args) throws IOException {

        //final Line line = new Line(256);
        Line line=new Matrix(256, 16);
        Monster.init_monsters(256);
        for(int i=0;i<256;i++){
            line.put(Monster.monsters[i], i);
        }
    
        final Boss theBoss = Boss.getTheBoss();

        //final Sorter sorter = new BubbleSorter();
        final Sorter sorter = new QuickSorter();

        theBoss.setSorter(sorter);

        final String log = theBoss.lineUp(line);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();
    }

}
