

public class Test {

    public static void main(String args[]) {
        String str = "04752613";
        System.out.println(str);
        if ( N_Queen_Problem.ReverseUpDown(str).equals("31625740") ) {
            System.out.println("ReverseUpDown : pass");
        }
        else {
            System.out.println("ReverseUpDown: fail - " + N_Queen_Problem.ReverseUpDown(str) );
        }

        if ( N_Queen_Problem.ReverseLeftRight(str).equals("73025164") ) {
            System.out.println("ReverseLeftRight : pass");
        }
        else {
            System.out.println("ReverseLeftRight : fail - " + N_Queen_Problem.ReverseLeftRight(str) );
        }

        if ( N_Queen_Problem.degree_90(str).equals("71306425") ) {
            System.out.println("degree_90 : pass");
        }
        else {
            System.out.println("degree_90 : fail - " + N_Queen_Problem.degree_90(str) );
        }

        if ( N_Queen_Problem.degree_180(str).equals("46152037") ) {
            System.out.println("degree_180 : pass");
        }
        else {
            System.out.println("degree_180 : fail - " + N_Queen_Problem.degree_180(str) );
        }

        if ( N_Queen_Problem.degree_270(str).equals("25317460") ) {
            System.out.println("degree_270 : pass");
        }
        else {
            System.out.println("degree_270 : fail - " + N_Queen_Problem.degree_270(str) );
        }
    }
}
