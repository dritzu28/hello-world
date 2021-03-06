package activity;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.widget.DrawerLayout;
import com.example.itzuvillarce.gittestproject.R;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener{

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    private CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        collapsingToolbarLayout.setTitle("dritzu");

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        displayFragmentView(0);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        final PagerAdapter adapter = new adapter.PagerAdapter(getSupportFragmentManager(),  tabLayout.getTabCount());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id =  item.getItemId();

        if(id == R.id.action_settings){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayFragmentView(position);
    }


    private void displayFragmentView(int position){

        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position){
            case 0:
                fragment = new HomeFragment();
                title = getString(R.string.title_home);
                break;
            case 1:
                fragment =  new FriendsFragment();
                title = getString(R.string.title_friends);
                break;
            case 2:
                fragment = new MessagesFragment();
                title = getString(R.string.title_message);
                break;
            default:
                break;

        }

        Log.d("Fragment", "fragment home : " + fragment);

        if(fragment != null){
            FragmentManager fragmentManager =  getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            getSupportActionBar().setTitle(title);

        }

    }
}
