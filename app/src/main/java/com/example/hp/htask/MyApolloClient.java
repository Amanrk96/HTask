package com.example.hp.htask;

import com.apollographql.apollo.ApolloClient;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class MyApolloClient {

    private static  final  String Base_url ="https://www.neetprep.com/graphql";

    private static ApolloClient myApolloClient ;

    public static ApolloClient getMyApolloClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().
                addInterceptor(loggingInterceptor).build();

        myApolloClient = ApolloClient.builder().serverUrl(Base_url).okHttpClient(okHttpClient).build();

        return myApolloClient ;
    }
}
