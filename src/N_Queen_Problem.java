import java.util.HashMap;

public class N_Queen_Problem {

    public static int scale = 8;
    public static int[][] arr = new int[scale][scale]; //row, column
    public static int case_n = 0;
    public static int case_code = 0;
    public static String S_case_code = "";
    public static boolean IsSpecialCase = false;
    public static HashMap<String, Integer> map = new HashMap<>(); //cannot understand how to use Hash maps.

    public static void print() {
        for ( int i = 0; i < scale; i++ ) {
            for ( int j = 0; j < scale; j++ ) {
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


    public static String ReverseLeftRight(String s) { //테스트 다 끝나면 return형을 void로 바꾸기
        String str = "";
        for ( int i = 0; i < scale;i++ ) {
            str += String.valueOf('7'-s.charAt(i));
        }
        //hash에 str 저장.
        return str;
    }

    public static String ReverseUpDown(String s) { //테스트 다 끝나면 return형을 void로 바꾸기
        String str = "";
        for ( int i = scale - 1; i >= 0; i-- ) {
            str += String.valueOf(s.charAt(i));
        }
        //hash에 str 저장.
        return str;
    }

    public static String degree_90(String s) { //테스트 다 끝나면 return형을 void로 바꾸기
        String str = "";
        for ( int i = 0; i < scale; i++ ) {
            for  ( int j = 0; j < scale; j++) {
                if ( s.charAt(j) == i + '0' ) {
                    str += String.valueOf(7 - j);
                    break;
                }
            }
        }
        //hash에 str 저장.
        return str;
    }

    public static String degree_180(String s) { //테스트 다 끝나면 return형을 void로 바꾸기
        String str = "";
        int a = scale - 1 + '0';
        for ( int i = scale - 1; i >= 0; i-- ) {
            str += String.valueOf(a - s.charAt(i));
        }
        //hash에 str 저장.
        return str;
    }

    public static String degree_270(String s) { //테스트 다 끝나면 return형을 void로 바꾸기
        String str = "";
        for ( int i = scale - 1; i >= 0; i-- ) {
            for ( int j = 0; j < scale; j++ ) {
                if ( s.charAt(j) - '0' == i ) {
                    str += String.valueOf(j);
                }
            }
        }
        //hash에 str 저장.
        return str;
    }



    public static void NQueenPlace(int[][] arr, int r) {
        for ( int c = 0; c < scale; c++ ) {
            if ( IsQueenPlacable.IsQueenPlacable(arr, r, c) ) {
                arr[r][c] = 1;
                if ( r == scale - 1 ) { //hash map을 훑어보며 특별한 케이스인지 판단한다.
                    //그 특별한 케이스의 원본을 hash map에 저장한다.
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
