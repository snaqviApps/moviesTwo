package nanodegree.dfw.perm.movieapp.utilities;

//import android.content.ContentValues;
import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import nanodegree.dfw.perm.movieapp.app.MainActivity;
import nanodegree.dfw.perm.movieapp.data.MoviesData;

public class MovieJsonUtils {

    private static final String MOVIE_ID = "id";
    private static final String MOVIE_STATUS_CODE = "status_code";
    private static final String MOVIE_STATUS_CODE_VALUE = "status_message";
    private static final String MOVIE_POSTER_PATH = "poster_path";
    private static final String MOVIE_POSTER_THUMB = "backdrop_path"; // string
    private static final String MOVIE_ORIGINAL_TITLE = "original_title";  // string
    private static final String TITLE = "title";                    // string
    private static final String MOVIE_OVERVIEW = "overview";              // String
    private static final String MOVIE_RELEASE_DATE = "release_date";      //String
    private static final String MOVIE_RATING = "vote_average";      // double
    private static final String MOVIE_POPULARITY = "popularity";    // double

    public static HashMap<Integer, MoviesData> getMoviesStringsFromJson(Context context, String forecastJsonStr)
            throws JSONException {
        HashMap movieData = new HashMap();
        JSONObject forecastJson = new JSONObject(forecastJsonStr);
        movieData.put(Integer.valueOf(forecastJson.getString(MOVIE_ID)),
                new MoviesData(
                        forecastJson.getString(MOVIE_POSTER_PATH),
                        forecastJson.getString(MOVIE_POSTER_THUMB),
                        forecastJson.getString(MOVIE_ORIGINAL_TITLE),
                        forecastJson.getString(MOVIE_OVERVIEW),
                        forecastJson.getString(MOVIE_RELEASE_DATE),
                        forecastJson.getDouble(MOVIE_RATING),
                        forecastJson.getDouble(MOVIE_POPULARITY),
                        null)
        );

        return movieData;
    }

//    public static HashMap<Integer, MoviesData> getOrderingMoviesStrings(Context context, String toOrderJsonStr)
    public static ArrayList<HashMap<Integer, MoviesData>> getOrderingMoviesStrings(Context context, String toOrderJsonStr)
            throws JSONException {

        ArrayList<HashMap<Integer, MoviesData>> moviesListToOrder = new ArrayList<>();

        HashMap orderedMovieData = new HashMap();
        JSONArray inMoviesJson_UnOrdered = new JSONObject(toOrderJsonStr).getJSONArray("results");

        for (int toOderMovies = 0; toOderMovies < inMoviesJson_UnOrdered.length();toOderMovies++) {
            orderedMovieData.put(toOderMovies,
                    new MoviesData(
                            inMoviesJson_UnOrdered.getJSONObject(toOderMovies).getString(MOVIE_POSTER_PATH),
                            inMoviesJson_UnOrdered.getJSONObject(toOderMovies).getString(MOVIE_POSTER_THUMB),
                            inMoviesJson_UnOrdered.getJSONObject(toOderMovies).getString(MOVIE_ORIGINAL_TITLE),
                            inMoviesJson_UnOrdered.getJSONObject(toOderMovies).getString(MOVIE_OVERVIEW),
                            inMoviesJson_UnOrdered.getJSONObject(toOderMovies).getString(MOVIE_RELEASE_DATE),
                            inMoviesJson_UnOrdered.getJSONObject(toOderMovies).getDouble(MOVIE_RATING),
                            inMoviesJson_UnOrdered.getJSONObject(toOderMovies).getDouble(MOVIE_POPULARITY),
                            null)
            );
            moviesListToOrder.add(orderedMovieData);
        }

//        return orderedMovieData;
        return moviesListToOrder;
    }


    /**
     * Parse the JSON and convert it into ContentValues that can be inserted into our database.
     *
     * @param context         An application context, such as a service or activity context.
     * @param forecastJsonStr The JSON to parse into ContentValues.
     *
     * @return An array of ContentValues parsed from the JSON.
     */
//    public static ContentValues[] getFullWeatherDataFromJson(Context context, String forecastJsonStr) {
//        /** This will be implemented in a future lesson **/
//        return null;
//    }
}

