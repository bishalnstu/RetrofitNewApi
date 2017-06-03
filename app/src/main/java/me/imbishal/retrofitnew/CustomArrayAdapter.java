package me.imbishal.retrofitnew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ROOT on 6/4/2017.
 */

public class CustomArrayAdapter extends ArrayAdapter {

    public ArrayList<GitHubRepos> ingredientsList;
    private static LayoutInflater inflater = null;

    public CustomArrayAdapter(Context context, ArrayList<GitHubRepos> list)
    {
        super(context,0,list);
        this.ingredientsList = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row,parent,false);
// inflate custom layout called row
            holder = new ViewHolder();
            holder.tv =(TextView) convertView.findViewById(R.id.textView1);
// initialize textview
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder)convertView.getTag();
        }
        GitHubRepos in = (GitHubRepos) ingredientsList.get(position);
        holder.tv.setText(in.name);
        // set the name to the text;

        return convertView;

    }

    static class ViewHolder
    {
        TextView tv;
    }
}
