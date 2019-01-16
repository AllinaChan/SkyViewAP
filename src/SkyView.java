public class SkyView {
    private double[][] view;

    public SkyView(int numRows, int numCols, double[] scanned)
    {
        this.view= new double[numRows][numCols];
        int currentPos=0;
        int currentCol=0;
        int lastCol=0;
        for(int i=0; i<numRows; i++)
        {
           if(currentCol%2!=0) {
               for (int j = view[i].length - 1; j >= 0; j--) {
                   view[i][j] = scanned[currentPos];
                   currentPos++;
                   lastCol = j;
               }
           }else{
                for (int j = 0; j < view[i].length; j++) {
                    view[i][j] = scanned[currentPos];
                    currentPos++;
                    lastCol=j;
                }
            }
            if(currentPos==scanned.length)
            {
                break;
            }
        }
    }

    public double getAverage(int startRow, int endRow,int startCol, int endCol)
    {
        int count=0;
        double sum=0;
        for(int i = startRow; i<=endRow; i++)
        {
            for(int j =startCol; j<=endCol; j++)
            {
                sum+=view[i][j];
                count++;
            }
        }
        return sum/count;
    }

    public void print()
    {
        String result="";
        for (int i = 0; i<view.length; i++ )
        {
            result="";
            for (int j =0; j< view[i].length; j++)
            {
                result += view[i][j]+" ";
            }
            System.out.println(result);
        }
    }
}
