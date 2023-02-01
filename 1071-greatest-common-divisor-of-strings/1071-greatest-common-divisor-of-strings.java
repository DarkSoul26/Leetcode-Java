class Solution {
public String gcdOfStrings(String str1, String str2) {

    // if the str1 = "ABCD" and str2 ="ABC"
    // then str1 + str2 = "ABCDABC"
    // and str2 + str1 = "ABCABCD"
    // here both are not equal so simply return "".
    if(!((str1 + str2).equals(str2 + str1))){
        
        return "";
    }
    
    // if str1 == str2 return any one of the two strings
    // str1 = "ABC" and str2 = "ABC"
    else if(str1.equals(str2)){
        
        return str1;
    }
    
    // if str1 > str2 
    // str1 = "ABCABC" and str2 = "ABC"
    else if(str1.length() > str2.length()){
        
        return gcdOfStrings(str1.substring(str2.length()), str2);
    }
    
    // if str1 < str2 
    // str2 = "ABCABC" and str1 = "ABC"
    else{
        
        return gcdOfStrings(str2.substring(str1.length()), str1);
    }
}
}