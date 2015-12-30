package co.globelist.globelist;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
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
        navigationListAdapter.addItem("item 1",
                DrawableUtil.getDrawable(this, R.drawable.ic_menu_black_24dp));
        navigationListAdapter.addItem("item 2",
                DrawableUtil.getDrawable(this, R.drawable.ic_close_grey600_18dp));
    }

    @Override
    protected View setupNavigationDrawerHeader() {
        AbsListView.LayoutParams params;
        params = new AbsListView.LayoutParams(AdapterView.LayoutParams.MATCH_PARENT, Converter.dp2px(this, 20));
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
        return R.layout.actionbar;
    }

    @Override
    protected void onMenuItemSelected(MenuItem menu) {
        switch (menu.getItemId()) {
            case android.R.id.home:
                //finish();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityCreated(Bundle savedInstanceState) {
    }

    @Override
    protected boolean navigationOnItemClickListener(AdapterView<?> adapterView, View itemView, int position) {
        return false;
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