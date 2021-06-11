// To find particular cell nth row and rth column use formular n-1Cr-1
// To print whole triangle use loop
//Find nth row
class Solution {
    ArrayList<Long> nthRowOfPascalTriangle(int n) {
        ArrayList<Long> list = new ArrayList<>();
        long res = 1;
        for (long i = 1; i < n; i++) {
            list.add(res);
            res = (long) (res * (double)(n - i) / i);
        }
        list.add(res);
        return list;
    }
}
