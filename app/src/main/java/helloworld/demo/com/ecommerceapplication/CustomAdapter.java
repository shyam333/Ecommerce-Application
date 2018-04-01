package helloworld.demo.com.ecommerceapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    ArrayList<Contact> contactlist;
    Context context;
    private static final String TAG = "RecyclerViewAdapter";


    public CustomAdapter(Context context, ArrayList<Contact> contactlist) {
        this.context = context;
        this.contactlist = contactlist;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cart_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,final int position) {
        final Contact m;
        m = contactlist.get(position);
        holder.mName.setText("" + m.getName());

    }

    @Override
    public int getItemCount() {
        return contactlist.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mName;
        public RelativeLayout mRelativeLayout;

        public ViewHolder(View v) {
            super(v);
            mName = (TextView) v.findViewById(R.id.from_name);
            mRelativeLayout = (RelativeLayout) v.findViewById(R.id.rl);
        }

    }
}

