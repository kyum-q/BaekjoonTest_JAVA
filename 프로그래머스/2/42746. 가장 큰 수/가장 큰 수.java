import java.util.Arrays;
import java.util.Comparator;
class Solution {
    //길이가 같을 경우 그냥 비교한다.
    //길이가 다를경우 맨 가장 앞부터 하나씩 비교
    // 끝까지 비교했는데 같은값이 나올경우 짧은 문자열의 가장 앞 숫자와 긴 문자열의 그 다음 문자(짧은 문자열의 길이만큼의 문자열 이후 숫자) 비교
    // 만약 다르면 그대로 비교 결과 return
    // 만약 같으면 짧은 문자열의 두번째 숫자와 긴 문자열의 다음 문자 비교
    // 위의 과정을 계속 반복(만약 긴 문자열의 길이가 짧은 문자열의 길이보다 3배가 길다면 3번 반복을 하는 것이다.
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] answerArray = new String[numbers.length];
        for(int i=0; i<numbers.length;i++) {
            answerArray[i] = String.valueOf(numbers[i]);
        }
        // 첫 번째 글자를 기준으로 내림차순으로 정렬하는 Comparator
        Comparator<String> customComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                //길이가 같은 문자열
                while(true) {
                    if(s1.length() ==  s2.length())
                        return s2.compareTo(s1);
                    if(s1.length() <  s2.length()) {
                        for (int i = 0; i < s1.length(); i++) {
                            if (s1.charAt(i) != s2.charAt(i))
                                return s2.substring(i, i + 1).compareTo(s1.substring(i, i + 1));
                        }
                        s2 = s2.substring(s1.length());
                    }
                    if(s1.length() >  s2.length()) {
                        for (int i = 0; i < s2.length(); i++) {
                            if (s1.charAt(i) != s2.charAt(i))
                                return s2.substring(i, i + 1).compareTo(s1.substring(i, i + 1));
                        }
                        s1 = s1.substring(s2.length());
                    }
                }
            }
        };
        // Comparator를 사용하여 배열 정렬
        Arrays.sort(answerArray, customComparator);
        for (String item : answerArray){
            answer.append(item);
        }

        return answer.substring(0,1).equals("0")?"0":String.valueOf(answer);

    }
}