package co.globelist.globelist;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.daililol.material.appbase.base.BaseNavigationDrawerActivity;
import com.daililol.material.appbase.component.BaseNavigationDrawerListAdapter;
import com.daililol.material.appbase.utility.Converter;
import com.daililol.material.appbase.utility.DrawableUtil;
import com.daililol.material.appbase.widget.ExtendableListView;

public class Main extends BaseNavigationDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onActivityCreated(Bundle savedInstanceState) {
        this.requestBackIcon(DrawableUtil.getDrawable(this, R.drawable.ic_arrow_back_white_24dp));
        this.setActionbarTitle("Globelist", Color.rgb(255, 255, 255));
    }

    @Override
    protected void setupNavigationDrawerItem(ExtendableListView listView, BaseNavigationDrawerListAdapter navigationListAdapter) {
        listView.setBackgroundColor(Color.WHITE);
        Drawable normalState = DrawableUtil.getDrawable(this, R.drawable.ic_chat_black);
        Drawable selectedState = DrawableUtil.getDrawable(this, R.drawable.ic_chat_white);
        StateListDrawable iconDrawable1 = DrawableUtil.createStateListDrawable(
                this, normalState, selectedState, selectedState, selectedState, normalState);
        StateListDrawable iconDrawable2 = DrawableUtil.createStateListDrawable(
                this, normalState, selectedState, selectedState, selectedState, normalState);

        navigationListAdapter.addItem("Messages", iconDrawable1);
        navigationListAdapter.addItem("Profile", iconDrawable2);

    }

    @Override
    protected View setupNavigationDrawerHeader() {
        AbsListView.LayoutParams params;
        params = new AbsListView.LayoutParams(AdapterView.LayoutParams.MATCH_PARENT, Converter.dp2px(this, 200));
        LinearLayout header = new LinearLayout(this);
        header.setLayoutParams(params);
        header.setBackgroundColor(Color.rgb(80, 8, 36));
        return header;
    }

    @Override
    protected Drawable setupThemeColor() {
        return new ColorDrawable(Color.rgb(80, 8, 36));
    }

    @Override
    protected int setupContentVew() {
        Log.d("MAIN", "setup content");
        return R.layout.actionbar;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        switch (position){
            case 1:
                launch(Messages.class);
                break;
            case 2:
                launch(Profile.class);
                break;
            default:
                Log.d("Main", "Unknown menu item position: "+position);
        }
    }

    @Override
    protected void onMenuItemSelected(MenuItem menu) {
        switch (menu.getItemId()) {
            case R.id.messages:
                Log.d("Main", "Messages");
                break;
            case R.id.profile:
                Log.d("Main", "Profile");
                break;
        }
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    @Override
    protected boolean navigationOnItemClickListener(AdapterView<?> adapterView, View itemView, int position) {
        return true;
    }

    @Override
    protected boolean onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        return false;
    }

    @Override
    protected Object onDoTaskInBackground(Object... params) {
        return null;
    }

    @Override
    protected void handleUiMessage(Message msg) {

    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {

    }

    @Override
    public void onDrawerOpened(View drawerView) {

    }

    @Override
    public void onDrawerClosed(View drawerView) {

    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }

    private void launch(Class destClass) {
        Intent i = new Intent(getApplicationContext(), destClass);
        startActivity(i);
    }
}