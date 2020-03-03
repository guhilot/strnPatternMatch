package com.company;

public class KMP_PatternMatching {
    public static void main(String[] args) {

        InputSource inputSource = new InputSource("/Users/vikramguhilot/PatternMatching/Bible.txt");
        // InputSource inputSource1 = new InputSource("/Users/vikramguhilot/PatternMatching/MatchA.txt");
        String str = inputSource.inputString;
//        InputSource patternSourcee = new InputSource("rabin_pattern.txt");
        String subString = "Now I will come to you, when I shall have passed through Macedonia. For I shall pass through Macedonia.";
        //inputSource1.inputString;
        if (subString.trim().equals("") || subString == null)
        {
            System.out.println("Pattern is empty");
            return;
        }
        long start = System.currentTimeMillis();
        KMP_PatternMatching ss = new KMP_PatternMatching();
        ss.KMP(str.toCharArray(), subString.toCharArray());
        long end = System.currentTimeMillis();
        System.out.println("search takes " +  (end - start) + "ms");
    }

    private int[] ComputePrefixFun(char pattern[]){
        int m = pattern.length;
        int[] lps = new int[pattern.length];
        lps[0] = 0;
        int k = 0;
        for(int i=1;i<m;i++){
            while (k>0 && pattern[k]!=pattern[i]) {
                k = lps[k-1];
            }
            if(pattern[k]==pattern[i]) {
                k = k + 1;
            }
            lps[i]=k;
        }
        return lps;
    }

    public void KMP(char[] text, char[] pattern){
        int m = pattern.length;
        int n = text.length;
        int[] lps = ComputePrefixFun(pattern);
        //System.out.println(Arrays.toString(lps));
        int q=0;
        int count=0;
        for(int i=0;i<n;i++){
            // System.out.println("i="+i+",q="+q);
            while (q>0 && pattern[q]!=text[i]){
                q=lps[q-1];
            }
            if(pattern[q]==text[i]){
                q=q+1;
            }
            if(q==m){
                System.out.println("Pattern found at index "+((i+1)-q));
                q=lps[q-1];
                count++;
            }
        }

        if(count==0){
            System.out.println("Pattern not found in given text.");
        }

    }

}

