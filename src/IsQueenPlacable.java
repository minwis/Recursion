public class IsQueenPlacable {

    static boolean IsQueenPlacable(int[][] arr, int i, int j) { //i is row, j is column

        if ( arr[i][j] == 1 ) {
            return false;
        }

        //1
        for(int d = 1; i-d >=0 && j-d >=0; d++) {
            if (arr[i-d][j-d] == 1) {
                return false;
            }
        }

        //2
        for (int a = i - 1; 0 <= a; a--) {
            if (arr[a][j] == 1) {
                return false;
            }
        }

        //3
        for (int b = 1; i - b >= 0 && j + b < N_Queen_Problem.scale; b++ ) {
            if (arr[i - b][j + b] == 1) {
                return false;
            }
        }

        //4
        for ( int a = 0; a < j; a++ ) {
            if ( arr[i][a] == 1 ) {
                return false;
            }
        }


        return true;
    }
}
