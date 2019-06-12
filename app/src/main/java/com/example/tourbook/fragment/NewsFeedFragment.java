package com.example.tourbook.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.tourbook.MainActivity;
import com.example.tourbook.R;
import com.example.tourbook.account.LoginActivity;
import com.example.tourbook.adapter.RVAdapter;
import com.example.tourbook.model.Person;
import com.example.tourbook.model.User;

import java.util.ArrayList;
import java.util.List;

public class NewsFeedFragment extends Fragment {
    private Context context;
    private MainActivity mainActivity;
    User user;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        mainActivity = (MainActivity) getActivity();
        user = LoginActivity.user;
    }



    private List<Person> persons;

    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Person("Emma Wilson", "23 years old", R.drawable.emma));
        persons.add(new Person("Lavery Maiss", "25 years old", R.drawable.emma));
        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.emma));
        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.emma));
        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.emma));
        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.emma));
        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.emma));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_feed, container, false);
        RecyclerView rv = view.findViewById(R.id.rv_news_feed);

        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(context);

        rv.setLayoutManager(llm);
        initializeData();

        RVAdapter adapter = new RVAdapter(persons);
        rv.setAdapter(adapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

}
