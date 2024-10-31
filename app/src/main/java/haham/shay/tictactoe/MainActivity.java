package haham.shay.tictactoe;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    String turn;
    String [] [] board;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void onNewGame() {
        board = new String[3][3];
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                board[row][col] = new String();
        turn = "x";
        count = 0;
    }


    void onButtonClick(View view)
    {
        if (view.getId() == R.id.btn_00) {
            handleClick(0, 0, R.id.btn_00);
        }
        if (view.getId() == R.id.btn_01){
            handleClick(0, 1, R.id.btn_01);
        }
        if(view.getId() == R.id.btn_02) {
            handleClick(0, 2, R.id.btn_02);
        }
        if(view.getId() == R.id.btn_10) {
            handleClick(1, 0, R.id.btn_10);
        }
        if(view.getId() == R.id.btn_11) {
            handleClick(1, 1, R.id.btn_11);
        }
        if(view.getId() == R.id.btn_12) {
            handleClick(1, 2, R.id.btn_12);
        }
        if(view.getId() == R.id.btn_20) {
            handleClick(2, 0, R.id.btn_20);
        }
        if(view.getId() == R.id.btn_21) {
            handleClick(2, 1, R.id.btn_21);
        }
        if(view.getId() == R.id.btn_22){
            handleClick(2, 2, R.id.btn_22);
        }

    }
    private void handleClick(int row, int col, int id) {
        if (board[row][col].equals("")) {
            board[row][col] = turn;
            Button btn = findViewById(id);
            btn.setText(turn);
            onTurnEnd();
        }
    }
    Boolean isWinner() {
        return false;
    }
    void endGame(String s) {
    }
    private void onTurnEnd() {
        if (isWinner())
            endGame(turn + " won!");
        else {
            count++;
        }
        if (count == 9)
            endGame("Tie");
        else {
            turn = (turn.equals("X") ? "O" : "X");
        }
    }
}