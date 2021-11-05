package com.example.myapplication;

public class Compare {
    public String s1;
    public String s2;

    public Compare(String s1,String s2){
        this.s1=s1;
        this.s2=s2;
    }

    public boolean compare_Strings(){
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
