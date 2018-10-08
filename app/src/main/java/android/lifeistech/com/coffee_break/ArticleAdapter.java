package android.lifeistech.com.coffee_break;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ArticleAdapter extends ArrayAdapter<Article> {
    // List<Article> articles; // いらないっちゃ

    public ArticleAdapter(Context context, int layoutResourceId, List<Article> objects){
        super(context, layoutResourceId, objects);
        // articles = objects; // いらないっちゃ

    }

    public static class ViewHolder{
        TextView title;
        TextView content;
        TextView datetime;
        public ViewHolder(View view){
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

        final Article item = getItem(position);

        if(item!=null) { //  ここ反対だっちゃ
            viewHolder.content.setText(item.description);
            viewHolder.title.setText(item.author);
            viewHolder.datetime.setText(item.publishedAt);
        }
        return convertView;
    }
}