package com.gab2233.recette;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.Button;
import android.widget.TextView;


public class tab_recette extends FragmentActivity {

    private static final int SECOND_ACTIVITY_RESULT_CODE = 0;
    private FragmentTabHost tabs;

    Button b_Search;

    private View.OnClickListener clickListenerBoutons = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
      /* Réagir au clic pour les boutons 1 et 2*/
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_recette);

        tabs = (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabs.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        tabs.addTab(tabs.newTabSpec("new_tab").setIndicator("new Tab", null),BlankFragment.class,null);




        tabs.addTab(tabs.newTabSpec("tab1").setIndicator("Search", null),search_criteria.class,null);
        tabs.setCurrentTabByTag("tab1");
        b_Search = (Button) findViewById(R.id.button_search);
        b_Search.setOnClickListener(clickListenerBoutons);
        tabs.setOnTabChangedListener(new OnTabChangeListener() {

            public void onTabChanged(String tabId) {
                if("new_tab".equals(tabId)) {
                    int count = tabs.getTabWidget().getTabCount();
                    String tab_name = "tab"+String.valueOf(count);

                    tabs.addTab(tabs.newTabSpec(tab_name).setIndicator("Search"),search_criteria.class,null);

                    tabs.setCurrentTabByTag(tab_name);



                }
            }

        });

    }




}







/*

    private OnClickListener onClickListener = new OnClickListener() {

        @Override
        public void onClick(final View v) {
            Intent intent = new Intent(tab_recette.this, search_engine.class);
            startActivityForResult(intent, SECOND_ACTIVITY_RESULT_CODE);

        }
    };


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SECOND_ACTIVITY_RESULT_CODE) {
            if (resultCode == RESULT_OK) {
                TabHost.TabSpec spec = tabs_global.newTabSpec("tag1");

                spec.setContent(new TabHost.TabContentFactory() {
                    public View createTabContent(String tag) {
                        return (new AnalogClock(tab_recette.this));

                    }
                });
                spec.setIndicator("Clock");
                tabs_global.addTab(spec);

            }
        }
    }


*/


//}

/*ublic class Main extends Activity implements View.OnTouchListener,View.OnClickListener {
    private Button b = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button) findViewById(R.id.calc);
        imc_texte =
                b.setOnClickListener(this);
        b.setOnTouchListener(this);
    }
    @Override
    public boolean Ontouch(View v, MotionEvent event){
        return true;
    }
    public boolean OnClick(View v){

        case R.id.calc:
        break;
        case R.id.raz:
        break;
    }
}*/
