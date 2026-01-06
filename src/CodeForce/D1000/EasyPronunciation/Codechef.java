package CodeForce.D1000.EasyPronunciation;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Codechef
{
    public static void main (String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int totalTestCases = sc.nextInt();

        for(int i = 0; i < totalTestCases; i++) {
            int length = sc.nextInt();
            String str = sc.next().toLowerCase();

            int count = 0;
            for(int j = 0; j < length; j++) {

                if(str.charAt(j) == 'a' || str.charAt(j) == 'e' || str.charAt(j) == 'i' || str.charAt(j) == 'o' || str.charAt(j) == 'u') count=0;
                else {
                    count++;
                    if(count >= 4){
                        System.out.println("No");
                        break;
                    }
                }
            }
            if(count < 4) System.out.println("Yes");
        }
    }
}
