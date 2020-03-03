package com.company;

public class BruteForce {
    public static void search(String text, String pattern)
    {
        int M = pattern.length();
        int N = text.length();
        int k=0;


        for (int i = 0; i <= N - M; i++) {

            int j;

            /* For current index i, check for pattern
              match */
            for (j = 0; j < M; j++)
                if (text.charAt(i + j) != pattern.charAt(j))
                    //System.out.println("Pattern not found in given text");
                    break;

            if (j == M) // if pat[0...M-1] = txt[i, i+1, ...i+M-1]
            {
                System.out.println("Pattern found at index " + i);
                k++;
            }
        }

        if (k == 0)
            System.out.println("Pattern not found ");
        else
            System.out.println(k);
    }

    public static void main(String[] args)
    {
        try {
            InputSource inputSource = new InputSource("/Users/vikramguhilot/PatternMatching/Bible.txt");
            InputSource inputSource1 = new InputSource("/Users/vikramguhilot/PatternMatching/MatchA.txt");
            String txt = inputSource.inputString;
//            InputSource patternSourcee = new InputSource("rabin_pattern.txt");
            String pattern = "Now I will come to you, when I shall have passed through Macedonia. For I shall pass through Macedonia.";
            String TXT2 =inputSource1.inputString;

            if (pattern == null || pattern.length() == 0)
            {
                System.out.println("Pattern is empty");
                return;
            }
            long start = System.currentTimeMillis();
            search(txt, pattern);
            //search(TXT2, pattern);
            long end = System.currentTimeMillis();
            System.out.println("search takes " +  (end - start) + "ms");

        } catch (Exception e) {
            // Handle it.
            System.out.println(e.getMessage());

        }

    }
}
