package CodeForce.D1001.ATMMachine;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();


        for(int t = 0; t < test; t++){

            int peoples = sc.nextInt();
            int availMoney = sc.nextInt();

            for(int i = 0; i < peoples; i++) {
                int currentWithdraw = sc.nextInt();
                if(availMoney - currentWithdraw < 0) System.out.print("0");
                else {
                    System.out.print("1");
                    availMoney -= currentWithdraw;
                }
            }
            System.out.println();
        }
    }
}
