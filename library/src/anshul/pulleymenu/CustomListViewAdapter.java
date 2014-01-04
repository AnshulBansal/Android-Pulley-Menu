package anshul.pulleymenu;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListViewAdapter extends ArrayAdapter<String> {

	Context Context;
	ArrayList<String> Menuitems = new ArrayList<String>();

	public CustomListViewAdapter(Context context, int ResourceId,
			List<String> objects) {
		super(context, ResourceId, objects);
		this.Menuitems = (ArrayList<String>) objects;
		this.Context = context;

	}

	private class ViewHolder {

		ImageView imageview;
		TextView textname;

	}

	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder;
		String str = Menuitems.get(position);
		LayoutInflater mInflater = (LayoutInflater) Context
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.listitem, null);
			holder = new ViewHolder();

			holder.textname = (TextView) convertView.findViewById(R.id.tVmenu);

			convertView.setTag(holder);
		} else
			holder = (ViewHolder) convertView.getTag();

		holder.textname.setText(str);

		convertView.setBackgroundColor(Color.WHITE);

		return convertView;

	}

}
