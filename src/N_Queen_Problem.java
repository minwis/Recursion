public class N_Queen_Problem {

    public static int[][] arr = new int[4][4]; //row, column
    public static boolean finished = false;

    public static void NQueenPlace(int[][] arr, int r) { //array, row
        for ( int c = 0; c < 4; c++ ) {
            if ( IsQueenPlacable.IsQueenPlacable(arr, r, c) ) {
                arr[r][c] = 1;
                if ( r == 3 ) {
                    finished = true;
                    break;
                }
                NQueenPlace(arr, r+1);
                if ( finished ) {
                    return;
                }
                arr[r][c] = 0;
            }
        }
    }
    //각각 케이스 출력. 각각 한 칸씩 띄어서.


    public static void main(String args[]) {
        /*arr[1][1] = 1;

        for ( int i = 0; i < arr.length; i++ ) {
            for ( int j = 0; j < arr[0].length; j++ ) {
                    System.out.print(IsQueenPlacable.IsQueenPlacable(arr, i, j) + " ");
            }
            System.out.println();
        }
        */
        int r = 0;
        NQueenPlace(arr, r);
        for ( int i = 0; i < 4; i++ ) {
            for ( int j = 0; j < 4; j++ ) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

}
