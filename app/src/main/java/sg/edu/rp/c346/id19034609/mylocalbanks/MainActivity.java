package sg.edu.rp.c346.id19034609.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvBankDBS, tvBankOCBC, tvBankUOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvBankDBS = findViewById(R.id.TextViewBankDBS);
        tvBankOCBC = findViewById(R.id.TextViewBankOCBC);
        tvBankUOB = findViewById(R.id.TextViewBankUOB);

        registerForContextMenu(tvBankDBS);
        registerForContextMenu(tvBankOCBC);
        registerForContextMenu(tvBankUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v == tvBankDBS){
            menu.add(1,1,0,"Website");
            menu.add(1,2,1,"Contact the bank");
        }
        else if (v == tvBankOCBC){
            menu.add(2,3,0,"Website");
            menu.add(2,4,1,"Contact the bank");
        }
        else if (v == tvBankUOB){
            menu.add(3,5,0,"Website");
            menu.add(3,6,1,"Contact the bank");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()==1) {
            Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
            startActivity(intentWebsite);
        }
        if(item.getItemId()==2) {
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18001111111"));
            startActivity(intentCall);
        }
        if(item.getItemId()==3) {
            Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
            startActivity(intentWebsite);
        }
        if(item.getItemId()==4) {
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18003633333"));
            startActivity(intentCall);
        }
        if(item.getItemId()==5) {
            Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
            startActivity(intentWebsite);
        }
        if(item.getItemId()==6) {
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18002222121"));
            startActivity(intentCall);
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.languageEnglish) {
            tvBankDBS.setText(getString(R.string.bankDBSe));
            tvBankOCBC.setText(getString(R.string.bankOCBCe));
            tvBankUOB.setText(getString(R.string.bankUOBe));
        } else if (id == R.id.languageChinese) {
            tvBankDBS.setText(R.string.bankDBSc);
            tvBankOCBC.setText(R.string.bankOCBCc);
            tvBankUOB.setText(R.string.bankUOBc);
        }
        return super.onOptionsItemSelected(item);
    }
}
