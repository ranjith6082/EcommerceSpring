package com.example.ecommercespring.configuration;

import com.example.ecommercespring.gateway.api.FakeStoreCategoryApi;
import com.example.ecommercespring.gateway.api.FakeStoreProductApi;
import com.example.ecommercespring.gateway.api.FakeStoreProductsCategoryApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {

    @Value("${base.url}")
    private String baseUrl;

    @Bean
    public Retrofit retrofit(){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Bean
    public FakeStoreCategoryApi fakeStoreCategoryApi(Retrofit retrofit){
        return retrofit.create(FakeStoreCategoryApi.class);
    }

    @Bean
    public FakeStoreProductApi fakeStoreProductApi(Retrofit retrofit) {
        return retrofit.create(FakeStoreProductApi.class);
    }

    @Bean
    public FakeStoreProductsCategoryApi fakeStoreProductsCategoryApi(Retrofit retrofit) {
        return retrofit.create(FakeStoreProductsCategoryApi.class);
    }
}
