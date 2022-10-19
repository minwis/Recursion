import java.util.HashMap;

public class N_Queen_Problem {

    public static int scale = 8;
    public static int[][] arr = new int[scale][scale]; //row, column
    public static int case_n = 0;
    public static int case_code = 0;
    public static String S_case_code = "";
    public static HashMap<Integer, String> map = new HashMap<>();

    public static void print() {
        for ( int i = 0; i < scale; i++ ) {
            for ( int j = 0; j < scale; j++ ) {
                if ( arr[i][j] == 1 ) {
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\n");
    }

    public static void GetCaseCode() {
        for ( int i = 0; i < scale; i++ ) {
            for ( int j = 0; j < scale; j++ ) {
                if ( arr[i][j] == 1 ) {
                    S_case_code += String.valueOf(j);
                }
            }
        }
        case_code = Integer.parseInt(S_case_code);
    }


    public static void ReverseLeftRight(String s) {
        String str = "";
        for ( int i = 0; i < scale;i++ ) {
            str += String.valueOf('7'-s.charAt(i));
        }
        map.put(case_n, str);
    }

    public static void ReverseUpDown(String s) { //return형을 void로 바꾸기
        String str = "";
        for ( int i = scale - 1; i >= 0; i-- ) {
            str += String.valueOf(s.charAt(i));
        }
        map.put(case_n, str);
    }

    public static void degree_90(String s) { //return형을 void로 바꾸기
        String str = "";
        for ( int i = 0; i < scale; i++ ) {
            for  ( int j = 0; j < scale; j++) {
                if ( s.charAt(j) == i + '0' ) {
                    str += String.valueOf(7 - j);
                    break;
                }
            }
        }
        map.put(case_n, str);
    }

    public static void degree_180(String s) { //return형을 void로 바꾸기
        String str = "";
        int a = scale - 1 + '0';
        for ( int i = scale - 1; i >= 0; i-- ) {
            str += String.valueOf(a - s.charAt(i));
        }
        map.put(case_n, str);
    }

    public static void degree_270(String s) { //return형을 void로 바꾸기
        String str = "";
        for ( int i = scale - 1; i >= 0; i-- ) {
            for ( int j = 0; j < scale; j++ ) {
                if ( s.charAt(j) - '0' == i ) {
                    str += String.valueOf(j);
                }
            }
        }
        map.put(case_n, str);
    }


    public static void store(String str) {
        ReverseLeftRight(str);
        ReverseUpDown(str);
        degree_90(str);
        degree_180(str);
        degree_270(str);
    }

    public static void NQueenPlace(int[][] arr, int r) {
        for ( int c = 0; c < scale; c++ ) {
            if ( IsQueenPlacable.IsQueenPlacable(arr, r, c) ) {
                arr[r][c] = 1;
                if ( r == scale - 1 ) {
                    case_n++;
                    GetCaseCode();
                    if (!map.containsValue(S_case_code)) {
                        print();
                        System.out.println(case_code);
                        System.out.println(S_case_code);
                        map.put(case_n, S_case_code);
                        store(S_case_code);
                    }
                    case_code = 0;
                    S_case_code = "";
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
