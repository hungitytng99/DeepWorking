package com.icthust.deepworking;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.icthust.deepworking.ui.account.AccountFragment;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


public class MainActivity extends AppCompatActivity {
    SpaceNavigationView navigationView;
    FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();

        navigationView = findViewById(R.id.bottom_tab);
        final SpaceNavigationView spaceNavigationView = (SpaceNavigationView) findViewById(R.id.bottom_tab);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_baseline_view_day_24));
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_baseline_score_24));
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_notifications_black_24dp));
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_outline_account_circle_24));
        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                Toast.makeText(MainActivity.this,"onCentreButtonClick", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                switch (itemIndex){
                    case 0:
                        FragmentTransaction ft_add = fm.beginTransaction();
                        ft_add.add(R.id.bottom_tab, new AccountFragment());
                        ft_add.commit();
                        break;
                    case 1:
                        Log.v("Press", "1");
                        break;
                    case 2:
                        Log.v("Press", "2");
                        break;
                    case 3:
                        Log.v("Press", "3");
                        break;
                }
                Toast.makeText(MainActivity.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {
                Toast.makeText(MainActivity.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
            }
        });

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.top_nav_menu,menu);
//        return true;
//    }


}