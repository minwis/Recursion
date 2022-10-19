import java.util.HashMap;
import java.util.HashSet;

public class N_Queen_Problem { //hash를 list로 바꾸고, 전체 rotation 디버깅. I 없애고.

    public static int scale = 8;
    public static int[][] arr = new int[scale][scale]; //row, column
    public static int case_n = 0;
    public static String S_case_code = "";
    public static HashSet<String> map = new HashSet<>();
    public static int I = 0;

    public static void print() {
        for ( int i = 0; i < scale; i++ ) {
            for ( int j = 0; j < scale; j++ ) {
                if ( arr[i][j] == 1 ) {
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void GetCaseCode() {
        for ( int i = 0; i < scale; i++ ) {
            for ( int j = 0; j < scale; j++ ) {
                if ( arr[i][j] == 1 ) {
                    S_case_code += String.valueOf(j);
                }
            }
        }
    }


    public static String ReverseLeftRight(String s) {
        String str = "";
        for ( int i = 0; i < scale;i++ ) {
            str += String.valueOf('7'-s.charAt(i));
        }
        return str;
    }

    public static String ReverseUpDown(String s) {
        String str = "";
        for ( int i = scale - 1; i >= 0; i-- ) {
            str += String.valueOf(s.charAt(i));
        }
        return str;
    }

    public static String degree_90(String s) {
        String str = "";
        for ( int i = 0; i < scale; i++ ) {
            for  ( int j = 0; j < scale; j++) {
                if ( s.charAt(j) == i + '0' ) {
                    str += String.valueOf(7 - j);
                    break;
                }
            }
        }
        return str;
    }

    public static String degree_180(String s) {
        String str = "";
        int a = scale - 1 + '0';
        for ( int i = scale - 1; i >= 0; i-- ) {
            str += String.valueOf(a - s.charAt(i));
        }
        return str;
    }

    public static String degree_270(String s) {
        String str = "";
        for ( int i = scale - 1; i >= 0; i-- ) {
            for ( int j = 0; j < scale; j++ ) {
                if ( s.charAt(j) - '0' == i ) {
                    str += String.valueOf(j);
                }
            }
        }
        return str;
    }


    public static void store(String str) {
        map.add(str);
        map.add(ReverseLeftRight(str));
        map.add(ReverseUpDown(str));
        map.add(degree_90(str));
        map.add(degree_180(str));
        map.add(degree_270(str));
        
    }

    public static void NQueenPlace(int[][] arr, int r) {
        for ( int c = 0; c < scale; c++ ) {
            if ( IsQueenPlacable.IsQueenPlacable(arr, r, c) ) {
                arr[r][c] = 1;
                if ( r == scale - 1 ) {
                    GetCaseCode();
                    if (!map.contains(S_case_code)) {
                        case_n++;
                        print();
                        System.out.println(S_case_code + "\n");
                        store(S_case_code);
                    }
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
