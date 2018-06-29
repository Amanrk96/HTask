package com.example.hp.htask;

import android.annotation.SuppressLint;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.exception.ApolloException;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;


 public class Cources extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    CustomAdapter customAdapter;
    List<CourceInfo> courceList;

   // HttpUrl url = HttpUrl.parse("https://www.neetprep.com/graphql?query={course{name,image,description,package}}");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cources_rv);

        recyclerView = (RecyclerView) findViewById(R.id.cources_rv);
        courceList = new ArrayList<>();
        load_data();

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        customAdapter = new CustomAdapter(this , courceList) ;
        recyclerView.setAdapter(customAdapter);
    }

    private void load_data() {
        @SuppressLint("StaticFieldLeak") AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... Strings) {
                    MyApolloClient.getMyApolloClient().query(GetCources.builder().build()).enqueue(new ApolloCall.Callback<GetCources.Data>() {
                        @Override
                        public void onResponse(@Nonnull com.apollographql.apollo.api.Response<GetCources.Data> response) {
                            //Log.d();
                        }

                        @Override
                        public void onFailure(@Nonnull ApolloException e) {

                        }
                    });
                    return null;
            }

            @Override
            protected void onPostExecute(Void s) {
               customAdapter.notifyDataSetChanged();
            }
        };
        task.execute();
    }
}
