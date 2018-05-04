package com.waynechen.fragmentbasicusage;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringDef;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.waynechen.fragmentbasicusage.fragments.DashboardFragment;
import com.waynechen.fragmentbasicusage.fragments.DetailFragment;
import com.waynechen.fragmentbasicusage.fragments.HomeFragment;
import com.waynechen.fragmentbasicusage.fragments.NotificationsFragment;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private FragmentManager mFragmentManager;
    private HomeFragment mHomeFragment;
    private DashboardFragment mDashboardFragment;
    private NotificationsFragment mNotificationsFragment;

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({
            HOME, DASHBOARD, NOTIFICATIONS, DETAIL
    })
    public @interface FragmentType {}
    public static final String HOME = "HOME";
    public static final String DASHBOARD = "DASHBOARD";
    public static final String NOTIFICATIONS = "NOTIFICATIONS";
    public static final String DETAIL = "DETAIL";
    public static final String DETAIL_MESSAGE = "DetailMessage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentManager = getFragmentManager();

        ((BottomNavigationView) findViewById(R.id.navigation)).setOnNavigationItemSelectedListener(this);
        ((BottomNavigationView) findViewById(R.id.navigation)).setSelectedItemId(R.id.navigation_home);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        if (mFragmentManager.findFragmentByTag(DETAIL) != null) {
            mFragmentManager.popBackStack();
        }

        switch (item.getItemId()) {
            case R.id.navigation_home:

                if (mHomeFragment == null) mHomeFragment = new HomeFragment();
                if (mDashboardFragment != null) fragmentTransaction.hide(mDashboardFragment);
                if (mNotificationsFragment != null) fragmentTransaction.hide(mNotificationsFragment);
                if (mHomeFragment.isAdded()) {
                    fragmentTransaction.show(mHomeFragment);
                } else {
                    fragmentTransaction.add(R.id.container_main, mHomeFragment, HOME);
                }
                fragmentTransaction.commit();

                return true;
            case R.id.navigation_dashboard:

                if (mDashboardFragment == null) mDashboardFragment = new DashboardFragment();
                if (mHomeFragment != null) fragmentTransaction.hide(mHomeFragment);
                if (mNotificationsFragment != null) fragmentTransaction.hide(mNotificationsFragment);
                if (mDashboardFragment.isAdded()) {
                    fragmentTransaction.show(mDashboardFragment);
                } else {
                    fragmentTransaction.add(R.id.container_main, mDashboardFragment, DASHBOARD);
                }
                fragmentTransaction.commit();

                return true;
            case R.id.navigation_notifications:

                if (mNotificationsFragment == null) mNotificationsFragment = new NotificationsFragment();
                if (mHomeFragment != null) fragmentTransaction.hide(mHomeFragment);
                if (mDashboardFragment != null) fragmentTransaction.hide(mDashboardFragment);
                if (mNotificationsFragment.isAdded()) {
                    fragmentTransaction.show(mNotificationsFragment);
                } else {
                    fragmentTransaction.add(R.id.container_main, mNotificationsFragment, NOTIFICATIONS);
                }
                fragmentTransaction.commit();

                return true;
        }
        return false;
    }

    public void onOpenDetail(String message) {

        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();

        if (mHomeFragment != null && !mHomeFragment.isHidden()) {
            fragmentTransaction.hide(mHomeFragment);
            fragmentTransaction.addToBackStack(HOME);
        }
        if (mDashboardFragment != null && !mDashboardFragment.isHidden()) {
            fragmentTransaction.hide(mDashboardFragment).addToBackStack(DASHBOARD);
        }
        if (mNotificationsFragment != null && !mNotificationsFragment.isHidden()) {
            fragmentTransaction.hide(mNotificationsFragment).addToBackStack(NOTIFICATIONS);
        }

        DetailFragment fragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(DETAIL_MESSAGE, message);
        fragment.setArguments(bundle);

        fragmentTransaction.add(R.id.container_main, fragment, DETAIL).commit();

    }
}
