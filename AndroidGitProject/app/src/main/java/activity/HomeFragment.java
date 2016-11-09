package activity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.itzuvillarce.gittestproject.R;

import java.util.ArrayList;
import java.util.List;

import adapter.CardViewAdaper;
import adapter.MoviesAdapter;
import model.Movie;
import model.MovieResponse;
import model.Perro;
import rest.ApiClient;
import rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {


    FloatingActionButton floatingActionButton;
    RecyclerView recyclerView;
    CardViewAdaper adapter;

    List<Perro> perros;

    // TODO - insert your themoviedb.org API KEY here
    private final static String API_KEY = "8ae7647903ef35133d7507fa84cc36ee";
    private static final String TAG = MainActivity.class.getSimpleName();


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
        /*recyclerView = (RecyclerView) rootView.findViewById(R.id.rvToDoList);*/

        /** Recycler View
        LinearLayoutManager llm = new LinearLayoutManager(getActivity().getApplicationContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);

        initializeData(); **/

       /* adapter = new CardViewAdaper(perros);

        recyclerView.setAdapter(adapter);*/

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Clic to floating button", Snackbar.LENGTH_SHORT).show();
            }
        });


        if(API_KEY.isEmpty()){
            Toast.makeText(getContext(), "Please obtain your KEY first", Toast.LENGTH_LONG).show();
            return rootView;
        }

        final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.rvToDoList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<MovieResponse> call =  apiInterface.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                List<Movie> movies = response.body().getResults();
                Log.d(TAG, "Number of movies received: " + movies.size());
                recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.list_item_movie, getContext()));
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
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

    /*private void initializeData() {
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
    }*/

}
