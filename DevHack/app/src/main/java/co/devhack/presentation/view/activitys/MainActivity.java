package co.devhack.presentation.view.activitys;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import co.devhack.R;
import co.devhack.domain.model.Program;
import co.devhack.domain.model.Work;
import co.devhack.presentation.interfaces.ReplaceFragmentProgram;
import co.devhack.presentation.interfaces.ReplaceFragmentWork;
import co.devhack.presentation.view.dialog.ContactsDialog;
import co.devhack.presentation.view.fragments.ListPrograms;
import co.devhack.presentation.view.fragments.ListWork;
import co.devhack.presentation.view.fragments.ProgramsInformation;
import co.devhack.presentation.view.fragments.WorkInformation;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ReplaceFragmentWork, ReplaceFragmentProgram {

    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        replaceFragment(ListPrograms.getInstance(), true);
        selectMenuItem(R.id.nav_programs);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_programs) {
            replaceFragment(ListPrograms.getInstance(), true);
        } else if (id == R.id.nav_work) {
            replaceFragment(ListWork.getInstance(), true);
        } else if (id == R.id.nav_contacts) {
            ContactsDialog contactsDialog = ContactsDialog.getInstance();
            contactsDialog.show(getSupportFragmentManager(),null);
        } else if (id == R.id.nav_manage) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void selectMenuItem(@IdRes int id) {
        MenuItem item = navigationView.getMenu().findItem(id);
        if(!item.isChecked()) {
            item.setChecked(true);
        }
    }

    public void replaceFragment(Fragment fragment, boolean addToBackStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        if(addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }


    @Override
    public void replaceFragmentMainActivity(Work work) {
        replaceFragment(WorkInformation.getInstance(work), true);
    }

    @Override
    public void replaceFragmentMainActivity(Program program) {
        replaceFragment(ProgramsInformation.getInstance(program), true);
    }
}
