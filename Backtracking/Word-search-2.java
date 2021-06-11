class Solution {
    public List<String> findWords(char[][] board, String[] words) {
            return method(board, words);
    }

    public List<String> method(char[][] board, String[] word) {
        int row = board.length;
        int col = board[0].length;

        boolean[][] visited = new boolean[row][col];
        List<String>  result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                for(String s: word) {
                    if (dfs(board, visited, i, j, 0, s)){                        
                        set.add(s);
                    }
                }
            }
        }
        for(String s: set) result.add(s);
        return result;
    }

    public boolean dfs(char[][] board, boolean[][] visited, int row, int col, int index, String word) {
        if(word.length() == index) {
            return true;
        }

        if(row<0 || col<0 || row>=board.length || col>=board[0].length) return false;


        char ch = word.charAt(index);
        if(!visited[row][col] && ch == board[row][col]) {
            visited[row][col] = true;
            boolean up = dfs(board,visited,row-1,col,index+1,word);
            boolean down = dfs(board,visited,row+1,col,index+1,word);
            boolean left = dfs(board,visited,row,col-1,index+1,word);
            boolean right = dfs(board,visited,row,col+1,index+1,word);

            visited[row][col] = false;
            if(up || down || left || right) {
                return true;
            }            
        }
        return false;
    }
}
