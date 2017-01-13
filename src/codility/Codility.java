/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codility;

/**
 *
 * @author Poorya Laptop
 */
import java.util.*;
import java.util.regex.*;

public class Codility {

    /**
     * @param args the command line arguments
     */
    public static int equilibrium(int[] A) {
        double[] leftSum = new double[A.length], rightSum = new double[A.length];
        double left = 0, right = 0;
        int n = A.length - 1;
        for (int i = 0; i < A.length - 1; i++) {
            left += A[i];
            leftSum[i + 1] = left;
            right += A[n - i];
            rightSum[n - i - 1] = right;
        }

        for (int i = 0; i < A.length; i++) {
            if (leftSum[i] == rightSum[i]) {
                return i;
            }
        }
        return -1;

    }

    public static int binaryGap(int N) {
        int biggestGap = 0;
        for (int i = 0; i < 32; i++) {
            int counter = 0;
            if ((N & (1 << i)) != 0) {
                i++;
                while (i < 32) {
                    if ((N & (1 << i)) == 0) {
                        counter++;
                        i++;
                    } else {
                        if (biggestGap < counter) {
                            biggestGap = counter;
                        }
                        i++;
                        counter = 0;
                    }
                }
            }
        }
        return biggestGap;
    }

    public static int[] cyclicRotation(int[] A, int K) {
        int[] result = new int[A.length];
        if (A.length == 0 || K == 0) {
            return A;
        }
        int shr = K % A.length;
        for (int i = 0; i < A.length; i++) {
            result[i] = A[(A.length - shr + i) % A.length];
        }
        return result;
    }

    public static int oddOccurrencesInArray(int[] A) {
        int oddValue = 0;
        for (int i : A) {
            oddValue ^= i;
        }
        return oddValue;
    }

    public static int frogJump(int X, int Y, int D) {
        // write your code in C99 (gcc 4.8.2)
        if (((Y - X) % D) > 0) {
            return ((Y - X) / D) + 1;
        } else {
            return ((Y - X) / D);
        }
    }

