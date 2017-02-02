package com.vo2group.zoo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.vo2group.zoo.data.ZooDatabase;
import com.vo2group.zoo.model.Category;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView mEmpty;

    ListView mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmpty = (TextView) this.findViewById(android.R.id.empty);
        mList = (ListView) this.findViewById(android.R.id.list);
        mList.setEmptyView(mEmpty);

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Category  itemValue  = (Category) mList.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(), "Position :" + position + "  ListItem : " + itemValue.getName() , Toast.LENGTH_LONG)
                        .show();

            }
        });

        ZooDatabase zooDatabase = new ZooDatabase(this);
        List<Category> categories = zooDatabase.getAllCategories();
        zooDatabase.close();

        mList.setAdapter(new CategoryAdapter(this, categories));
    }
}
