package com.example.myapplication;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompactActivity{
    private EditText editText;
    private Spinner spinner;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        spinner = findViewById(R.id.spinner);
        resultTextView = findViewById(R.id.resultTextView);

        Button countButton = findViewById(R.id.countButton);
        countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = editText.getText().toString().trim();

                if (inputText.isEmpty()) {
                    // Show a toast warning if the input text is empty
                    Toast.makeText(getApplicationContext(), "Text is empty", Toast.LENGTH_SHORT).show();
                } else {
                    String countType = spinner.getSelectedItem().toString();
                    int count = 0;

                    if (countType.equals("Words")) {
                        count = TextCounter.countWords(inputText);
                    } else if (countType.equals("Characters")) {
                        count = TextCounter.countCharacters(inputText);
                    }

                    resultTextView.setText("Count: " + count);
                }
            }
        });
    }

}
