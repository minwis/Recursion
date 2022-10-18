public class N_Queen_Problem {

    public static int arr_scale = 8;
    public static int[][] arr = new int[arr_scale][arr_scale]; //row, column
    public static int case_n = 0;
    public static int case_code = 0;
    public static String S_case_code = "";

    public static void print() {
        for ( int i = 0; i < arr_scale; i++ ) {
            for ( int j = 0; j < arr_scale; j++ ) {
                if ( arr[i][j] == 1 ) {
                    S_case_code += String.valueOf(j);
                }
                System.out.print(arr[i][j] + " ");

            }
            System.out.println();
        }
        case_code = Integer.parseInt(S_case_code);
        System.out.println(S_case_code);
        case_code = 0;
        S_case_code = "";
        System.out.println("\n");
    }


    public static void NQueenPlace(int[][] arr, int r) {
        for ( int c = 0; c < arr_scale; c++ ) {
            if ( IsQueenPlacable.IsQueenPlacable(arr, r, c) ) {
                arr[r][c] = 1;
                if ( r == arr_scale - 1 ) {
                    case_n++;
                    print();
                    arr[r][c] = 0;
                    break;
                }
                NQueenPlace(arr, r+1);
                arr[r][c] = 0;
            }
        }
    }


    public static void main(String args[]) {
        int r = 0;
        NQueenPlace(arr, r);
        System.out.println(case_n);
    }

}
