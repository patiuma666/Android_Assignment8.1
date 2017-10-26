package com.example.iis5.sortinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
//creating main activity
public class MainActivity extends AppCompatActivity {

    // initialising Array list of type string,listview,buttons and myadapter
    private ListView mlistview;
    private ArrayList<String> mitems;
    private Button ascending_button;
    private Button descending_button;
    Myadapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//findViewById is a method that finds the view from the layout resource file that are attached with current Activity

        mlistview = (ListView) findViewById(R.id.months_listview);
        ascending_button = (Button) findViewById(R.id.ascendingbutton);
        descending_button = (Button) findViewById(R.id.descendingbutton);
//creating object for Arraylist mitems
        mitems = new ArrayList<>();
//adding them in the array list obj
        mitems.add("January");
        mitems.add("February");
        mitems.add("March");
        mitems.add("April");
        mitems.add("May");
        mitems.add("June");
        mitems.add("July");
        mitems.add("August");
        mitems.add("September");
        mitems.add("October");
        mitems.add("November");
        mitems.add("December");
//Adapter is an interface whose implementations provide data and control the display of that data.
// ListViews own adapters that completely control the ListView’s display.
// So adapters control the content displayed in the list as well as how to display it.
        myadapter = new Myadapter();
        mlistview.setAdapter(myadapter);


//here by using setonclicklistener we if click on ascending button it notifies the data to be changed
        ascending_button.setOnClickListener(new View.OnClickListener() {

public void onClick(View view) {
        ascending();
        myadapter.notifyDataSetChanged();
        }
        });

        //here by using setonclicklistener we if click on descending button it notifies the data to be changed
        descending_button.setOnClickListener(new View.OnClickListener() {

public void onClick(View view) {
        descending();
        myadapter.notifyDataSetChanged();

        }
        });
        }
        //creating Myadapter whcih extends baseadapter
class Myadapter extends BaseAdapter{
//which implements methods
    @Override
    public int getCount() {
        return mitems.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
//in this method we are using position ,convert view and viewgroup
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Here, position is the index in the list, the convertView is the view to be
        //recycled (or created), and parent is the ListView itself.
        ViewHolder holder;
        //Grab the convertView as our row of the ListView
        if(convertView == null){
            // //Here, position is the index in the list, the convertView is the view to be
            //recycled (or created), and parent is the ListView itself.
            //Now either row is the recycled view, or one that we've inflated. All that's left
            //to do is set the data of the row. In this case, assume that the row is just a
            //simple TextView
            //and set its textView field to the proper value
            convertView = getLayoutInflater().inflate(R.layout.row_view,parent,false);
            holder = new ViewHolder();
            holder.bindview(convertView);
            convertView.setTag(holder);
            Log.e("MainActivity","convertView is NULL");
        }else{
            Log.e("MainActivity","convertview is not null" );
            holder = (ViewHolder)convertView.getTag();
        }
        //Grab the item to be rendered. In this case, I'm just using a string, but
        //you will use your underlying object type.
        holder.tv_months_list.setText(mitems.get(position));
        //and return the row
        return convertView;
    }
}
public class ViewHolder{
    TextView tv_months_list;

    void bindview(View convertView){
        tv_months_list = (TextView) convertView.findViewById(R.id.textview_months_list);
    }

}
    public void ascending(){
        Collections.sort(this.mitems);

    }
    public void descending(){
        Collections.sort(this.mitems,Collections.<String>reverseOrder());
    }
}