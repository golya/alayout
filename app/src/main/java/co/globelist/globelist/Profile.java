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

import com.daililol.material.appbase.base.BaseActionbarActivity;
import com.daililol.material.appbase.utility.DrawableUtil;


public class Profile extends BaseActionbarActivity{

    @Override
    protected void onActivityCreated(Bundle savedInstanceState) {
        this.requestBackIcon(DrawableUtil.getDrawable(this, R.drawable.ic_arrow_back_white_24dp));
        this.setActionbarTitle("Profile", Color.rgb(255, 255, 255));
    }

    @Override
    protected int setupContentVew() {
        return R.layout.profile;
    }


    @Override
    protected Drawable setupThemeColor() {
        return new ColorDrawable(Color.rgb(80, 8, 36));
    }
    @Override
    protected void onMenuItemSelected(MenuItem menu) {
        switch (menu.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
    }

    @Override
    protected boolean onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.setting, menu);
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
