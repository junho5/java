package Codeup;
public class Test {
    public static void main(String[] args) {
        // 각 과목 점수
        // 이곳에 코드를 작성하세요.
        int koreanScore = 86;
        int mathScore = 94;
        int scienceScore = 87;
        int computerScore = 100;
        int total = koreanScore+mathScore+scienceScore+computerScore;
        double answer = (double) (koreanScore+mathScore+scienceScore+computerScore)/4;
        // 평균 점수
        // 이곳에 코드를 작성하세요.
        System.out.println(answer);
    }
}