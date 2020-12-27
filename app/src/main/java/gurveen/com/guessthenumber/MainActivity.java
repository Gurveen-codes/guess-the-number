package gurveen.com.guessthenumber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText input_guess;
    Button guess_button,refresh_button;
    private int myGuess;
    private int random_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_guess = findViewById(R.id.input_guess);
        guess_button = findViewById(R.id.button_guess);
        refresh_button = findViewById(R.id.refresh_button);
        generateRandom();

        guess_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGuess();
            }
        });

        refresh_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateRandom();
                input_guess.setText("");
                Toast.makeText(MainActivity.this, "NEW GAME", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void checkGuess(){
        myGuess = Integer.parseInt(input_guess.getText().toString());
        if (myGuess < random_number) {
            Toast.makeText(MainActivity.this, "Go Higher!!!", Toast.LENGTH_SHORT).show();
            input_guess.setText("");
        } else if (myGuess > random_number) {
            Toast.makeText(MainActivity.this, "Go Lower!!!", Toast.LENGTH_SHORT).show();
            input_guess.setText("");
        } else {
            Toast.makeText(MainActivity.this, "!!You Win!!", Toast.LENGTH_LONG).show();

        }

    }
    private void generateRandom(){
        random_number = (int)( Math.random() * 100 + 1);
    }
}
