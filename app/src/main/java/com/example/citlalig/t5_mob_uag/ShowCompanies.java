package com.example.citlalig.t5_mob_uag;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import com.example.citlalig.t5_mob_uag.list.ListItem;
import com.example.citlalig.t5_mob_uag.list.ListItemAdapter;

/**
 * Created by citlalig on 12/4/14.
 */
public class ShowCompanies extends Activity {
    private ArrayList<ListItem> mArraylist = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_companies);

        ListView listView = (ListView) findViewById(R.id.list_test);

        Intent intent = getIntent();
        mArraylist = intent.getParcelableArrayListExtra(MainActivity.SHARED_LIST_KEY);

        /*mArraylist = new ArrayList<ListItem>();
        ListItem listItem = new ListItem();
        listItem.setImageUser(getResources().getDrawable(R.drawable.ic_launcher));
        listItem.setHeader("Gerardo");
        listItem.setSubHeader("González");
        mArraylist.add(listItem);*/



        final ListItemAdapter listItemAdapter = new ListItemAdapter(getBaseContext(), mArraylist);
        listView.setAdapter(listItemAdapter);

        //set on click listeners
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //show header of the item clicked on a toast
                Toast.makeText(getBaseContext(), mArraylist.get(i).getHeader() + " pressed", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_companies, menu);
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