package picture.questions;

import adapters.MysteryAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import classes.InfoCreater;

public class VariotyActivity extends Activity {
    private int positionInVarioties;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  
        
        setContentView(R.layout.main);
        
        Bundle extras = getIntent().getExtras(); 
        
        ListView mainListView = (ListView)findViewById(R.id.listItem);
        positionInVarioties = extras.getInt("position", 0);

        mainListView.setAdapter(new MysteryAdapter(this, 
        		InfoCreater.allMysteries.get(positionInVarioties).getMysteries())); 
        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {
        	   Intent intent = new Intent(VariotyActivity.this, MysteryActivity.class);
        	   intent.putExtra("pisitionInVarioties", positionInVarioties);
        	   intent.putExtra("positionInMysteries", position);
               startActivity(intent);
            }
        });
    }

}