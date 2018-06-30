package com.example.hp.htask;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.exception.ApolloException;

import java.util.ArrayList;

import javax.annotation.Nonnull;


public class Courses extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    CustomAdapter customAdapter;
    ArrayList<CourceInfo> courceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crv);

        recyclerView = findViewById(R.id.courses_rv);
        courceList = new ArrayList<>();

        load_data();

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        customAdapter = new CustomAdapter(this, courceList);
        recyclerView.setAdapter(customAdapter);

    }

    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }

    private void load_data() {
        @SuppressLint("StaticFieldLeak") AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... Strings) {
                MyApolloClient.getMyApolloClient().query(GetCourses.builder().build()).enqueue(new ApolloCall.Callback<GetCourses.Data>() {
                    @Override
                    public void onResponse(@Nonnull com.apollographql.apollo.api.Response<GetCourses.Data> response) {

                        CourceInfo courceInfo = new CourceInfo("https://www.neetprep.com" + response.data().course().image().toString(),
                                response.data().course().name().toString(),
                                response.data().course().description().toString(),
                                "Package : "+response.data().course().package_().toString());
                        courceList.add(courceInfo);
                    }

                    @Override
                    public void onFailure(@Nonnull ApolloException e) {

                    }
                });
                return null;
            }

            @Override
            protected void onPostExecute(Void s) {
                //customAdapter.notifyItemRangeChanged(0, customAdapter.getItemCount());
                customAdapter.notifyDataSetChanged();
            }
        };
        task.execute();
    }
}