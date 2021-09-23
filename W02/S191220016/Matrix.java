package W02.S191220016;

import W02.S191220016.Linable;
import W02.S191220016.Line.Position;

public class Matrix extends Line{
    private int lineLength;
    public Matrix(final int length,final int _lineLength) {
        super(length);
        lineLength=_lineLength;
    }

    @Override
    public String toString() {
        String lineString = "\t";
        int i=0;
        for (final Position p : positions) {
            lineString += p.linable.toString();
            i++;
            if(i==lineLength){
                i=0;
                lineString+="\n"+"\t";
            }
        }
        return lineString;
    }


}
