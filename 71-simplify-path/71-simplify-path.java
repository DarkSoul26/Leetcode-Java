class Solution {
    
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!skip.contains(dir)) stack.push(dir);
        }
        String res = "";
        for (String dir : stack) res = "/" + dir + res;
        return res.isEmpty() ? "/" : res;
    }
//     public String simplifyPath(String path) {
//         Stack<String> stk = new Stack<>();
//         // System.out.println(path.length());
//         for(int i=0;i<path.length();i++){
//             if(path.charAt(i) == '/'){
//                 // i++;   
//                 // if(stk.isEmpty())
//                 // if(!stk.isEmpty() && stk.peek()!="/")
//                 //     stk.push("/");
//                 continue;
//             }
//             if(i<path.length()-1 && path.substring(i, i+2).equals("..") && (i<path.length()-2 && path.charAt(i+2)=='/')){
//                 // if(i<path.length()-2 && path.charAt(i+2)!='/')
//                 //     continue;
//                 // System.out.println(path.substring(i, i+2));
//                 if(!stk.isEmpty())
//                     stk.pop();
//             }
//             else if(path.charAt(i) == '.' && (i<path.length()-1 && path.charAt(i+1)=='/')){
//                 // System.out.println("Yo");
//                 // if(i<path.length()-1 && path.charAt(i+1)!='/')
//                     // continue;
//                 i++;
//             }
//             else{
//                 // int r = path.substring(i, path.length()).indexOf('/');
//                 int r = i;
//                 while(r<path.length() && path.charAt(r)!='/')
//                     r++;
//                 // System.out.println(path.substring(i,r));
                
//                 if(r == -1)
//                     r = path.length();
//                 // stk.push("/");
//                 stk.push(path.substring(i,r));
//                 i = r;
//             }
//         }
//         StringBuffer sb = new StringBuffer();
//         if(stk.isEmpty())
//             return "/";
//         Stack<String> stk2 = new Stack<>();
//         while(!stk.isEmpty())
//             stk2.push(stk.pop());
        
//         while(!stk2.isEmpty())
//             sb.append("/"+stk2.pop());
//         return sb.toString();
//     }
}