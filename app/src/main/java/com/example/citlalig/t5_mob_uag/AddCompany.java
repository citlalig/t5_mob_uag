package com.example.citlalig.t5_mob_uag;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by citlalig on 12/4/14.
 */
public class AddCompany extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_company);

        Intent intent = getIntent();
        Integer companiesNumber = intent.getIntExtra("companies_number", 0);

        TextView txtCompanyName = (TextView) findViewById(R.id.counter_txt);
        txtCompanyName.setText(companiesNumber.toString());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_company, menu);
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

    public void addCompany(View view) {
        EditText txtCompanyName = (EditText) findViewById(R.id.company_txt);
        EditText txtBusinessLine  = (EditText) findViewById(R.id.line_bus_txt);

        String userName = txtCompanyName.getText().toString().trim();
        String businessLine = txtBusinessLine.getText().toString().trim();

        if(TextUtils.isEmpty(userName)) {
            Toast.makeText(this, "Please enter the company name ", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(businessLine)) {
            Toast.makeText(this, "Please enter the business line ", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra("company_name", userName);
        data.putExtra("business_line", businessLine);
        setResult(Activity.RESULT_OK, data);
        super.onBackPressed();
    }


    @Override
    public void onBackPressed() {
        Intent data = new Intent();
        //data.putExtra("key", yourDataHere);

        setResult(Activity.RESULT_CANCELED, data);
        super.onBackPressed();
    }
}

