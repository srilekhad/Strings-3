//Time Complexity (TC): O(n), single left-to-right pass over the string.
//Space Complexity (SC): O(1) auxiliary space.

//Parse digits into currNum; when you hit an operator or the end, apply the previous lastSign.
//Maintain calc (total so far) and tail (last added term) to handle precedence: for +/- do calc += ±currNum; tail = ±currNum.
//back out the last term then re-add the combined term: calc = calc - tail + tail*currNum (or tail/currNum), update tail accordingly.

class Solution {
    public int calculate(String s) {
        
        int currNum = 0;
        char lastSign = '+';    
        int calc = 0, tail = 0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                currNum = currNum * 10 + c - '0';
            }

            if((!Character.isDigit(c) && c!=' ') || i == s.length()-1){
                if(lastSign == '+'){
                    calc = calc + currNum;
                    tail = currNum;
                }else if(lastSign == '-'){
                    calc = calc - currNum;
                    tail = -currNum;
                }else if(lastSign == '*'){
                    calc = (calc - tail) + (tail * currNum);
                    tail = tail * currNum;
                }else if(lastSign == '/'){
                    calc = (calc - tail) + (tail / currNum);
                    tail = tail / currNum;
                }

                currNum = 0;
                lastSign = c;
            }
        }

        return calc;
    }
}
