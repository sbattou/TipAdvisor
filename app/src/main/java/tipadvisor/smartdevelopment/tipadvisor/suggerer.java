package tipadvisor.smartdevelopment.tipadvisor;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class suggerer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggerer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RatingBar rating = (RatingBar)findViewById(R.id.ratingBar);
        final TextView rate = (TextView)findViewById(R.id.textView6);
        rating.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        float rateNum = rating;
                        rateNum = 2*rateNum + 10;

                        rate.setText("D'après nos calculs, on vous suggère un pourboire de: "+ String.valueOf(rateNum) + "%");
                    }
                }
        );
    }

}