    public static int PermMissingElem(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum ^= A[i] ^ (i + 1);
        }
        return sum ^ (A.length + 1);
    }

    public static int FrogRiverOne(int X, int[] A) {
        // write your code in Java SE 8
        boolean[] path = new boolean[X];
        for (int i = 0; i < X; i++) {
            path[i] = false;
        }
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (path[A[i] - 1] == false) {
                path[A[i] - 1] = true;
                sum++;
            }
            if (sum == X) {
                return i;
            }
        }
        return -1;
    }

    public static int PermCheck(int X, int[] A) {
        int value = 0;
        for (int i = 0; i < A.length; i++) {
            value ^= A[i] ^ (i + 1);
        }
        if (value == 0) {
            return 1;
        }
        return 0;
    }

    public static int MissingInteger(int[] A) {
        boolean[] oneToN = new boolean[A.length];
        for (int i = 0; i < A.length; i++) {
            oneToN[i] = false;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0 && A[i] <= A.length) {
                oneToN[A[i] - 1] = true;
            }
        }
        for (int i = 0; i < oneToN.length; i++) {
            if (oneToN[i] == false) {
                return i + 1;
            }
        }
        return A.length + 1;
    }

    public static int[] MaxCounters(int N, int[] A) {
        int max = 0;
        int lastIncrease = 0;
        int[] counter = new int[N];
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= N) {
                counter[A[i] - 1] = counter[A[i] - 1] > lastIncrease ? counter[A[i] - 1] : lastIncrease;
                counter[A[i] - 1]++;
                max = counter[A[i] - 1] > max ? counter[A[i] - 1] : max;
            } else {
                lastIncrease = max;
            }
        }
        for (int i = 0; i < N; i++) {
            counter[i] = counter[i] > lastIncrease ? counter[i] : lastIncrease;
        }

        return counter;
    }

    public static int CountDiv(int A, int B, int K) {
        int up = B / K;
        int down = A % K > 0 ? (A / K) + 1 : A / K;
        return up - down + 1;
    }

    public static int PassingCars(int[] A) {
        int eastCounter = 0, pairCounter = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                pairCounter += eastCounter;
                if (pairCounter > 1000000000) {
                    return -1;
                }
            } else {
                eastCounter++;
            }
        }
        return pairCounter;
    }

    public static int[] GenomicRangeQuery(String S, int[] P, int[] Q) {
        int[] result = new int[P.length],
                LSA = new int[S.length()],
                LSC = new int[S.length()],
                LSG = new int[S.length()],
                LST = new int[S.length()];
        java.util.Arrays.asList(result, 0);
        for (int i = 0; i < S.length(); i++) {
            LSA[i] = -1;
            LSC[i] = -1;
            LSG[i] = -1;
            LST[i] = -1;
        }
        for (int i = 0; i < S.length(); i++) {
            switch (S.charAt(i)) {
                case 'A':
                    LSA[i] = i;
                    if (i > 0) {
                        LSC[i] = LSC[i - 1];
                        LSG[i] = LSG[i - 1];
                        LST[i] = LST[i - 1];
                    }
                    break;
                case 'C':
                    LSC[i] = i;
                    if (i > 0) {
                        LSA[i] = LSA[i - 1];
                        LSG[i] = LSG[i - 1];
                        LST[i] = LST[i - 1];
                    }
                    break;
                case 'G':
                    LSG[i] = i;
                    if (i > 0) {
                        LSC[i] = LSC[i - 1];
                        LSA[i] = LSA[i - 1];
                        LST[i] = LST[i - 1];
                    }
                    break;
                case 'T':
                    LST[i] = i;
                    if (i > 0) {
                        LSC[i] = LSC[i - 1];
                        LSG[i] = LSG[i - 1];
                        LSA[i] = LSA[i - 1];
                    }
                    break;
            }
        }
        for (int i = 0; i < P.length; i++) {
            if (LSA[Q[i]] >= P[i]) {
                result[i] = 1;
            } else if (LSC[Q[i]] >= P[i]) {
                result[i] = 2;
            } else if (LSG[Q[i]] >= P[i]) {
                result[i] = 3;
            } else if (LST[Q[i]] >= P[i]) {
                result[i] = 4;
            }
        }
        return result;
    }

    public static int MinAvgTwoSlice(int[] A) {
        int startIndex = 0;
        float minimum;
        if (A.length == 2) {
            return 0;
        }
        if ((A[0] + A[1]) / 2f <= (A[0] + A[1] + A[3]) / 3f) {
            minimum = (A[0] + A[1]) / 2f;
        } else {
            minimum = (A[0] + A[1] + A[2]) / 3f;
        }
        for (int i = 1; i < A.length - 1; i++) {
            if ((A[i] + A[i + 1]) / 2f < minimum) {
                minimum = (A[i] + A[i + 1]) / 2f;
                startIndex = i;
            }
            if ((i < A.length - 2) && ((A[i] + A[i + 1] + A[i + 2]) / 3f < minimum)) {
                minimum = (A[i] + A[i + 1] + A[i + 2]) / 3f;
                startIndex = i;
            }
        }
        return startIndex;
    }

    public static int Distinct(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        java.util.Arrays.parallelSort(A);
        int sum = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[i - 1]) {
                sum++;
            }
        }
        return sum;
    }

    public static int Triangle(int[] A) {
        if (A.length <= 2) {
            return 0;
        }
        java.util.Arrays.parallelSort(A);
        for (int i = 0; i < A.length - 2; i++) {
            double temp = (double) A[i] + (double) A[i + 1];
            if (temp > (double) A[i + 2]) {
                return 1;
            }
        }
        return 0;
    }

    public static double MaxProductOfThree(int[] A) {
        java.util.Arrays.parallelSort(A);
        return Math.max(A[A.length - 1] * A[A.length - 2] * A[A.length - 3], A[0] * A[1] * A[A.length - 1]);
    }

    //correctness = 100 performance=62 total=81
    public static int NumberOfDiscIntersections(int[] A) {
        if (A.length < 2) {
            return 0;
        }
        int intersectNumber = 0;
        double[][] temp = new double[2][A.length];
        for (int i = 0; i < A.length; i++) {
            temp[0][i] = (double) i - (double) A[i];
            temp[1][i] = (double) i + (double) A[i];
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (temp[1][i] >= temp[0][j]) {
                    intersectNumber++;
                }
            }
        }
        if (intersectNumber == 0) {
            return -1;
        }
        return intersectNumber;
    }

    public static int Fish(int[] A, int[] B) {
        ArrayList<Integer> a = new ArrayList(0);
        for (int i : A) {
            a.add(i);
        }
        ArrayList<Integer> b = new ArrayList(0);
        for (int i : B) {
            b.add(i);
        }
        for (int i = 0; i < a.size(); i++) {
            if (b.get(i) == 1) {
                while ((i < a.size() - 1) && (b.get(i + 1) == 0)) {
                    //sum++;
                    if (a.get(i + 1) < a.get(i)) {
                        a.remove(i + 1);
                        b.remove(i + 1);
                    } else {
                        a.remove(i);
                        b.remove(i);
                        i = i == 0 ? i - 1 : i - 2;
                        break;
                    }
                }
            }
        }
        return a.size();
    }

    public static int Brackets(String S) {
        Stack st = new Stack();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(' || S.charAt(i) == '{' || S.charAt(i) == '[') {
                st.push(S.charAt(i));
            } else if (S.charAt(i) == ')') {
                if (!st.isEmpty() && (char) st.peek() == '(') {
                    st.pop();
                } else {
                    return 0;
                }
            } else if (S.charAt(i) == '}') {
                if (!st.isEmpty() && (char) st.peek() == '{') {
                    st.pop();
                } else {
                    return 0;
                }
            } else if (S.charAt(i) == ']') {
                if (!st.isEmpty() && (char) st.peek() == '[') {
                    st.pop();
                } else {
                    return 0;
                }
            }
        }
        if (st.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int Nesting(String S) {
        Stack st = new Stack();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                st.push(S.charAt(i));
            } else if (S.charAt(i) == ')') {
                if (!st.isEmpty() && (char) st.peek() == '(') {
                    st.pop();
                } else {
                    return 0;
                }
            }
        }
        if (st.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    //not answered
    public static int StoneWall(int[] H) {
        return 0;
    }

    public static int Dominator(int[] A) {
        if (A.length == 0) {
            return -1;
        }
        Stack st = new Stack();
        st.push(A[0]);
        for (int i = 1; i < A.length; i++) {
            if ((!st.isEmpty()) && (int) st.peek() != A[i]) {
                st.pop();
            } else {
                st.push(A[i]);
            }
        }
        if (st.isEmpty()) {
            return -1;
        }
        int candidate = (int) st.peek();
        int sum = 0, indx = 0;
        for (int i = 0; i < A.length; i++) {
            if (candidate == A[i]) {
                sum++;
                indx = i;
            }
        }
        if (sum > (A.length / 2)) {
            return indx;
        } else {
            return -1;
        }
    }

    public static int EquiLeader(int A[]) {
        if (A.length == 0) {
            return 0;
        }
        Stack st = new Stack();
        st.push(A[0]);
        for (int i = 1; i < A.length; i++) {
            if ((!st.isEmpty()) && (int) st.peek() != A[i]) {
                st.pop();
            } else {
                st.push(A[i]);
            }
        }
        if (st.isEmpty()) {
            return 0;
        }
        int candidate = (int) st.peek();
        int sum = 0, indx = 0;
        for (int i = 0; i < A.length; i++) {
            if (candidate == A[i]) {
                sum++;
                indx = i;
            }
        }
        if (sum < (A.length / 2)) {
            return 0;
        }
        int leftCoutner = 0, eqiCounter = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == candidate) {
                leftCoutner++;
            }
            if (leftCoutner > ((i + 1) / 2) && ((sum - leftCoutner) > ((A.length - (i + 1)) / 2))) {
                eqiCounter++;
            }
        }
        return eqiCounter;
    }

    public static int MaxDoubleSliceSum(int A[]) {
        if (A.length < 3) {
            return 0;
        }
        double[] maxZeroToIndx = new double[A.length];
        maxZeroToIndx[0] = 0;
        for (int i = 1; i < A.length; i++) {
            maxZeroToIndx[i] = Math.max(0, (double) (maxZeroToIndx[i - 1]) + (double) A[i]);
        }

        double[] maxFromIndxToEnd = new double[A.length];
        maxFromIndxToEnd[A.length - 1] = 0;
        for (int i = A.length - 2; i >= 0; i--) {
            maxFromIndxToEnd[i] = Math.max(0, (double) (maxFromIndxToEnd[i + 1]) + (double) A[i]);
        }

        double maxSlice = 0;
        for (int i = 1; i < A.length - 1; i++) {
            maxSlice = Math.max(maxSlice, maxZeroToIndx[i - 1] + maxFromIndxToEnd[i + 1]);
        }
        return (int) maxSlice;
    }

    public static int MaxProfit(int A[]) {
        if (A.length == 0) {
            return 0;
        }
        double minPrice = A[0], maxProfToIndx = 0;
        for (int i = 1; i < A.length; i++) {
            minPrice = Math.min(A[i], minPrice);
            maxProfToIndx = Math.max(A[i] - minPrice, maxProfToIndx);
        }
        if (maxProfToIndx < 0) {
            return 0;
        }
        return (int) maxProfToIndx;
    }

    public static int MaxSliceSum(int A[]) {
        double maxSliceSum = A[0], maxToIndx = A[0];
        for (int i = 1; i < A.length; i++) {
            maxToIndx = Math.max(A[i], (double) (maxToIndx) + (double) A[i]);
            maxSliceSum = Math.max(maxSliceSum, maxToIndx);
        }
        return (int) maxSliceSum;
    }

    public static int CountFactors(int N) {
        int counter = 0;
        for (int i = 1; i < Math.sqrt(N); i++) {
            if (N % i == 0) {
                counter++;
            }
        }
        if (Math.floor(Math.sqrt(N)) == Math.sqrt(N)) {
            return (counter * 2) + 1;
        } else {
            return counter *= 2;
        }
    }

    public static int MinPerimeterRectangle(int N) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                min = Math.min(min, (N / i) + i);
            }
        }
        return min * 2;
    }

    public static int Peaks(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int[] lastPeakIndx = new int[A.length];
        lastPeakIndx[0] = -1;
        for (int i = 1; i < A.length - 1; i++) {
            if ((A[i] > A[i + 1]) && (A[i] > A[i - 1])) {
                lastPeakIndx[i] = i;
                lastPeakIndx[i + 1] = lastPeakIndx[i];
                i++;
            } else {
                lastPeakIndx[i] = lastPeakIndx[i - 1];
            }
        }
        lastPeakIndx[A.length - 1] = lastPeakIndx[A.length - 2];

        for (int i = 1; i <= A.length; i++) {
            if (A.length % i == 0) {
                boolean flag = true;
                for (int j = i - 1; j < A.length; j += i) {
                    if (lastPeakIndx[j] < j - i + 1) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return A.length / i;
                }
            }
        }
        return 0;
    }

    public static int Flags(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int maxFlag = 0;
        int[] nextPeak = new int[A.length];
        nextPeak[A.length - 1] = -1;
        for (int i = A.length - 2; i >= 1; i--) {
            if (A[i] > (Math.max(A[i - 1], A[i + 1]))) {
                nextPeak[i] = i;
            } else {
                nextPeak[i] = nextPeak[i + 1];
            }
        }
        nextPeak[0] = nextPeak[1];
        int i = 1;
        while ((i - 1) * i <= A.length) {
            int pos = 0;
            int num = 0;
            while (pos < A.length && num < i) {
                pos = nextPeak[pos];
                if (pos == -1) {
                    break;
                }
                num++;
                pos += i;
            }
            maxFlag = Math.max(maxFlag, num);
            i++;
        }
        return maxFlag;
    }

    public static int[] CountSemiprimes(int N, int[] P, int[] Q) {
        int[] F = new int[N + 1];
        int i = 2;
        while (i * i <= N) {
            if (F[i] == 0) {
                int k = i * i;
                while (k <= N) {
                    if (F[k] == 0) {
                        F[k] = i;
                    }
                    k += i;
                }
            }
            i++;
        }

        int[] semiPrimesTag = new int[N + 1];
        for (int j = 4; j <= N; j++) {
            int temp = j;
            int factorsCouner = 0;
            while (F[temp] > 0) {
                factorsCouner++;
                temp /= F[temp];
            }
            factorsCouner++;
            if (factorsCouner == 2) {
                semiPrimesTag[j] = 1;
            }
        }

        int[] semiPreSum = new int[N + 1];
        semiPreSum[0] = semiPrimesTag[0];
        for (int j = 1; j <= N; j++) {
            semiPreSum[j] = semiPreSum[j - 1] + semiPrimesTag[j];
        }

        int[] semiPrimesCounter = new int[P.length];
        for (int j = 0; j < P.length; j++) {
            semiPrimesCounter[j] = semiPreSum[Q[j]] - semiPreSum[P[j] - 1];
        }

        return semiPrimesCounter;
    }

    //not answered
    public static int[] CountNonDivisible(int[] A) {
        int[] k = {};
        return k;
    }

    public static int ChocolatesByNumbers(int N, int M) {
        int n = N;
        int gcd = N;
        while (true) {
            if (N % M == 0) {
                gcd = M;
                break;
            } else {
                int temp = N;
                N = M;
                M = temp % M;
            }
        }
        return n / gcd;
    }

    //correctness = 100 performance=16 total=61
    public static int CommonPrimeDivisors(int A[], int B[], int Z) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, Math.max(A[i], B[i]));
        }

        int[] F = new int[max + 1];
        int i = 2;
        while (i * i <= max) {
            if (F[i] == 0) {
                int k = i * i;
                while (k <= max) {
                    if (F[k] == 0) {
                        F[k] = i;
                    }
                    k += i;
                }
            }
            i++;
        }

        int maxPair = 0;
        ArrayList<Integer> AFactors = new ArrayList();
        ArrayList<Integer> BFactors = new ArrayList();
        for (int j = 0; j < A.length; j++) {
            int x = A[j];
            while (F[x] > 0) {
                if (AFactors.isEmpty()) {
                    AFactors.add(F[x]);
                } else if (AFactors.get(AFactors.size() - 1) != F[x]) {
                    AFactors.add(F[x]);
                }
                x /= F[x];
            }
            if (AFactors.isEmpty()) {
                AFactors.add(x);
            } else if (AFactors.get(AFactors.size() - 1) != x) {
                AFactors.add(x);
            }

            x = B[j];
            while (F[x] > 0) {
                if (BFactors.isEmpty()) {
                    BFactors.add(F[x]);
                } else if (BFactors.get(BFactors.size() - 1) != F[x]) {
                    BFactors.add(F[x]);
                }
                x /= F[x];
            }
            if (BFactors.isEmpty()) {
                BFactors.add(x);
            } else if (BFactors.get(BFactors.size() - 1) != x) {
                BFactors.add(x);
            }

            if (AFactors.equals(BFactors)) {
                maxPair++;
            }
            AFactors.clear();
            BFactors.clear();
        }
        return maxPair;
    }

    //Copy answer 
    public static int FibFrog(int A[]) {
        class Status {

            public int position;
            public int moves;

            public Status(int p, int m) {
                position = p;
                moves = m;
            }
        }

        int N = A.length;
        int[] fib = new int[N + 4];
        boolean[] visit = new boolean[N];
        fib[0] = 0;
        fib[1] = 1;
        int m = 1;
        do {
            m++;
            fib[m] = fib[m - 1] + fib[m - 2];
        } while (fib[m] <= N + 1);
        ArrayList<Status> statusQueue = new ArrayList<Status>();
        // use a queue to save the position and the moves of every possible jump
        statusQueue.add(new Status(-1, 0));
        int nextTry = 0;
        // use the breadth first search to get the result
        while (true) {
            if (nextTry == statusQueue.size()) {
                return -1;
            }
            Status currStatus = statusQueue.get(nextTry);
            nextTry++;
            int currPosition = currStatus.position;
            int currMoves = currStatus.moves;
            for (int i = m - 1; i > 0; i--) {
                if (currPosition + fib[i] == N) {
                    return currMoves + 1;
                } else if (currPosition + fib[i] > N
                        || A[currPosition + fib[i]] == 0
                        || visit[currPosition + fib[i]] == true) {
                    continue;
                }
                statusQueue.add(new Status(currPosition + fib[i], currMoves + 1));
                visit[currPosition + fib[i]] = true;
            }
        }
    }

    public static int[] Ladder(int A[], int B[], int L) {
        int maxA = A[0];
        int maxB = B[0];
        for (int i = 1; i < A.length; i++) {
            maxA = Math.max(maxA, A[i]);
            maxB = Math.max(maxB, B[i]);
        }
        ArrayList<Integer> fib = new ArrayList();
        fib.add(1);
        fib.add(2);
        for (int i = 2; i < maxA; i++) {
            fib.add((fib.get(i - 1) + fib.get(i - 2)) & ((1 << maxB) - 1));
        }
        int[] ways = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            ways[i] = fib.get(A[i] - 1) & ((1 << B[i]) - 1);
        }
        return ways;
    }

    public static int MinMaxDivision(int K, int M, int[] A) {
        class check {

            public int blockNumber(int[] arr, int expSum) {
                int numberOfBlocks = 1;
                int sum = arr[0];
                for (int i = 1; i < arr.length; i++) {
                    if (sum + arr[i] > expSum) {
                        sum = arr[i];
                        numberOfBlocks++;
                    } else {
                        sum += arr[i];
                    }
                }
                return numberOfBlocks;
            }
        }
        check ch = new check();
        int maxSum = A[0];
        int minSum = A[0];
        for (int i = 1; i < A.length; i++) {
            maxSum += A[i];
            minSum = Math.max(minSum, A[i]);
        }
        if (K >= A.length) {
            return minSum;
        }
        if (K == 1) {
            return maxSum;
        }
        int minimumValue = 0;
        while (maxSum >= minSum) {
            int mid = (minSum + maxSum) / 2;
            int neededBlocks = ch.blockNumber(A, mid);
            if (neededBlocks <= K) {
                maxSum = mid - 1;
                minimumValue = mid;
            } else {
                minSum = mid + 1;
            }
        }
        return minimumValue;
    }

    public static int NailingPlanks(int[] A, int[] B, int[] C) {
        class check {

            public int blockNumber(int[] arrA, int[] arrB, int[] arrC) {
                int numberOfPlank = 0;
                int[] preSumC = new int[arrC.length + 1];
                preSumC[1] = arrC[0];
                for (int i = 1; i < arrC.length; i++) {
                    preSumC[i] = preSumC[i - 1] + arrC[i];
                }
                for (int i = 0; i < arrA.length; i++) {
                    if (preSumC[arrB[i]] - preSumC[arrA[i] - 1] > 0) {
                        numberOfPlank++;
                    }
                }
                return numberOfPlank;
            }
        }
        check ch = new check();
        if (C.length == 0) {
            return -1;
        }

        int minimumNails = -1;
        int maxIndx = C.length - 1;
        int minIndx = 0;
        while (maxIndx >= minIndx) {
            int mid = (minIndx + maxIndx) / 2;
            int[] nailPos = new int[(C.length * 2) + 1];
            for (int i = 0; i <= mid; i++) {
                nailPos[C[i]] = 1;
            }
            int nailedPlanksNum = ch.blockNumber(A, B, nailPos);
            if (nailedPlanksNum == A.length) {
                maxIndx = mid - 1;
                minimumNails = mid + 1;
            } else {
                minIndx = mid + 1;
            }
        }
        return minimumNails;
    }

    public static int AbsDistinct(int[] A) {
        int end = 0, front = A.length - 1;
        int distinctElement = 0;
        if (A[end] == Integer.MIN_VALUE) {
            distinctElement++;
            while (A[end] == Integer.MIN_VALUE) {
                end++;
            }
        }
        while (end < front) {
            while (Math.abs(A[front]) > Math.abs(A[end]) && (end < front)) {
                if (A[front] != A[front - 1]) {
                    distinctElement++;
                }
                front--;
            }
            while (Math.abs(A[end]) >= Math.abs(A[front]) && (end < front)) {
                if ((A[end] != A[end + 1]) && (Math.abs(A[end]) != Math.abs(A[front]))) {
                    distinctElement++;
                }
                end++;
            }
        }
        distinctElement++;
        return distinctElement;

//        Set<Integer> mySet = new HashSet();
//        for (int i : A) {
//            mySet.add(Math.abs(i));
//        }
//        return mySet.size();
    }

    public static int CountDistinctSlices(int M, int[] A) {
        if (A.length == 1) {
            return 1;
        }
        int front = 0, end = 0;
        int numberOfSlices = 1;
        boolean[] m = new boolean[M + 1];
        Arrays.fill(m, true);
        m[A[0]] = false;
        while (true) {
            if (m[A[front + 1]] && (front < (A.length - 1))) {
                front++;
                numberOfSlices += (front - end + 1);
                m[A[front]] = false;
                if (numberOfSlices > 1_000_000_000) {
                    return 1_000_000_000;
                }
                if (front == A.length - 1) {
                    return numberOfSlices;
                }
            } else {
                while (!m[A[front + 1]]) {
                    m[A[end]] = true;
                    end++;
                }
            }
        }
    }

    public static int CountTriangles(int A[]) {
        if (A.length < 3) {
            return 0;
        }
        Arrays.parallelSort(A);
        int numberOfTriangles = 0;
        for (int i = 0; i < A.length; i++) {
            int k = i + 2;
            for (int j = i + 1; j < A.length; j++) {
                while ((k < A.length) && ((A[i] + A[j]) > A[k])) {
                    k++;
                }
                numberOfTriangles += (k - j - 1);
            }
        }
        return numberOfTriangles;
    }

    public static int MinAbsSumOfTwo(int A[]) {
        if (A.length == 1) {
            return Math.abs(A[0] + A[0]);
        }
        Arrays.parallelSort(A);
        int start = 0, end = A.length - 1;
        int min = (Math.abs(A[start] + A[end]));
        while (start <= end) {
            min = Math.min(min, Math.abs(A[start] + A[end]));
            if (Math.abs(A[start]) <= Math.abs(A[end])) {
                end--;
            } else {
                start++;
            }
        }
        return min;
    }

    public static int MaxNonoverlappingSegments(int A[], int B[]) {
        if (A.length <= 1) {
            return A.length;
        }
        int i = 0;
        int j = 1;
        int longestSequence = 1;
        while (j <= A.length - 1) {
            if (B[i] < A[j]) {
                longestSequence++;
                i = j;
            }
            j++;
        }
        return longestSequence;
    }

    public static int TieRopes(int K, int A[]) {
        if (A.length < 1) {
            return A.length;
        }
        int i = 0;
        int length = 0;
        int ropeNumber = 0;
        while (i <= A.length - 1) {
            length += A[i];
            if (length >= K) {
                ropeNumber++;
                length = 0;
            }
            i++;
        }
        return ropeNumber;
    }

    //no solution
    public static int NumberSolitaire(int[] A) {
        class check {

            public int nextPos(int[] arrA, int K, int start) {
                int nextHop = start;
                int i = 1;
                while (i < K && i < A.length) {
                    nextHop = A[i] >= A[nextHop] ? i : nextHop;
                    i++;
                }
                return nextHop;
            }
        }
        check ch = new check();

        int[] dp = new int[A.length];
        dp[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            dp[i] = dp[i - 1] + A[i];
        }
        for (int j = 2; j <= 6; j++) {
            int currentPos = 0;
            int sum = A[currentPos];
            while (currentPos < A.length - 1) {
                int nextHop = j;
                int i = 1;
                while ((i < j) && ((currentPos + i) < A.length)) {
                    if ((A[currentPos] + A[currentPos + i]) > A[currentPos]) {
                        nextHop = i;
                        break;
                    }
                    i++;
                }
                sum += A[nextHop];
                dp[currentPos + nextHop] = Math.max(dp[currentPos + nextHop], sum);
            }
        }
        return 0;
    }

    //no solution
    public static int MinAbsSum(int[] A) {
        return 0;
    }

    public static int TreeHeight(BinaryTree T) {
        if (T == null) {
            return -1;
        }
        return Math.max(TreeHeight(T.l), TreeHeight(T.r)) + 1;
    }

    public static class BinaryTree {

        public int x;
        public BinaryTree l;
        public BinaryTree r;
    }

    public static int StrSymmetryPoint(String S) {
        if ((S.length() % 2) == 0) {
            return -1;
        }
        for (int i = 0; i < S.length() / 2; i++) {
            if (S.charAt(i) != S.charAt(S.length() - i - 1)) {
                return -1;
            }
        }
        return S.length() / 2;
    }

    public static int solution(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;
        for (int k = 0; k < n; k++) {
            while (i < m - 1 && B[i] < A[k]) {
                i += 1;
            }
            if (A[k] == B[i]) {
                return A[k];
            }
        }
        return -1;
    }

    public static String password(String S) {
        String pass = "";
        Pattern p = Pattern.compile("[^0-9]*[A-Z]+[^0-9]*");
        Matcher m = p.matcher(S);
        while (m.find()) {
            System.out.println("match =" + m.group());
            pass = pass.length() < m.group().length() ? m.group() : pass;
        }
//        String pass = "";
//        int front = 1, end = 0;
//        while (front < S.length() + 1) {
//            String temp = S.substring(end, front);
//            if (temp.matches("[^0-9]*")) {
//                if (temp.matches("^[^0-9]*[A-Z]+[^0-9]*?")) {
//                    pass = pass.length() < temp.length() ? temp : pass;
//                }
//            } else {
//                end = front;
//            }
//            front++;
//        }
        return pass;
    }

    public static boolean areAnagrams(String a, String b) {
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        Arrays.parallelSort(A);
        Arrays.parallelSort(B);
        return Arrays.equals(A, B);
    }

    public static boolean isPalindrome(String str) {
        String temp = str.replaceAll("[^a-zA-Z]", "");
        temp = temp.toLowerCase();
        for (int i = 0; i < temp.length() / 2; i++) {
            if (temp.charAt(i) != temp.charAt(temp.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static int[] mergeSort(int[] A) {
        if (A.length <= 1) {
            return A;
        }
        int[] lowerA = mergeSort(Arrays.copyOfRange(A, 0, A.length / 2));
        int[] upperA = mergeSort(Arrays.copyOfRange(A, A.length / 2, A.length));
        int[] result = new int[A.length];
        int lowerIndx = 0;
        int upperIndx = 0;
        int resultIndx = 0;
        while (lowerIndx < lowerA.length && upperIndx < upperA.length) {
            if (lowerA[lowerIndx] < upperA[upperIndx]) {
                result[resultIndx] = (lowerA[lowerIndx]);
                lowerIndx++;
                resultIndx++;
            } else {
                result[resultIndx] = (upperA[upperIndx]);
                upperIndx++;
                resultIndx++;
            }
        }
        while (lowerIndx < lowerA.length) {
            result[resultIndx] = (lowerA[lowerIndx]);
            lowerIndx++;
            resultIndx++;
        }
        while (upperIndx < upperA.length) {
            result[resultIndx] = (upperA[upperIndx]);
            upperIndx++;
            resultIndx++;
        }
        return result;
    }

    public static int[][] matrixRotation(int[][] A) {
        int[][] B = new int[A.length][A[0].length];
        int first = 0;
        int last = A[0].length - 1;
        for (int i = 0; i <= A.length / 2; i++) {
            B[first][last] = A[first][first];
            B[last][last] = A[first][last];
            B[last][first] = A[last][last];
            B[first][first] = A[last][first];
            for (int j = first + 1; j <= last - 1; j++) {
                B[j][last] = A[first][j];
            }
            int jInv = last - 1;
            for (int j = first + 1; j <= last - 1; j++) {
                B[last][jInv] = A[j][last];
                jInv--;
            }
            for (int j = first + 1; j <= last - 1; j++) {
                B[j][first] = A[last][j];
            }
            jInv = last - 1;
            for (int j = first + 1; j <= last - 1; j++) {
                B[first][j] = A[jInv][first];
                jInv--;
            }
            first++;
            last--;
        }
        return B;
    }

    public static class Path {

        private String path;

        public Path(String path) {
            this.path = path;
        }

        public String getPath() {
            return path;
        }

        public Path cd(String newPath) {
            if (newPath.matches("^\\.\\./[a-zA-Z0-9]+([/][a-zA-Z0-9]+)*")) {
                path = path.substring(0, path.lastIndexOf('/')) + newPath.substring(newPath.lastIndexOf('/'));
            }
            if (newPath.matches("^\\.\\.")) {
                path = path.substring(0, path.lastIndexOf('/'));
            }
            if (newPath.matches("^/[a-zA-Z0-9]+([/][a-zA-Z0-9]+)*")) {
                path = path.substring(0, path.indexOf('/')) + newPath.substring(newPath.lastIndexOf('/'));
            }

            return new Path(path);
        }

    }

    public static int[] findTwoSum(int[] list, int sum) {
        Arrays.parallelSort(list);
        ArrayList<Integer> sumTarget = new ArrayList();
        for (int i = 0; i < list.length; i++) {
            if (Arrays.binarySearch(list, sum - list[i]) >= 0) {
                int j = Arrays.binarySearch(list, sum - list[i]);
                sumTarget.add(i);
                sumTarget.add(j);
                while ((j < list.length - 1) && (list[j] == list[j + 1])) {
                    j++;
                    sumTarget.add(i);
                    sumTarget.add(j);
                }
            }
        }
        int[] sumIndx = new int[sumTarget.size()];
        for (int i = 0; i < sumTarget.size(); i++) {
            sumIndx[i] = sumTarget.get(i);
        }
        return sumIndx;
    }

    public static class Tree {

        int node;
        ArrayList<Tree> children = new ArrayList(0);

        private Tree() {
        }

        Tree(int val) {
            Tree root = new Tree();
            root.node = val;
        }

        void addChild(int val) {
            Tree child = new Tree();
            child.node = val;
            this.children.add(child);
        }

        Tree getChild(int childNum) {
            if ((childNum < 1) && (childNum > this.children.size())) {
                throw new ArrayIndexOutOfBoundsException("The tree " + this + "has only " + this.children.size() + "child/ren.");
            }
            return this.children.get(childNum - 1);
        }

        void removeChild(int childNum) {
            if ((childNum < 1) && (childNum > this.children.size())) {
                throw new ArrayIndexOutOfBoundsException("The tree " + this + "has only " + this.children.size() + "child/ren.");
            }
            this.children.remove(childNum - 1);
        }

        void traverseBreadthfirst() {
            ArrayList<Tree> queue = new ArrayList();
            queue.add(this);
            while (!queue.isEmpty()) {
                System.out.println(queue.get(0).node);
                for (Tree k : queue.get(0).children) {
                    queue.add(k);
                }
                queue.remove(0);
            }
        }
    }

    public static void main(String[] args) {
        // Start your code here
        Tree t = new Tree(0);

        t.addChild(1);
        t.addChild(2);
        t.addChild(3);

        t.getChild(1).addChild(11);

        t.getChild(2).addChild(21);
        t.getChild(2).addChild(22);

        t.getChild(2).getChild(1).addChild(211);
        t.getChild(2).getChild(1).addChild(212);
        t.getChild(2).getChild(1).addChild(213);
        t.traverseBreadthfirst();

//        int[] indices = findTwoSum(new int[]{1, 5, 5, 6, 14, 15, 15, 15, 20, 21, 22, 25, 24, 28, 29, 31}, 34);
//        for (int i = 0; i < indices.length; i = i + 2) {
//            System.out.println(indices[i] + ", " + indices[i + 1]);
//        }
//
//        System.out.println(S.matches("^-?((\\d+)|((\\d{1,3})(\\,\\d{3})*))(\\.\\d+)?(e\\d+)?$"));
    }
}
