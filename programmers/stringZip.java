public class stringZip {
    public static void main(String[] args) {
        int result = solution("aaaaaaaa");
        System.out.println(result);
    }

    static int solution(String s) {
        int answer = s.length();
        int step = 1;
        while (step <= s.length()) {
            int count = 1;
            String zip = "";
            for (int index = step; index <= s.length()-step; index += step) {
                String prevString = s.substring(index-step,index);
                String curString = s.substring(index,index+step);
                boolean equals = prevString.toString().equals(curString.toString());

                if(equals) count++;
                else{
                    if(count==1) zip=zip.concat(prevString);
                    else {
                        zip=zip.concat(count+""+prevString);
                        count=1;
                    }
                }

                if(index+step ==s.length()){
                    if(count==1) zip=zip.concat(curString);
                    else zip=zip.concat(count+""+curString);
                }

                else if(index+2*step > s.length()){
                    String rest = s.substring(index+step,s.length());
                    if(count==1) zip=zip.concat(curString+rest);
                    else zip=zip.concat(count+""+curString+rest);
                }
                System.out.println(step+" : "+zip.toString());
            }
            if(zip.length()==0) zip =s;
            answer = Math.min(answer,zip.length());
            step++;
        }

        return answer;
    }
}
