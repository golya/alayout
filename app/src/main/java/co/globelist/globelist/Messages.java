package co.globelist.globelist;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.daililol.material.appbase.base.BaseActionbarActivity;
import com.daililol.material.appbase.utility.DrawableUtil;


public class Messages extends BaseActionbarActivity{

    @Override
    protected void onActivityCreated(Bundle savedInstanceState) {
        this.requestHomeIcon(DrawableUtil.getDrawable(this, R.drawable.ic_chat_white));
        this.requestBackIcon(DrawableUtil.getDrawable(this, R.drawable.ic_arrow_back_white_24dp));
        this.setActionbarTitle("Messages", Color.rgb(255, 255, 255));
    }

    @Override
    protected int setupContentVew() {
        return R.layout.messages;
    }

    @Override
    protected Drawable setupThemeColor() {
        return new ColorDrawable(Color.rgb(80, 8, 36));
    }

    @Override
    protected void onMenuItemSelected(MenuItem menu) {
        Log.d("Messages", "menu selected: " + menu.getItemId());
        switch (menu.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
    }

    @Override
    protected boolean onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.messages, menu);
        menu.add(0, 0, 0, "Option1").setShortcut('3', 'c');
        return true;
    }

    @Override
    protected Object onDoTaskInBackground(Object... params) {
        return null;
    }

    @Override
    protected void handleUiMessage(Message msg) {

    }

    @Override
    public void onClick(View view) {

    }
}
