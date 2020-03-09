package fiix.challenge.fiixexercise.javasample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import fiix.challenge.fiixexercise.R;
import fiix.challenge.fiixexercise.dp.DataProcessor;
import fiix.challenge.fiixexercise.javasample.MockRepo2;

public class MainActivity2 extends AppCompatActivity {

    List<String> quiestion_list;
    List<TriviaQuestion2> tq2;
    private DataProcessor dp = new DataProcessor(new LocalDataSource());





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TinyDB tinyDB = new TinyDB(getApplicationContext());

        if (!tinyDB.preferences.contains("answer"))
        {
            List<String> answers = dp.getAnswers();
            tinyDB.putListString("answer", answers);
        }

        setContentView(R.layout.activity_main);
        ListView main_list = findViewById(R.id.questions_list);

        List<TriviaQuestion2> Tquestions = MockRepo2.getTriviaQuestions();

        final trivia_question_grid adapter = new trivia_question_grid(this, Tquestions, true);
        main_list.setAdapter(adapter);

        Button reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(view -> {
            tinyDB.clear();
            Intent detailed_view = new Intent(MainActivity2.this, MainActivity2.class);
            startActivity(detailed_view);
        });







    }
}
