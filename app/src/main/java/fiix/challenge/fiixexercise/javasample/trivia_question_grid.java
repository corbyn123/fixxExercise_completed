package fiix.challenge.fiixexercise.javasample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import fiix.challenge.fiixexercise.R;
import fiix.challenge.fiixexercise.dp.DataProcessor;
import fiix.challenge.fiixexercise.kotlinsample.MainActivity;


public class trivia_question_grid extends BaseAdapter{
    private Context mContext;
    public List<TriviaQuestion2> Tquestions;


    public trivia_question_grid(Context c, List<TriviaQuestion2> Tquestions, boolean b) {
        this.mContext = c;
        this.Tquestions = Tquestions;
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return this.Tquestions.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return this.Tquestions.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    static class ViewHolder {


        TextView question;
        Button view_answer;
        LinearLayout background;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final fiix.challenge.fiixexercise.javasample.trivia_question_grid.ViewHolder holder;
        TinyDB tinyDB = new TinyDB(mContext);

        TriviaQuestion2 x = this.Tquestions.get(position);


        LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            holder = new fiix.challenge.fiixexercise.javasample.trivia_question_grid.ViewHolder();


        convertView = inflater.inflate(R.layout.trivia_question, null);
            holder.question = (TextView) convertView.findViewById(R.id.question_text);
        holder.background = (LinearLayout) convertView.findViewById(R.id.background);

        holder.question.setText(x.question);
        holder.view_answer = (Button) convertView.findViewById(R.id.view_answer);

        if (tinyDB.preferences.contains(String.valueOf(position)))
        {

            holder.view_answer.setText("ANSWER VIEWED!");
            holder.background.setBackgroundColor(mContext.getResources().getColor(R.color.colorAccent));




        }






        holder.view_answer.setOnClickListener(view -> {
                tinyDB.putBoolean(String.valueOf(position), true);
            Bundle results = new Bundle();
            results.putString("Trivia_question", x.question);
            List<String> answers1 = tinyDB.getListString("answer");
            String answer = answers1.get(position);
            results.putString("Trivia_answer", answer);
            Intent detailed_view = new Intent(mContext, Deatiled_Screen.class);
                detailed_view.putExtras(results);
            mContext.startActivity(detailed_view);
            });



            convertView.setTag(holder);





        return convertView;
    }





}
