package tipadvisor.smartdevelopment.tipadvisor;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class bienvenue extends AppCompatActivity {
    public String devise;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenue);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        EditText numPersonnes = (EditText)findViewById(R.id.numPersones);
        numPersonnes.setText("1");
        Intent i = getIntent();
        String pourboire = i.getStringExtra("pourcentage");
        devise = i.getStringExtra("devise");
        EditText pourcentage = (EditText)findViewById(R.id.pourcentage);
        pourcentage.setText(pourboire);

    }
    public void nextPage(View v) {
        EditText facture = (EditText) findViewById(R.id.facture);
        EditText pourcentage = (EditText) findViewById(R.id.pourcentage);
        if (facture.getText().toString().matches("") || pourcentage.getText().toString().matches("")) {
            Toast.makeText(bienvenue.this, "Veuillez remplir les champs requis!", Toast.LENGTH_SHORT).show();
        } else {
            startActivity(new Intent(getApplicationContext(), sommaire.class));
            EditText numPersonnes = (EditText) findViewById(R.id.numPersones);
            Intent intent = new Intent(bienvenue.this, sommaire.class);
            intent.putExtra("pourcentage", pourcentage.getText().toString());
            intent.putExtra("facture", facture.getText().toString());
            intent.putExtra("numPersonnes", numPersonnes.getText().toString());
            intent.putExtra("devise", devise);
            startActivity(intent);
        }
    }
    public void settings(View v){
        startActivity(new Intent(getApplicationContext(), parametres.class));
    }
    public void suggerer(View v){
        startActivity(new Intent(getApplicationContext(), suggerer.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bienvenue, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
