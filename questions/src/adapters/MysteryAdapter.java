package adapters;

import java.util.List;

import picture.questions.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import classes.Mystery;


public class MysteryAdapter extends ArrayAdapter<Mystery> {
    private final Context context;
    private List<Mystery> items;

    public String setDescription(String input, int maxSymbols)
    {
  	String[] split = input.split(" ");
  	String answer = split[0] + " ";
  	int k = 0;
  	for (int i = 1; i < split.length; i++)
  	{	
  	  if(answer.length() - k + split[i].length() < maxSymbols)
  		answer += " " + split[i];
  	  else{
  		    if ((answer.charAt(answer.length()-1) == ',')
  		    	|| (answer.charAt(answer.length()-1) == '.')
  		    	|| (answer.charAt(answer.length()-1) == '?')
  		    	|| (answer.charAt(answer.length()-1) == '!'))
  			    answer = answer.substring(0, answer.length() - 1) + "...";
  		    else answer += "...";
  		    break;
  		  }
  		
  	}
  	return answer; 
    }
    
    public MysteryAdapter(Context context, List<Mystery> mysteries) {
        super(context, R.layout.mystery, mysteries);
        this.context = context;
        this.items = mysteries;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.mystery, parent, false);

        TextView nameMystery = (TextView) rowView.findViewById(R.id.title);
        ImageView imageMystery = (ImageView) rowView.findViewById(R.id.imageMystery);
        TextView questionMystery = (TextView) rowView.findViewById(R.id.questionMystery);
        
        nameMystery.setText(items.get(position).getName());
        imageMystery.setImageResource(items.get(position).getPictureId());
        questionMystery.setText(setDescription(items.get(position).getQuestion(),24));
        return rowView;
    }
}