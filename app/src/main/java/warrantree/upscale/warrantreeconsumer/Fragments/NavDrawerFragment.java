package warrantree.upscale.warrantreeconsumer.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import warrantree.upscale.warrantreeconsumer.R;

public class NavDrawerFragment extends Fragment {
    //my variable declaration starts here
    public static final String SHARED_PREF_FILENAME = "wintech_drawer_sharedPref";
    public static final String KEY_USER_LEARNED_DRAWER = "user_learned_drawer";

    private ActionBarDrawerToggle myDrawerToggle;
    private DrawerLayout myDrawerLayout;

    private boolean mUserLearnedDrawer;
    private boolean mFromSavedIntance;

    private View navDrawerContainerView;

//  //my varaiable declaration ends here

    private OnFragmentInteractionListener mListener;

    public NavDrawerFragment() {
        // Required empty public constructor
    }
/*
    // TODO: Rename and change types and number of parameters
    public static navDrawerFragment newInstance(String param1, String param2) {
        navDrawerFragment fragment = new navDrawerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }*/

    //  //my method declaration starts here: Part 1

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserLearnedDrawer=Boolean.valueOf(readFromPreferences(getActivity(), KEY_USER_LEARNED_DRAWER, "false"));

        if (savedInstanceState!=null){
            mFromSavedIntance = true;
        }

        /*if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nav_drawer, container, false);
    }

    //  //my methods declaration ends here: Part 1


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    //my method declaration starts here : Part 2

    public void setUp(int drawerFragmentID, final DrawerLayout mydrawerlayout, Toolbar mytoolbar) {

        navDrawerContainerView = getActivity().findViewById(drawerFragmentID);

        myDrawerLayout = mydrawerlayout;
        myDrawerToggle = new ActionBarDrawerToggle(getActivity(), mydrawerlayout, mytoolbar, R.string.nav_drawer_open, R.string.nav_drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

                if (!mUserLearnedDrawer){
                    mUserLearnedDrawer = true;
                    saveToPreferences(getActivity(), KEY_USER_LEARNED_DRAWER, mUserLearnedDrawer+"");
                }
                //ActionBar needs to be redrawn
                getActivity().invalidateOptionsMenu();  //Forces activity to redraw the ActionBar
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

                //ActionBar needs to be redrawn again so...
                getActivity().invalidateOptionsMenu();  //Forces activity to redraw the ActionBar

            }
        };

        if (!mUserLearnedDrawer && !mFromSavedIntance){
            myDrawerLayout.openDrawer(navDrawerContainerView);
        }

        //myDrawerLayout.setDrawerListener(myDrawerToggle); //this method has been deprecated and replaced with the method below
        myDrawerLayout.addDrawerListener(myDrawerToggle);
        myDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                myDrawerToggle.syncState();
            }
        });
    }

    //We'll save the value of the mUserLearnedDrawer variable in shared preferences
    //Function for shared preferences takes 3 arguments
    //Doesn't deal with live objects so can be static.

    public static void saveToPreferences(Context mycontext, String preferenceName, String preferenceValue){
        SharedPreferences myDrawerSharedPreferences = mycontext.getSharedPreferences(SHARED_PREF_FILENAME, Context.MODE_PRIVATE);

        // PS: Find out how to use SharedPreferencesCompat (only for devices older than API 9)
        //SharedPreferencesCompat myDrawerSharedPreferencescompat = mycontext.get

        SharedPreferences.Editor myEditor = myDrawerSharedPreferences.edit();
        myEditor.putString(preferenceName, preferenceValue);

        //myEditor.commit(); //to be used when synchronous tasks are required.
        myEditor.apply();
    }

    //Method to read from saved  shared preferences
    public static String readFromPreferences(Context mycontext, String preferenceName, String defaultValue){
        SharedPreferences myDrawerSharedPreferences = mycontext.getSharedPreferences(SHARED_PREF_FILENAME, Context.MODE_PRIVATE);
        return myDrawerSharedPreferences.getString(preferenceName, defaultValue);
    }

//  //my methods declaration ends here
   /* @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    *
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.*/

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
