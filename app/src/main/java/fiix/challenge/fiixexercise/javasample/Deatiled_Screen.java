package fiix.challenge.fiixexercise.javasample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import fiix.challenge.fiixexercise.R;
import fiix.challenge.fiixexercise.dp.DataProcessor;

public class Deatiled_Screen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deatiled__screen);

        TextView question = findViewById(R.id.question);
        TextView answer = findViewById(R.id.answer);
        Button back = findViewById(R.id.back);
        back.setOnClickListener(view -> {
            Intent detailed_view = new Intent(Deatiled_Screen.this, MainActivity2.class);
            startActivity(detailed_view);
        });
        final Bundle extras = getIntent().getExtras();
         String tq = extras.getString("Trivia_question");
         String  ta = extras.getString("Trivia_answer");
         question.setText(tq);
         answer.setText(ta);




    }

}
