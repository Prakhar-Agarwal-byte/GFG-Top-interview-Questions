class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor) solve(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void solve(int[][] image, int row, int col, int oldColor, int newColor) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != oldColor) return;
        image[row][col] = newColor;
        solve(image, row+1, col, oldColor, newColor);
        solve(image, row, col+1, oldColor, newColor);
        solve(image, row-1, col, oldColor, newColor);
        solve(image, row, col-1, oldColor, newColor);
    }
}
