package com.leontheprofessional.bballscoreboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.leontheprofessional.bballscoreboard.scoreboard.ScoreBoardMainActivity;

public class MainActivity extends AppCompatActivity {

    private Button scoreBoardMainActivityBtn;
    private Button statisticsMainActivityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreBoardMainActivityBtn = (Button) findViewById(R.id.scoreboard_btn_main_activity);
        scoreBoardMainActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScoreBoardMainActivity.class);
                startActivity(intent);
            }
        });

        statisticsMainActivityBtn = (Button) findViewById(R.id.statistic_btn_main_activity);
        statisticsMainActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Statistics will be added shortly.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_activity_menu_login:
                Toast.makeText(MainActivity.this, "LogIn capabilities will be added shortly", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
