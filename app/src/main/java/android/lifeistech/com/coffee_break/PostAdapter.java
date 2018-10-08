package android.lifeistech.com.coffee_break;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PostAdapter extends ArrayAdapter<Post> {
    List<Post> posts;

    public PostAdapter(Context context, int layoutResourceId, List<Post> objects){
        super(context, layoutResourceId, objects);
        posts = objects;

    }

    @Override
    public int getCount(){
        return posts.size();
    }

    @Override
    public Post getItem(int position){
        return posts.get(position);
    }

    public static class ViewHolder{
        ImageView icon;
        TextView title;
        TextView content;
        TextView datetime;
        public ViewHolder(View view){
            icon = view.findViewById(R.id.icon);
            title = view.findViewById(R.id.title);
            content = view.findViewById(R.id.content);
            datetime = view.findViewById(R.id.datetime);
        }
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        final ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.post, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Post item = getItem(position);

        if(item==null){
            viewHolder.icon.setBackgroundResource(item.icon);
            viewHolder.content.setText(item.title);
            viewHolder.content.setText(item.content);
        }
        return convertView;
    }
}
