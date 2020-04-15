package com.example.gmail;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<UserItem> userItemList;

    public UserAdapter(Context context, int layout, List<UserItem> userItemList) {
        this.context = context;
        this.layout = layout;
        this.userItemList = userItemList;
    }

    @Override
    public int getCount() {
        return userItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return userItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder{
        TextView tvAggName;
        TextView tvName;
        TextView tvDes1;
        TextView tvDes2;
        TextView tvTime;
        CheckBox cbStar;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(layout, null);

            viewHolder = new ViewHolder();
            //Anh xa
            viewHolder.tvAggName = convertView.findViewById(R.id.tvAggName);
            viewHolder.tvName = convertView.findViewById(R.id.tvName);
            viewHolder.tvDes1 = convertView.findViewById(R.id.tvDes1);
            viewHolder.tvDes2 = convertView.findViewById(R.id.tvDes2);
            viewHolder.tvTime = convertView.findViewById(R.id.tvTime);
            viewHolder.cbStar = convertView.findViewById(R.id.cbStar);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final UserItem item = userItemList.get(position);
        String agg = item.getName().charAt(0) + "";
        viewHolder.tvAggName.setText(agg);
        viewHolder.tvName.setText(item.getName());
        viewHolder.tvDes1.setText(item.getDescription1());
        viewHolder.tvDes2.setText(item.getDescription2());
        viewHolder.tvTime.setText(item.getTime());
        viewHolder.cbStar.setChecked(item.isCheck());

        viewHolder.cbStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChecked = item.isCheck();
                item.setCheck(!isChecked);
            }
        });
        return convertView;
    }
}
