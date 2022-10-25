public class GameOfLife {
    public void gameOfLife(int[][] board) {
        // original | new | state
        //    0     |  0  |   0
        //    1     |  0  |   1
        //    0     |  1  |   2
        //    1     |  1  |   3

        int ROWS = board.length;
        int COLS = board[0].length;

        for(int r=0; r<ROWS; r++){
            for(int c=0; c<COLS; c++){
                int nei = countNeighbors(board, r, c);

                if(board[r][c] == 1){
                    if(nei == 2 || nei == 3){
                        board[r][c] = 3;
                    }
                }else{
                    if(nei == 3) board[r][c] = 2;
                }
            }
        }

        for(int r=0; r<ROWS; r++){
            for(int c=0; c<COLS; c++){
                if(board[r][c] == 2 || board[r][c] == 3){
                    board[r][c] = 1;
                }else if(board[r][c] == 1){
                    board[r][c] = 0;
                }
            }
        }
    }

    public int countNeighbors(int[][] board, int r, int c){
        int nei = 0;
        
        for(int i=r-1; i<r+2; i++){
            for(int j = c-1; j<c+2; j++){

                if((i==r && j==c) || i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1){
                    continue;
                }

                if(board[i][j] == 1 || board[i][j] == 3){
                    nei++;
                }
            }
        }

        return nei;
    }
}
