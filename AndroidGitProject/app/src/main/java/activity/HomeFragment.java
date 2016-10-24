package activity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import com.example.itzuvillarce.gittestproject.R;

import java.util.ArrayList;
import java.util.List;

import adapter.CardViewAdaper;
import model.Perro;

public class HomeFragment extends Fragment {


    FloatingActionButton floatingActionButton;
    RecyclerView recyclerView;
    CardViewAdaper adapter;

    List<Perro> perros;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container,false );
        floatingActionButton = (FloatingActionButton) rootView.findViewById(R.id.fab);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.rvToDoList);

        /** Recycler View **/
        LinearLayoutManager llm = new LinearLayoutManager(getActivity().getApplicationContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);

        initializeData();

        adapter = new CardViewAdaper(perros);

        recyclerView.setAdapter(adapter);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Clic to floating button", Snackbar.LENGTH_SHORT).show();
            }
        });



        return rootView;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    private void initializeData() {
        perros = new ArrayList<>();
        perros.add(new Perro("Perro 1", R.drawable.ic_user));
        perros.add(new Perro("Perro 2", R.drawable.ic_user));
        perros.add(new Perro("Perro 3", R.drawable.ic_user));
        perros.add(new Perro("Perro 4", R.drawable.ic_user));
        perros.add(new Perro("Perro 5", R.drawable.ic_user));
        perros.add(new Perro("Perro 6", R.drawable.ic_user));
        perros.add(new Perro("Perro 7", R.drawable.ic_user));
        perros.add(new Perro("Perro 8", R.drawable.ic_user));
        perros.add(new Perro("Perro 9", R.drawable.ic_user));
        perros.add(new Perro("Perro 10", R.drawable.ic_user));
        perros.add(new Perro("Perro 11", R.drawable.ic_user));
        perros.add(new Perro("Perro 12", R.drawable.ic_user));
    }

}
