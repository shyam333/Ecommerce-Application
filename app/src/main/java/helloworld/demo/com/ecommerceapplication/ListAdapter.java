package helloworld.demo.com.ecommerceapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by shyamramesh on 31/03/18.
 */

public class ListAdapter extends ArrayAdapter<String> {

    String[] names;
    int[] images;
    Context mContext;

    public ListAdapter(Context context, String[] names, int[] images) {
        super(context, R.layout.list_item);
        this.mContext = context;
        this.names = names;
        this.images = images;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.list_item, parent, false);
            mViewHolder.mImage = (ImageView) convertView.findViewById(R.id.list_image);
            mViewHolder.mName = (TextView) convertView.findViewById(R.id.from_name);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.mImage.setImageResource(images[position]);
        mViewHolder.mName.setText(names[position]);

        return convertView;
    }

    static class ViewHolder {
        ImageView mImage;
        TextView mName;
    }

}
