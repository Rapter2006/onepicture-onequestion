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
import classes.Varioty;


public class VariotyAdapter extends ArrayAdapter<Varioty> {
    private final Context context;
    private List<Varioty> items;

    public VariotyAdapter(Context context, List<Varioty> varioties) {
        super(context, R.layout.mystery, varioties);
        this.context = context;
        this.items = varioties;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.varioty, parent, false);

        TextView nameVarioty = (TextView) rowView.findViewById(R.id.title);
        TextView descriptionVarioty = (TextView) rowView.findViewById(R.id.DescriptionVarioty);
        ImageView imageVarioty = (ImageView) rowView.findViewById(R.id.imageVarioty);
        
        nameVarioty.setText(items.get(position).getName());
        descriptionVarioty.setText(items.get(position).getDescription());
        imageVarioty.setImageResource(items.get(position).getPictureId());
        
        return rowView;
    }
}