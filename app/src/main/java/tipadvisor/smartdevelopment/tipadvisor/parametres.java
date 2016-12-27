package tipadvisor.smartdevelopment.tipadvisor;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class parametres extends AppCompatActivity {
    public static int selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RadioButton defaut = (RadioButton)findViewById(R.id.radioButton);
        RadioGroup rg = (RadioGroup)findViewById(R.id.radioGroup);
        rg.check(defaut.getId());
        selected = rg.getCheckedRadioButtonId();
    }
    public void submit(View v){
        final RadioGroup rg = (RadioGroup)findViewById(R.id.radioGroup);
        selected = rg.getCheckedRadioButtonId();
        RadioButton rb = (RadioButton)findViewById(selected);
        startActivity(new Intent(getApplicationContext(), bienvenue.class));
        EditText pourboireDefault = (EditText)findViewById(R.id.pourboiredefault);
        Intent intent = new Intent (parametres.this, bienvenue.class);
        intent.putExtra("pourcentage", pourboireDefault.getText().toString());
        intent.putExtra("devise", rb.getText().toString());
        startActivity(intent);
        Toast.makeText(parametres.this, "La devise séléctioner est: " + rb.getText().toString(),Toast.LENGTH_SHORT).show();

    }
}



