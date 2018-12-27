package marcelo.junior.projetoblocodenotas.ui;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;


import com.savvi.rangedatepicker.CalendarPickerView;

import java.util.Calendar;

import marcelo.junior.projetoblocodenotas.R;
import marcelo.junior.projetoblocodenotas.adapter.PageAdapter;

public class MainActivity extends AppCompatActivity  {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private TabItem tabItem1;
    private TabItem tabItem2;
    private ViewPager viewPager;
    private PageAdapter adapter;


//    EditText etDate;
//    int y,m,d;
//    String DOB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Calendar calendar = Calendar.getInstance();



        //Refs
        tabLayout = findViewById(R.id.tab_layout);
        tabItem1 = findViewById(R.id.tab_item_1);
        tabItem2 = findViewById(R.id.tab_item_2);
        viewPager = findViewById(R.id.view_pager);



        adapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());

        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }//fecha onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       // getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }//fecha onCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }//fecha onOptionsItemSelected

}//fecha Classe
