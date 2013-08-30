package picture.questions;

import adapters.VariotyAdapter;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import classes.InfoCreater;


public class MainActivity extends Activity {
     @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  
        
        setContentView(R.layout.main);
        
        InfoCreater.initAll();
        ListView mainListView = (ListView)findViewById(R.id.listItem);
         
       
        mainListView.setAdapter(new VariotyAdapter(this, InfoCreater.allMysteries)); 
        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {
        	 Intent intent = new Intent(MainActivity.this, VariotyActivity.class);
             intent.putExtra("position", position);
        	 startActivity(intent);
            }
        });
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
		if(item.getItemId() == R.id.action_settings)
		{
     			final Dialog dialog = new Dialog(this);
				dialog.setContentView(R.layout.dialog);
				dialog.setTitle("О программе");
				TextView text = (TextView) dialog.findViewById(R.id.text);
				text.setTextColor(Color.BLACK);
				text.setText("Приложение \"Загадки в картинках\" \n\nРазработчик: Данил Руденко \n\nО багах, возможном сотрудничестве и новых задачках сообщать сюда:\n raptersbugs@gmail.com");
				dialog.setCanceledOnTouchOutside(true);
				dialog.show();
		}
		else{
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=picture.questions"));
				startActivity(intent);
		    }
		return false;
    }    
}