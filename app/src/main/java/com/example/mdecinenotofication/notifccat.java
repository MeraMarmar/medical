package com.example.mdecinenotofication;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mdecinenotofication.databases.DatabaseClient;
import com.example.mdecinenotofication.databases.Medecine;

import java.util.ArrayList;
import java.util.List;

public class notifccat extends AppCompatActivity {
    // ArrayList<String> items;
    ArrayList<listItem> items;
    ArrayAdapter<String> myadater;
    ListView ls;
    RecyclerView myRecyclerView;
    MedicneAdapter medicneAdapter;
    database db = new database(this);
    Medecine medecine;
    List<Medecine> medecines =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifccat);
        Myadater myadater = new Myadater(items);
        myRecyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);
        showFromRoom();

    }

    public void show() {

       // ArrayList<Medecine> listData = db.getAllData();
      //  Toast.makeText(this, ""+listData.size(), Toast.LENGTH_SHORT).show();

//        ArrayList<String> arrayList = new ArrayList<>();
//        for (int i = 0; i < listData.size(); i++) {
//            // String s = listData.get(i).getNameOfmedicine()+"        "+listData.get(i).date +"        "
//            //    +listData.get(i).hour +"         "+listData.get(i).minute +"        "+listData.get(i).second
//            //   +"        "+listData.get(i).numoftaken;
//            items.add(new listItem(listData.get(i).getNameOfmedicine(), listData.get(i).hour));
//        }
//        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.list_row, arrayList);
//        ls.setAdapter(myadater);
    }
    public void showFromRoom() {



        GetTasks gt = new GetTasks(getApplicationContext());
        gt.execute();

          medicneAdapter =new MedicneAdapter(getApplicationContext(),medecines);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        myRecyclerView.setAdapter(medicneAdapter);
        Toast.makeText(this, "rdad2", Toast.LENGTH_SHORT).show();
    }


    public void addData(View view) {
        Intent i = new Intent(this, addData.class);
        startActivity(i);
    }

    public void update(View view) {

    }

    class Myadater extends BaseAdapter {
         List<listItem> items ;

        Myadater(ArrayList<listItem> items) {
            this.items = items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position).Name;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.list_row, null);
            TextView textshowname = view.findViewById(R.id.textshowname);
            TextView textshowtime = view.findViewById(R.id.textshowtime);
            textshowname.setText(items.get(position).Name);
            textshowtime.setText(items.get(position).Time);
            Button button_yes = view.findViewById(R.id.imageyes);
            Button button_no = view.findViewById(R.id.imageno);
            Button button_alrm = view.findViewById(R.id.imagealarm);
            button_yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            return view;

        }
    }

    class GetTasks extends AsyncTask<Void, Void,  List<Medecine>> {

        Context context;
        GetTasks(Context context)
        {
            this.context=context;
        }

        @Override
        protected  List<Medecine> doInBackground(Void... voids) {
            List<Medecine> taskList = DatabaseClient
                    .getInstance(this.context)
                    .getAppDatabase()
                    .mediceDAO()
                    .getAll();
            return taskList;
        }

        @Override
        protected void onPostExecute( List<Medecine> tasks) {
            super.onPostExecute(tasks);
            medecines= (ArrayList<Medecine>) tasks;
            Log.e("bakrlog","size ="+ medecines.size()) ;

        }
    }
}




