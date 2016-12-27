package tipadvisor.smartdevelopment.tipadvisor;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class sommaire extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sommaire);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent i = getIntent();
        String facture = i.getStringExtra("facture"); //importing the data from bienvenue
        String pourcentage = i.getStringExtra("pourcentage");
        String numPersonnes = i.getStringExtra("numPersonnes");
        String devise = i.getStringExtra("devise");
        if (devise ==null){
            devise = "Dollar ($)";
        }

        TextView factureTotal = (TextView)findViewById(R.id.facture);
        TextView pourboire = (TextView)findViewById(R.id.pourboire);
        TextView total = (TextView)findViewById(R.id.total);
        TextView pourboirePP = (TextView)findViewById(R.id.pourboirePP);
        TextView facturePP = (TextView)findViewById(R.id.facturePP);
        factureTotal.setText("Montant de la facture: "+facture + " " +devise);

        double pour = Integer.parseInt(pourcentage);
        double fac = Integer.parseInt(facture);
        double pourboireCal = fac * pour / 100;
        String pourboireTotal = String.valueOf(pourboireCal);
        pourboire.setText("Montant du pourboire: " +pourboireTotal + " " +devise);

        double tot = pourboireCal + fac;
        String Total = String.valueOf(tot);
        total.setText("Montant total: " + Total + " " +devise  );


        int personnes = Integer.parseInt(numPersonnes);
        if (personnes > 1) {
            double pourboirePersonne = pourboireCal / personnes;
            String PP = String.valueOf(pourboirePersonne);
            pourboirePP.setText("Montant du pourboire par personne: " + PP + " " +devise);

            double facturePersonne = tot / personnes;
            String FP = String.valueOf(facturePersonne);
            facturePP.setText("Montant de la facture par personne: " + FP + " " +devise);
        }
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
    public void back(View v){
        startActivity(new Intent(getApplicationContext(), bienvenue.class));
    }
    //@Override
   //  public void onBackPressed() { }


}
