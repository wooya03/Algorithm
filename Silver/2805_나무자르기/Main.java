import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 나무의 수
        int M = sc.nextInt(); // 필요한 나무 길이

        int[] trees = new int[N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            trees[i] = sc.nextInt();
            if (trees[i] > max) {
                max = trees[i];
            }
        }

        int left = 0;
        int right = max;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;

            for (int tree : trees) {
                if (tree > mid) {
                    sum += tree - mid;
                }
            }

            if (sum >= M) { // 나무를 충분히 얻은 경우
                result = mid; // 높이를 올려도 괜찮을지 탐색
                left = mid + 1;
            } else { // 부족하면 높이를 낮춤
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}
