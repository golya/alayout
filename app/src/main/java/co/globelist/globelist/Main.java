package co.globelist.globelist;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
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
        header.setBackgroundColor(this.getResources().getColor(com.daililol.material.appbase.R.color.base_theme_blue));
        return header;
    }

    @Override
    protected Drawable setupThemeColor() {
        return new ColorDrawable(Color.YELLOW);
    }

    @Override
    protected int setupContentVew() {
        Log.d("MAIN", "setup content");
        return R.layout.actionbar;
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
    protected void onActivityCreated(Bundle savedInstanceState) {
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
}