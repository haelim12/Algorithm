class Solution {
    public String solution(String new_id) {
        String answer = "";
        // 1단계
        new_id = new_id.toLowerCase();
        // 2단계
        for (int i=0; i<new_id.length(); i++) {
            char c = new_id.charAt(i);
            if (Character.isAlphabetic(c) || Character.isDigit(c) || 
                c == '-' || c == '_' || c == '.')
                answer += c;
        }
        // 3단계
        while (answer.indexOf("..") != -1) {
            answer = answer.replace("..", ".");
        }
        // 4단계
        if(answer.startsWith(".")) {
			answer = answer.substring(1, answer.length());
		}
        if(answer.endsWith(".")) {
			answer = answer.substring(0, answer.length()-1);
		}
        // 5단계
        if(answer.isEmpty()) {
            answer += "a";
        }
        // 6단계
        if(answer.length() >= 16) {
            answer = answer.substring(0, 15);
        }
        if(answer.endsWith(".")) {
			answer = answer.substring(0, answer.length()-1);
		}
        // 7단계
        String last = answer.charAt(answer.length()-1) + "";
		if(answer.length() == 1) {
			answer += last + last;
		} else if(answer.length() == 2) {
			answer += last;
		}
            
        return answer;
    }
}