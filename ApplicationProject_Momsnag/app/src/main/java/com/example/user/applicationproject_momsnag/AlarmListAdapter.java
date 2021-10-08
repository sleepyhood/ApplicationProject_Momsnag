package com.example.user.applicationproject_momsnag;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//필터 사용시 public class AlarmListAdapter extends BaseAdapter implements Filterable  로 대체(명령어 검색 기능)
public class AlarmListAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<Alarms> listDatas = new ArrayList<>();
    //private ArrayList<Alarms> filteredItemList = new ArrayList<>();
    //Filter listFilter;

    public AlarmListAdapter(Context context, ArrayList<Alarms> listDatas) {
        this.context = context;
        //this.listDatas = listDatas;
        //this.filteredItemList = listDatas;
    }

    @Override
    public int getCount() {
        return listDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return listDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null);
        }
        TextView t1 = (TextView) convertView.findViewById(R.id.titleTextView);
        TextView t2 = (TextView) convertView.findViewById(R.id.contentTextView);
       // ImageView i1 = (ImageView) convertView.findViewById(R.id.img);
       // CheckBox c1 = (CheckBox)convertView.findViewById(R.id.checkbox1);

       /*Restaurants checkbox = filteredItemList.get(position);
        checkbox.setCheckBox(c1);
       filteredItemList.set(position, checkbox);
       listDatas.set(position, checkbox);*/

        //t1.setText(filteredItemList.get(position).getTitle());
        //t2.setText(filteredItemList.get(position).getContent());
        //i1.setImageResource(filteredItemList.get(position).getCategory());
        return convertView;
    }
/*
    Comparator<Restaurants> nameAsc = new Comparator<Restaurants>() {
        @Override
        public int compare(Restaurants o1, Restaurants o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    Comparator<Restaurants> categoryAsc = new Comparator<Restaurants>() {
        @Override
        public int compare(Restaurants o1, Restaurants o2) {
            if (o1.getCategory() < o2.getCategory())
                return -1;
            else if (o1.getCategory() > o2.getCategory())
                return 1;
            else
                return 0;
        }
    };
*/

//정렬!
    /*public void setNameAsc() {
        Collections.sort(filteredItemList, nameAsc);
        this.notifyDataSetChanged();
    }

    public void setCategoryAsc() {
        Collections.sort(filteredItemList, categoryAsc);
        this.notifyDataSetChanged();
    }*/
    //카테고리!

/*
    public void showCheckBox(){
        for(int i = 0; i<filteredItemList.size();i++ ){
            filteredItemList.get(i).getCheckBox().setVisibility(View.VISIBLE);
        }
        this.notifyDataSetChanged();
    }*/

/*
    public void deleteData(){
        for(int i = filteredItemList.size()-1; i>=0; i--){
            final int index = i;
            if(filteredItemList.get(i).getCheckBox().isChecked()){
                AlertDialog.Builder dlg = new AlertDialog.Builder(context);
                dlg.setTitle("삭제확인")
                        .setIcon(R.mipmap.ic_launcher)
                        .setMessage("선택한 맛집을 정말 삭제할거에요?")
                        .setNegativeButton("취소", null)
                        .setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                filteredItemList.get(index).getCheckBox().setChecked(false);
                                filteredItemList.get(index).getCheckBox().setVisibility(View.GONE);
                                filteredItemList.remove(index);
                                notifyDataSetChanged();
                            }
                        })
                        .show();
            }
            else {
                filteredItemList.get(i).getCheckBox().setVisibility(View.GONE);
            }
        }
    }*/


/*
  @Override
    public Filter getFilter() {
        if (listFilter == null) {
            listFilter = new ListFilter();
        }
        return listFilter;
    }

   private class ListFilter extends Filter{
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint == null || constraint.length() == 0) {
                results.values = listDatas;
                results.count = listDatas.size();
            } else {
                ArrayList<Alarms> itemList = new ArrayList<>();
                for (Alarms item : listDatas) {
                    if (item.getTitle().toUpperCase().contains(constraint.toString().toUpperCase())) {
                        itemList.add(item);
                    }
                }
                results.values = itemList;
                results.count = itemList.size();
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredItemList = (ArrayList<Alarms>) results.values;
            if (results.count > 0) {
                notifyDataSetChanged();
            } else {
                notifyDataSetInvalidated();
            }
        }
    }*/
}
